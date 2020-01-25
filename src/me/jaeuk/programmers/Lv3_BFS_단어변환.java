package me.jaeuk.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43163?language=java
 */
public class Lv3_BFS_단어변환 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        Lv3_BFS_단어변환 solve = new Lv3_BFS_단어변환();
        int answer = solve.solution(begin, target, words);

        System.out.println("answer : " + answer);
    }

    int answer = 0;
    boolean visited[];

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        bfs(0, words, begin, target, 0);
        return answer;
    }

    void bfs(int index, String[] words, String begin, String target, int stage) {
        LinkedList<Integer> queue = new LinkedList<Integer>();

        if (index == 0) {
            for (int i = 0; i < words.length; i++) {
                if (str_match(begin, words[i]) == true) {
                    System.out.println("add i : " + i);
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println("queue : " + queue);

        while (!queue.isEmpty()) {
            int x = queue.getFirst();
            System.out.println("x : " + x);

            queue.pollFirst(); // 맨 앞에 수 빼기
            stage++;
            System.out.println("stage : " + stage);
            //System.out.println(words[x]);
            if (words[x].compareTo(target)==0) {
                answer = stage;
                return;
            }
            for (int i = 0; i < words.length; i++) {
                if (visited[i] == false && str_match(words[x], words[i])) {
                    queue.push(i);
                    visited[i] = true;
                }
            }
        }
        answer = 0;
    }

    boolean str_match(String str1, String str2) {
        int total = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.substring(i, i + 1).compareTo(str2.substring(i, i + 1)) != 0)
                total++;
        }
        if (total == 1)
            return true;
        else
            return false;
    }

}