public class Traversals {
	

	//-----------------------------------------------------------------
	// Title: Question 2
	// Description: This is a helper class that is used by the main 
        //              class. It has the needed operations and methods to
        //              find the required path calculate its cost. 
	//-----------------------------------------------------------------
	
	
	
//-------------------------------------------------------
// Attribute: a 2-D Matrix to hold the input grid
//-------------------------------------------------------
		
	public Vertex [][] Matrix;
	
	
//-------------------------------------------------------
// Attribute: the source vertex where the traversal
//            starts from
//-------------------------------------------------------
	
	public Vertex SourceVertex;
	
	
	
//-------------------------------------------------------
// Attribute: the destination vertex where the traversal
//	          ends at
//-------------------------------------------------------
		
	public Vertex DestinationVertex;
	
	
	
	
	public void FIND_SHORTESTPATH_MST (KruskalMST kruskal , Graph MST_Graph, Graph G)
//------------------------------------------------------------------
// Summary: this method calls the the required methods and does the
//          required operations for finding the required path 
//          calculate its cost
// Precondition: this constructor takes the KrusualMST object, 
//               the MST Graph and the standard graph as parameter
// Postcondition: the input of the total path cost is printed to
//                console in this method
//------------------------------------------------------------------
	

	{	
		
		
	//-------------------------------------------------------
	// Initializing an array of type Vertex to store all the 
	// vertices in the MST graph
	//-------------------------------------------------------

		 Vertex [] array = new Vertex [1000];
		 int z = 0;
		
			
			
	//-------------------------------------------------------
	// Using the Kurskal algorithm, we find the MST of the 
	// Graph and add the vertices of each edge to the Vertex
	// array
	//-------------------------------------------------------
		
		 for (Edge e : kruskal.edges())
		 {
			 MST_Graph.addEdge(e);
			 array[z++] = e.either();
			 array[z++] = e.other(e.either().getIndex());
		}

		
			
	//-------------------------------------------------------
	// After taking all the vertices in the MST graph and 
	// storing them in the Vertex array, we check the following
	// if there is any vertex that occurs twice in the list of 
	// edges we remove them both from the array. This way, we 
	// only end up with two vertices which are supposed to be 
	// starting and terminating vertices in the traversal.
	//-------------------------------------------------------
	
		 for (int i = 0 ; i < array.length ; i++)
		 {
			 for (int j = i+1 ; j < array.length ; j++)
			 {
				 if (array[i] != null)
				 {
					 if ((array[j] != null) && (array[i].getIndex() == array[j].getIndex()))
					 {
						 array[i] = null;
						 array[j] = null;
					 } 
				 }
				 
			 }
		 }
		 
		 
			
	//-------------------------------------------------------
    // Initializing an array of type Vertex which stores the 
	// 2 vertices that are remaining from the above "array" 
	// array.
	//-------------------------------------------------------

			 
		 Vertex [] vertices = new Vertex[100];
		 z = 0;
	
	//-------------------------------------------------------
    // We store the stores the remaining vertices from the 
	// previous "array" array.
	//-------------------------------------------------------
		 
		 for (int i = 0 ; i < array.length ; i++)
		 {
			 if (array[i] != null)
			 {
				 vertices[z++] = array[i];
			 }
		 }
		 
		 
	//-------------------------------------------------------
    // Initializing a "DijkstraSP" object which will used to 
	// find the shortest path from one vertex to another
	//-------------------------------------------------------

		 DijkstraSP dijkstra = null;
		 

			
	//-------------------------------------------------------
    // At this point, we have 2 remaining vertices. Those 
	// vertices have to be the source and destination vertices
	// given in the input. If they are not, then we have to 
	// do the following:
	// 1- check which vertex is the source/destination 
	//    vertex
	// 2- Once we know which vertex is the source/destination
	//    vertex we have to check exactly if it is a source
	//	  vertex or it is a destination vertex
	// 3- if it's a source vertex then we have to find the 
	//    shortest path from the other/second vertex in the 
	//    "vertices" array to the destination vertex. Else, if
	//	  it's a destination vertex then we have to find the 
	//    shortest path from the other/second vertex in the 
	//    "vertices" array to the source vertex
	// 4- the boolean "dijkstra_applied" returns true if we
	//    apply dijkstra's algorithm and false if we didn't
	//    which means that the vertices are the source and 
	//    destination vertices so, no need for dijkstra
	//-------------------------------------------------------
			
		 boolean dijkstra_applied = false;
			
		 
		 if ((!   (vertices[0].getIndex() == SourceVertex.getIndex() && vertices[1].getIndex() == DestinationVertex.getIndex())  || 
				  (vertices[0].getIndex() == DestinationVertex.getIndex() && vertices[1].getIndex() == SourceVertex.getIndex())  ))
		 {
			 if (vertices[0].getIndex() == SourceVertex.getIndex())
			 {
				 dijkstra = new DijkstraSP(MST_Graph, DestinationVertex.getCount());
				 dijkstra.pathTo(vertices[1].getCount());
				 dijkstra_applied = true;
			 }
			 
			 else if (vertices[0].getIndex() == DestinationVertex.getIndex())
			 {
				 dijkstra = new DijkstraSP(MST_Graph, SourceVertex.getCount());
				 dijkstra.pathTo(vertices[1].getCount());
				 dijkstra_applied = true;
			 }
			 
			 else if (vertices[1].getIndex() == SourceVertex.getIndex()) 
			 {
				 dijkstra = new DijkstraSP(MST_Graph, DestinationVertex.getCount());
				 dijkstra.pathTo(vertices[0].getCount());
				 dijkstra_applied = true;
			 } 
			 
			 else if (vertices[1].getIndex() != DestinationVertex.getIndex())
			 {
				 dijkstra = new DijkstraSP(MST_Graph, SourceVertex.getCount());
				 dijkstra.pathTo(vertices[0].getCount());
				 dijkstra_applied = true;
			 }
		 }
		  
		 
	//-------------------------------------------------------
    // Printing out the total cost of the trip 
	// Note: check the "CALCULATE" method below for details
	//-------------------------------------------------------

		 System.out.println(CALCULATE (MST_Graph, dijkstra, dijkstra_applied));
		 
		 
	}
	
	
	
	public int CALCULATE(Graph MST_Graph, DijkstraSP dijkstra, boolean dijkstra_applied)
//------------------------------------------------------------------
// Summary: this method calculates the total cost of the trip 
// Precondition: this constructor takes the dijkstra object, 
//               the MST Graph and the "dijkstra_applied" boolean 
//               as parameter
// Postcondition: the method returns an int which represents the
//                total cost of the trip
//------------------------------------------------------------------
	
	{
		 
	//-------------------------------------------------------
    // The trip cost is initiallyset to 0
	//-------------------------------------------------------
		
		int Trip_total_cost = 0;
		
		 
	//-------------------------------------------------------
    // For each edge in the MST Graph, we add it to the total
	// cost of the trip. But, before doing so we check if
	// dijkstra was applied and the edge is visited twice, 
	// then we incerement the its number of iterations to
	// use it int he calculation.
	//-------------------------------------------------------

	
		for (Edge e : MST_Graph.edges())
		{
			if (dijkstra_applied)
			{
				for (Edge edge : dijkstra.path)
				{
					if (edge.equals(e))
					{
						e.incrementIteration();
					}
				}
			}
				
		//-------------------------------------------------------
	    // The formula of the total trip cost 
		//-------------------------------------------------------
			
			Trip_total_cost = Trip_total_cost + e.getEdgeWeight() * (int) Math.ceil((double)e.getIteration()/2);
		}
		
		return Trip_total_cost;
	}
	

}
