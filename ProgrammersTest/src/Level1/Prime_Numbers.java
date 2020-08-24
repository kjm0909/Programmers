/*
* 문제 설명
1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.

소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
(1은 소수가 아닙니다.)

제한 조건
n은 2이상 1000000이하의 자연수입니다.
입출력 예
n	result
10	4
5	3
입출력 예 설명
입출력 예 #1
1부터 10 사이의 소수는 [2,3,5,7] 4개가 존재하므로 4를 반환

입출력 예 #2
1부터 5 사이의 소수는 [2,3,5] 3개가 존재하므로 3를 반환
* */
package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Prime_Numbers {
    public static int solution(int n) {
        int answer = 0;

        // 에라토스테네스의 체 개념
        /*
        * 그리스의 수학자이자 지리학자인 에라토스테네스가 고안한 소수(素數)를 찾는 방법으로,
        * 이 방법으로 소수를 찾으려면, 2부터 시작해 자연수를 차례로 쓴 다음,
        * 2 이외의 2의 배수, 3 이외의 3의 배수, 5 이외의 5의 배수의 순서로 수를 지워나가 끝에 남는 수가 소수이다.
        * */

        if(n==2) return 1;
        if(n==3) return 2;
        int[] arr = new int[n+1];
        arr[0] = 0; // 0 번째 : 소수 아님
        arr[1] = 0; // 1 번째 : 소수 아님
        for(int i=2; i<=n; i++){ // 2 번째 부터 일단 다 소수
            arr[i] = 1;
            answer++;
        }
        for(int i = 2; i <= Math.sqrt(n); i++){ // i 의 배수 체크
            for(int j = i*i; j <=n; j+=i){ // i의 제곱수 부터 i씩 더하면서 소수 아님 체크 / i = 2 면 4, 6, 8, 10, ....
                if(arr[j]==1) answer--;
                arr[j] = 0;
            }
        }

        /* ArrayList 사용 시 효율성에서 fail 됨
        System.out.println(n+" 의 소수 찾기 : ");
        ArrayList<Boolean> arrayList = new ArrayList<Boolean>(n+1);
        arrayList.add(false); // 0 번째 : 소수 아님
        arrayList.add(false); // 1 번째 : 소수 아님

        for(int i = 2; i <= n; i++){ // 2 번째 부터 일단 다 소수
            arrayList.add(i, true);
            answer++;
        }


        for(int i = 2; i <= Math.sqrt(n); i++){ // i 의 배수 체크
            for(int j = i*i; j <=n; j+=i){ // i의 제곱수 부터 i씩 더하면서 소수 아님 체크 / i = 2 면 4, 6, 8, 10, ....
                if(arrayList.get(j)) answer--;
                arrayList.set(j, false);
            }
        }*/

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("Return : "+solution(10)+", 기대값: 4"); // 2,3,5,7
        System.out.println("Return : "+solution(5)+", 기대값: 3"); // 2,3,5
        System.out.println("Return : "+solution(19)+", 기대값: 8"); //2,3,5,7,11,13,17,19
        System.out.println("Return : "+solution(25)+", 기대값: 9"); //2,3,5,7,11,13,17,19,23
        System.out.println("Return : "+solution(33)+", 기대값: 11"); //2,3,5,7,11,13,17,19,23,29,31
        System.out.println("Return : "+solution(37)+", 기대값: 12"); //2,3,5,7,11,13,17,19,23,29,31,37
    }
}
