/*

board의 각 칸에는 0 이상 100 이하인 정수가 담겨있습니다.
0은 빈 칸을 나타냅니다.
1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을 나타냅니다.
moves 배열의 크기는 1 이상 1,000 이하입니다.
moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.

입출력 예
board	                                                            moves	            result
[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	[1,5,3,5,1,2,1,4]	    4

입출력 예 #1
인형의 처음 상태는 문제에 주어진 예시와 같습니다.
크레인이 [1, 5, 3, 5, 1, 2, 1, 4] 번 위치에서 차례대로 인형을 집어서 바구니에 옮겨 담은 후,
상태는 아래 그림과 같으며 바구니에 담는 과정에서 터트려져 사라진 인형은 4개 입니다.

*/
package Level1;

public class Crane_Game {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        StringBuffer result = new StringBuffer("");

        /*
        board[0][] = {0,0,0,0,0};
        board[1][] = {0,0,1,0,3};
        board[2][] = {0,2,5,0,1};
        board[3][] = {4,2,4,4,2};
        board[4][] = {3,5,1,3,2};
        ===========================
        moves[] = {1,5,3,5,1,2,1,4};
        ============================
        result[] = {4,3,1,1,3,2,3,4};
        answer = 4;
        */

        for(int m = 0; m < moves.length; m++){ // moves.length = 8
            int point = moves[m]-1; // 인형 가져올 위치
            for(int i = 0; i < board.length; i++){
                if(board[i][point] != 0){

                    String[] arr = result.toString().split("[|]");
                    String pointer = Integer.toString(board[i][point]);
                    if(pointer.equalsIgnoreCase(arr[arr.length-1])){
                        answer += 2;
                        result = setArray(arr, arr.length-1);
                    }
                    else{
                        result.append(pointer+"|");
                    }

                    board[i][point] = 0; // 빼온 자리는 0으로
                    break;
                }
            }
        }

        return answer;
    }

    private static StringBuffer setArray(String[] arr, int len){
        StringBuffer sb = new StringBuffer("");
        for(int i=0; i<len; i++){
            sb.append(arr[i]+"|");
        }
        return sb;
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println("Return : "+solution(board, moves)+", 기대값: 4");
    }
}
