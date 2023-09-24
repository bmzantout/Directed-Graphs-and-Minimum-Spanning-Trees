public class Edge implements Comparable<Edge> {
	

	//-----------------------------------------------------------------
	// Title: Question 2
	// Description: This is an Edge class, which has the attributes and
        //              methods required for the Edge object used in the Graph
	//-----------------------------------------------------------------
	

	
//-------------------------------------------------------
// Attribute: the vertices at both sides of the edge
//-------------------------------------------------------
	
	 private final Vertex v, w;
	
		
//-------------------------------------------------------
// Attribute: the weight of the edge
//-------------------------------------------------------

	 private final int weight;
	 
		
//-------------------------------------------------------
// Attribute: the number of times we visit an edge
//-------------------------------------------------------

	 private int iteration;
	 
	 
	 
	 
	 public Edge(Vertex v, Vertex w, int weight)
//------------------------------------------------------------------
// Summary: a Constructor method
// Precondition: this constructor takes the vertices and
//               the edge weight as parameters
// Postcondition: the method initializes the attributes
//------------------------------------------------------------------
	
	 {
		 this.v = v;
		 this.w = w;
		 this.weight = weight;
		 this.iteration = 1;
	 }
	 
	 
	 public Vertex either()
//------------------------------------------------------------------
// Summary: a Getter method that returns the Vertex at one side of
//          the edge
//------------------------------------------------------------------
	
	 { 
		 return v;
	 }
	 
	 
	 
	 
	 public Vertex other(int vertex)
//------------------------------------------------------------------
// Summary: a Getter method that returns the Vertex at the other side
//          of the edge
//------------------------------------------------------------------
	
	 {
		 if (vertex == v.getIndex()) 
		 {
			 return w;
		 }
		 
		 else return v;
	 }
	 
	 
	 
	 public int getEdgeWeight()
//------------------------------------------------------------------
// Summary: a Getter method that returns the weight of the edge
//------------------------------------------------------------------
	
	 {
		 return this.weight;
	 }
	 
	 

	 
	 public void incrementIteration()
//------------------------------------------------------------------
// Summary: this method increments the "iteration" by one in case
//          we revisit an edge
//------------------------------------------------------------------
	
	 {
		 this.iteration = this.iteration++;
	 }
	 
	 
	 public int getIteration()
//------------------------------------------------------------------
// Summary: a Getter method that returns the "iteration" of the edge
//------------------------------------------------------------------
	
	 {
		return iteration; 
	 }
	 
	 
	 public int compareTo(Edge that)
//------------------------------------------------------------------
// Summary: the method compares two edges by their weight values
//------------------------------------------------------------------
	
	 {
		 if      (this.weight < that.weight)    return -1;
		 else if (this.weight > that.weight)    return +1;
		 else                                   return  0;
	 } 
	 
	 
	 
	 public boolean equalTo(Edge e)
//------------------------------------------------------------------
// Summary: the method compares two edges by comparing their vertices
//          at both sides
//------------------------------------------------------------------
	
	 {
		 return this.v.getIndex() == e.v.getIndex() && this.w.getIndex() == e.w.getIndex();
	 }


	 
	 public static int Calculate_EdgeWeight(Vertex v, Vertex w)
//------------------------------------------------------------------
// Summary: the method calculates the edge of a single edge using 
//          a given formula
//------------------------------------------------------------------
	
	 {
		 return v.getValue() ^ w.getValue();
	 }
	 
	
}
