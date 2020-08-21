/*
* 문제 설명
array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.

제한사항
arr은 자연수를 담은 배열입니다.
정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
divisor는 자연수입니다.
array는 길이 1 이상인 배열입니다.
입출력 예
arr	            divisor	    return
[5, 9, 7, 10]	    5	    [5, 10]
[2, 36, 1, 3]	    1	    [1, 2, 3, 36]
[3,2,6]         	10	    [-1]
입출력 예 설명
입출력 예#1
arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.

입출력 예#2
arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.

입출력 예#3
3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴합니다.
* */
package Level1;

import java.util.ArrayList;
import java.util.Collections;

public class Divide_Array {
    public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(divisor == 1 || arr[i]%divisor == 0){
                list.add(arr[i]);
            }
        }
        Collections.sort(list);
        if(list.size() == 0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }else{
            answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                answer[i] = list.get(i);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[] arr_A = {5, 9, 7, 10};
        int[] answer_A = solution(arr_A, 5);
        System.out.print("Return: ");
        for(int i=0; i< answer_A.length; i++){
            System.out.print(answer_A[i]+",");
        }
        System.out.println(" 기대값: {5, 10}");

        int[] arr_B = {2, 36, 1, 3};
        int[] answer_B = solution(arr_B, 1);
        System.out.print("Return: ");
        for(int i=0; i< answer_B.length; i++){
            System.out.print(answer_B[i]+",");
        }
        System.out.println(" 기대값: {1, 2, 3, 36}");

        int[] arr_C = {3,2,6};
        int[] answer_C = solution(arr_C, 10);
        System.out.print("Return: ");
        for(int i=0; i< answer_C.length; i++){
            System.out.print(answer_C[i]+",");
        }
        System.out.println(" 기대값: {-1}");
    }
}
