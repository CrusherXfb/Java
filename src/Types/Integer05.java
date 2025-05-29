package Types;

public class Integer05 {
    public static void main (String[] args) {
        int a = 1000;
        int b = 6;
        int bInA = a / b;
        int remaining = a % bInA;
        System.out.println("Количество отрезков b (" + b + ") в отрезке a (" + a + "): " + bInA);
        System.out.print("Незанятая часть: " + remaining);

    }
}
