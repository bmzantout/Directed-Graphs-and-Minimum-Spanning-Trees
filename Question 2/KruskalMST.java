import Queue;

public class KruskalMST {
	
	//-----------------------------------------------------------------
	// Title: Question 2
	// Description: This is a standard Kruskal Minimum Spanning Tree
	//              algorithm taken from the "Algorithms, 4th edition
	//              by Robert Sedgewick and Kevin Wayne" book for reference
	//-----------------------------------------------------------------
	
	
	 private Queue<Edge> mst = new Queue<Edge>();
	 
	 
	 public KruskalMST(Graph G)
	 {
		 MinPQ pq = new MinPQ(G.edges(), G);
		 UF uf = new UF(G.V());
		 
		 while (!pq.isEmpty() && mst.size() < G.V()-1)
		 {
			 Edge e = pq.delMin();
			 int v = e.either().getCount(), w = e.other(e.either().getIndex()).getCount();

			 if (!uf.connected(v, w))
			 {
				 uf.union(v, w);
				 mst.enqueue(e);
			 }
		 } 
	 }
	 
	 
	 
	
	public Iterable<Edge> edges()
	 { 
		 return (Iterable<Edge>) mst;
	 } 


}
