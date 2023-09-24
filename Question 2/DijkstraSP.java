import Stack;

public class DijkstraSP {
	
	//-----------------------------------------------------------------
	// Title: Question 2
	// Description: This is a standard Dijkstra Shortest Path algorithm
        //              taken from the "Algorithms, 4th edition by Robert
	//              Sedgewick and Kevin Wayne" book for reference
	//-----------------------------------------------------------------
	


	    private double[] distTo;
	    
	    private Edge[] edgeTo;
	    
	    private IndexMinPQ<Double> pq;
	    
	    public  Stack<Edge> path;

	    
	    
	    public DijkstraSP(Graph G, int s) 
	    {
	        distTo = new double[G.V()];
	        
	        edgeTo = new Edge[G.V()];
	        
	        pq = new IndexMinPQ<>(G.V());
	        
	        path = new Stack<>();
	        
	        for (int v = 0; v < G.V(); v++) 
	        {
	            distTo[v] = Double.POSITIVE_INFINITY;
	        }
	        
	        
	        distTo[s] = 0.0;

	        pq.insert(s, 0.0);
	        
	        while (!pq.isEmpty()) 
	        {
	            int v = pq.delMin();
	            
	            for (Edge e : G.adj(v)) 
	            {
	                int w = e.other(e.either().getIndex()).getCount();
	                
	                double newDist = distTo[v] + e.getEdgeWeight();
	                
	                if (newDist < distTo[w]) 
	                {	
	                    distTo[w] = newDist;
	                    
	                    edgeTo[w] = e;
	                    
	                    if (pq.contains(w)) 
	                    {
	                        pq.decreaseKey(w, newDist);
	                    } 
	                    
	                    else 
	                    {
	                        pq.insert(w, newDist);
	                    }
	                }
	            }
	        }
	    }

	    
	    
	    
	    public double distTo(int v) 
	    {
	        return distTo[v];
	    }

	    
	    
	    public boolean hasPathTo(int v) 
	    {
	        return distTo[v] < Double.POSITIVE_INFINITY;
	    }

	    
	    
	    public Iterable<Edge> pathTo(int v)
	    {
	        if (!hasPathTo(v)) 
	        {
	        	return null;
	        }
	        
	        
	        for (Edge e = edgeTo[v] ; e != null; e = edgeTo[e.either().getCount()]) 
	        {
	        	path.push(e);
	        }
	        
	        return path;
	    }


}
