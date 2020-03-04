package algorithm2020.solutsions.wildcard;

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
         * 1. 글자 하나하나 대응시켜서 맞는지 확인 2. w랑 filename이랑 하나하나 맞춰나감 - 더이상 나갈 수 없을 때 종료 1.
         * s-filename이 대응되지 않을 때 2. w 끝에 도달 - 길이가 정확하게 같아야 (패턴 = 문자열) 3. filename 끝에 도달
         * - 패턴은 남았는데 문자열이 이미 끝난 경우 - 남은 패턴이 전부 *라면 대응 가능 4. w[pos]가 *인 경우 - 몇글자가 대응될지
         * 모르기 때문에 재귀호출로 모든 가능성 검사
         */

        for (int i = 0; i < filename.length; i++) {
            if (isMatch(w, filename[i]))
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