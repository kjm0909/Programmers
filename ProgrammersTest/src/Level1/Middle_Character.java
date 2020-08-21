/*
문제 설명
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

재한사항
s는 길이가 1 이상, 100이하인 스트링입니다.
입출력 예
s	    return
abcde	c
qwer	we
*/

package Level1;

public class Middle_Character {
    public static String solution(String s) {
        String answer = "";
        StringBuffer sb = new StringBuffer(s);

        if(sb.length()%2 == 0){ // 짝수
            int start = sb.length()/2-1;
            answer = sb.substring(start, start+2);

        }else{
            int start = sb.length()/2;
            answer = sb.substring(start, start+1);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Return: "+solution("abcde")+", 기대값: c");
        System.out.println("Return: "+solution("qwer")+", 기대값: we");
    }
}
