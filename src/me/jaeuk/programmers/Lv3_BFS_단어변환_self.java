package me.jaeuk.programmers;

import java.util.LinkedList;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43163?language=java
 */
public class Lv3_BFS_단어변환_self {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        Lv3_BFS_단어변환_self solve = new Lv3_BFS_단어변환_self();
        int answer = solve.solution(begin, target, words);

        System.out.println("answer : " + answer);
    }

    int answer = 0;
    boolean visited[];

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        bfs(0, words, begin, target, 0);
        System.out.println(answer);
        return answer;
    }

    void bfs(int index, String[] words, String begin, String target, int stage) {
        LinkedList<Integer> queue = new LinkedList<Integer>();

        if(index == 0){
            for(int i=0; i<words.length; i++){
                if(isNext(begin,words[i])){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        while (!queue.isEmpty()){
            int x = queue.pollFirst();
            stage++;
            if (target.equals(words[x])){
                answer = stage;
                return;
            } else {
                begin = words[x];
                for (int i=0; i<words.length; i++){
                    if(visited[i] == false && isNext(begin, words[i])){
                        visited[i] = true;
                        queue.push(i);
                    }
                }
            }
        }
        answer = 0;
    }

    // 한글자 이상 차이나면 false
    private boolean isNext(String begin, String word) {
        int diffCount = 0;

        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                diffCount++;

                if (diffCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }



}