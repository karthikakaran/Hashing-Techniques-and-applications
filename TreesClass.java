//===========================================================================================================================
//	Program : Add, Remove, Contains using Trees
//===========================================================================================================================
//	@author: Karthika, Nevhetha, Kritka
// 	Date created: 2016/11/15
//===========================================================================================================================
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class TreesClass<T extends Comparable<? super T>> {
	private TreeSet<T> treeSet = new TreeSet<>();
	
	/** Procedures to perform contains
	 * Runs in time O(logn) 
	 * @param x : T to check contains
	 * @param true/false : boolean contains or not
	 */
	boolean contains(T x) {
		return treeSet.contains(x);
	}
	 
	/** Procedures to perform add
	 * Runs in time O(logn) 
	 * @param x : T to add
	 * @param true/false : boolean added or replaced
	 */
	boolean add(T x) {
		return treeSet.add(x);
	}
	
	/** Procedures to perform remove
	 * Runs in time O(logn) 
	 * @param x : T to remove
	 * @param x : T this is removed
	 */
	T remove(T x) {
		if(treeSet.remove(x)) {
			return x;
		} else 
			return null;
	}
	

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc;
		if (args.length > 0) {
			File file = new File(args[0]);
			sc = new Scanner(file);
		} else {
			sc = new Scanner(System.in);
		}
		String operation = "";
		long operand = 0;
		int modValue = 999983;
		long result = 0;
		ListClass<Long> treeClass = new ListClass<>();
		// Initialize the timer
		Timer timer = new Timer();
		while (!((operation = sc.next()).equals("End"))) {
			switch (operation) {
				case "Add": {
					operand = sc.nextLong();
					if (treeClass.add(operand)) {
						result = (result + 1) % modValue;
					}
					break;
				}
				case "Remove": {
					operand = sc.nextLong();
					if (treeClass.remove(operand) != null) {
						result = (result + 1) % modValue;
					}
					break;
				}
				case "Contains": {
					operand = sc.nextLong();
					if (treeClass.contains(operand)) {
						result = (result + 1) % modValue;
					}
					break;
				}
			}
		}

		// End Time
		timer.end();

		System.out.println(result);
		System.out.println(timer);
		sc.close();
	}
}
