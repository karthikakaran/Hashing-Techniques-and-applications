//===========================================================================================================================
//	Program : SkipList Implementation
//===========================================================================================================================
//	@author: Karthika, Nevhetha, Kritka
// 	Date created: 2016/11/15
//===========================================================================================================================
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Random;
// Skeleton for skip list implementation.

public class SkipListImpl<T extends Comparable<? super T>> implements SkipList<T> {
	/** Class Entry holds a single node of the list */
	public class Entry<T> {
		public T element;
		public int level;
		public Entry<T>[] next;
		public Integer[] width;
		
		Entry(T x, int level) {
			this.element = x;
			this.level = level + 1;
			next = (Entry[])Array.newInstance(Entry.class, this.level);
			width = new Integer[this.level];
		}
	}
	
	// Dummy header is used.  tail stores reference of tail element of list
	public Entry<T> head, tail;
	private int size;
	private T last;
	static private int MAXLEVEL = 10;
	public SkipListImpl() {
		head = new Entry<>(null, MAXLEVEL);
		tail = new Entry<>(null, MAXLEVEL);
		size = 0;
		last = null;
		for (int i = 0; i < head.level; i++) {
			head.next[i] = tail;
			head.width[i] = 1;
		}
		/* for (int i = 0; i < head.level; i++) { head.width[i] = 1; }*/
	}
	
	/** Procedures to random choice level
	 * Runs in time O(maxlevel) 
	 * @param x : maxlevel
	 * @return maxlevel : int, new max level at random
	 */
	int levelChoice (int maxLevel) {
		int l = 0;
		Random rand = new Random();
		//P (choosing level of i) = 1/2 P (Choosing level of i - 1)
		while (l < maxLevel) {
			if (rand.nextBoolean())
				break;
			else
				l++;
		}
		return l;
	}
	
	/** Procedures to perform find previous or that element
	 * Runs in time O(logn) 
	 * @param x : element to find
	 * @return prev : Entry[] of previous or that element
	 */ 
	Entry<T>[] find (T x) {
		Entry<T> p = head;
		Entry<T>[] prev = (Entry[])Array.newInstance(Entry.class, head.level);
		for (int i = 0; i < head.level; i++) {
			prev[i] = head;
		}
		if (isEmpty()) return prev;
		for (int i = p.level - 1; i >= 0; i--) {
			while (p.next[i] != tail && p.next[i].element.compareTo(x) < 0) {
				p = p.next[i];
			}
			prev[i] = p;
		}
		return prev;
	}

	 /** Procedures to perform add
		 * Runs in time O(logn) 
		 * @param x : T to add
		 * @return true/false : boolean added or replaced
		 */
    @Override
    public boolean add(T x) {
    	int maxLevel = 0;
    	Entry<T>[] prev = find (x);
    	if (prev[0].next[0] != tail && prev[0].next[0].element.compareTo(x) == 0) {
    		prev[0].next[0].element = x;
    		return false;
    	} else {
    		maxLevel = levelChoice(MAXLEVEL);
    		Entry<T> newNode = new Entry<T>(x, maxLevel);
    		
    		for (int i = 0 ;i < newNode.level; i++) {
    			newNode.next[i] = prev[i].next[i];
    			prev[i].next[i] = newNode;
    		}
    		if (newNode.next[0] == tail)
    			last = newNode.element;
    		//Updating the width of stooping down levels
    		updateLevel(newNode, prev, newNode.level);
    	}
    	this.size++;
    	return true;
    }
    
    /** Procedures to perform update of weights after add
   	 * @param newNode : Entry<T> : new node added
   	 * @param prev : Entry[] : prev pointers
   	 * @param newLevel : int : length of prev
   	 */  
    private void updateLevel(Entry<T> newNode, Entry<T>[] prev, int newLevel) {
    	for (int i = 0; i <= MAXLEVEL; i++) {
    		//Nodes passing above the new node level
    		if (i > newLevel - 1) {
    			prev[i].width[i] = prev[i].width[i] + 1; 
    		} else {
    			//Nodes passing through the new node level
    				if (i == 0) {
    					newNode.width[i] = prev[i].width[i];
    					prev[i].width[i] = 1;
    				}
    			   else {
    				   int prevWidth = prev[i].width[i];
    				   if (prev[i].element == prev[i - 1].element) {
    				    	prev[i].width[i] = prev[i - 1].width[i - 1];
    				    	newNode.width[i] = prevWidth - prev[i].width[i] + 1;
    				   } else {
    					   Entry<T> down = prev[i].next[0];
    					   int gap = 1;
    					   while (down != newNode) {
    						   down = down.next[0];
    						   gap++;
    					   }
    					   prev[i].width[i] = gap;
    					   newNode.width[i] = prevWidth - prev[i].width[i] + 1;
    				   }
	    		  }
    			}
    	}
	}

    /** Procedures to perform update of weights after remove
   	 * @param newNode : Entry<T> : new node added
   	 * @param prev : Entry[] : prev pointers
   	 * @param newLevel : int : length of prev
   	 */  
    private void updateLevelRemove(Entry<T> newNode, Entry<T>[] prev, int newLevel) {
    	for (int i = 0; i <= MAXLEVEL; i++) {
    		//Nodes passing above the new node level
    		if (i > newLevel - 1) {
    			prev[i].width[i] = prev[i].width[i] - 1; 
    		} else {
    			//Nodes passing through the new node level
    			prev[i].width[i] = 	prev[i].width[i] + newNode.width[i] - 1;
    		}
    	}
	}
    
    /** Procedures to perform remove
	 * Runs in time O(logn) 
	 * @param x : T to remove
	 * @return x : T this is removed
	 */
	@Override
    public T remove(T x) {
    	if (isEmpty()) return null;
    	Entry<T>[] prev = find (x);
    	Entry<T> curr = prev[0].next[0];
    	if (curr != tail && curr.element.compareTo(x) == 0) {
    		updateLevelRemove(curr, prev, curr.level);
    		for (int i = 0; i < head.level; i++) {
    			
    			if (prev[i].next[i] == curr)
    				prev[i].next[i] = curr.next[i];
    			else {
    				break;
    			}
    		}
    		if (curr.next[0] == tail)
    			last = prev[0].element;
    		size--;
    		return curr.element;
    	} else
    		return null;
    }
    
    /** Procedures to perform contains
	 * Runs in time O(logn) 
	 * @param x : T to check contains
	 * @return true/false : boolean contains or not
	 */
    @Override
    public boolean contains(T x) {
    	if (isEmpty()) return false;
    	Entry<T>[] prev = find(x);
    	if (prev[0].next[0] != tail && prev[0].next[0].element.compareTo(x) == 0) {
    		 return true;
    	}
    	return false;
    }

    /** Procedures to check isEmpty
	 * Runs in time O(1) 
	 * @return true/false : boolean to return isEmpty or not
	 */
    @Override
    public boolean isEmpty() {
    	if (head.next[0] == tail) return true;
    	else return false;
    }

    @Override
    public int size() {
    	return this.size;
    }
}
