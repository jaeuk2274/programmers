package me.jaeuk.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42578?language=java
 * 프로그래머스-해시-베스트앨범
 *
 */
public class 베스트앨범3_해시 {
    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop", "test", "test", "test"};
        int[] plays = {500, 600, 150, 800, 2500, 5000, 5000, 5001};

        베스트앨범3_해시 베스트앨범 = new 베스트앨범3_해시();
        int[] answer = 베스트앨범.solution(genres, plays);

        for (int i:answer) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(String[] ge, int[] pl) {
        int len = pl.length;
        int[] r = new int[len];
        List<Map> list = new ArrayList<Map>();

        for(int i=0; i<len; i++) {
            Map<String,Object> check = new HashMap<String,Object>();
            int sum = 0;
            int pl_rank = 0;
            for(int j=0; j<len; j++) {
                if(ge[i].equals(ge[j])) {
                    sum += pl[j];
                    if(pl[i] < pl[j]) {
                        pl_rank += 1;
                    }else if(pl[i] == pl[j] && i>j){
                        pl_rank += 1;
                    }
                }
            }
            check.put("NO", i);
            check.put("GE", ge[i]);
            check.put("PL", pl[i]);
            check.put("SUM", sum);
            check.put("PL_RANK", pl_rank);

            System.out.println(i + " i : " + check);
            list.add(check);

        }

        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                int a = Integer.parseInt(list.get(i).get("SUM").toString());
                int b = Integer.parseInt(list.get(j).get("SUM").toString());
                if(a < b ) {
                    r[i] += 1;
                }
            }
            list.get(i).put("GE_RANK", r[i]);
            System.out.println(list.get(i ).toString());
        }
        ArrayList<String> a = new ArrayList<String>();
        for(int i=0; i<len; i++) {
            int j=0;
            int pl_rank = Integer.parseInt(list.get(i).get("PL_RANK").toString());
            if(pl_rank < 2){
                a.add(list.get(i).get("GE_RANK").toString() + list.get(i).get("PL_RANK").toString());
                j++;
            }
        }
        System.out.println(a);
        Collections.sort(a);
        System.out.println(a);

        int[] answer = new int[a.size()];

        for(int i=0; i<len; i++) {
            String chk = list.get(i).get("GE_RANK").toString() + list.get(i).get("PL_RANK").toString();
            int rank = Integer.parseInt(list.get(i).get("NO").toString());
            for(int j=0; j<a.size(); j++) {
                if(chk.equals(a.get(j))) {
                    answer[j] = rank;
                }
            }
        }

        return answer;
    }

}