package solutsions.wildcard;

import java.util.*;

class Solution {
    /*
     * 와일드카드 패턴을 앞에서 한 글자씩 파일명과 비교해서 모든 글자가 일치했을 때 해당 와일드카드 패턴이 파일명과 대응된다고 말한다. 단,
     * 와일드카드 패턴에 포함된 ?는 어떤 글자와도 대응된다고 가정하며, 는 0글자 이상의 어떤 문자열에도 대응된다고 가정한다.
     * 
     * 예를들어 와일드카드 he?p는 파일명 help에도, heap에도 대응되지만, helpp에는 대응되지 않는다. 반면 와일드카드 *p*는
     * 파일명 help에도, papa에도 대응되지만 hello에는 대응되지 않는다.
     */
    public static void main(String args[]) throws Exception {
        List<TestCase> test = new ArrayList<>();
        test.add(new TestCase("he?p", new String[] { "help", "heap", "helpp" }, new String[] { "help", "heap" }));
        test.add(new TestCase("*p*", new String[] { "help", "papa", "hello" }, new String[] { "help", "papa" }));
        test.add(new TestCase("*bb*", new String[] { "babbbc" }, new String[] { "babbbc" }));

        for (int i = 0; i < test.size(); i++) {
            System.out.println("TEST " + (i + 1));
            System.out.println("예상 정답 : " + test.get(i).getAnswer());

            String[] myAnswer = mySolution(test.get(i).w, test.get(i).filename);

            String myAns = "";
            for (String string : myAnswer) {
                myAns += string + " ";
            }
            System.out.println(" * 내 정답 : " + myAns);
        }
    }

    static String[] mySolution(String w, String[] filename) {
        List<String> answer = new ArrayList<>();
        /*
         * 1. 글자 하나하나 대응시켜서 맞는지 확인
         * 
         * 2. w랑 filename이랑 하나하나 맞춰나감 - 더이상 나갈 수 없을 때 종료
         * 
         * 1. s-filename이 대응되지 않을 때 2. w 끝에 도달 - 길이가 정확하게 같아야 (패턴 = 문자열) 3. filename 끝에
         * 도달 - 패턴은 남았는데 문자열이 이미 끝난 경우 - 남은 패턴이 전부 *라면 대응 가능 4. w[pos]가 *인 경우 - 몇글자가
         * 대응될지 모르기 때문에 재귀호출로 모든 가능성 검사
         */

        for (int i = 0; i < filename.length; i++) {
            if (isMatch(new HashMap<Integer[], Boolean>(), 0, 0, w, filename[i]))
                answer.add(filename[i]);
        }

        return answer.toArray(new String[answer.size()]);
    }

    static boolean isMatch(String w, String s) {
        int pos = 0;
        while (pos < s.length() && pos < w.length() && (w.charAt(pos) == '?' || w.charAt(pos) == s.charAt(pos))) {
            ++pos;
        }
        // 2번 경우
        if (pos == w.length())
            return pos == s.length();
        if (w.charAt(pos) == '*')
            for (int skip = 0; pos + skip <= s.length(); skip++) {
                if (isMatch(w.substring(pos + 1), s.substring(pos + skip)))
                    return true;
            }
        return false;
    }

    /*
     * 1. 메모이제이션을 이용하여 매번 스트링객체를 쪼개서 만들지 않고, 위치값을 이용하여 탐색하면서 케시에 비교값을 넣고 그 값들을 계속해서
     * 참조하여 속도를 높인다. >> 자바는 해쉬를 이용해서!! // -1 : 아직 답이 계산되지 않았음을 의미 // 1은 해당 입력들이 서로
     * 대응됨을 의미 // 0은 해당 입력들이 서로 대응되지 않음을 의미한다. 2. while문에서 스트링 인덱스값만 올려주고 있는데, 여기에서
     * 바로 그 다음 인덱스 값으로 재귀로 불러주면 더 단순해진다. 에 몇글자가 대응되어야 할지를 확인하는 것도 반복문이 아닌 재귀호출로 바꾼다면
     * 시간복잡도가 O(n2)가 된다.
     */

    static boolean isMatch(HashMap<Integer[], Boolean> dp, int posW, int posS, String w, String s) {
        if (dp.containsKey(new Integer[] { posW, posS }))
            return dp.get(new Integer[] { posW, posW });
        while (posS < s.length() && posW < w.length() && (w.charAt(posW) == '?' || w.charAt(posW) == s.charAt(posS))) {
            posW++;
            posS++;
        }
        // 2번 경우
        if (posW == w.length()) {
            Boolean result = posS == s.length();
            dp.put(new Integer[] { posW, posS }, result);
            return result;
        }
        if (w.charAt(posW) == '*')
            for (int skip = 0; posS + skip <= s.length(); skip++) {
                if (isMatch(dp, posW + 1, posS + skip, w, s)) {
                    dp.put(new Integer[] { posW + 1, posS + skip }, true);
                    return true;
                }
            }
        dp.put(new Integer[] { posW, posS }, false);
        return false;
    }
}

class TestCase {
    public String w;
    public String[] filename;
    public String[] answer;

    TestCase(String w, String[] filename, String[] answer) {
        this.w = w;
        this.filename = filename;
        this.answer = answer;
    }

    public String getAnswer() {
        String ans = "";
        for (String str : answer) {
            ans += str + " ";
        }
        return ans;
    }
}