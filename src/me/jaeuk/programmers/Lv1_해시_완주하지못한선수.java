package me.jaeuk.programmers;

import java.util.HashMap;
/**
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 * 프로그래머스-해시-완주하지 못한 선수
 */
public class Lv1_해시_완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        Lv1_해시_완주하지못한선수 완주하지못한선수 = new Lv1_해시_완주하지못한선수();
        String remainName = 완주하지못한선수.solution(participant, completion);

        System.out.println(remainName);
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        // getOrDefault 없으면 디폴트값, 있으면 +1
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}