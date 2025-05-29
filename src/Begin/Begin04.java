package Begin;

import java.util.Scanner;
import java.lang.Math;
public class Begin04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Диаметр окружности >>> ");
        int x = sc.nextInt();
        System.out.print("Длина окружности: " + Math.PI * x);
    }
}
