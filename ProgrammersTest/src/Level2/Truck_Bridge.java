/*
문제 설명
트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다.
모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length 이고 다리는 무게 weight 까지 견딥니다.
※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다.
무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

경과 시간	다리를 지난 트럭	다리를 건너는 트럭	    대기 트럭
    0	         []	               []      	    [7,4,5,6]
    1~2	         []                [7]      	[4,5,6]
    3	         [7]	           [4]	        [5,6]
    4	         [7]	           [4,5]    	[6]
    5	         [7,4]	           [5]	        [6]
    6~7	         [7,4,5]	       [6]	        []
    8	         [7,4,5,6]	       []	        []
따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights 가 주어집니다.
이 때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

제한 조건
bridge_length 는 1 이상 10,000 이하입니다.
weight 는 1 이상 10,000 이하입니다.
truck_weights 의 길이는 1 이상 10,000 이하입니다.
모든 트럭의 무게는 1 이상 weight 이하입니다.
입출력 예
bridge_length	weight	truck_weights	                return
2	            10	    [7,4,5,6]	                    8
100	            100	    [10]	                        101
100	            100	    [10,10,10,10,10,10,10,10,10,10]	110
* */
package Level2;

import java.util.LinkedList;
import java.util.Queue;

public class Truck_Bridge {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> waitingQ = new LinkedList<>();
        for(int i=0; i<truck_weights.length;i++)
        {
            waitingQ.add(truck_weights[i]);
        }
        Queue<Integer> passingList = new LinkedList<>();

        int totalWeight = 0;
        while(!waitingQ.isEmpty()){
            System.out.print("passing("+ passingList.size()+") : ");
            queuePrint(passingList);
            System.out.println(" ");
            System.out.print("waiting("+ waitingQ.size()+") : ");
            queuePrint(waitingQ);

            if (passingList.isEmpty()) {
                passingList.add(waitingQ.poll());
                totalWeight = passingList.peek();
            } else {
                int nextTruckWeight = waitingQ.peek();
                if (nextTruckWeight + totalWeight <= weight) {
                    int next = waitingQ.poll();
                    totalWeight += next;
                    passingList.add(next);
                } else {
                    passingList.add(0);
                }
                if(passingList.size() == bridge_length) {
                    totalWeight -= passingList.poll();
                    //passingList.add(waitingQ.poll());
                }
            }
            if(waitingQ.isEmpty()) answer += bridge_length;
            answer++;
            System.out.println("\n>>> answer : "+answer);
        }

        return answer;
    }

    private static void queuePrint(Queue<Integer> queue){
        Object[] list = queue.toArray();
        for(int i=0; i<list.length; i++){
            System.out.print(list[i]+", ");
        }
    }

    private static void listPrint(LinkedList<Integer> queue){
        for(int i=0; i<queue.size(); i++){
            System.out.print(queue.get(i)+", ");
        }
    }

    public static void main(String[] args) {
        int[] truck_weights_A = {7,4,5,6};
        //System.out.println("Return : "+solution(2, 10, truck_weights_A)+", 기대값: 8");
        int[] truck_weights_B = {10};
        //System.out.println("Return : "+solution(100, 100, truck_weights_B)+", 기대값: 101");
        int[] truck_weights_C = {10,10,10,10,10,10,10,10,10,10};
        //System.out.println("Return : "+solution(100, 100, truck_weights_C)+", 기대값: 110");
//        int[] truck_weights_D = {1, 1, 1, 1};
//        System.out.println("Return : "+solution(4, 2, truck_weights_D)+", 기대값: 10");
//        int[] truck_weights_E = {1, 1, 1};
//        System.out.println("Return : "+solution(3, 1, truck_weights_E)+", 기대값: 10");
        int[] truck_weights_F = {1, 1, 1, 1, 1, 2, 2};
        System.out.println("Return : "+solution(5, 5, truck_weights_F)+", 기대값: 14");
        int[] truck_weights_G = {1, 1, 1, 1, 1, 3, 3};
        System.out.println("Return : "+solution(7, 7, truck_weights_G)+", 기대값: 18");
        int[] truck_weights_H = {1, 1, 1, 1, 1, 2, 2, 2, 2};
        System.out.println("Return : "+solution(5, 5, truck_weights_H)+", 기대값: 19");
        int[] truck_weights_J = {2, 2, 2, 2, 1, 1, 1, 1, 1};
        System.out.println("Return : "+solution(5, 5, truck_weights_J)+", 기대값: 19");

    }
    /*
1	2	[1, 1, 1]	4
1	1	[1, 1, 1]	4
4	2	[1, 1, 1, 1]	10
3	3	[1, 1, 1]	6
3	1	[1, 1, 1]	10
5	5	[1, 1, 1, 1, 1, 2, 2]	14
7	7	[1, 1, 1, 1, 1, 3, 3]	18
5	5	[1, 1, 1, 1, 1, 2, 2, 2, 2]	19
5	5	[2, 2, 2, 2, 1, 1, 1, 1, 1]	19
    * */
}
