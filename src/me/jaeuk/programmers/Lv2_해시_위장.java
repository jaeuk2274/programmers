package me.jaeuk.programmers;

import java.util.HashMap;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42578?language=java
 * 프로그래머스-해시-위장
 *
 */
public class Lv2_해시_위장 {
    public static void main(String[] args) {

        String[][] clothes = {{"yellow_hat", "headgear"}
                            , {"blue_sunglasses", "eyewear"}
                            , {"green_turban", "headgear"}
                            };

        Lv2_해시_위장 위장 = new Lv2_해시_위장();
        int answer = 위장.solution(clothes);

        System.out.println("answer : " + answer);
    }


    public int solution(String[][] clothes) {

        // 문제풀이 고민
        // getOrDefault 활용
        // 같은 이름을 가진 의상은 존재하지 않습니다. 라고 명시되어 있다.
        // 해시맵에 타입별로 int 숫자 넣고
        // 공식 구해서 계산
        // (타입+1) * (타입+1)... -1

        int answer = 0;

        HashMap<String, Integer> typeCntMap = new HashMap<String, Integer>();

        String tempType = "";
        for(int i=0; i<clothes.length; i++){
            tempType = clothes[i][1];
            typeCntMap.put(tempType, typeCntMap.getOrDefault(tempType,0) + 1);
        }

        answer = 1;
        for (Integer typeCnt : typeCntMap.values()) {
            answer *= typeCnt+1;
        }
        answer--;

        return answer;
    }
}