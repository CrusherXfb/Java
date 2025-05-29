package Begin;

import java.util.Scanner;
import java.lang.Math;
public class Begin09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Число a >>> ");
        int a = sc.nextInt();
        System.out.print("Число b >>> ");
        int b = sc.nextInt();
        System.out.print("Среднее геометрическое: " + Math.sqrt(a * b));
    }
}
