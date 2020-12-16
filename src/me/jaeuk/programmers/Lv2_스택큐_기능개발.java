package me.jaeuk.programmers;


public class Lv2_스택큐_기능개발 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        Lv2_스택큐_기능개발 solve = new Lv2_스택큐_기능개발();
        int[] answer = solve.solution(progresses, speeds);

        for (int a : answer) {
            System.out.println(a);
        }
        System.out.println("answer : " + answer);
    }

    public int[] solution(int[] progresses, int[] speeds){
        int[] answerLen = new int[progresses.length];
        for(int i=0; i<progresses.length; i++) {
        	answerLen[i] = (int)Math.ceil((float)(100-progresses[i])/speeds[i]);
        }

        List answerList = new ArrayList<Integer>();
        int max = answerLen[0]; 
        int count = 0;
        for(int i=0; i<answerLen.length; i++) {
        	if(max >= answerLen[i]) {
        		count++;
        	} else {
        		answerList.add(count);
        		count = 1;
        		max = answerLen[i];
        	}
        }
        
        answerList.add(count);      
        int[] answer = new int[answerList.size()];
        for(int i=0; i<answerList.size(); i++) {
        	answer[i] = (int) answerList.get(i);
        }
        return answer;
    }
}
