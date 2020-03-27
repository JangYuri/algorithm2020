package solutsions.sort;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] natural = { 3, 4, 2, 12, 8, 40 };

        List<Integer> list = new ArrayList<>();
        for (int v : natural) {
            list.add(v);
        }

        Collections.sort(list, Comparator.reverseOrder());

        for (int v : list) {
            System.out.print(v + " ");
        }

        int[][] natural2 = { { 1, 3 }, { 8, 3 }, { 1, 9 }, { 3, 3 }, { 5, 5 }, { 5, 1 }, { 1, 5 } };

        List<int[]> list2 = new ArrayList<>();
        for (int[] v : natural2) {
            list2.add(v);
        }
        list2.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else
                return o1[0] - o2[0];
        });

        for (int[] v : list2) {
            System.out.print("{" + v[0] + ", " + v[1] + "} ");
        }

    }
}