package org.example;

public class Factorial {
    public static int fact(int n) {
        if (n < 0) return -1;
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
