package Assignment2_Q1;

public class CheckTreeStructure {


	//-----------------------------------------------------------------
	// Title: Question 1
	// Author: Basme Zantout
	// ID: 99227947762
	// Section: 1
	// Assignment: 2 
	// Description: This is a class used by the main class. It 
	//              has the methods that perform the needed operations, 
    //              which are intended check whether a graph satisfies 
	//              the three conditions that make it  eligible to be
    //              converted to a tree structure.
	//-----------------------------------------------------------------
	
	
	
	public static void Print_Connections(LinearProbingHashST<String> st , Digraph G)
//------------------------------------------------------------------
// Summary: prints the connections between the taxi pickups and rides
// Precondition: this methods takes the Hash/Symbol table and the 
//               Directed Graph as parameters 
// Postcondition: It prints out the cities and their connections 
//                based on the order they were inserted to the hash 
//                table and on the edges created between them in the
//                Digraph.
// Note: this method uses the "return_order()" and "return_key" 
//       methods from the "LinearProbingHashST" class and the "adj()"
//       method from the "Digraph" class. Check the classes for 
//       implementation details.
//------------------------------------------------------------------
		
	{	
		for (int i = 0 ; i < G.V() ; i++)
		{
			// printing out the taxi pickup
			
			System.out.print(st.return_order(i) + ": ");
			
			for (int vertex : G.adj(st.get(st.return_order(i))))
			{
				// printing out the taxi pickup's rides
				
				System.out.print( st.return_key(vertex) + " ");
			}
			
			System.out.println();
		}
	}
	
	
	
	
	public static boolean Check_Edges_Vertices(Digraph G)
//------------------------------------------------------------------
// Summary: checks the first condition
// Precondition: this methods takes the Directed Graph as parameter
// Postcondition: this method returns "true" if the number of edges is 
//                is one less than the number of vertices and returns
//                "false" otherwise.
//------------------------------------------------------------------
		
	{
		return ((G.E() + 1) == G.V());
	}
	
	
	
	public static boolean Check_Cycle(Digraph G)
//------------------------------------------------------------------
// Summary: checks the second condition
// Precondition: this methods takes the Directed Graph as parameter
// Postcondition: this method returns "true" if the graph is acyclic
//                and returns "false" otherwise. This method calls 
//                the "hasCycle" method in the "DirectedCycle" class
//                to check this condition.
// Note: check the "DirectedCycle" class for implementation details.
//------------------------------------------------------------------
		
	{
		DirectedCycle check_cycle = new DirectedCycle(G);
		
		return (!(check_cycle.hasCycle()));
	}
	
	
	
	
	public static boolean Check_Connected(Digraph G)
//------------------------------------------------------------------
// Summary: checks the third condition
// Precondition: this methods takes the Directed Graph as parameter
// Postcondition: this method returns "true" if the graph is connected
//	                and returns "false" otherwise. The method checks
//                  the condition by performing a DFS starting from
//                  each vertex (1) and then checking if all vertices
//                  were visited (2).
// Note: check the "dfs" method below for implementation details.
//------------------------------------------------------------------
		
	{
		// (1)
		
		boolean[] visited = new boolean[G.V()];
		
        for (int v = 0; v < G.V(); v++) 
        {
            dfs(G, v, visited);
        }

        
        // (2)
        
        for (int v = 0; v < G.V(); v++) 
        {
            if (!visited[v]) 
            {
                return false;
            }
        }
        
        return true;
	}
	
	
	
	private static void dfs(Digraph G, int v, boolean [] visited)
//-----------------------------------------------------------------------
// Summary: this is a DFS method
// Precondition: this methods takes the Directed Graph, the vertex
//               in which the DFS is performed at and the boolean array
//               "visited" which marks each visited vertex as parameters
// Postcondition: this method performs a standard Depth-First Search 
//                algorithm.s
//-----------------------------------------------------------------------
	
	 {
		visited[v] = true;
		
		for (int w : G.adj(v))
		{
			if (!visited[w])
			 {
				 dfs(G, w, visited);
			 }
		}
	 }
	
	
}
