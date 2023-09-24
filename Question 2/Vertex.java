package Assignment2_Q2;

public class Vertex {
	

	//-----------------------------------------------------------------
	// Title: Question 2
	// Author: Basme Zantout
	// ID: 99227947762
	// Section: 1
	// Assignment: 2
	// Description: This is a Vertex class, which has the attributes and
    //              methods required for the Vertex object
	//-----------------------------------------------------------------
	

	
//-------------------------------------------------------
// Attribute: the index value of the Vertex in the Matrix
//-------------------------------------------------------
		
	 private int index;
	 
		
//-------------------------------------------------------
// Attribute: the value of the vertex that is stored at
//            each index in the 2-D Matrix
//-------------------------------------------------------
		
	 private int value;
	 
		
//-------------------------------------------------------
// Attribute: the count holds the vertex number that will
//           represent the vertex in the graph structure
//-------------------------------------------------------
	
	 private int count;
	 
	 
	 public Vertex (int index , int value, int count)
//------------------------------------------------------------------
// Summary: a Constructor method
// Precondition: this constructor takes the index, value and count
//               as parameters
// Postcondition: the method initializes the attributes
//------------------------------------------------------------------
		
	 {
		 this.index = index;
		 this.value = value;
		 this.count = count;
		 
	 }
	 
	 public Vertex(int index)
//------------------------------------------------------------------
// Summary: another Constructor method
// Precondition: this constructor takes the index as parameter
// Postcondition: the method initializes some of the attributes
//------------------------------------------------------------------
		
	 {
		 this.index = index;
		 this.value = 0;
	 }
	 
	 
	 public int getCount()
//------------------------------------------------------------------
// Summary: a Getter method that returns the "count" of the Vertex
//------------------------------------------------------------------
		
	 {
		 return this.count;
	 }
	 
	 
	 
	 public int getIndex()
//------------------------------------------------------------------
// Summary: a Getter method that returns the "index" of the Vertex
//------------------------------------------------------------------

	 {
		 return this.index;
	 }
	 
	 
	
	 public int getValue()
//------------------------------------------------------------------
// Summary: a Getter method that returns the "value" of the Vertex
//------------------------------------------------------------------

	 {
		 return this.value;
	 }
	 
}
