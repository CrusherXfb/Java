package Arrays;

import java.util.Random;

public class ArraySort {
    public static void main(String[] strings) {
        int arr_size = 10;
        int[] arr = new int[arr_size];
        Random r = new Random();
        System.out.println("До сортировки: ");

        for (int i = 0; i < arr_size; i++) {
            arr[i] = r.nextInt(50);
            System.out.print(arr[i] + "\t");
        }

        arr = bubbleSort(arr);

        System.out.println("\nПосле сортировки bubble: ");
        for (int i = 0; i < arr_size; i++) {
            System.out.print(arr[i] + "\t");
        }

        arr = quickSort(arr, 0, arr_size-1, true);

        System.out.println("\nПосле сортировки quick: ");
        for (int i = 0; i < arr_size; i++) {
            System.out.print(arr[i] + "\t");
        }


    }

    private static int[] bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }


    private static int[] quickSort(int[] array, int leftIndex, int rightIndex, boolean desc) {
        int i = leftIndex;
        int j = rightIndex;
        int pivot = array[leftIndex];

        while (i <= j) {
            if (!desc) {
                while (i < array.length && array[i] < pivot) {
                    i++;
                }
                while (j >= 0 && array[j] > pivot) {
                    j--;
                }
            } else {
                while (i < array.length && array[i] > pivot) {
                    i++;
                }
                while (j >= 0 && array[j] < pivot) {
                    j--;
                }
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }

        if (leftIndex < j)
            quickSort(array, leftIndex, j, desc);
        if (i < rightIndex)
            quickSort(array, i, rightIndex, desc);

        return array;
    }

    private static void swap(int[] numbers, int first, int second) {
        int temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }

}
