package me.jaeuk.programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43163?language=java
 */
public class Lv3_DFS_여행경로_2 {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}, {"SFO", "ABC"} , {"ABC", "SFO"}};
        // [ICN, ATL, ICN, SFO, ATL, SFO]
        Lv3_DFS_여행경로_2 solve = new Lv3_DFS_여행경로_2();
        String[] answer = solve.solution(tickets);

    }

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];

        sortArray(tickets);

        for (String[] s : tickets) {
            System.out.println(s[0] + " " + s[1]);
        }
        System.out.println("=============");

        boolean[] visit = new boolean[tickets.length];
        answer[0] = "ICN";
        dfs(answer[0], tickets, visit, answer, 1);

        for (String a : answer) {
            System.out.print(a + " ");
        }

        return answer;
    }

    public void dfs(String begin, String[][] tickets, boolean[] visit, String[] answer, int stage){
        int index = 0;
        for (String[] ticket : tickets) {
            if(begin.equals(ticket[0]) && !visit[index]){
                visit[index] = true;
                answer[stage] = ticket[1];
                dfs(ticket[1], tickets, visit, answer, stage+1);

               // visit[index] = false;
            }
            index++;
        }
    }

    public static void sortArray(Object[][] arr){
        Arrays.sort(arr, new Comparator<Object[]>() {
            public int compare(Object[] arr1, Object[] arr2) {
                // [1]목적지 여러 곳 가능시 알파벳순
                if( ((Comparable)arr1[1]).compareTo(arr2[1]) < 0 ){
                    return -1;
                }
                else if(((Comparable)arr1[1]).compareTo(arr2[1]) > 0 ){
                    return 1;
                }
                return 0;
            }
        });
    }
}