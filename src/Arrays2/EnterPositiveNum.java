package Arrays2;

import java.util.Scanner;

public class EnterPositiveNum {
    public static void main(String[] strings) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Введите положительное число >>> ");
                int x = sc.nextInt();

                if (x <= 0) {
                    throw new IllegalArgumentException();
                } else {
                    System.out.println("Введено положительное число: " + x + ", завершение цикла.");
                    break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Ошибка: число должно быть положительным.");
                sc.nextLine();
            } catch (java.util.InputMismatchException ex) {
                System.out.println("Ошибка: введите корректное целое число.");
                sc.nextLine();
            } catch (Exception ex) {
                System.out.println("Ошибка: " + ex.getMessage());
                sc.nextLine();
            }
        }
        sc.close();
    }
}
