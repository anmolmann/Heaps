import java.io.*;
import java.util.*;
public class Solution {
    
    int clinics;
    int population;
    int load;

    Solution() {}
    
    Solution(int clinics, int population) {
        this.clinics = clinics;
        this.population = population;
        this.load = population/clinics;
    }
    public static void main(String[] args) {
	// Read input from stdin and provide input before running if required
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();  // cities
	int b = sc.nextInt();  // clinics
		
	PriorityQueue<Solution> q = new PriorityQueue<Solution>(new Comparator<Solution>() {
	    public int compare(Solution s1, Solution s2) {
		if(s1.load < s2.load) return 1;
		else if(s1.load > s2.load) return -1;
		return 0;
	    }
	});
		
	for (int i = 0; i < n; i++) {
	    q.add(new Solution(1, sc.nextInt()));
	}
		
	for(int i = 0; i < b - n; i++) {
	    Solution temp = q.poll();
	    temp.clinics++;
	    temp.load = temp.population / temp.clinics;
	    if(temp.population % temp.clinics != 0) ++temp.load;
	    q.add(temp);
	}
	System.out.println(q.peek().load);
	sc.close();
    }
}
