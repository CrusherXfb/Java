package ArraysSort;

import java.util.ArrayList;
import java.util.Collections;

public class Arrays73 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("Start list: " + list);

        int K = 2;
        int L = 7;

        ArrayList<Integer> subList = new ArrayList<>(list.subList(K, L));

        Collections.reverse(subList);

        for (int i = 0; i < subList.size(); i++) {
            list.set(K + i, subList.get(i));
        }

        System.out.println("Result list: " + list);
    }
}
