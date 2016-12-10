//===========================================================================================================================
//	Program : To perform Double Hashing
//===========================================================================================================================
//	@author: Karthika, Nevhetha, Kritka
// 	Date created: 2016/11/15
//===========================================================================================================================
import java.util.Set;
import java.util.*;

public class DoubleHashing<T> {
    static int initialSize = 1000;
    class HashEntry<E> {
	E element;
	boolean occupied;
	HashEntry(E x) {
	    element = x;
	    occupied = true;
	}
	@Override
	public int hashCode(){
		return element.hashCode();
		
	}
    }

    HashEntry<T>[] table;
    int size, maxSize;
    Set<T> overflow;
    int k=3;
    DoubleHashing() {
	table = new HashEntry[initialSize];
	size = 0;  maxSize = initialSize;
	overflow = new HashSet<>();
    }

    DoubleHashing(int n) {
	table = new HashEntry[n];
	size = 0;  maxSize = n;
	overflow = new HashSet<>();
    }

    int find(T x) {
	// find x in hash table and return index of the element if found,
	// otherwise return the index where it stopped
    	for(int i=0;i<k;i++){
    		int s=probe(i,x);
    		if(table[s] !=null && table[s].occupied && table[s].element.equals(x)){
    			return s;
    		}
    	}
    	//if the element is present in the overflow table
    	if(overflow.contains(x)){
    		T[] over=(T[]) overflow.toArray();
    		for(int i=0;i<over.length;i++){
    			if(x.equals(over[i]))
    				return i;
    		}
    	}
	return 0;
    }

    public boolean add(T x) {
    	//if any of the k spaces are free
    for(int i=0;i<k;i++){
    	if(table[probe(i,x)]!=null && table[probe(i,x)].occupied && table[probe(i,x)].element.equals(x)){
    		return false;
    	}
    	else if(table[probe(i,x)]== null || !table[probe(i,x)].occupied) {
    		table[probe(i,x)]=new HashEntry(x);
    		size++;
    		return true;
    	}
    }
    //if the k spots are all occupied
    for(int i=0;i<k;i++){
    	int s=probe(i,x);
    	T value=table[s].element;
    	int s0=probe(0,value);
    	for(int j=0;j<k;j++){
    		if(table[probe(j,value)]==null || table[probe(j,value)].occupied==false){
    			table[probe(j,value)]=new HashEntry(value);
    			table[i]=new HashEntry(x);
    			size++;
    		}
    	}
    }
    overflow.add(x);
    size++;
	return true;
    }

    private T retrieve(int probe) {
		if(table[probe]!=null && table[probe].occupied)
			return table[probe].element;
		return null;
	}

	private int probe(int i, T x) {
		int s0=x.hashCode()%maxSize;
		int s=( s0+i ) % maxSize;
		return s;
	}

	public T get(T x) {
		if(contains(x)){
			if(table[find(x)]!=null && table[find(x)].element.equals(x)){
				return table[find(x)].element;
			}
		}
		Iterator<T> it=overflow.iterator();
		while(it.hasNext()){
			if(it.next().equals(x))
				return x;
		}
	return null;
    }

    public T remove(T x) {
	// If x exists, remove it from the hash table and return it.
	// Otherwise return null;
    	if(contains(x)){
    		for(int i=0;i<k;i++){
        		int s=probe(i,x);
    			if(table[s] != null && table[s].occupied && table[s].element.equals(x)){
    				table[s]=null;
    				size--;
    				return x;
    			}
    		}
    		if(overflow.contains(x)){
    			overflow.remove(x);
    			size--;
    			return x;
    		}
    	}
	return null;
    }

    public boolean contains(T x) {
    	for(int i=0;i<k;i++){
    		int s=probe(i,x);
    		if(table[s] != null && table[s].occupied && table[s].element.equals(x)){
    			return true;
    		}
    	}
    	//if the element is present in overflow set
    	if(overflow.contains(x))
    		return true;
    	return false;
    }

    void resize() {
    	if(overflow.size()>=Math.log(maxSize)){
			int n1=size;
			int n2=overflow.size();
			DoubleHashing<T> n=new DoubleHashing((n1+n2)*4);
		//copy elements from original table
			for(int i=0;i<size;i++){
				if(retrieve(i)!=null){
					n.add(retrieve(i));
				}
			}
		//copy elements from overflow set
			Iterator it=overflow.iterator();
			while(it.hasNext()){
				n.add((T) it.next());
			}
			table=n.table;
			size=n.size;
			maxSize=n.maxSize;
			overflow=new HashSet<T>();
		}	
    }
	public static void main(String[] args){
		DoubleHashing<Integer> t=new DoubleHashing<>();
		Integer arr[] = new Integer[1000000];
		Random rand = new Random();
		Timer timer = new Timer();
		for (int i = 0; i < 1000000; i++) {
			//arr[i] = rand.nextInt(10*1000000);
			t.add(rand.nextInt(10*1000000));
		}
		System.out.println(timer.end());
	}
}
