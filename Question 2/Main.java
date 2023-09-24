import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//-----------------------------------------------------------------
		// Title: Question 2
		// Description: This is the main class for Question 2 which calls 
		//              the methods that perform the needed operations, 
	        //              which are intended to operate an MST  over a graph 
	        //              from a source vertex to a destination vertex, while
		//              calculating the total expense of the path taken.
		//-----------------------------------------------------------------
		

		
//-------------------------------------------------------
// Creating a Scanner object named "scanner"   
//-------------------------------------------------------
	
		Scanner scan = new Scanner(System.in);
		System.out.println("buyrun");

		
//-------------------------------------------------------
// Reading the number of test cases   
//-------------------------------------------------------
	
			
		int Number_Of_TestCases = scan.nextInt();
		
		
		
//-------------------------------------------------------
// In a for loop, we read the input based on the number
// of test cases
//-------------------------------------------------------
	
			
		for (int x = 0 ; x < Number_Of_TestCases ; x++)
		{
			
			
		//-------------------------------------------------------
		// Defining a "Traversals" object which does most of 
		// the operations needed. 
		// Note: check the "Traversals" class for details
		//-------------------------------------------------------
					
			Traversals traversal = new Traversals();
			
			
			
			
		//-------------------------------------------------------
		// Reading the number of rows and columns in the matrix  
		//-------------------------------------------------------		
				
			int rows = scan.nextInt();
			int columns = scan.nextInt();
			
			
			
		//-------------------------------------------------------
		// Initializing the 2-D matrix in the "Traversals" class
		// with the given number of rows and columns
		//-------------------------------------------------------
					
			traversal.Matrix = new Vertex [rows][columns];
			
			
			
			
		//-------------------------------------------------------
		// Initializing the Source and Destination vertices in the
		// "Traversals" class. 
		// Note: "SourceVertex" and "DestinationVertex" are of 
		//       type "Vertex". Check the "Vertex" class and 
		//       constructor for implementation details.
		//-------------------------------------------------------
					
			traversal.SourceVertex = new Vertex (scan.nextInt()*10 + scan.nextInt());
			traversal.DestinationVertex = new Vertex (scan.nextInt()*10 + scan.nextInt());
			
			
			
			
		//-------------------------------------------------------
		// The "count" variable will be assigned to each vertex 
		// read. It will give each vertex an index number based
		// on the order they are read in.
		//-------------------------------------------------------
		
			int count = 0;
			
			
	    //-------------------------------------------------------
    	// In a nested for-loop read the values of the vertices 
		// and fill the 2-d matrix with the given values.
		//-------------------------------------------------------
			
			for (int i = 0 ; i < rows ; i++)
			{
				for (int j = 0 ; j < columns ; j++)
				{
					
					
					
				//-------------------------------------------------------
				// Create a vertex object and assign it to its specified 
				// place in the matrix.
				// Note: Check the "Vertex" class for implementation 
				//       details
				//-------------------------------------------------------
					
					Vertex ver = new Vertex (((i+1)*10 + (j+1)), scan.nextInt(), count++);
					traversal.Matrix[i][j] = ver;
					
					
					
				//-------------------------------------------------------
				// The Source and Destination Vertices initially held the 
				// index number of the Vertex only, so here we redefine 
				// them so they also hold the "count" or index number, too.
				//-------------------------------------------------------
						
					if (ver.getIndex() == traversal.SourceVertex.getIndex())
					{
						traversal.SourceVertex = ver;
					}
					
					if (ver.getIndex() == traversal.DestinationVertex.getIndex())
					{
						traversal.DestinationVertex = ver;
					}
					
				}
			}
	
			
		//-------------------------------------------------------
		// Initializing a Graph object "G" with the number of 
		// vertices calculated by multiplying the rows by the 
		// columns number of the matrix.
		//-------------------------------------------------------
				
			Graph G = new Graph(rows * columns);
			
			
		//-------------------------------------------------------
		// This method takes the 2-D Matrix as input and converts 
		// the Matrix to a Graph structure by establishing the 
		// connections between the vertices as edges.
		// Note: check the "Establish_Connection" method in the 
		//       "Graph" class for implementation details.
		//-------------------------------------------------------
				
			G.Establish_Connection(traversal.Matrix);
	
			
		//-------------------------------------------------------
		// Initializing a KruskalMST object "kruskal" which is 
		// responsible for finding the MST for the Graph "G".
		//-------------------------------------------------------
	
			 KruskalMST kruskal = new KruskalMST (G);
			
			 
		//-------------------------------------------------------
		// Initializing a Graph object "MST_Graph" with the same
		// initial number of vertices. This graph will be the 
	    // Graph in its Minimum-Spanning Tree form.
	    //-------------------------------------------------------
			
			 Graph MST_Graph = new Graph(G.V());			 
		
			 
		//-------------------------------------------------------
		// This method does the necessary operations for finding
		// the needed path and calculating its total weight.
	    // Note: check the "FIND_SHORTESTPATH_MST" method in the 
		// "Traversals" class for implementation details.
	    //-------------------------------------------------------
		
			 traversal.FIND_SHORTESTPATH_MST (kruskal ,MST_Graph, G);
		
		
		}
		
		
//-------------------------------------------------------
// closing the scanner
//-------------------------------------------------------
				
	 scan.close();
				 
	}

}
