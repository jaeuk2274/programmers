package me.jaeuk;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 * 프로그래머스-정렬-K번째
 */
public class K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        K번째수 K번째수 = new K번째수();
        int answer[] = K번째수.solution(array, commands);

        for (int i : answer) {
            System.out.print(i + ", ");
        }
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int index = 0;
        for (int[] com : commands) {

            // copyOfRange 메서드 활용
            int[] list = Arrays.copyOfRange(array, com[0]-1, com[1]);
            Arrays.sort(list);

            answer[index] = list[(com[2]-1)];
            index++;
        }

        return answer;
    }
}