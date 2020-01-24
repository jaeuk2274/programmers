package me.jaeuk.programmers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42578?language=java
 * 프로그래머스-해시-베스트앨범
 *
 */
public class 베스트앨범2_스트림 {
    public static void main(String[] args) {

        String[] genres = {"classic", "pop", "classic", "classic", "pop", "test", "test", "test"};
        int[] plays = {500, 600, 150, 800, 2500, 5000, 5000, 4999};

        베스트앨범2_스트림 베스트앨범 = new 베스트앨범2_스트림();
        int[] answer = 베스트앨범.solution(genres, plays);

        for (int i:answer) {
            System.out.print(i + " ");
        }
    }

    public class Music implements Comparable<Music>{

        private int played;
        private int id;
        private String genre;

        public Music(String genre, int played, int id) {
            this.genre = genre;
            this.played = played;
            this.id = id;
        }

        @Override
        public int compareTo(Music other) {
            System.out.println("compareTo");
            System.out.println(other);
            System.out.println(this);
            if(this.played == other.played) return this.id - other.id;
            return other.played - this.played;
        }

        public String getGenre() {return genre;}
    }

    public int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Music(genres[i], plays[i], i))
                .collect(Collectors.groupingBy(Music::getGenre))
                .entrySet().stream()
                .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue()))
                .flatMap(x->x.getValue().stream().sorted().limit(2))
                .mapToInt(x->x.id).toArray();
    }

    private int sum(List<Music> value) {
        int answer = 0;
        for (Music music : value) {
            answer+=music.played;
        }
        return answer;
    }

}