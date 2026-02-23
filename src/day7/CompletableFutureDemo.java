package day7;

import javax.crypto.spec.PSource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureDemo {

    private static final List<String> SOURCES = List.of("OpenExchangeRates", "Fixer", "CurrencyLayer", "XE", "OANDA");
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        ExecutorService poolExecutor = Executors.newFixedThreadPool(5);

        BigDecimal fasterResponse = getFastestResponse(poolExecutor, "USD", "EUR");

        System.out.println("Fastest response for the exchange rate: " + fasterResponse);

        Map<String , BigDecimal> aggregatedResult = getAllRate(poolExecutor, "USD", "EUR");

        System.out.println("Aggregated Json: " + aggregatedResult);

        poolExecutor.shutdown();

    }

    public static BigDecimal getFastestResponse(ExecutorService poolExecutor, String from, String to) {

        List<CompletableFuture<BigDecimal>> futures = SOURCES.stream()
                .map(source -> CompletableFuture.supplyAsync(() -> getExchangeRate(source, from, to), poolExecutor))
                .collect(Collectors.toList());

        return (BigDecimal) CompletableFuture.anyOf(futures.toArray(new CompletableFuture[0])).join();
    }

    public static Map<String, BigDecimal> getAllRate(ExecutorService poolExecutor, String from, String to) {

        Map<String, CompletableFuture<BigDecimal>> futureMap = SOURCES.stream()
                .collect(Collectors.toMap(s -> s, s -> CompletableFuture.supplyAsync(() -> getExchangeRate(s, from , to), poolExecutor)));


        CompletableFuture<Void> allFinished = CompletableFuture.allOf(futureMap.values().toArray(new CompletableFuture[0]));

        return allFinished.thenApply((v) ->
                futureMap.entrySet().stream()
                        .collect(Collectors.toMap(Map.Entry :: getKey, entry -> entry.getValue().join()))
                ).join();
    }

    public static BigDecimal getExchangeRate(String source, String from, String to)  {

        try {
            Thread.sleep(500 + RANDOM.nextInt(1500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double value =  0.85 + (0.10 * RANDOM.nextDouble());

        BigDecimal result = BigDecimal.valueOf(value);

        result = result.setScale(4, RoundingMode.HALF_UP);

        return result;

    }
}
