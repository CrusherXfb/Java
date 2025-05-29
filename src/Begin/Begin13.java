package Begin;

import java.util.Scanner;
import java.lang.Math;
public class Begin13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Радиус 1 >>> ");
        int r1 = sc.nextInt();
        System.out.print("Радиус 2 >>> ");
        int r2 = sc.nextInt();
        double s1 = Math.PI * Math.pow(r1, 2);
        double s2 = Math.PI * Math.pow(r2, 2);
        double s3 = Math.PI * s1 - s2;
        System.out.println("S1: " + s1);
        System.out.println("S2: " + s2);
        System.out.println("S3: " + s3);
    }
}
