//===========================================================================================================================
//	Program : To perform Seperate Chaining
//===========================================================================================================================
//	@author: Karthika, Nevhetha, Kritka
// 	Date created: 2016/11/15
//===========================================================================================================================
import java.util.*;

public class SeperateChaining<T> {
	
	private List<T>[] hashArray;
	private int size = 0;
	private int maxSize = 1000;
	
	public SeperateChaining(T[] arr) {
		hashArray = new List[maxSize];
		for (int i = 0; i < maxSize; i++)
			hashArray[i] = new LinkedList<T>();
		for(int i = 0; i < arr.length; i++) {
			add(arr[i]);
		}
	}
	
	public void add (T x) {
		int i = hashCode(x) % maxSize;
		//System.out.println(i + " " + hashCode(x));
		if(!hashArray[i].contains(x)) {
			hashArray[i].add(x);
			size++;
		}
	}
	
	public boolean contains (T x) {
		int i = hashCode(x) % maxSize;
		return hashArray[i].contains(x);
	}
	
	public T remove (T x) {
		int i = hashCode(x) % maxSize;
		if(hashArray[i].contains(x)) {
			hashArray[i].remove(x);
			size--;
			return x;
		} else
			return null;
	}
	
	public int hashCode(T key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
	
	public int maxListSize() {
		int maxLength = 0;
		for (int i = 0; i < hashArray.length; i++) {
			if (maxLength < hashArray[i].size())
				maxLength = hashArray[i].size();
		}
		return maxLength;
	}
	
	public int noOfEmptyLists() {
		int noOfEmptyList = 0;
		for (int i = 0; i < hashArray.length; i++) {
			if (hashArray[i].size() == 0)
				noOfEmptyList++;
		}
		return noOfEmptyList;
	}
	
	public static void main(String[] args) {
		Integer arr[] = new Integer[1000000];
		Random rand = new Random();
		for (int i = 0; i < 1000000; i++) {
			arr[i] = rand.nextInt(10*1000000);
		}
		SeperateChaining<Integer> sep = new SeperateChaining<>(arr);
		System.out.println("Max length of the list ::" + sep.maxListSize());
		System.out.println("Number of empty lists ::" + sep.noOfEmptyLists());
	}
}
