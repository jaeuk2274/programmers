package me.jaeuk.programmers;

import java.util.LinkedList;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 * 프로그래머스-스택큐-프린터
 *
 */
public class Lv2_스택_프린터_self {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        Lv2_스택_프린터_self solve = new Lv2_스택_프린터_self();
        int answer = solve.solution(priorities, location);

        System.out.println("answer : " + answer);
    }

    public int solution(int[] priorities, int location) {
        LinkedList<Document> list = new LinkedList<Document>();

        for (int i = 0; i < priorities.length; i++) {
            list.add(new Document(i, priorities[i]));
        }

        for (Document d:list) {
            System.out.println(d);
        }

        //인쇄 순번
        int answer = 1;

        //첫번째 Document
        Document firstDc = null;

        //대기목록 순차적으로 체크
        while(!list.isEmpty()) {
            firstDc = list.getFirst();
            for (int i = 1; i < list.size(); i++) {
                // 대기목록의 가장 마지막으로
                if (firstDc.prioritie < list.get(i).prioritie) {
                    list.addLast(firstDc);
                    list.removeFirst();
                    break;
                }
                // 인쇄
                if (i == list.size()-1) {
                    if(firstDc.idx == location) return answer;
                    list.removeFirst();
                    answer++;
                }
            }
        }
        return answer;
    }

    public class Document {
        int idx;
        int prioritie;

        public Document(int idx, int prioritie) {
            this.idx = idx;
            this.prioritie = prioritie;
        }

        @Override
        public String toString() {
            return "Document{" +
                    "idx=" + idx +
                    ", prioritie=" + prioritie +
                    '}';
        }
    }
}