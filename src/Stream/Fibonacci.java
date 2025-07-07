package Stream;

import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 20;

        if (n <= 2) {
            System.out.println("N должно быть больше 2");
            return;
        }

        Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                .limit(n)
                .mapToInt(fib -> fib[0])
                .forEach(num -> System.out.print(num + " "));
    }
}

