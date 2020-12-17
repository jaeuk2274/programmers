
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class lv2_큐_다리를지나는트럭 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("main start");

		int a = solution(2, 10, new int[]{7,4,5,6}); // 8
		int b = solution(100, 100, new int[]{10}); // 101
		int c = solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}); // 110

		System.out.println("a : " + a);
		System.out.println("b : " + b);
		System.out.println("c : " + c);
		
		System.out.println("main end");
	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
	    int sec = 0;
	    int curWeight = 0;
	    int count = 0;
	    int max = truck_weights.length;
	    Queue<Truck> queue = new LinkedList<>();
	    
	    while(max != 0) {
	    	sec++;
	    	for(int j=0; j<queue.size(); j++) {
	    		if(queue.isEmpty()) {
	    			break;
	    		} else {
	    			Truck curTruck = queue.poll();
	    			curTruck.position++;
	    			if(curTruck.position == bridge_length) {
	    				System.out.println("return curTruck : " + curTruck.position + " / " + curTruck.weight + " sec : " + sec);
	    				curWeight -= curTruck.weight;
	    				max--;
	    				j--;
	    			} else {
	    				queue.add(curTruck);
	    			}
	    		}
	    	}
	    	
	    	if(curWeight + truck_weights[count] <= weight ) {
	    		curWeight += truck_weights[count];
	    		Truck Truck = new Truck(truck_weights[count]);
	    		if(count < truck_weights.length-1) {
	    			count++;	
	    		}
	    		queue.add(Truck);
	    	}
	    }
	    return sec;
	}

    static class Truck{
        int position = 0;
        int weight = 0;
        
        Truck(int weight){
        	this.weight = weight;
        }
    }
  
}
