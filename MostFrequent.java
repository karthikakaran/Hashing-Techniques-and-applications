//===========================================================================================================================
//	Program : To find the most frequent element in a given array
//===========================================================================================================================
//	@author: Karthika, Nevhetha, Kritka
// 	Date created: 2016/11/15
//===========================================================================================================================
import java.util.Scanner;
import java.util.HashMap;

public class MostFrequent<T> {
	/** Procedure to find the most frequent element in a given array
	 * @param arr : T[] : array of elements
	 * @param mostFreqItem : T : element that is most frequent
	 */
	public static<T> T mostFrequent(T[] arr) {
		T mostFreqItem = null;
		//store in hashmap the count as value and the element as key 
		HashMap<T, Integer> hMap = new HashMap<>();
		for(T item : arr) {
			Integer count = hMap.get(item);
			if(count == null)
				hMap.put(item, 1);
			else
				hMap.put(item, count + 1);
		}
		int count = 0, mostFreqCount = 0;
		//get the element with max count value 
		for (T item : arr) {
			count = hMap.get(item);
			if (count > mostFreqCount) {
				mostFreqCount = count;
				mostFreqItem = item;
			}
		}
		//if no elements in array return null else the max count element
		return mostFreqItem; 
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter k :: ");
		int k = in.nextInt();
		System.out.println("Enter k numbers:: ");
		Integer arr[] = new Integer[k];		
		for (int i = 0 ; i < k; i++)
		    arr[i] = in.nextInt();
		System.out.println("Most frequent :: " + mostFrequent(arr));
	}

}
