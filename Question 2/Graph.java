import Bag;

public class Graph {

	//-----------------------------------------------------------------
	// Title: Question 2
	// Description: This is a Graph class, which has the methods that create 
        //              a graph and that perform basic graph operations based on
        //              the Graph data structure. This class also depends on 
        //              the Bag.java class in its implementation
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
	 
	 private final Bag<Edge>[] adj;
	 
	 
	 
	 @SuppressWarnings("unchecked")
	public Graph(int V)
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
		 this.E = 0;
		 adj = (Bag<Edge>[]) new Bag[V];
		 
		 
		 // (2)
		 
		 for (int v = 0; v < V; v++)
		 {
			 adj[v] = new Bag<Edge>();
		 }
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
	 
	 
	 public void addEdge(Edge e)
//----------------------------------------------------------
// Summary: adds an edge/connection between 2 vertices
// Precondition: takes the vertices as parameters
// Postcondition: calls the "add" method from the Bag class
//	              to add a vertex to the the adjacency list 
// 
// Note: check the "add" method in the "Bag" class for details
//----------------------------------------------------------
	
	 {
		 int v = e.either().getCount();	 
		 adj[v].add(e);
		 E++;
	 }
	 
	 
	
	 public Iterable<Edge> adj(int v)
//----------------------------------------------------------
// Summary: returns the adjacency list of edges
// Precondition:  takes an int as parameter
// Postcondition: returns adjacency list as an Iterable list.
//
// Note: check the "Bag" class for details
//----------------------------------------------------------
		
	 { 
		 return adj[v];
	 } 
	 
	 
	 
	 
	 public Iterable<Edge> edges() 
//----------------------------------------------------------
// Summary: returns the list of edges
// Precondition: this method takes no parameter
// Postcondition: returns all the edges in the graph as an 
//                Iterable list.
//
// Note: check the "Bag" class for details
//----------------------------------------------------------
		
	 {
		  Bag<Edge> b = new Bag<Edge>();
		  
		  for (int v = 0; v < V; v++)
		  {
			  for (Edge e : adj[v])
			  {  
				  b.add(e); 
			  }
		  }
		  
		  return b;
	 }
	
	
	 
	 public void Establish_Connection(Vertex [][] Matrix)
//----------------------------------------------------------
// Summary: establishes a graph from a 2-D Matrix
// Precondition: takes the 2_D Matrix as parameter
// Postcondition: the method iterates through the Matrix
//                row by row and then column by column. At
//                each iteration we create an edge between the
//                vertices in the matrix accordingly.
//
// Note: check the "Edge" class for details
//----------------------------------------------------------
		
	 {
		 for (int i = 0 ; i < Matrix.length ; i++)
		 {
			 for (int j = 0 ; j < Matrix[0].length ; j++)
			 {
				 if (j+1 < Matrix[0].length)
				 {
					 Edge e = new Edge(Matrix[i][j] , Matrix[i][j+1], Edge.Calculate_EdgeWeight(Matrix[i][j], Matrix[i][j+1]));
					 addEdge(e);
				 }
			 }
		 }
		 
		 
		 for (int j = 0 ; j < Matrix[0].length ; j++)
		 {
			 for (int i = 0 ; i < Matrix.length ; i++)
			 {
				 if (i+1 < Matrix.length)
				 {
					 Edge e = new Edge(Matrix[i][j] , Matrix[i+1][j], Edge.Calculate_EdgeWeight(Matrix[i][j], Matrix[i+1][j]));
					 addEdge(e);
				 }
			 }
		 }
		
		 
	 }
	 
}
