package solutsions.combination;

import java.util.*;

public class Solution {
    static List<List<Integer>> result;
    static int count = 0;

    public static void main(String args[]) throws Exception {
        // int[][] test = { { 4, 2 }, { 5, 3 }, { 6, 4 } };

        // for (int i = 0; i < test.length; i++) {
        // System.out.println("TEST " + (i + 1));
        // System.out.println(" * 조합 결과 : " + mySolution(test[i][0], test[i][1]));
        // }

        HashMap<String, List<Integer>> testCases = new HashMap<>();
        List<Integer> idList = new ArrayList<>();
        idList.add(5);
        idList.add(2);
        idList.add(10);
        idList.add(7);
        idList.add(3);
        testCases.put("Pr*do", idList);
        List<Integer> idList2 = new ArrayList<>();
        idList2.add(2);
        idList2.add(1);
        idList2.add(7);
        idList2.add(3);
        testCases.put("*rodo", idList2);
        List<Integer> idList3 = new ArrayList<>();
        idList3.clear();
        idList3.add(7);
        idList3.add(9);
        idList3.add(10);
        testCases.put("*ro", idList3);
        mySolution2(testCases);

    }

    // n * n2 * n3 * ... 중복하지 않는 조합
    static void mySolution2(HashMap<String, List<Integer>> mapList) {
        for (String key : mapList.keySet()) {
            List<Integer> idList = mapList.get(key);
            System.out.println(key + " : ");
            for (int j = 0; j < idList.size(); j++) {
                System.out.print(idList.get(j) + " ");
            }
            System.out.println();
        }
        List<String> keyList = new ArrayList<>(mapList.keySet());

        Collections.sort(keyList, (o1, o2) -> {
            return mapList.get(o1).size() - mapList.get(o2).size();
        });
        List<List<Integer>> candiList = new ArrayList<>();
        System.out.println("sorted and ....");
        for (String key : keyList) {
            System.out.print(key + " ");
            candiList.add(mapList.get(key));
        }
        dynamicCombi(candiList, new int[candiList.size()], 0);
        System.out.println("answer : " + count);
    }

    static void dynamicCombi(List<List<Integer>> candiList, int[] combi, int index) {
        List<Integer> idList = candiList.get(index);
        for (int i = 0; i < idList.size(); i++) {
            Boolean dupli = false;
            for (int j = 0; j < index; j++) {
                if (combi[j] == idList.get(i)) {
                    dupli = true;
                    break;
                }
            }
            if (dupli)
                continue;
            else {
                combi[index] = idList.get(i);
                if (index == candiList.size() - 1) {
                    count++;
                    for (int v : combi) {
                        System.out.print(v + " ");
                    }
                    System.out.println();
                } else
                    dynamicCombi(candiList, combi, index + 1);
            }
        }
    }

    // 1~n >> 순서없이 중복없이 선택
    static int mySolution(int n, int r) {
        result = new ArrayList<>();
        Boolean[] visited = new Boolean[n + 1];
        Arrays.fill(visited, false);
        combination(visited, n, r, 1);

        for (List<Integer> combis : result) {
            for (int v : combis)
                System.out.print(v + " ");
            System.out.println();
        }
        return result.size();
    }

    static void combination(Boolean[] visited, int n, int r, int index) {
        if (r == 0) { // 다 고름
            List<Integer> combi = new ArrayList<>();
            for (int num = 1; num < visited.length; num++) {
                if (visited[num])
                    combi.add(num);
            }
            result.add(combi);
            return;
        } else if (index == n + 1) { // index가 끝에 도달했을 때
            return;
        } else {
            // 고를 경우
            visited[index] = true;
            combination(visited, n, r - 1, index + 1);
            // 안고를 경우
            visited[index] = false;
            combination(visited, n, r, index + 1);
            return;
        }
    }

}
