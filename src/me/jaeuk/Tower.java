package me.jaeuk;

import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42588
 * 프로그래머스 - 스택/큐 - 탑
 */

public class Tower {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length]; // 수신 탑 배열 길이는 동일

        // 문제 풀이 고민
        // 1. 시작부터 오른쪽으로 순서니까 반복하면서 스택에 하나씩 넣는다. (인덱스와 탑 높이)
        // 2. 스택에 들어있는 것, 꺼내는 순서대로 현재 내 왼쪽에 있는 거일테니 비교.
        // 3. 꺼내면서 다음 번째 다시 비교해야하니 temp스택에 저장 후 다시 넣어줌.
        // 4. 큰게 있다면 answer 배열에 인덱스를 넣어줌. 안넣으면 자동으로 0
        // 5. temp스택에 있던 것 넣어주고 다음 번째 비교

        Stack<Point> stack = new Stack<Point>();
        Stack<Point> tempStack = new Stack<Point>();

        int index = 0;
        for (int h : heights) {
            for (Point p : stack) {
                if (p.towerHeight > h) {
                    answer[index] = p.index;
                }
            } // stack end

            index++;
            stack.push(new Point(index, h));
        } // heights end

        for (int i : answer) {
            System.out.print(i + ", ");
        }

        return answer;
    }

    class Point {
        private int index;
        private int towerHeight;

        Point(int index, int towerHeight) {
            this.index = index;
            this.towerHeight = towerHeight;
        }
    }
}
