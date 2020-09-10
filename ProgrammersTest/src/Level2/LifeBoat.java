/*
* 구명보트
문제 설명
무인도에 갇힌 사람들을 구명보트를 이용하여 구출하려고 합니다. 구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.

예를 들어, 사람들의 몸무게가 [70kg, 50kg, 80kg, 50kg]이고 구명보트의 무게 제한이 100kg이라면
* 2번째 사람과 4번째 사람은 같이 탈 수 있지만 1번째 사람과 3번째 사람의 무게의 합은 150kg이므로
* 구명보트의 무게 제한을 초과하여 같이 탈 수 없습니다.

구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.

사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때,
* 모든 사람을 구출하기 위해 필요한 구명보트 개수의 최솟값을 return 하도록 solution 함수를 작성해주세요.

제한사항
무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
각 사람의 몸무게는 40kg 이상 240kg 이하입니다.
구명보트의 무게 제한은 40kg 이상 240kg 이하입니다.
구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어지므로 사람들을 구출할 수 없는 경우는 없습니다.
*
입출력 예
people	            limit	return
[70, 50, 80, 50]	100	    3
[70, 80, 50]	    100 	3
* */
package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LifeBoat {
    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        LinkedList<Integer> list = new LinkedList<>();

        for(int i=0; i< people.length; i++){
            list.add(people[i]);
        }
        int index = list.size()-1;
        for(int i = 0; i<=index; i++){
            // 일단 answer + 1 하고
            answer++;
            // 아래 조건을 만족시키지 않으면 각각 타야 하므로 answer + 1 한 번 더 해준다
            // i 와 index 이 같이 못 타면 index 랑 같이 탈 사람 없음... 그래서 answer++ 하고
            // index-- 해가면서 i랑 같이 탈 사람 찾음
            while (index > i && list.get(i) + list.get(index--) > limit) {
                answer++;
            }
            /* 정확성100 효율성60
            if(list.get(i) == limit){
                answer++;
                list.remove(i);

            }else {
                if (index > i && list.get(0) + list.get(index - i - 1) <= limit) {
                    list.remove(index - i - 1);
                    list.remove(0);
                    i = 0;
                    answer++;
                } else if (index == i-1) {
                    answer += list.size();
                    break;
                }
            }
            index = list.size();*/
        }
//                for (int j = index-1; j > i; j--) {
//                    System.out.println("people["+i+"]: "+list.get(i)+", people["+j+"]: "+list.get(j));
//                    if (list.get(i) + list.get(j) <= limit) {
//                        // 합이 limit 이하인 경우
//                        answer++;
//                        System.out.println(">> Remove people["+i+"]: "+list.get(i)+", people["+j+"]: "+list.get(j));
//                        list.remove(j);
//                        list.remove(i);
//                        System.out.println(">> size: "+list.size());
//                        isRescued = true;
//                        break;
//                    }
//                }
//                if (!isRescued) {
//                    answer++;
//                    i++;
//                }
//            }

        return answer;

        /* 정확성 100 효율성 60
        int index = people.length-1;

        for(int i = 0; i<people.length; i++){
            boolean isRescued = false;
            if(people[i]==limit){
                answer++;
            }
            else {
                if (people[i] != 0) {
                    for (int j = index; j > i; j--) {
                        System.out.println("people["+i+"]: "+people[i]+", people["+j+"]: "+people[j]);
                        if(people[j]==limit){
                            answer++;
                            //people[j] = 0;
                            index = j - 1;
                        }
                        if (people[j] != 0 && people[i] + people[j] <= limit) {
                            // 합이 limit 이하인 경우
                            answer++;
                            people[j] = 0;
                            isRescued = true;
                            index = j-1;
                            break;
                        }
                    }
                    if (!isRescued) {
                        answer++;
                    }
                }
            }
        }
        return answer;*/

        //ArrayList 사용 시 효율성에서 fail 됨
        /*ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i<people.length; i++){
            arr.add(people[i]);
        }

        Collections.sort(arr);
        Collections.reverse(arr);

        for(int i = 0; i<arr.size(); i++){
            boolean isRescued = false;
            for(int j = i+1; j<arr.size(); j++){
                if(arr.get(i) == 0) break;
                if(arr.get(j) != 0 && arr.get(i) + arr.get(j) <= limit){
                    // 합이 limit 이하인 경우
                    answer++;
                    arr.set(i, 0);
                    arr.set(j, 0);
                    isRescued = true;
                    break;
                }
            }
            if(arr.get(i) != 0 && !isRescued) {
                answer++;
            }
        }*/


    }

    public static void main(String[] args) {
        int[] people_A = {70, 50, 80, 50};
        System.out.println("Return: "+solution(people_A, 100)+", 기대값: 3");
        int[] people_B = {70, 80, 50};
        System.out.println("Return: "+solution(people_B, 100)+", 기대값: 3");
        int[] people_C = {10,20,30,40,50,60,70,80,90};
        System.out.println("Return: "+solution(people_C, 100)+", 기대값: 5");
    }
}
