package me.jaeuk.programmers;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 * 프로그래머스-해시-전화번호목록
 *
 */
public class Lv2_해시_전화번호목록 {
    public static void main(String[] args) {
       // String[] phone_book = {"123", "456", "789", "119123453", "118" , "11818"};
        String[] phone_book = {"123", "456", "789", "4 43", "02-6800-1234"};

        Lv2_해시_전화번호목록 전화번호목록 = new Lv2_해시_전화번호목록();
        boolean answer = 전화번호목록.solution2(phone_book);

        System.out.println("answer : " + answer);
    }


    public boolean solution(String[] phone_book) {
        boolean answer = true;

        int index = 0;
        for (String trimNum : phone_book) {
            // 길이에 대해서만 명시했지, 띄어쓰기나 - 등 다른 문자에 대해선 언급이 없었다.
            phone_book[index] = trimNum.replaceAll("[^0-9]",""); // 숫자만 추출
            index++;
        }

        // 문자열 순 정렬
        Arrays.sort(phone_book);

        index = 0;
        for (String phone : phone_book) {
            for (int i = index+1; i<phone_book.length; i++){
                // 처음에 substring을 쓰다가, startsWith 메소드 사용
                if(phone_book[i].startsWith(phone)){
                    return false;
                } else {
                    break;
                }
            }
            index++;
        }
        return answer;
    }


    public boolean solution2(String[] phone_book) {
        boolean answer = true;

        int index = 0;
        for (String trimNum : phone_book) {
            // 길이에 대해서만 명시했지, 띄어쓰기나 - 등 다른 문자에 대해선 언급이 없었다.
            phone_book[index] = trimNum.replaceAll("[^0-9]",""); // 숫자만 추출
            index++;
        }

        // 문자열 순 정렬
        Arrays.sort(phone_book);

        // foreach 를 위해 이중 포문을 쓰느니 for 문 하나로 사용
        for(int i=0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }

        return answer;
    }
}