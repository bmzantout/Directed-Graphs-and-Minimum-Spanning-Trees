public class DirectedCycle {


	//-----------------------------------------------------------------
	// Title: Question 1
	// Description: This is an Directed Cycle class, which has the 
        //              methods that checks whether a directed graph is 
        //              cyclic or not.
	//-----------------------------------------------------------------
	
	
	
//-------------------------------------------------------
// Attribute: a boolean array that marks true for each 
//	            visited vertex-index in the graph
//-------------------------------------------------------
		
	 private boolean[] marked;
	 
		
//-------------------------------------------------------
// Attribute: an int array that saves the last vertex on
//      the known path to this vertex
//-------------------------------------------------------

	 private int[] edgeTo;
	 
		
//-------------------------------------------------------
// Attribute: a Stack of integers that stores the vertices
//           on a cycle (if one exists)
//-------------------------------------------------------

	 private Stack<Integer> cycle; 
	 
		
//-------------------------------------------------------
// Attribute: a boolean array that checks whether the 
//            vertices are in the stack in a recursive call
//-------------------------------------------------------
	 
	 private boolean[] onStack; 
	 
	 
	 
	 public DirectedCycle(Digraph G)
//-------------------------------------------------------
// Summary: a Constructor method
// Precondition: this constructor takes the Directed Graph
//               as parameter
// Postcondition: the method initializes the attributes (1)
//                and calls a recursive "dfs" method that 
//                checks whether the graph has a cycle or
//                or not (2).
//-------------------------------------------------------
	
	 {
		 // (1)
		 
		 onStack = new boolean[G.V()];
		 edgeTo = new int[G.V()];
		 marked = new boolean[G.V()];
		 
		 // (2)
		 
		 for (int v = 0; v < G.V(); v++)
		 {
			 if (!marked[v]) 
			 {
				 dfs(G, v);
			 }
		 }
	 }
	 
	 
	 
	 private void dfs(Digraph G, int v)
//-------------------------------------------------------------
// Summary: a Recursive DFS method
// Precondition: this method takes the graph and the vertex
//               in which the DFS will be applied on as
//               parameters 
// Postcondition: this modified version of the DFS, performs
//                a Depth-First Search to check whether the 
//                given graph has a cycle or not. If there's
//                a cycle in the graph then the method assigns
//                vertices included in the cycle to the Stack
//                named cycle. Otherwise, "cycle" remains null.
//-------------------------------------------------------------
	
	 {
		 onStack[v] = true;
		 marked[v] = true;
		 
		 for (int w : G.adj(v))
		 {
			 if (this.hasCycle()) 
			 {
				 return;
			 }
			 
			 else if (!marked[w])
			 {
				 edgeTo[w] = v; dfs(G, w);
			 }
			 
			 
			 else if (onStack[w])
			 {
				 cycle = new Stack<Integer>();
				 for (int x = v; x != w; x = edgeTo[x])
				 cycle.push(x);
				 cycle.push(w);
				 cycle.push(v);
			 }
		 }
		 
		 onStack[v] = false;
	 }
	 
	 
	 
	 public boolean hasCycle()
//-------------------------------------------------------------
// Summary: returns whether a Digraph has a cycle or not
// Precondition: this method checks if a graph is cyclic 
// Postcondition: if the "cycle" Stack is empty or null this 
//                the graph is acyclic "false" is returned. 
//                But, if the "cycle" Stack has values then the
//                graph is cyclic and "true" is returned. 
//-------------------------------------------------------------
		
	 {
		 return cycle != null;
	 }
	 
	 
	 
}
