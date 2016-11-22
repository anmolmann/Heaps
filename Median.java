
import java.util.*;

public class Median {

	public static void main(String args[]) {
    
		PriorityQueue<Double> min_heap = new PriorityQueue<Double>();
    	
		PriorityQueue<Double> max_heap = new PriorityQueue<Double>(new Comparator<Double>() {
    		public int compare(Double a, Double b) {
    			return -1 * a.compareTo(b);
    		}
    	});
    	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			double n = sc.nextInt();
			if(max_heap.isEmpty() == true) max_heap.add(n);
			else if(n < max_heap.peek()) max_heap.add(n);
			else min_heap.add(n);
			
			// balance both the heaps			
			if(Math.abs(max_heap.size() - min_heap.size()) > 1) {
				if(max_heap.size() > min_heap.size()) {
					min_heap.add(max_heap.peek());
					max_heap.poll();
				}
				else {
					max_heap.add(min_heap.peek());
					min_heap.poll();
				}
			}
			if(i % 2 == 0) {
				if(max_heap.size() > min_heap.size()) System.out.println(max_heap.peek());
				else System.out.println(min_heap.peek());
			}
			else System.out.println((max_heap.peek() + min_heap.peek()) / 2);
		}
        sc.close();	
    }
}
/*
 * Example :- 9
3 5 67 87 27 56 434 91
3.0
4.0
5.0
36.0
27.0
41.5
56.0
61.5

 */