/*
* 문제 설명
두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요.
* 배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다.
* 예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로
* solution(3, 12)는 [3, 12]를 반환해야 합니다.

제한 사항
두 수는 1이상 1000000이하의 자연수입니다.
입출력 예
n	m	return
3	12	[3, 12]
2	5	[1, 10]
입출력 예 설명
입출력 예 #1
위의 설명과 같습니다.

입출력 예 #2
자연수 2와 5의 최대공약수는 1, 최소공배수는 10이므로 [1, 10]을 리턴해야 합니다.
* */
package Level1;

public class Greatest_Least {
    public static int[] solution(int n, int m) {
        int[] answer = new int[2];
        System.out.println(n+"와 "+m+" 의 최대공약수, 최소공배수 구하기");

        int min = Math.min(n, m);
        int max = Math.max(n, m);
        int greatest = 0;

        for(int i = 1; i <= min; i++){
            // 약수 : i 로 나누어 떨어지는 수
            if(min%i==0) {
                for (int j = 1; j <= max; j++) {
                    if (max % j == 0) {
                        if (i == j) greatest = i;
                    }
                }
            }
        }
        answer[0] = greatest;
        // 숫자의 곱 = 최대 공약수 * 최소 공배수
        answer[1] = min * max / greatest;

        return answer;
    }

    public static void main(String[] args) {
        int[] answer_A = solution(3, 12);
        System.out.print("Return: ");
        for(int i=0; i< answer_A.length; i++){
            System.out.print(answer_A[i]+",");
        }
        System.out.println(" 기대값: {3, 12}");

        int[] answer_B = solution(2, 5);
        System.out.print("Return: ");
        for(int i=0; i< answer_B.length; i++){
            System.out.print(answer_B[i]+",");
        }
        System.out.println(" 기대값: {1, 10}");

        int[] answer_C = solution(12, 28);
        System.out.print("Return: ");
        for(int i=0; i< answer_C.length; i++){
            System.out.print(answer_C[i]+",");
        }
        System.out.println(" 기대값: {4, 84}");
    }
}
