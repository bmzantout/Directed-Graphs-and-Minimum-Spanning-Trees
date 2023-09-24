package Assignment2_Q2;

public class IndexMinPQ<Key extends Comparable<Key>> {
	
	//-----------------------------------------------------------------
	// Title: Question 2
	// Author: Basme Zantout
	// ID: 99227947762
	// Section: 1
	// Assignment: 2
	// Description: This is a standard Index Minimum Priority Queue 
    //              data structure taken from the "Algorithms, 4th edition
    //              by Robert Sedgewick and Kevin Wayne" book for reference
	//-----------------------------------------------------------------
	
	
	private int[] pq;
	
    private int[] qp;
     
    private Key[] keys;
    
    private int n;

    
    
    @SuppressWarnings("unchecked")
    public IndexMinPQ(int maxN) {
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++) {
            qp[i] = -1;
        }
    }

    
    
    public boolean isEmpty()
    {
        return n == 0;
    }

    
    
    public boolean contains(int i) 
    {
        return qp[i] != -1;
    }
    
    

    public void insert(int i, Key key) 
    {
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;
        swim(n);
    }

    
    
    public int delMin() 
    {
        int min = pq[1];
        exch(1, n--);
        sink(1);
        qp[min] = -1;
        keys[min] = null;
        pq[n + 1] = -1;
        return min;
    }
    
    

    public void decreaseKey(int i, Key key)
    {
        keys[i] = key;
        swim(qp[i]);
    }

    
    
    private boolean greater(int i, int j) 
    {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }
    
    

    private void exch(int i, int j) 
    {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    
    
    private void swim(int k) 
    {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    
    
    private void sink(int k)
    {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }
    
}

