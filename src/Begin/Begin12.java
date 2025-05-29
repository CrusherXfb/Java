package Begin;

import java.util.Scanner;
import java.lang.Math;
public class Begin12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Катет a >>> ");
        int a = sc.nextInt();
        System.out.print("Катет b >>> ");
        int b = sc.nextInt();
        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
        double P = a + b + c;
        System.out.print(
                "Гипотенуза: " + c + "\n" +
                "Периметр: " + P
        );
    }
}
