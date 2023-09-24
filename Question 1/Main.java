package Assignment2_Q1;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		//-----------------------------------------------------------------
		// Title: Question 1
		// Author: Basme Zantout
		// ID: 99227947762
		// Section: 1
		// Assignment: 2
		// Description: This is the main class for Question 1 which calls 
		//              the methods that perform the needed operations, 
	    //              which are intended to find the whether a given 
		//              directed graph can be converted to  tree structure 
	    //              or not.
		//-----------------------------------------------------------------
		

		
//-------------------------------------------------------
// Creating a Scanner object named "scanner"   
//-------------------------------------------------------
	
		Scanner scan = new Scanner(System.in);
		
		
//-------------------------------------------------------
// Getting the number of vertices in the graph in which:
// (Number of vertices = Number of taxi pickups)
//-------------------------------------------------------
	
		System.out.println("Enter the number of taxi pickups:");
		int Vertices = scan.nextInt();
		
		
//-------------------------------------------------------
// Getting the number of edges in the graph in which:
// (Number of vertices = Number of taxi rides)
//-------------------------------------------------------
	
		System.out.println("Enter the number of taxi rides:");
		int Edges = scan.nextInt();
		
		
		
//-------------------------------------------------------
// Creating a Digraph with the given number of vertices 
// and edges
// Note: Check the "Digraph" class for implementation
//       details 
//-------------------------------------------------------
	
		Digraph Graph = new Digraph(Vertices, Edges);
		

		
//-------------------------------------------------------
// Creating a Symbol or Hash table with the given number 
// of vertices to store the names of the cities and 
// calculate their vertex-indices 
// Note: Check the "LinearProbingHashST" class for
//       implementation details 
//-------------------------------------------------------
	
		LinearProbingHashST <String> SymbolTable = new LinearProbingHashST <String>(Vertices);
		
		
		
//-------------------------------------------------------
// We ask the user to enter the taxi rides and for each
// input String we add the city (String) to the the hash
// hash table find its vertex number by calculating its
// hash function. We then add the cities to the graph
// based on their hash value.
//-------------------------------------------------------
			
		System.out.println("Enter the taxi rides:");
		
		
		for (int i = 1 ; i <= Edges ; i++ )
		{
			String Mahalle_1 = scan.next();
			SymbolTable.put(Mahalle_1);
			
			String Mahalle_2 = scan.next();
			SymbolTable.put(Mahalle_2);
			
			Graph.addEdge(SymbolTable.get(Mahalle_1), SymbolTable.get(Mahalle_2));
			
		}
		
	
		
//-------------------------------------------------------
// This methods takes the Hash/Symbol table and the 
// created Directed Graph as parameters and prints out 
// the cities and their connections.
// Note: Check the static "Print_Connections" method in
//       the "CheckTreeStructure" class for details
//-------------------------------------------------------
	
		CheckTreeStructure.Print_Connections(SymbolTable, Graph);
		
		
		
		
//-------------------------------------------------------
// In that part, we check the three conditions:
//
// 1- Is the number of edges less than the number of 
//    vertices by 1?
//
// 2- Is the Graph Acyclic?
//		
// 3- Is the Graph Connected?
//
// The three methods return a true or false boolean if the 
// condition is satisfied or not respectively
//
// Note: Check the three static methods in the
//       "CheckTreeStructure" class for details
//-------------------------------------------------------
			
	
		if (CheckTreeStructure.Check_Edges_Vertices(Graph) &&
			CheckTreeStructure.Check_Cycle(Graph) &&
			CheckTreeStructure.Check_Connected(Graph))
		{
			System.out.println("This ride network can be kept in a tree structure.");
		}
		
		else 
		{
			System.out.println("This ride network cannot be kept in a tree structure.");
		}
		
		
		
		
//-------------------------------------------------------
// closing the scanner
//-------------------------------------------------------
			
		scan.close();
		
	}

}
