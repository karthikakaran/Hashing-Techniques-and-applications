//===========================================================================================================================
//	Program : To perform Two Choice Hashing
//===========================================================================================================================
//	@author: Karthika, Nevhetha, Kritka
// 	Date created: 2016/11/15
//===========================================================================================================================
import java.util.*;

public class TwoChoiceHashing<T> {
	
	private List<T>[] hashArray;
	private int size;
	private int maxSize = 900;
	
	public TwoChoiceHashing(T[] arr) {
		hashArray = new List[maxSize];
		for (int i = 0; i < maxSize; i++)
			hashArray[i] = new LinkedList<T>();
		for(int i = 0; i < arr.length; i++) {
			add(arr[i]);
		}
	}
	
	public void add(T x) {
		int h1 = hashCode1(x) % maxSize;
		int h2 = hashCode2(x) % maxSize;
		if (hashArray[h1].size() > hashArray[h2].size()) {
			if (!hashArray[h1].contains(x)) {
				hashArray[h1].add(x);
				size++;
			}
		} else {
			if(!hashArray[h2].contains(x)) {
				hashArray[h2].add(x);
				size++;
			}
		}
	}
	
	public boolean contains(T x) {
		int h1 = hashCode1(x) % maxSize;
		int h2 = hashCode2(x) % maxSize;
		return (hashArray[h1].contains(x) || hashArray[h2].contains(x));
	}
	
	public T remove (T x) {
		int h1 = hashCode1(x) % maxSize;
		int h2 = hashCode2(x) % maxSize;
		if (hashArray[h1].contains(x)) {
			hashArray[h1].remove(x);
			size--;
			return x;
		} else if (hashArray[h2].contains(x)) {
			hashArray[h2].remove(x);
			size--;
			return x;
		} else
			return null;
	}
	
	public int hashCode1(T key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
	
	public int hashCode2(T key) {
			// This function ensures that hashCodes that differ only by
			// constant multiples at each bit position have a bounded
			// number of collisions (approximately 8 at default load factor).
			int h = key.hashCode();
			h ^= (h >>> 20) ^ (h >>> 12);
			h = (h ^ (h >>> 7) ^ (h >>> 4));
			return h % hashArray.length;
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
	 	Integer arr[] = new Integer[100000];
		Random rand = new Random();
		for (int i = 0; i < 100000; i++) {
			arr[i] = rand.nextInt(100000);
		}
		TwoChoiceHashing<Integer> twoChoice = new TwoChoiceHashing<>(arr);
		System.out.println("Max length of the list ::" + twoChoice.maxListSize());
		System.out.println("Number of empty lists ::" + twoChoice.noOfEmptyLists());
	}
}
