package me.jaeuk.programmers;

// https://programmers.co.kr/learn/courses/30/lessons/12921
public class 소수찾기_에라토스테네스의체 {
    public static void main(String[] args) {

        소수찾기_에라토스테네스의체 solution = new 소수찾기_에라토스테네스의체();
        int answer = solution.solution(5);

        System.out.println(answer);
    }

    public int solution(int n) {
        // 에라토스테네스의 체
        int answer = 0;
        int[] number = new int[n+1];

        //2부터 n까지의 수를 배열에 넣는다.
        for(int i=2; i<=n; i++) {
            number[i] = i;
        }

        //2부터 시작해서 그의 배수들을 0으로 만든다.
        //후에 0이면 넘어가고 아니면 그의 배수들을 다시 0으로 만든다.
        for(int i=2; i<=n; i++) {
            if(number[i]==0) continue;

            for(int j= 2*i; j<=n; j += i) {
                number[j] = 0;
            }
        }

        //배열에서 0이 아닌 것들의 개수를 세준다.
        for(int i=0; i<number.length; i++) {
            if(number[i]!=0) {
                answer++;
            }
        }

        return answer;
    }
}
