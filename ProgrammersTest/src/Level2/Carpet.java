/*
* 문제 설명
Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.

Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.

Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때
* 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한사항
갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
입출력 예
brown	yellow	return
10      	2	[4, 3]
8	        1	[3, 3]
24	        24	[8, 6]

* */
package Level2;

public class Carpet {
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 중앙 노란색 , 테두리 1줄 갈색
        // 갈색 N 개 -> 테두리 !
        int sum = brown + yellow; // 전체 넓이
        int row = 0;
        int col = 0;
        // 약수 중 가운데 노란색 들어가야 하므로 가로는 3이상의 값이어야 함
        for(int i=3; i<=sum; i++){
            if(sum%i == 0 && sum/i <= i) { // 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
                row = i;
                col = sum / row;
                int brownSum = row*2 + (col-2)*2;
                if ((brown - row * 2) % 2 == 0 && brownSum == brown) break;
            }
        }

        answer[0] = row;
        answer[1] = col;

        return answer;
    }

    public static void main(String[] args) {
        int[] result_A = solution(10, 2);
        System.out.print("Return: ");
        for(int i=0; i< result_A.length; i++){
            System.out.print(result_A[i]+",");
        }
        System.out.println(" 기대값: {4, 3}");

        int[] result_B = solution(8, 1);
        System.out.print("Return: ");
        for(int i=0; i< result_B.length; i++){
            System.out.print(result_B[i]+",");
        }
        System.out.println(" 기대값: {3, 3}");

        int[] result_C = solution(24, 24);
        System.out.print("Return: ");
        for(int i=0; i< result_C.length; i++){
            System.out.print(result_C[i]+",");
        }
        System.out.println(" 기대값: {8, 6}");

        int[] result_D = solution(50, 22);
        System.out.print("Return: ");
        for(int i=0; i< result_D.length; i++){
            System.out.print(result_D[i]+",");
        }
        System.out.println(" 기대값: {24, 3}");
    }
}
