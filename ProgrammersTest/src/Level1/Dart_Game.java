/*
* 문제 설명
다트 게임
카카오톡에 뜬 네 번째 별! 심심할 땐? 카카오톡 게임별~

카카오톡 게임별의 하반기 신규 서비스로 다트 게임을 출시하기로 했다.
다트 게임은 다트판에 다트를 세 차례 던져 그 점수의 합계로 실력을 겨루는 게임으로, 모두가 간단히 즐길 수 있다.
갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 다트 게임의 점수 계산 로직은 아래와 같다.

다트 게임은 총 3번의 기회로 구성된다.
각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고
* 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다.
* 아차상(#) 당첨 시 해당 점수는 마이너스된다.
스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.

입력 형식
점수|보너스|[옵션]으로 이루어진 문자열 3세트.
예) 1S2D*3T

점수는 0에서 10 사이의 정수이다.
보너스는 S, D, T 중 하나이다.
옵선은 *이나 # 중 하나이며, 없을 수도 있다.
출력 형식
3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다.
예) 37

입출력 예제
예제	dartResult	answer	설명
1	1S2D*3T	    37	    1^1 * 2 + 2^2 * 2 + 3^3
2	1D2S#10S	9	    1^2 + 2^1 * (-1) + 10^1
3	1D2S0T	    3	    1^2 + 2^1 + 0^3
4	1S*2T*3S	23	    1^1 * 2 * 2 + 2^3 * 2 + 3^1
5	1D#2S*3S	5	    1^2 * (-1) * 2 + 2^1 * 2 + 3^1
6	1T2D3D#	    -4	    1^3 + 2^2 + 3^2 * (-1)
7	1D2S3T*	    59	    1^2 + 2^1 * 2 + 3^3 * 2
* */

package Level1;

public class Dart_Game {
    public static int solution(String dartResult) {
        int answer = 0;
        StringBuffer sb = new StringBuffer(dartResult);
        double[] result = new double[3];
        int count = 0;
        for(int i=1; i<sb.length(); i++){
            String str = Character.toString(sb.charAt(i));
            if(str.equals("*") || str.equals("#")) {
                count--;
                if(str.equals("*")) { // * 2
                    System.out.println("str: " + str);
                    if(count>=1){
                        result[count-1] = result[count-1]*2;
                        result[count] = result[count]*2;
                    }
                    else {
                        result[0] = result[0]*2;
                        System.out.println("result 0 *: " + result[0]);
                    }
                } else if(str.equals("#")){ // -
                    System.out.println("str: " + str);
                  result[count] = result[count] * (-1);
                    System.out.println("result #: " + result[count]);
                }
                count++;
            }else{
                if(!Character.isDigit(sb.charAt(i))) {
                    String str_f = Character.toString(sb.charAt(i - 1));
                    System.out.println("str: " + str + ", str_f: " + str_f);
                    int value = Integer.parseInt(str_f);
                    if(value==0) {
                        if(i>=2 && Character.isDigit(sb.charAt(i-2))){
                            value = 10;
                        }
                    }
                    if (str.equals("S")) {
                        result[count] = Math.pow(value, 1);
                    } else if (str.equals("D")) {
                        result[count] = Math.pow(value, 2);
                    } else if (str.equals("T")) {
                        result[count] = Math.pow(value, 3);
                    }
                    System.out.println("result: " + result[count] + ", count: " + count);
                    count++;
                }
            }
        }
        for(int i=0; i<result.length; i++){
            System.out.println("result: "+result[i]);
            answer += result[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("dart input: 1S2D*3T : "+solution("1S2D*3T")+", 기댓값: 37");
        System.out.println("dart input: 1D2S#10S : "+solution("1D2S#10S")+", 기댓값: 9");
        System.out.println("dart input: 1D2S0T : "+solution("1D2S0T")+", 기댓값: 3");
        System.out.println("dart input: 1S*2T*3S : "+solution("1S*2T*3S")+", 기댓값: 23");
        System.out.println("dart input: 1D#2S*3S : "+solution("1D#2S*3S")+", 기댓값: 5");
        System.out.println("dart input: 1T2D3D# : "+solution("1T2D3D#")+", 기댓값: -4");
        System.out.println("dart input: 1D2S3T* : "+solution("1D2S3T*")+", 기댓값: 59");
    }
}
