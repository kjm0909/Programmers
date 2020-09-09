/*
* 문제 설명
2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution 을 완성해주세요.

제한 조건
행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
곱할 수 있는 배열만 주어집니다.
입출력 예
arr1	                                 arr2	                                    return
[[1, 4], [3, 2], [4, 1]]	            [[3, 3], [3, 3]]                	    [[15, 15], [15, 15], [15, 15]]
[[2, 3, 2], [4, 2, 4], [3, 1, 4]]	    [[5, 4, 3], [2, 4, 1], [3, 1, 1]]	    [[22, 22, 11], [36, 28, 18], [29, 20, 14]]
* */

package Level2;

public class Matrix_Multiple {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr2[0].length;
        int[][] answer = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int r = 0;
                while(r < arr1[0].length){
                    answer[i][j] += arr1[i][r] * arr2[r][j];
                    r++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] arr1_A = {{1,4}, {3,2}, {4,1}}; // arr1_A.length 3 , 3*1
        int[][] arr2_A = {{3,3}, {3,3}}; // 2*1
        int[][] result_A = solution(arr1_A, arr2_A); // 3*1 앞 행렬의 행의 갯수 * 뒷 행렬의 열의 갯수
        System.out.println("Return : "+arr1_A.length+", "+arr2_A[0].length);
        for(int i=0; i< result_A.length; i++){
            for(int j=0; j<result_A[i].length; j++){
                System.out.print(result_A[i][j]+", ");
            }
            System.out.print("\n");
        }
        System.out.println("\n기대값: [[15, 15], [15, 15], [15, 15]]");

        int[][] arr1_B = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}; // arr1_A.length 3 , 3*1
        int[][] arr2_B = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}}; // 2*1
        int[][] result_B = solution(arr1_B, arr2_B); // 3*1
        System.out.println("Return : "+arr1_B.length+", "+arr2_B[0].length);
        for(int i=0; i< result_B.length; i++){
            for(int j=0; j<result_B[i].length; j++){
                System.out.print(result_B[i][j]+", ");
            }
            System.out.print("\n");
        }
        System.out.println("\n기대값: [[22, 22, 11], [36, 28, 18], [29, 20, 14]]");

    }
}
