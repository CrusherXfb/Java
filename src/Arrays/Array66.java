package Arrays;

import java.util.Random;

public class Array66 {
    public static void main(String[] strings) {
        int arr_size = 10;
        int[] arr = new int[arr_size];
        Random r = new Random();
        System.out.println("До изменений: ");

        for (int i = 0; i < arr_size; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + "\t");
        }
        arr = upEvens(arr);

        System.out.println("\nПосле изменений: ");

        for (int i = 0; i < arr_size; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public static int[] upEvens (int[] array) {
        int incNum = findEven(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
               array[i] += incNum;
        }
        return array;
    }

    public static int findEven(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                return array[i];
        }
        return 0;
    }
}
