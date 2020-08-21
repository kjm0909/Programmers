/*
문제 설명
2016년 1월 1일은 금요일입니다. 2016년 a월 b일은 무슨 요일일까요?
두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요.
요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT입니다.
예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 TUE를 반환하세요.

제한 조건
2016년은 윤년입니다. // 2016년 2월 29일 존재
2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
입출력 예
a	b	result
5	24	TUE
*/
package Level1;

public class YYYY_2016 {
    public static String solution(int a, int b) {
    String answer = "";
    int month = a;
    int day = b;
        System.out.println(a+"월 "+b+"일");
    String[] week = {"SUN","MON","TUE","WED","THU","FRI","SAT"}; // 2016년 1월 3일 일요일
    int[] monthDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int startWeek = 5; // 2016년 1월 1일 금요일
    int count = startWeek + day;
    for(int i=1; i<monthDays.length; i++){
        //System.out.println("i: "+i+", count: "+count);
        if(i == month) break;
        count += monthDays[i-1];
    }

    System.out.println("count: "+count+", count%week.length: "+count%week.length);
    if(count%week.length == 0 ) answer = week[week.length-1];
    else answer = week[count%week.length-1];

    return answer;
    }

    public static void main(String[] args) {
        System.out.println("Return: "+solution(5,24)+", 기대값: TUE" );
        System.out.println("Return: "+solution(1,3)+", 기대값: SUN" );
        System.out.println("Return: "+solution(2,29)+", 기대값: MON" );
        System.out.println("Return: "+solution(3,1)+", 기대값: TUE" );
        System.out.println("Return: "+solution(1,7)+", 기대값: THU" );
        System.out.println("Return: "+solution(11,23)+", 기대값: WED" );
        System.out.println("Return: "+solution(12,25)+", 기대값: SUN" );
        System.out.println("Return: "+solution(4,2)+", 기대값: SAT" );
    }
}
