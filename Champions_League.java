import java.io.*;
import java.util.*;
public class Champions_League {
	public static void main(String[] args){
		
		// Read input from stdin and provide input before running if required
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n =  sc.nextInt();
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(m, Collections.reverseOrder());
		
		for (int i = 0; i < m; i++) {
			q.add(sc.nextInt());
		}
		
		
		int cost = 0;
		for(int i = 0; i < n; i++) {
		    cost += q.peek();
		    int temp = q.poll() - 1;
		    q.add(temp);
		}
		
		System.out.print(cost);
		sc.close();
	}
}
