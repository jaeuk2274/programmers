package me.jaeuk.programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
public class Lv2_정렬_가장큰수 {
    public static void main(String[] args) {
        Lv2_정렬_가장큰수 solution = new Lv2_정렬_가장큰수();
        int[] numbers = {3, 30, 34, 5, 9, 0};
        //int[] numbers = {0, 0};

        String answer = solution.solution(numbers);
        System.out.println(answer); // 9534330
    }


    /*
    문제풀이 고민
    1. 문자열로 정렬, s1+s2 와 s2+s1 비교 // (3,34)-> (343,334) 343이 더 크다.
    2. 그리고 순서대로 붙인다.
     */
    public String solution(int[] numbers) {
        String answer = "";

        List<String> list = Arrays.stream(numbers)
                .mapToObj(s -> Integer.toString(s))
                .sorted((s1, s2) -> (s2+s1).compareTo(s1+s2))
                .collect(Collectors.toList());

        /*
        Collections.sort(list, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o2+o1).compareTo(o1+o2);
                }
            }
        );
        */

        for (String s:list) {
            answer += s;
        }

        // 문제의 함정.. 엄청나게 해멨다..
        // - numbers의 원소는 0 이상 1,000 이하입니다.
        // 0이 중복될 수도 있다. {0, 0, 0, 0} -> 0000이 출력된다.
        if (answer.startsWith("0")){
            answer = "0";
        }

        return answer;
    }
}
