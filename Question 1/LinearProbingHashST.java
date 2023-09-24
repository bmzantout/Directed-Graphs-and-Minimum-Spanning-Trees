package Assignment2_Q1;

public class LinearProbingHashST <Key> {


	//-----------------------------------------------------------------
	// Title: Question 1
	// Author: Basme Zantout
	// ID: 99227947762
	// Section: 1
	// Assignment: 2
	// Description: This is an Hash Table or Symbol Table class, which 
    //              has the methods that store a set of values in a hash
    //              table data structure by computing their hash codes
    //              and functions. The class implements the Linear-Probing 
    //              Hashing method.
	//-----------------------------------------------------------------
	
	
	
//-------------------------------------------------------
// Attribute: the number of key-value pairs in the table
//-------------------------------------------------------
		
	 private int N; 
	 
		
//-------------------------------------------------------
// Attribute: the size of linear-probing table
//-------------------------------------------------------
		
	 private int M; 
	 
		
//-------------------------------------------------------
// Attribute: an array that stores the keys of the values 
//-------------------------------------------------------
			 
	 public Key[] keys; 
	 
		
//-------------------------------------------------------
// Attribute: an array that stores the order in which the 
//           values are read from the input. It helps in 
//           printing them out to the console in that same
//           order.
//-------------------------------------------------------
		 
	 public Key[] order;
	 
		
//-------------------------------------------------------
// Attribute: a static integer value that keeps count of 
//            order a value was inserted into the table.
//-------------------------------------------------------
	
	 private static int count = 0;

	 
	 
	 @SuppressWarnings("unchecked")
	 
	public LinearProbingHashST(int M)
//------------------------------------------------------------------
// Summary: a Constructor method
// Precondition: this constructor takes the size of linear-probing 
//               table as parameter
// Postcondition: the method initializes the the attributes.
//------------------------------------------------------------------
	
	 {
		 this.M = M;
		 keys = (Key[]) new Object[M];
		 order = (Key[]) new Object[M];
	 }
	
	
	
	 private int hash(Key key)
//------------------------------------------------------------------
// Summary: the method hashes a given key
// Precondition: it takes the key as parameter
// Postcondition: the method hashes a given key by performing the 
//                specified formula of the hash function
//------------------------------------------------------------------
		
	 {
		 return (key.hashCode() & 0x7fffffff) % M;
	 }
	 
	 
	 
	 public void put(Key key)
//------------------------------------------------------------------
// Summary: the method adds a key to the hash table
// Precondition: it takes the key as parameter
// Postcondition: the method put or inserts the key in the hash table
//                by getting its hash function. If the key already 
//                exists the method terminates without any addition.
//                The method also adds the key based on the order it 
//                was added to the "order" array and updates/increments 
//                the "count" int accordingly.
//------------------------------------------------------------------
		
	 {
		 
		 int i;
		 for (i = hash(key); keys[i] != null; i = (i + 1) % M)
		 {
			 if (keys[i].equals(key)) 
			 {
				 return;
			 }
		 }
		 
		 keys[i] = key;
		 order[count] = key;
		 count++;
		 
		 N++;
	 }
	 
	 
	 
	 
	 public int get(Key key)
//------------------------------------------------------------------
// Summary: the method returns the key-index to the hash table
// Precondition: it takes the key as parameter
// Postcondition: the method first searches for the given key, in 
//                case the key as found its index / hash value is 
//                returned. Otherwise, "-1" is returned.
//------------------------------------------------------------------
		
	 {
		 for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
		 {
			 if (keys[i].equals(key))
				 return i;
		 }
		 
		 return -1;
	 } 
	 

	 
	 public Key return_order(int i)
//-------------------------------------------------------
// Summary: returns the order of the key
// Precondition: a getter method
// Postcondition: gets the key from the "order" array based
//                on its order of insertion "i".
//-------------------------------------------------------
		
	 {
		 return order[i];
	 }
	 
	 
	 
	 
	 public Key return_key(int i)
//-------------------------------------------------------
// Summary: returns the key in a specific index
// Precondition: a getter method
// Postcondition: gets the key from the "keys" array based
//	              their index / hash value.
//-------------------------------------------------------
		
	 {
		return keys[i];
	 }
}
