package solutsions.lcs;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.nextLine();
        String B = sc.nextLine();
        sc.close();

        System.out.print(solution(A, B));

    }

    static int solution(String a, String b) {
        int[][] comp = new int[a.length() + 1][b.length() + 1];
        Arrays.fill(comp[0], 0);
        for (int i = 1; i < a.length() + 1; i++) {
            comp[i][0] = 0;
        }

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    comp[i + 1][j + 1] = comp[i][j] + 1;
                } else
                    comp[i + 1][j + 1] = comp[i][j + 1] > comp[i + 1][j] ? comp[i][j + 1] : comp[i + 1][j];
            }
        }
        return comp[a.length()][b.length()];
    }
}