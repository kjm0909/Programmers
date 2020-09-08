/*
* 문제 설명
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

제한 사항
numbers의 길이는 1 이상 100,000 이하입니다.
numbers의 원소는 0 이상 1,000 이하입니다.
정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
입출력 예
numbers	            return
[6, 10, 2]	        6210
[3, 30, 34, 5, 9]	9534330
*
* */

package Level2;

import java.util.Arrays;
import java.util.Comparator;

public class Largest_Number {
    public static String solution(int[] numbers) {
        String answer = "";
        String[] numStr = new String[numbers.length];

        for(int i=0; i< numbers.length;i++){
            numStr[i] = String.valueOf(numbers[i]);
            System.out.print(numStr[i]+", ");
        }

        Arrays.sort(numStr, new Comparator<String>() { // Comparator : 객체 간 특별한 정렬이 필요할 때 사용
                    @Override
                    public int compare(String o1, String o2) {
                        return (o2 + o1).compareTo(o1 + o2);
                        // A.compareTo(B) 일 때, A<B : 음수 리턴, A=B : 0 리턴, A>B : 양수 리턴
                        // o2 + o1 값 vs o1 + o2 값 비교 -> o2가 더 크면 swap
                    }
                });
        // numbers의 원소는 0 이상 1,000 이하입니다.
        // 맨 앞의 원소가 0이 올 경우 return 0 해줘야 함 -> testcase 11
        if(numStr[0].equalsIgnoreCase("0")) return "0";

        for(int i=0; i< numbers.length;i++){
            answer += numStr[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers_A = {6, 10, 2};
        System.out.println("Return: "+solution(numbers_A)+", 기대값: 6210");
        int[] numbers_B = {3, 30, 34, 5, 9};
        System.out.println("Return: "+solution(numbers_B)+", 기대값: 9534330");
        int[] numbers_C = {3, 30, 34, 5, 9, 4, 40, 42};
        System.out.println("Return: "+solution(numbers_C)+", 기대값: 954424034330");
        int[] numbers_D = {41, 413, 9};
        System.out.println("Return: "+solution(numbers_D)+", 기대값: 941413");
        int[] numbers_E = {158, 15, 9};
        System.out.println("Return: "+solution(numbers_E)+", 기대값: 915815");
        int[] numbers_F = {1,2,21, 21};
        System.out.println("Return: "+solution(numbers_F)+", 기대값: '221211");
    }
}
