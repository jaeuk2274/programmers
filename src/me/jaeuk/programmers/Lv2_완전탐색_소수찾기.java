package me.jaeuk.programmers;

import java.util.HashSet;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42839?language=java
 * 프로그래머스-완전탐색-소수찾
 */
public class Lv2_완전탐색_소수찾기 {
    public static void main(String[] args) {
        Lv2_완전탐색_소수찾기 solution = new Lv2_완전탐색_소수찾기();
        int answer = solution.solution("17");
    }

    /* 문제풀이 고민
     * 1. 가능한 모든 조합(순열) -> num 변환하면 0 시작 등은 걸러짐
     * 2. hashSet으로 중복체크
     * 3. 소수 판별 메서드
     */
    public int solution(String numbers) {
        int answer = 0;

        HashSet<Integer> toNumOverlapHashSet = new HashSet<Integer>();
        permutationToNumOverlapCheck(numbers, "", toNumOverlapHashSet);
        System.out.println(toNumOverlapHashSet);

        answer = isPrimeCnt(toNumOverlapHashSet);
        System.out.println(answer);
        return answer;
    }

    /*
    F(abc, "")
        F(bc, a)
            F(c, ab)
                F("", abc) -> abc
            F(b, ac)
                F("", acb) -> acb
        F(ac, b)
            F(c, ba)
                F("", bac) -> bac
            F(a, bc)
                F("", bca) -> bca
     ...
     */
    private void permutationToNumOverlapCheck(String numbers, String prefix, HashSet<Integer> hs) {
        String temp = "";
        if (numbers.length() == 0) {
            hs.add(Integer.parseInt(prefix));
        } else {
            for (int i = 0; i < numbers.length(); i++) {
                temp = numbers.substring(0, i) + numbers.substring(i + 1);
                permutationToNumOverlapCheck(temp, prefix + numbers.charAt(i), hs);
            }
        }
    }

    private int isPrimeCnt(HashSet<Integer> hs){
        int answer = 0;

        for (int num : hs) {
            if(isPrime(num)){
                answer++;
            }
        }

        return answer;
    }

    /* 소수판별 메소드 */
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;

        //2를 제외한 모든 짝수는 소수가 아님
        if (num % 2 == 0) return false;

        /**
         * num 이 p * q 라고 할때 한 수는 항상 sqrt(num) 이하의 값을 갖는다. (ex, num = 24, p = [1, 2, 3, 4], q = [6, 8, 12, 24])
         * 따라서 num 이 sqrt(num) 이하의 값중 하나로 나눠지는지 체크한다. (ex, 24 가 4 이하의 숫자로 나눠지는지 체크,, 1,2 는 예외)
         */
        int sqrtn = (int) Math.sqrt(num);
        for (int i = 3; i <= sqrtn; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
