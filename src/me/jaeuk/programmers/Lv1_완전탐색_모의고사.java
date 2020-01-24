package me.jaeuk.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 * 프로그래머스 - 완전탐색 - 모의고사
 */
public class Lv1_완전탐색_모의고사 {
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};

        Lv1_완전탐색_모의고사 모의고사 = new Lv1_완전탐색_모의고사();
        int answer[] = 모의고사.solution(answers);

        for (int i : answer) {
            System.out.print(i + ", ");
        }
    }

    public int[] solution(int[] answers) {
        int[][] typeAns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int typeAnsCnt[] = new int[typeAns.length]; // 케이스별 정답수 배열
        int ansIdx = 0;
        int tpIdx = 0;
        for (int ans : answers) { // 정답수만큼

            tpIdx = 0;
            for (int[] tp : typeAns) { // 케이스별 체크
                if (ans == tp[ansIdx % tp.length]) {
                    typeAnsCnt[tpIdx]++; // 케이스별 정답수++
                }
                tpIdx++;
            } // type end

            ansIdx++;
        } // answers end

        // 가장 높은 점수 체크
        int max = 0;
        for (int ansCnt : typeAnsCnt) {
            if (max < ansCnt) {
                max = ansCnt;
            }
        }

        // 가장 높은 점수로 확인 (여러명 가능)
        List<Integer> returnList = new ArrayList<Integer>();
        tpIdx = 1;
        for (int ansCnt : typeAnsCnt) {
            if (max == ansCnt) {
                returnList.add(tpIdx);
            }
            tpIdx++;
        }

        // Collections.sort(returnList); // 오름차순
        // Collections.sort(returnList, Comparator.reverseOrder()); // 내림차순

        // list -> 배열로 변환 , toList 등..
        int[] returnArray = new int[returnList.size()];
        tpIdx = 0;
        for (int rtn : returnList) {
            System.out.println(rtn);
            returnArray[tpIdx] = rtn;
            tpIdx++;
        }

        return returnArray;
    }
}