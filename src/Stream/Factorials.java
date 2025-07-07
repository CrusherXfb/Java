package Stream;

import java.util.stream.LongStream;

public class Factorials {
    public static void main(String[] args) {
        int N = 10;
        System.out.println("Факториалы чисел от 0 до " + N + ":");
        LongStream.rangeClosed(0, N)
                .mapToObj(Factorials::factorial)
                .forEach(result -> System.out.println(result.factor + "! = " + result.value));
    }

    public static FactorialResult factorial(long number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return new FactorialResult(number, result);
    }

    static class FactorialResult {
        long factor;
        long value;

        FactorialResult(long factor, long value) {
            this.factor = factor;
            this.value = value;
        }
    }
}

