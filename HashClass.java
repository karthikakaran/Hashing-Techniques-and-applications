//===========================================================================================================================
//	Program : Add, Remove, Contains using Hashing
//===========================================================================================================================
//	@author: Karthika, Nevhetha, Kritka
// 	Date created: 2016/11/15
//===========================================================================================================================
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class HashClass<T extends Comparable<? super T>> {
	HashSet<T> hashSet = new HashSet<>();
	
	boolean contains(T x) {
		return hashSet.contains(x);
	}
	
	boolean add(T x) {
		return hashSet.add(x);
	}
	
	T remove(T x) {
		if (hashSet.remove(x)) {
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
		HashClass<Long> hashObject = new HashClass<>();
		// Initialize the timer
		Timer timer = new Timer();
		while (!((operation = sc.next()).equals("End"))) {
			switch (operation) {
				case "Add": {
					operand = sc.nextLong();
					if (hashObject.add(operand)) {
						result = (result + 1) % modValue;
					}
					break;
				}
				case "Remove": {
					operand = sc.nextLong();
					if (hashObject.remove(operand) != null) {
						result = (result + 1) % modValue;
					}
					break;
				}
				case "Contains": {
					operand = sc.nextLong();
					if (hashObject.contains(operand)) {
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
