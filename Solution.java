import java.io.*;
import java.util.*;
public class Solution{
    
    int clinics;
    int population;
    int load;

    Solution() {}
    
    Solution(int clinics, int population) {
        this.clinics = clinics;
        this.population = population;
        this.load = population/clinics;
    }
    
    public int getPop() {
        return this.population;
    }
    
    public int getClinics() {
        return this.clinics;
    }
    
    public int getLoad() {
        return this.load;
    }
    
    public static void sink(Solution []s, int n, int i) {
        int L = 2 * i;
        int R = 2 * i + 1;
        int max = i;
        if(L <= n && s[L].load > s[max].load) max = L;
        if(R <= n && s[R].load > s[max].load) max = R;
        if(max != i) {
            Solution temp = s[i];
            s[i] = s[max];
            s[max] = temp;
            sink(s, n, max);
        }
    }
    
    public static void clinicAdd(Solution []s, int i) {
        s[i].clinics = s[i].clinics + 1;
    }
    
    public static void loadChange(Solution []s, int i) {
    	s[i].load = s[i].population / s[i].clinics;
        if(s[i].population % s[i].clinics != 0)
        	s[i].load++;
    }
    
	public static void main(String[] args){
		
		// Read input from stdin and provide input before running if required
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();  // cities
		int b = sc.nextInt();  // clinics
		
		Solution[] s = new Solution[n + 2];

		//PriorityQueue<Solution> q = new PriorityQueue<Solution>(n, Collections.reverseOrder);
		
		for (int i = 1; i <= n; i++) {
		    s[i] = new Solution(1, sc.nextInt());
		    //q.add(s[i].getPop() / s[i].getClinics);
		}
		
		for(int i = n/2; i >= 1; i--)
            sink(s, n, i);
		
		for(int i = 1; i <= b - n; i++) {
			//System.out.println(s[1].getLoad());
		    clinicAdd(s, 1);
		    loadChange(s, 1);
		    sink(s, n, 1);
		}
		
		System.out.print(s[1].getLoad());
		
		/*
		Enter Your Code Here
		*/
		
		
	}
}