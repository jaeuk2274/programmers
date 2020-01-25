package me.jaeuk.programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43162?language=java
 */
public class Lv3_DFS_네트워크 {
    public static void main(String[] args) {
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
        int n = 3;

        Lv3_DFS_네트워크 solve = new Lv3_DFS_네트워크();
        int answer = solve.solution(n, computers);

        System.out.println("answer : " + answer);
    }

    /*
        문제풀이 고민
        1. 0번째 컴퓨터부터 dfs로 끝까지 타고 들어간다.
        2. 타고들어가면서 방문했는지 visit[]에 true 체크
        3. 끝까지 타고들어간 후 다시 1번째 컴퓨터 시작. 이미 방문했으면 true 체크되어 있으니 넘어간다.
     */
    public int solution(int n, int[][] computers) {
        boolean[] visit = new boolean[n];
        int answer = 0;

        for(int i=0; i<n; i++){
            if(!visit[i]){
                dfs(computers, i, visit);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int[][] computers, int idx, boolean[] visit){
        for (int i=0; i<computers.length; i++){
            if(computers[idx][i] == 1 && !visit[i]){
                visit[i] = true;
                dfs(computers, i, visit);
            }
        }
    }
}