//===========================================================================================================================
//	Program : Add, Remove, Contains using SkipLists, code provided by Dr.Balaji
//===========================================================================================================================
//	@author: Karthika, Nevhetha, Kritka
// 	Date created: 2016/11/15
//===========================================================================================================================
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Driver program for skip list implementation.

public class SkipListDriver {

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
		SkipListImpl<Long> skipList = new SkipListImpl<>();
		// Initialize the timer
		Timer timer = new Timer();
		while (!((operation = sc.next()).equals("End"))) {
			switch (operation) {
				case "Add": {
					operand = sc.nextLong();
					if (skipList.add(operand)) {
						result = (result + 1) % modValue;
					}
					break;
				}
				case "Remove": {
					operand = sc.nextLong();
					if (skipList.remove(operand) != null) {
						result = (result + 1) % modValue;
					}
					break;
				}
				case "Contains": {
					operand = sc.nextLong();
					if (skipList.contains(operand)) {
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
