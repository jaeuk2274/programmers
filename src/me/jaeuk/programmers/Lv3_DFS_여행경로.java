package me.jaeuk.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43163?language=java
 */
public class Lv3_DFS_여행경로 {
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        // [ICN, ATL, ICN, SFO, ATL, SFO]
        Lv3_DFS_여행경로 solve = new Lv3_DFS_여행경로();
        String[] answer = solve.solution(tickets);

    }


    public String[] solution(String[][] tickets) {
        boolean[] visit = new boolean[tickets.length];
        List<String> routeList = new ArrayList<>();

        String start = "", end = "", route = "";
        int index = 0;
        for (String[] ticket : tickets) {
            start = ticket[0];
            end = ticket[1];

            if(start.equals("ICN")){
                visit[index] = true;
                route = start + ",";
                dfs(tickets, end, 1, visit, route, routeList);
                visit[index] = false;
            }
        }

        Collections.sort(routeList);

        for (String a : routeList) {
            System.out.println("a : " + a);
        }

        String[] answer = routeList.get(0).split(",");
        return answer;
    }

    public static void dfs(String[][] tickets, String end, int count, boolean[] visit, String route, List<String> routeList) {

        route += end + ",";

        if(count==tickets.length) {
            routeList.add(route);
            return;
        }

        int index = 0;
        for (String[] ticket : tickets) {
            if(end.equals(ticket[0]) && visit[index]){
                visit[index] = true;
                dfs(tickets, ticket[1], count + 1, visit, route, routeList);
                visit[index] = false;
                route = route.substring(0, route.length()-4);
            }
        }
    }
}