package solutsions.fibonacci;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static HashMap<Integer, int[]> cache;
    static HashMap<Integer, Integer> cache2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        int[] N = new int[T];
        for (int i = 0; i < T; i++) {
            N[i] = Integer.parseInt(sc.nextLine());
        }
        sc.close();

        for (int n : N) {
            cache = new HashMap<>();
            int[] check = fibonacci(n);
            System.out.println(check[0] + " " + check[1]);
        }

    }

    private static int f(int n) {
        if (n == 0) {
            cache2.put(n, 0);
            return 0;
        } else if (n == 1) {
            cache2.put(1, 1);
            return 1;
        } else {
            int num = n - 1;

            int f1 = cache2.containsKey(num) ? cache2.get(num) : f(num);
            int f2 = cache2.containsKey(num - 1) ? cache2.get(num - 1) : f(num - 1);
            int f0 = f1 + f2;
            cache2.put(n, f0);
            return f0;
        }
    }

    private static int[] fibonacci(int n) {
        if (n == 0) {
            int[] zo = { 1, 0 };
            cache.put(0, zo);
            return zo;
        } else if (n == 1) {
            int[] zo = { 0, 1 };
            cache.put(1, zo);
            return zo;
        } else {
            int num = n - 1;

            int[] zo1 = cache.containsKey(num) ? cache.get(num) : fibonacci(num);
            int[] zo2 = cache.containsKey(num - 1) ? cache.get(num - 1) : fibonacci(num - 1);
            int[] zo0 = new int[2];
            for (int v = 0; v < 2; v++) {
                zo0[v] = zo1[v] + zo2[v];
            }
            cache.put(n, zo0);
            return zo0;
        }
    }
}