package day7;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ExchangeRateApp {

    // Simulating 5 different exchange sources
    private static final List<String> SOURCES = List.of("Binance", "Coinbase", "Kraken", "Bitstamp", "Gemini");
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws Exception {
        // 1. Create a thread pool specifically for these IO tasks
        ExecutorService executor = Executors.newFixedThreadPool(5);

        System.out.println("Fetching rates for USD to EUR...\n");

        // --- SCENARIO 1: GET FASTEST RESPONSE ---
        Double fastest = getFastestRate(executor, "USD", "EUR");
        System.out.println("1. Fastest Rate Received: " + fastest);

        // --- SCENARIO 2: AGGREGATE ALL RESPONSES ---
        Map<String, Double> allRates = getAllRates(executor, "USD", "EUR");
        System.out.println("2. Aggregated JSON: " + allRates);

        executor.shutdown();
    }

    /**
     * Uses CompletableFuture.anyOf to return the result of the first task that finishes.
     */
    public static Double getFastestRate(Executor executor, String from, String to) {
        List<CompletableFuture<Double>> futures = SOURCES.stream()
                .map(source -> CompletableFuture.supplyAsync(() -> mockApiCall(source, from, to), executor))
                .toList();

        // anyOf returns the first one to complete, regardless of which source it is
        return (Double) CompletableFuture.anyOf(futures.toArray(new CompletableFuture[0])).join();
    }

    /**
     * Uses CompletableFuture.allOf to wait for every single API to return.
     */
    public static Map<String, Double> getAllRates(Executor executor, String from, String to) {
        // Map each source to its own future
        Map<String, CompletableFuture<Double>> futureMap = SOURCES.stream()
                .collect(Collectors.toMap(
                        source -> source,
                        source -> CompletableFuture.supplyAsync(() -> mockApiCall(source, from, to), executor)
                ));

        // Create a single future that tracks the completion of ALL futures
        CompletableFuture<Void> allFinished = CompletableFuture.allOf(
                futureMap.values().toArray(new CompletableFuture[0])
        );

        // Wait for all to finish, then collect the results into a Map
        return allFinished.thenApply(v ->
                futureMap.entrySet().stream()
                        .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().join()))
        ).join();
    }

    /**
     * Mock method representing a network call with random latency.
     */
    private static Double mockApiCall(String source, String from, String to) {
        try {
            // Simulate network delay between 500ms and 2000ms
            Thread.sleep(500 + RANDOM.nextInt(1500));
            return 0.85 + (0.10 * RANDOM.nextDouble()); // Random exchange rate
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return 0.0;
        }
    }
}