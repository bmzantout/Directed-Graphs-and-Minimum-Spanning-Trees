import Bag;

public class Digraph {


	//-----------------------------------------------------------------
	// Title: Question 1
	// Description: This is an Directed Graph class, which has the 
        //              methods that create a directed graph and that perform
        //              basic graph operations based on the Graph data structure.
        //              This class also depends on the Bag.java class in its
	//              implementation
	//-----------------------------------------------------------------
	
	

//-------------------------------------------------------
// Attribute: the number of vertices in the graph
//-------------------------------------------------------
	
	private final int V;
	

//-------------------------------------------------------
// Attribute: the number of edges in the graph
//-------------------------------------------------------
			
	private int E;
	

//-------------------------------------------------------
// Attribute: vertex-indexed array for the adjacency list
//-------------------------------------------------------
	 
	private Bag<Integer>[] adj;
	 
	
	
	
	 @SuppressWarnings("unchecked")
	public Digraph(int V, int E)
//------------------------------------------------------------------
// Summary: a Constructor method
// Precondition: this constructor takes the number of vertices in
//	               the graph as parameter
// Postcondition: the method initializes the the number of vertices,
//	                edges and the vertex-indexed Bag array (1). It also
//	                creates a bag at each index in the Bag array to
//	                store the adjacency list of each vertex (2).
//------------------------------------------------------------------
		
	 {
		 // (1)
		 
		 this.V = V;
		 this.E = E;
		 adj = (Bag<Integer>[]) new Bag[V];
		 
		 // (2)
		 
		 for (int v = 0; v < V; v++)
		 {
			 adj[v] = new Bag<Integer>();
		 }
	 }
	 
	 
	 
	 public void addEdge(int v, int w)
//----------------------------------------------------------
// Summary: adds an edge/connection between 2 vertices
// Precondition: takes the vertices as parameters
// Postcondition: calls the "add" method from the Bag class
//	              to add a vertex to the the adjacency list 
// 
// Note: check the "add" method in the "Bag" class for details
//----------------------------------------------------------
		
	 {
		 adj[v].add(w);
	 }
	 
	 
	 
	 public Iterable<Integer> adj(int v)
//----------------------------------------------------------
// Summary: returns the adjacency list of a vertex
// Precondition:  takes the vertex as parameter
// Postcondition: returns adjacency list as an Iterable list.
//
// Note: check the "Bag" class for details
//----------------------------------------------------------
		
	 {
		 return adj[v];
	 }
	 
	 
	 
	 public int V()
//-------------------------------------------------------
// Summary: returns the number of vertices in the graph
// Precondition: a getter method
// Postcondition: returns "V" the number of vertices 
//-------------------------------------------------------
		
	 {
		 return V;
	 }
	 
	 
	 
	 public int E()
//-------------------------------------------------------
// Summary: returns the number of edges in the graph
// Precondition: a getter method
// Postcondition: returns "E" the number of edges 
//-------------------------------------------------------
		
	 {
		 return E;
	 }
	 
	 
}
