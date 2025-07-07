package Stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class PrimeNumbers {

    public static void main(String[] args) {
        int n = 50; // Пример значения n
        int[] array = new int[n];

        // Заполнение массива случайными числами от 0 до 100
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(101);
        }

        System.out.println("Исходный массив: " + Arrays.toString(array));

        // Параллельная фильтрация и сортировка простых чисел
        int[] primes = IntStream.range(0, n)
                .parallel()
                .map(i -> array[i])
                .filter(PrimeNumbers::isPrime)
                .sorted()
                .toArray();

        System.out.println("Простые числа в диапазоне: " + Arrays.toString(primes));
    }

    // Метод для проверки, является ли число простым
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

