package Stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class PrimeNumbersInArray {

    public static void main(String[] args) {
        int n = 50;
        int[] array = new int[n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(101);
        }

        System.out.println("Исходный массив: " + Arrays.toString(array));

        int[] primes = IntStream.range(0, n)
                .parallel()
                .map(i -> array[i])
                .filter(PrimeNumbersInArray::isPrime)
                .sorted()
                .toArray();

        System.out.println("Простые числа в диапазоне: " + Arrays.toString(primes));
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

