package me.jaeuk.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42578?language=java
 * 프로그래머스-해시-베스트앨범
 *
 */
public class Lv3_해시_베스트앨범 {
    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop", "test", "test", "test"};
        int[] plays = {500, 600, 150, 800, 2500, 5000, 5000, 4999};

        Lv3_해시_베스트앨범 베스트앨범 = new Lv3_해시_베스트앨범();
        int[] answer = 베스트앨범.solution(genres, plays);

        for (int i:answer) {
            System.out.print(i + " ");
        }
    }

    /*
    * 문제풀이 고민
    * 1. 해시에 넣어서 장르별로 재생횟수 합 구하기 + vo 안에 넣기 list
    * 2. 해시 정렬해서 재생횟수 높은 순 정렬 (문제에서 모든 장르는 재생 횟수가 다르다고 명시해줌)
    * 3. vo 정렬 (장르 + 재생횟수)
    * 4. 장르별 2개씩만 수록한다. (장르별 2개 넘어가는거 remove)
     */
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genersPlaysMap = new HashMap<String, Integer>();
        List<Music> musicList = new ArrayList<Music>();

        for(int i=0; i<genres.length; i++){
            genersPlaysMap.put(genres[i], genersPlaysMap.getOrDefault(genres[i], 0) + plays[i]);
            musicList.add(new Music(genres[i], plays[i], i));
        }

        // 요건대로 정렬(장르+재생횟수)
        musicList = sortListByGenrePlay(musicList, genersPlaysMap);

        // 각 장르별 2개씩만 남게끔 remove
        String tempGenre = musicList.get(0).getGenre();
        String curGenre = "";
        int tempGenreCnt = 0;
        for(int i=0; i<musicList.size(); i++){
            curGenre = musicList.get(i).getGenre();

            if(tempGenre.equals(curGenre)){
                tempGenreCnt++;
            }else{
                tempGenre = curGenre;
                tempGenreCnt = 1;
            }

            if(tempGenreCnt > 2){
                musicList.remove(i);
                i--;
                continue;
            }
        }

        int[] answer = new int[musicList.size()];

        int index = 0;
        for (Music m: musicList) {
            answer[index] = musicList.get(index).getSeq();
            index++;
        }

        return answer;
    }

    public static List<Music> sortListByGenrePlay(List<Music> list, HashMap<String, Integer> map){

        Collections.sort(list, new Comparator<Music>() {
            // 정렬 공부하며 새롭게 알게된 사실
            // 1. o1이 더 뒤에 나오는 객체, o2가 더 앞의 객체.
            //   (1,0)비교 -> (2,1)비교 -> (2,0)비교 -> (3,0)비교 -> (3,1)..
            // 2. o1 기준으로 -1이 더 앞으로 가는 것. (o1원래 뒤에있던 애니까 -1) ,1은 기존 들어있던 순서 그대로
            @Override
            public int compare(Music o1, Music o2) {
                // System.out.println("o1 : " + o1);
                // System.out.println("o2 : " + o2);

                // 1.장르 비교
                if(map.get(o2.getGenre()) > map.get(o1.getGenre())){
                    return 1;
                } else if(map.get(o2.getGenre()) < map.get(o1.getGenre())){
                    return -1;
                }

                // 2. 장르 같을때 재생횟수 비교 (같은 장르 내 재생횟수가 같다면? 문제에는 명시되지 않음)
                if(o2.getPlay() > o1.getPlay()){
                    return 1;
                } else if(o2.getPlay() < o1.getPlay()) {
                    return -1;
                }

                // 여기서는 예외 케이스(재생횟수 같을 때) 원래 배열에 들어있던/고유번호 순서대로 처리
                return 1;
            }
        });

        return list;
    }

    public class Music{
        private String genre;
        private int play;
        private int seq;

        public Music(String genre, int play, int seq) {
            this.genre = genre;
            this.play = play;
            this.seq = seq;
        }

        public String getGenre() {
            return genre;
        }

        public int getPlay() {
            return play;
        }

        public int getSeq() {
            return seq;
        }

        @Override
        public String toString() {
            return "Music{" +
                    "genre='" + genre + '\'' +
                    ", play=" + play +
                    ", seq=" + seq +
                    '}';
        }
    }


}