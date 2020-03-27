package solutsions.palindrome;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[] strNs = sc.nextLine().split(" ");
        int queryN = Integer.parseInt(sc.nextLine());
        int[] startI = new int[queryN];
        int[] endI = new int[queryN];

        for (int i = 0; i < queryN; i++) {
            String[] se = sc.nextLine().split(" ");
            startI[i] = Integer.parseInt(se[0]);
            endI[i] = Integer.parseInt(se[1]);
        }
        sc.close();

        solution(N, strNs, startI, endI);
    }

    static void solution(int n, String[] nums, int[] start, int[] end) {
        for (int i = 0; i < n; i++) {
            if (end[i] - start[i] == 1) {
                System.out.println(1);
                continue;
            }

            int judge = 1;
            for (int v = start[i] - 1; v < (start[i] + end[i]) / 2; v++) {
                if (!nums[v].equals(nums[end[i] - 1 - v])) {
                    judge = 0;
                    break;
                }
            }
            System.out.println(judge);
        }
        return;
    }

    // static Boolean isPalin(String[] nums, int start, int end) {

    // }
}