package ArraysSort;
import java.util.ArrayList;

public class Arrays66 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : array) {
            list.add(num);
        }
        System.out.println("Start list: " + list);

        Integer firstEven = null; //первое чётное
        for (int num : list) {
            if (num % 2 == 0) {
                firstEven = num;
                break;
            }
        }
        System.out.println("First even: " + firstEven);

        if (firstEven != null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) % 2 == 0) {
                    list.set(i, list.get(i) + firstEven);
                }
            }
        }

        System.out.println("Result list: " + list);
    }
}

