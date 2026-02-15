package Day2;
import  java.math.*;


public class bigDecimal {
    public static void main(String[] args) {
        BigDecimal example1 = new BigDecimal("12345.12345467");

        example1 = example1.setScale(5, RoundingMode.HALF_UP);

        System.out.println(example1);

        BigDecimal example2 = new BigDecimal("12345.123456");

        example2 = example2.setScale(5, RoundingMode.HALF_UP);

        System.out.println(example2);

        BigDecimal resulted1 = new BigDecimal("12345.12345");
        BigDecimal resulted2 = new BigDecimal("12345.12346");

        System.out.println(example1.compareTo(resulted1));
        System.out.println(example2.compareTo(resulted2));


    }
}
