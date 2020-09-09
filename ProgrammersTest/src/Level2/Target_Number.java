/*
* 문제 설명
n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서
타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

제한사항
주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
각 숫자는 1 이상 50 이하인 자연수입니다.
타겟 넘버는 1 이상 1000 이하인 자연수입니다.

입출력 예
numbers         	target	    return
[1, 1, 1, 1, 1]   	3	        5
입출력 예 설명
문제에 나온 예와 같습니다.
* */
package Level2;

public class Target_Number {
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        int count = (int)Math.pow(2, numbers.length); // 모든 경우의 수
        System.out.println("count: "+count);
        for(int i =0; i<count; i++){
            // numbers[i] 값에 대해 ....
            answer += DFS(numbers, 0);
        }
        return answer;
    }
    /*
     모든 경우의 수를 다 봐야할 때, 하나의 경우의 수를 끝까지 깊게 본 다음에 바로 전 노드를 보는 형태
    - 재귀함수를 사용한다.
    - 현재 노드를 탐색하다가 불가능해지면 바로 전 노드를 다시 탐색하는 방식
    */
    /*
    1, 1, 1, 1, 1
    */
    private static int DFS(int[] num, int start){
        int result =0;
        // num[i]
        return result;
    }

    public static void main(String[] args) {
        int[] numbers_A = {1,1,1,1,1};
        System.out.println("Return : "+solution(numbers_A, 3)+", 기댓값: 5");

    }
}

// DFS/BFS 깊이/너비 우선 탐색

/*
DFS : 모든 경우의 수를 다 봐야할 때, 하나의 경우의 수를 끝까지 깊게 본 다음에 바로 전 노드를 보는 형태
- 재귀함수를 사용한다.
- 현재 노드를 탐색하다가 불가능해지면 바로 전 노드를 다시 탐색하는 방식
(시작점에 따라 형태가 조금씩 다름. 여러곳마다 시작해야 한다면 for 문 안에 DSF 함수 넣는 방식)

BFS : 모든 경우의 수를 다 봐야할 때, 조건을 만족하면 바로 나감 (return or system.exit)
- Queue 를 사용한다.

for 문 : 제약 조건이 많지 않은 경우 사용함

*/
