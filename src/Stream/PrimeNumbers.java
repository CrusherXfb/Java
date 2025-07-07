package Stream;

import java.util.stream.IntStream;

public class PrimeNumbers {
    public static void main(String[] args) {
        int n = 50;

        System.out.println("Простые числа в диапазоне от 0 до " + n + ": ");
        IntStream.rangeClosed(2, n)
                .filter(PrimeNumbers::isPrime)
                .forEach(prime -> System.out.print(prime + " "));
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        return IntStream.rangeClosed(2, (int) Math.sqrt(num))
                .noneMatch(i -> num % i == 0);
    }
}

