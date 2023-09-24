package Assignment2_Q2;

public class MinPQ {
	
	//-----------------------------------------------------------------
	// Title: Question 2
	// Author: Basme Zantout
	// ID: 99227947762
	// Section: 1
	// Assignment: 2
	// Description: This is a standard Minimum Priority Queue 
    //              data structure taken from the "Algorithms, 4th edition
    //              by Robert Sedgewick and Kevin Wayne" book for reference
	//-----------------------------------------------------------------
	
	
    	// array to store the priority queue
	    private Edge[] pq; 
	    
	   // number of elements in the priority queue
	    private int size; 

	    
	    // constructor that takes an iterable bag of edges and initializes the priority queue
		public MinPQ(Iterable<Edge> edges, Graph G) 
	    {
	    	pq = new Edge[G.E()];
	        size = 0;
	        for (Edge e : edges)
	        {
	        	insert(e);
	        }
	        
	    }
	    

	    // method to check if the priority queue is empty
	    public boolean isEmpty() 
	    {
	        return size == 0;
	    }

	    
	    // method to get the size of the priority queue
	    public int size() 
	    {
	        return size;
	    }
	    

	    // method to insert an edge into the priority queue
	    public void insert(Edge e) 
	    {
	        if (size == pq.length) 
	        {
	            resize(2*pq.length);
	        }
	        
	        pq[size++] = e;
	        swim(size-1);
	    }

	    
	    
	    
	    // method to remove the minimum weight edge from the priority queue
	    public Edge delMin() 
	    {
	        Edge min = pq[0];
	        swap(0, --size);
	        sink(0);
	        pq[size] = null;
	        
	        if (size > 0 && size == pq.length/4) 
	        {
	            resize(pq.length/2);
	        }
	        
	        return min;
	    }

	    
	    
	    // helper method to resize the array
	    private void resize(int capacity) 
	    {
			Edge[] temp = new Edge[capacity];
	        
	        for (int i = 0; i < size; i++) 
	        {
	            temp[i] = pq[i];
	        }
	        
	        pq = temp;
	    }

	    
	    
	    // helper method to move an element up the heap
	    private void swim(int k)
	    {
	        while (k > 0 && getWeight(pq[k]) < getWeight(pq[(k-1)/2])) 
	        {
	            swap(k, (k-1)/2);
	            k = (k-1)/2;
	        }
	    }

	    
	    
	    // helper method to move an element down the heap
	    private void sink(int k)
	    {
	        while (2*k+1 < size) 
	        {
	            int j = 2*k+1;
	            
	            if (j+1 < size && getWeight(pq[j+1]) < getWeight(pq[j])) 
	            {
	                j++;
	            }
	            
	            if (getWeight(pq[k]) <= getWeight(pq[j]))
	            {
	                break;
	            }
	            
	            swap(k, j);
	            k = j;
	        }
	    }
	    
	    

	    // helper method to swap two elements in the priority queue
	    private void swap(int i, int j) 
	    {
	        Edge temp = pq[i];
	        pq[i] = pq[j];
	        pq[j] = temp;
	    }

	    
	    // method to get the weight of an edge (assuming Edge is a class with a getWeight() method)
	    private int getWeight(Edge e) 
	    {
	        return e.getEdgeWeight();
	    }

}
