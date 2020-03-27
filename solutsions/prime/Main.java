package solutsions.prime;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] kn = sc.nextLine().split(" ");
        int K = Integer.parseInt(kn[0]);
        long[] primeNum = new long[K];
        PriorityQueue<Long> pQueue = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            primeNum[i] = sc.nextInt();
            pQueue.add(primeNum[i]);
        }
        sc.close();

        int N = Integer.parseInt(kn[1]);
        for (int i = 0; i < N; i++) {
            N--;
            long n = pQueue.poll();
            if (N == 0) {
                System.out.println(n);
                break;
            }
            for (long p : primeNum) {
                pQueue.add(n * p);
                if (n % p == 0)
                    break;
            }
        }
    }
}