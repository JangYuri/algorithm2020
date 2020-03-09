package solutsions.jlis;

import java.util.*;

class Solution {
    /*
     * 어떤 수열에서 0개 이상의 숫자를 지운 결과를 원 수열의 부분 수열이라고 부른다. 그 중 중복된 숫자가 없고 오름 차순으로 정렬되어 있는
     * 부분 수열들을 가리켜 증가 부분 수열이라고 부른다.
     * 
     * 두 개의 정수 수열 A와 B에서 각각 길이 0이상의 증가 부분 수열을 얻은 뒤 이들을 크기 순서대로 합친 것을 합친 증가 부분 수열이라고
     * 부르기로 하자. 이 중 가장 긴 수열을 합친LIS라고 부르자.
     * 
     * 예를들어 '1 3 4 7 9'는 '1 9 4'와 '3 4 7'의 합친 LIS이다. '1 9'와 '3 4 7'을 합쳐 '1 3 4 7 9'를
     * 얻을 수 있기 때문이다. A와 B가 주어질 때, 합친 LIS의 길이를 계산하는 프로그램을 작성하라
     */
    public static void main(String args[]) throws Exception {
        List<TestCase> test = new ArrayList<>();
        test.add(new TestCase(new int[] { 1, 2, 4 }, new int[] { 3, 4, 7 }, 5));
        test.add(new TestCase(new int[] { 1, 2, 4 }, new int[] { 4, 5, 6 }, 6));
        test.add(new TestCase(new int[] { 10, 20, 30, 1, 2 }, new int[] { 10, 20, 30 }, 5));

        for (int i = 0; i < test.size(); i++) {
            System.out.println("TEST " + (i + 1));
            System.out.println("예상 정답 : " + test.get(i).answer);

            System.out.println(" * 내 정답 : " + mySolution(test.get(i).A, test.get(i).B));
        }
    }

    static int mySolution(int[] a, int[] b) {
        int answer = 0;

        return answer;
    }

}

class TestCase {
    public int[] A;
    public int[] B;
    public int answer;

    TestCase(int[] A, int[] B, int answer) {
        this.A = A;
        this.B = B;
        this.answer = answer;
    }

}