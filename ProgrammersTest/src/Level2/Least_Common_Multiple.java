/*
* N개의 최소공배수
문제 설명
두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
* 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
* n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

제한 사항
arr은 길이 1이상, 15이하인 배열입니다.
arr의 원소는 100 이하인 자연수입니다.
입출력 예
arr	            result
[2,6,8,14]	    168
[1,2,3]	        6
* */
package Level2;

public class Least_Common_Multiple {
    public static int solution(int[] arr) {
        int answer = arr[0];
        for(int i =0; i<arr.length-1; i++){
            // arr[i] 와 arr[i+1] 의 최소 공배수 구하기
            System.out.println("answer : "+answer);
            answer = getLeast(answer, arr[i+1]);
        }
        return answer;
    }

    private static int getLeast(int n, int m){
        int greatest = 0;
        int min = Math.min(n, m);
        int max = Math.max(n, m);
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
        // n * m = greatest * result
        int result = n * m / greatest;
        return result;
    }

    public static void main(String[] args) {
        int[] arr_A = {2,6,8,14};
        System.out.println("Return : "+solution(arr_A)+", 기대값 : 168");
        int[] arr_B = {1,2,3};
        System.out.println("Return : "+solution(arr_B)+", 기대값 : 6");
    }
}
