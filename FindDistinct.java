//===========================================================================================================================
//	Program : To find distinct elements in a given array and return no of distinct elements
//===========================================================================================================================
//	@author: Karthika, Nevhetha, Kritka
// 	Date created: 2016/11/15
//===========================================================================================================================
import java.util.*;
import java.util.Scanner;
import java.util.HashSet;

public class FindDistinct<T> {
	/** Procedure to find distinct elements in a given array and return no of distinct elements
	 * @param arr : T[] : array of elements
	 * @param k : int : no of distinct elements
	 */
	public static<T> int findDistinct(T[] arr) {
		//store the elements in the hash set that does not allow duplicates
		HashSet<T> hashSet = new HashSet<>();
		int k = 0, i = 0;
		for(T item : arr) {
			hashSet.add(item);
		}
		//k is the size of set
		k = hashSet.size();
		//push the distinct elements to 0 to k-1 positions in the array and set remaining positions as null
		for(T item :hashSet) {
			arr[i++] = item;
		}
		while(i < arr.length) {
			arr[i++] = null;
		}
		
		return k;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter n :: ");
		int n = in.nextInt();
		System.out.println("Enter n numbers:: ");
		Integer arr[] = new Integer[n];		
		for (int i = 0 ; i < n; i++)
		    arr[i] = in.nextInt();
		System.out.println("K distinct elements:: " + findDistinct(arr));
	}

}

