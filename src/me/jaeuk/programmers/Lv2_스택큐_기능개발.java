package me.jaeuk.programmers;


public class Lv2_스택큐_기능개발 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        Lv2_스택큐_기능개발 solve = new Lv2_스택큐_기능개발();
        int[] answer = solve.solution(progresses, speeds);

        for (int a : answer) {
            System.out.println(a);
        }
        System.out.println("answer : " + answer);
    }

    public int[] solution(int[] progresses, int[] speeds){
        int[] answer = new int[0];

        return answer;
    }
}