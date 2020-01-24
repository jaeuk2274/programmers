package me.jaeuk.programmers;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
 * 프로그래머스-깊이,너비 우선 탐색(DFS,BFS)-타겟 넘버
 *
 */
public class Lv2_DFS_타겟넘버 {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        Lv2_DFS_타겟넘버 타겟넘버 = new Lv2_DFS_타겟넘버();
        int answer = 타겟넘버.solution(numbers, target);

        System.out.println("answer : " + answer);
    }
    /* 해당 그림을 보면 이해가 쉽다.
                                 0
                      1(+)                      1(-)
                 2(+)          2(-)         2(+)         2(-)
             3(+)    3(1)   3(+)  3(1)   3(+)  3(1)   3(+)  3(1)
          4(+)  4(-) ..
       5(+) 5(-) ..
     최종에서 (5번째) 에서 타겟과 같으면 1, 아니면 0으로 결과가 전부 나온다.
     그걸 다 더하면 정답.
     */

    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, 0, 0, target);

        return answer;
    }

    public int dfs(int[] numbers, int node, int sum, int target){
        // 그림 참조. 마지막에서만 체크하면 된다. 노드가 5개인 것(=5번 더한/뺀 것)
        if(numbers.length == node){
            if(sum == target){ // 타겟넘버와 같으면 카운팅
                return 1;
            }
            else {
                return 0;
            }
        }

        return dfs(numbers, node+1, sum + numbers[node], target)
               + dfs(numbers, node+1, sum - numbers[node], target);
    };

}