package me.jaeuk;
import java.util.PriorityQueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42626?language=java
 * 프로그래머스-힙-더맵게
 */
public class 더맵게 {
    public static void main(String[] args) {
        int[] scoville = {1,2,3,9,10,12};
        int k = 7;

        더맵게 더맵게 = new 더맵게();
        int answer = 더맵게.solution(scoville, k);

        System.out.println("answer : " + answer);
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        // 문제풀이 고민
        // 1. 내림차순 정렬 -> 정렬할 필요 없이 큐 사용 (PriorityQueue)
        // 2. 내림차순 정렬한 상태에서 k보다 크면 리턴(전체가 다 넘으니까)
        // 3. 아니면 차례대로 두개 빼서 a + b*2 = 넣고 다시 정렬
        // 4. 끝까지 못하면 -1

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

        for (int scov : scoville ) {
            queue.add(scov);
        }

        int index = 0;
        while (queue.peek() < K){
            if(queue.peek() >= K){
                return index;
            }
            // 다 합쳤는데도 K 안되면 -1
            if(queue.size() == 1){
                return -1;
            }

            queue.add(queue.poll() + (queue.poll() * 2));
            index++;
        }

        return index;
    }
}