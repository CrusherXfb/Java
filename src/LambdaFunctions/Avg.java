package LambdaFunctions;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.function.IntPredicate;

public class Avg {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size;
        while (true) {  //защита от ввода отрицательных значений
            size = scanner.nextInt();
            if (size > 0) {
                break;
            } else {
                System.out.println("Размер массива должен быть положительным числом. Попробуйте снова.");
                System.out.print("Введите размер массива: ");
            }
        }
        scanner.nextLine();

        int[] randomNumbers = generateRandomArray(size);
        System.out.println("Сгенерированный массив: " + Arrays.toString(randomNumbers));

        System.out.println("Выберите тип позиций для вычисления среднего:");
        System.out.println("1 - Нечетные позиции");
        System.out.println("2 - Четные позиции");
        System.out.println("X - Позиции, кратные X");
        System.out.print("Ваш выбор: ");

        String choice = scanner.nextLine();

        IntPredicate positionFilter;
        switch (choice) {
            case "1":
                positionFilter = Avg::isOddPosition;
                break;
            case "2":
                positionFilter = Avg::isEvenPosition;
                break;
            default:
                try {
                    int multipleOf = Integer.parseInt(choice);
                    if (multipleOf <= 0) { //защита от отрицательных значений
                        throw new NumberFormatException();
                    }
                    positionFilter = position -> (position + 1) % multipleOf == 0;
                } catch (NumberFormatException e) {
                    System.out.println("Некорректный ввод. Будет использован фильтр по нечетным позициям.");
                    positionFilter = Avg::isOddPosition;
                }
        }

        double average = averageOnPositions(randomNumbers, positionFilter);
        System.out.println("Среднее арифметическое на выбранных позициях: " + average);
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        return random.ints(size, 1, 100).toArray();
    }

    public static double averageOnPositions(int[] numbers, IntPredicate positionFilter) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (positionFilter.test(i)) {
                sum += numbers[i];
                count++;
            }
        }
        return count > 0 ? (double) sum / count : 0.0;
    }

    public static boolean isOddPosition(int index) {
        return index % 2 != 0;
    }

    public static boolean isEvenPosition(int index) {
        return index % 2 == 0;
    }
}
