package me.jaeuk.programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 * 프로그래머스-스택큐-프린터
 *
 */
public class Lv2_스택큐_주식가격_20201213 {
    public static void main(String[] args) {
//        int[] prices = {1, 2, 3, 2, 3};
        int[] prices = {10,9,10};
             //        12,10, 7, 8, 6,

        Lv2_스택큐_주식가격_20201213 solve = new Lv2_스택큐_주식가격_20201213();
        int[] answer = solve.solution(prices);

        for (int a : answer) {
            System.out.print(a + " ");
        }
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length; i++){
            for (int j = i+1; j<prices.length; j++){
                answer[i] += 1;
                if(prices[i] > prices[j]){
                    break;
                }
            }
        }
        System.out.println(answer);
        return answer;
    }
}