/*
* 문제 설명
슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다.
그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다.
원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.

이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다.
역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다.
오렐리를 위해 실패율을 구하는 코드를 완성하라.

실패율은 다음과 같이 정의한다.
스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages 가 매개변수로 주어질 때,
실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.

제한사항
스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
stages 의 길이는 1 이상 200,000 이하이다.
stages 에는 1 이상 N + 1 이하의 자연수가 담겨있다.
각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
입출력 예
N	stages	                    result
5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
4	[4,4,4,4,4]	                [4,1,2,3]
입출력 예 설명
입출력 예 #1
1번 스테이지에는 총 8명의 사용자가 도전했으며, 이 중 1명의 사용자가 아직 클리어하지 못했다. 따라서 1번 스테이지의 실패율은 다음과 같다.
1 번 스테이지 실패율 : 1/8
*
2번 스테이지에는 총 7명의 사용자가 도전했으며, 이 중 3명의 사용자가 아직 클리어하지 못했다. 따라서 2번 스테이지의 실패율은 다음과 같다.
2 번 스테이지 실패율 : 3/7
*
마찬가지로 나머지 스테이지의 실패율은 다음과 같다.
3 번 스테이지 실패율 : 2/4
*
4번 스테이지 실패율 : 1/2
*
5번 스테이지 실패율 : 0/1
각 스테이지의 번호를 실패율의 내림차순으로 정렬하면 다음과 같다.

[3,4,2,1,5]
입출력 예 #2

모든 사용자가 마지막 스테이지에 있으므로 4번 스테이지의 실패율은 1이며 나머지 스테이지의 실패율은 0이다.

[4,1,2,3]
* */
package Level1;

import static java.lang.Float.NaN;

public class Failure_Rate {
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        float[] temp = new float[N];
        int players = stages.length;

        for(int i=0; i<N; i++){
            int count = 0;
            int j = 0;
            while(j < stages.length){
                if(stages[j]==(i+1)) count++;
                j++;
            }

            temp[i] = (float)count/players;
            if(Float.isNaN(temp[i])) { // Float 에 NaN 값이 들어갈 경우에 대한 예외 처리 추가
                temp[i] = 0;
            }
            players -= count;

        }
        for(int i=0; i<N; i++){
            float max = temp[0];
            int stage_num = 0;
            int j=0;
            while(j < N){

                if(max < temp[j]) {
                    max = temp[j];
                    stage_num = j+1;
                }
                if(stage_num==0) stage_num = 1;
                j++;
            }
            temp[stage_num-1] = -1;

            answer[i] = stage_num;
        }

        return answer;
    }

    public static void main(String[] args) {
        /*int[] stages_A = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] result_A = solution(5, stages_A);
        System.out.print("Return: ");
        for(int i=0; i< result_A.length; i++){
            System.out.print(result_A[i]+",");
        }
        System.out.println(" 기대값: {3,4,2,1,5");

        int[] stages_B = {4,4,4,4,4};
        int[] result_B = solution(4, stages_B);
        System.out.print("Return: ");
        for(int i=0; i< result_B.length; i++){
            System.out.print(result_B[i]+",");
        }
        System.out.println(" 기대값: {4,1,2,3}");*/

        int[] stages_C = {1,2,3,4,5,6,7};
        int[] result_C = solution(8, stages_C);
        System.out.print("Return: ");
        for(int i=0; i< result_C.length; i++){
            System.out.print(result_C[i]+",");
        }
        System.out.println(" 기대값: {7,6,5,4,3,2,1,8}");

        /*
        *
8이 가장 마지막에 와야합니다.
왜? 8스테이지에는 아무도 도달하지 못했기때문에 0이됩니다.
실패율이 100%인 즉 0/n 과 도달 자체를 안한것은 다르기때문에
도달하지못한 스테이지를 가장 마지막으로 빼면됩니다.
* */
    }
}
