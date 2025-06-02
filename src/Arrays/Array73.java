package Arrays;

import java.util.Random;

public class Array73 {
    public static void main(String[] strings) {
        int arr_size = 10;
        int[] arr = new int[arr_size];
        Random r = new Random();
        System.out.println("До сортировки: ");

        for (int i = 0; i < arr_size; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + "\t");
        }

        arr = reverseSubarray(arr, 3, 7);

        System.out.println("\nПосле сортировки: ");

        for (int i = 0; i < arr_size; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public static int[] reverseSubarray(int[] array, int K, int L) {
        int left = K + 1;
        int right = L - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }

        return array;
    }
}
