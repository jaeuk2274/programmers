package me.jaeuk.programmers;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 * 프로그래머스-스택큐-프린터
 *
 */
public class Lv2_스택_쇠막대기 {
    public static void main(String[] args) {
        String arrangement = "()(((()())(())()))(())";

        Lv2_스택_쇠막대기 solve = new Lv2_스택_쇠막대기();
        int answer = solve.solution(arrangement);

        System.out.println("answer : " + answer);
    }

    public int solution(String arrangement) {
        int answer = 0;

        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<arrangement.length(); i++){
            char cur = arrangement.charAt(i);
            if(cur == '('){
                stack.add(cur);
            } else {
                System.out.println(stack.peek());
                System.out.println(stack.peek()+1);
                if(stack.peek() == '('){
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer++;
                }
            }
        }
        return answer;
    }
}