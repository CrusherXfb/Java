package Arrays;
import java.util.Scanner;

public class Seasons {
    public static void main(String[] args) {
        System.out.print("Введите месяц (1-12): ");
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        String season;

        switch (month) {
            case 12, 1, 2 -> season = "Winter";
            case 3, 4, 5 -> season = "Spring";
            case 6, 7, 8 -> season = "Summer";
            case 9, 10, 11 -> season = "Autumn";
            default -> season = "Bogus Month";
        }

        System.out.println("Время года - " + season);
    }
}
