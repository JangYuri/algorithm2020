package solutsions.combination;

import java.util.*;

public class Solution {
    static List<Boolean[]> result = new ArrayList<>();
    static List<String> resultS = new ArrayList<>();

    public static void main(String args[]) throws Exception {
        int[] test = { 4, 5, 6 };

        for (int i = 0; i < test.length; i++) {
            System.out.println("TEST " + (i + 1));
            System.out.println(" * 조합 결과 : " + mySolution(test[i]));
        }
    }

    static int mySolution(int n) {
        int answer = 0;
        for (int i = 1; i < 3; i++) {
            result.clear();
            // System.out.println(n + "개 중에서 " + i + "개 고를 경우");
            Boolean[] visited = new Boolean[n];
            Arrays.fill(visited, false);
            combination(visited, n, i, 0);
            for (int j = 0; j < result.size(); j++) {
                Boolean[] r = result.get(j);
                for (int k = 0; k < r.length; k++) {
                    if (r[k])
                        System.out.print(k + " ");
                }
                System.out.println();
            }
        }

        return answer;
    }

    static void combination(Boolean[] visited, int n, int r, int index) {
        if (r == 0) { // 다 고름
            Boolean[] copy = new Boolean[visited.length];
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == true)
                    copy[i] = visited[i]; // System.out.print(i + " ");
                else
                    copy[i] = visited[i];
            }
            // System.out.println();
            result.add(copy);
            return;
        } else if (index == n) { // n개중에서 n개 고를 경우
            return;
        } else {
            // 고를 경우
            visited[index] = true;
            combination(visited, n, r - 1, index + 1);
            // 안고를 경우
            visited[index] = false;
            combination(visited, n, r, index + 1);
        }
    }

}

/**
 * Combination
 */
class Combination {
    Boolean[] visited;

    Combination(int n) {
        visited = new Boolean[n];
    }
}
