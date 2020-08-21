/*
문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

입출력 예
answers	    return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
입출력 예 설명
입출력 예 #1

수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2

모든 사람이 2문제씩을 맞췄습니다.
*/
package Level1;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice_Test {

    public static int[] solution(int[] answers) {
        int[] answer = {};

        int[] pattern_1 = {1, 2, 3, 4, 5}; // 5
        int[] pattern_2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] pattern_3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10

        int d =0;
        for(int i = 1; i<= pattern_1.length* pattern_2.length*pattern_3.length; i++){
            if(i%pattern_1.length==0 && i%pattern_2.length==0 && i%pattern_3.length==0) {
                d = i;
               break;
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        if(compare(d, answers, pattern_1) > compare(d, answers, pattern_2)){
            if(compare(d, answers, pattern_1) > compare(d, answers, pattern_3))arrayList.add(1);
            else if(compare(d, answers, pattern_1) < compare(d, answers, pattern_3)) arrayList.add(3);
            else {
                arrayList.add(1);
                arrayList.add(3);
            }
        }else if(compare(d, answers, pattern_2) > compare(d, answers, pattern_1)){
            if(compare(d, answers, pattern_2) > compare(d, answers, pattern_3))arrayList.add(2);
            else if(compare(d, answers, pattern_2) < compare(d, answers, pattern_3))arrayList.add(3);
            else {
                arrayList.add(2);
                arrayList.add(3);
            }
        }else{
            if(compare(d, answers, pattern_1) > compare(d, answers, pattern_3)){
                arrayList.add(1);
                arrayList.add(2);
            }
            else if(compare(d, answers, pattern_1) < compare(d, answers, pattern_3)) arrayList.add(3);
            else{
                arrayList.add(1);
                arrayList.add(2);
                arrayList.add(3);
            }
        }

        answer = new int[arrayList.size()];

        for(int i =0; i< arrayList.size(); i++){
            answer[i] = arrayList.get(i);
        }
        Arrays.sort(answer);

        return answer;
    }

    private static int compare(int d, int[] answers, int[] pattern){
        int result = 0;
        for(int i = 0; i < answers.length; i++){
            if(answers[i% answers.length] == pattern[i% pattern.length]){
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] answers_A = {1,2,3,4,5};
        int[] result_A = solution(answers_A);
        System.out.print("Return: ");
        for(int i=0; i< result_A.length; i++){
            System.out.print(result_A[i]+",");
        }
        System.out.println(" 기대값: {1}");

        int[] answers_B = {1,3,2,4,2};
        int[] result_B = solution(answers_B);
        System.out.print("Return: ");
        for(int i=0; i< result_B.length; i++){
            System.out.print(result_B[i]+",");
        }
        System.out.print(" 기대값: {1,2,3}");
    }
}
