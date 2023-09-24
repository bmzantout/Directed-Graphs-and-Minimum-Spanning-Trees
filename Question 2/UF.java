package Assignment2_Q2;

public class UF {
	
	//-----------------------------------------------------------------
	// Title: Question 2
	// Author: Basme Zantout
	// ID: 99227947762
	// Section: 1
	// Assignment: 2
	// Description: This is a standard Union Find algorithm taken from 
	//              the "Algorithms, 4th edition by Robert Sedgewick and 
	//              Kevin Wayne" book for reference
	//-----------------------------------------------------------------
	
	
	// access to component id (site indexed)
	 private int[] id; 
	 
	 
	// number of components
	 private int count; 
	 
	 
	 public UF(int N)
	 {  
		 // Initialize component id array.
		 count = N;
		 id = new int[N];
		 for (int i = 0; i < N; i++)
		 id[i] = i;
	 }
	 
	 
	 public int count()
	 { 
		 return count;
	 }
	 
	 
	 public boolean connected(int p, int q)
	 { 
		 return find(p) == find(q);
	 }
	 
	 
	 public int find(int p)
	 { 
		 return id[p];
	 }
	 
	 
	 public void union(int p, int q) 
	 { 
		// Put p and q into the same component.
		  int pID = find(p);
		  int qID = find(q);
		  
		  // Nothing to do if p and q are already in the same component.
		  if (pID == qID) return;
		  
		  // Rename p’s component to q’s name.
		  for (int i = 0; i < id.length; i++)
		  if (id[i] == pID) id[i] = qID;
		  count--;
	 }
}
