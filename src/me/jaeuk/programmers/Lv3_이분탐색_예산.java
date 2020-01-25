package me.jaeuk.programmers;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43237?language=java
 */
public class Lv3_이분탐색_예산 {
    public static void main(String[] args) {
        int[] budgets = {120, 110, 140, 150};
        int M = 485;

        Lv3_이분탐색_예산 solve = new Lv3_이분탐색_예산();
        int answer = solve.solution(budgets, M);
        System.out.println(answer);
    }

    public int solution(int[] budgets, int M) {
        int answer = 0;

        Arrays.sort(budgets); // 오름차순 정렬

        long sum = 0;
        for (int num:budgets) {
            sum += num;
        }

        int max = budgets[budgets.length-1];
        if(sum <= M) return max;

        int min = (int)(M / budgets.length);
        int mid = 0;
        int curMid = 0;

        while (true) {
            mid = (max+min)/2;

            System.out.println(max + " " + min + " " + mid);

            sum = 0;
            for (int num:budgets) {
                sum += (num > mid) ? mid : num;
            }

            if(curMid == mid){
                answer = mid;
                break;
            }

            if(sum < M){
                min = mid;
            } else{
                max = mid;
            }
            curMid = mid;
        }

        return answer;
    }
}