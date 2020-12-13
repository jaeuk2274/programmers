package me.jaeuk.programmers;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42578?language=java
 * 프로그래머스-해시-베스트앨범
 *
 */
public class Lv3_해시_베스트앨범_20201213 {
    public static int MAX_GENRE_INCULDE = 2;

    public static void main(String[] args) {

        //String[] genres = {"classic", "pop", "classic", "classic", "pop", "test", "test", "test"};
        //int[] plays = {500, 600, 150, 800, 2500, 5000, 5000, 4999};

        String[] genres = {"classic", "pop", "classic", "classic", "pop", "test", "test", "test","pop", "classic", "classic","pop", "classic", "classic"};
        int[] plays = {500, 600, 150, 800, 2500, 5000, 5000, 4999, 1234, 314, 431, 535, 231, 234};

        /*
        속한 노래가 많이 재생된 장르를 먼저 수록합니다.
        장르 내에서 많이 재생된 노래를 먼저 수록합니다.
        장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.

        genres[i]는 고유번호가 i인 노래의 장르입니다.
        plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
        genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
        장르 종류는 100개 미만입니다.
        장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
        모든 장르는 재생된 횟수가 다릅니다.
         */

        // String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        // int[] plays = {500, 600, 150, 800, 2500};

        Lv3_해시_베스트앨범_20201213 베스트앨범 = new Lv3_해시_베스트앨범_20201213();
        int[] answer = 베스트앨범.solution(genres, plays);

        for (int i:answer) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        HashMap<String, Integer> genreCountMap = getGenreCountMap(genres, plays);
        String maxPlayGenre = getMaxPlayGenre(genreCountMap);
        System.out.println("maxPlayGenre : " + maxPlayGenre);

        List<Music> musicList = getMusicList(genres, plays);
        sortMusicListByGenreAndPlays(musicList, genreCountMap);
        System.out.println("sort musicList");
        for(int i=0; i<musicList.size(); i++){
            System.out.println(musicList.get(i));
        }

        System.out.println("----");
        removeMaxGenreInclude(musicList);
        System.out.println("removeMaxGenreInclude musicList");
        for(int i=0; i<musicList.size(); i++){
            System.out.println(musicList.get(i));
        }

        int[] answer = new int[musicList.size()];
        for (int i=0; i<musicList.size(); i++){
            answer[i] = musicList.get(i).getSeq();
        }
        return answer;
    }

    private HashMap<String, Integer> getGenreCountMap(String[] genres, int[] plays) {
        HashMap<String, Integer> genreCountMap = new HashMap<String, Integer>();
        for(int i = 0; i< genres.length; i++){
            genreCountMap.put(genres[i], genreCountMap.getOrDefault(genres[i],0) + plays[i]);
        }
        return genreCountMap;
    }

    private String getMaxPlayGenre(HashMap<String, Integer> genreCountMap) {
        int maxPlays = 0;
        String maxPlayGenre = "";
        for (String curGenre : genreCountMap.keySet()){
            int curPlays = genreCountMap.get(curGenre);
            if(curPlays > maxPlays){
                maxPlayGenre = curGenre;
                maxPlays = curPlays;
            }
        }
        return maxPlayGenre;
    }

    private List<Music> getMusicList(String[] genres, int[] plays) {
        List<Music> musicList = new ArrayList<>();
        for(int i = 0; i< genres.length; i++){
            musicList.add(new Music(genres[i], plays[i],i));
        }
        return musicList;
    }

    private void sortMusicListByGenreAndPlays(List<Music> musicList, HashMap<String, Integer> map) {
        Comparator<Music> playComparator = new Comparator<Music>() {
            @Override
            public int compare(Music o1, Music o2) {
                if(map.get(o2.getGenre()) > map.get(o1.getGenre())){
                    return 1;
                } else if(map.get(o2.getGenre()) < map.get(o1.getGenre())){
                    return -1;
                }
                if(o2.getPlay() > o1.getPlay()){
                    return 1;
                } else if(o2.getPlay() < o1.getPlay()) {
                    return -1;
                }
                return 1;
            }
        };
        Collections.sort(musicList,playComparator);
    }

    private void removeMaxGenreInclude(List<Music> musicList) {
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

            if(tempGenreCnt > MAX_GENRE_INCULDE){
                musicList.remove(i);
                i--;
                continue;
            }
        }
    }

    private int[] transArray(List<Integer> answerList) {
        int[] answer = new int[answerList.size()];
        for(int i = 0; i< answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        return answer;
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