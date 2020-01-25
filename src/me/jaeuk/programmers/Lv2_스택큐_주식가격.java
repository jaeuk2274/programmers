package me.jaeuk.programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 * 프로그래머스-스택큐-프린터
 *
 */
public class Lv2_스택큐_주식가격 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};

        Lv2_스택큐_주식가격 solve = new Lv2_스택큐_주식가격();
        int[] answer = solve.solution(prices);

        for (int a : answer) {
            System.out.println(a);
        }
        System.out.println("answer : " + answer);
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < answer.length; i++) {
            for (int j = i+1; j < answer.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j-i;
                    break;
                }
                if (j==answer.length-1) answer[i] = j-i;
            }
        }
        return answer;
    }
}