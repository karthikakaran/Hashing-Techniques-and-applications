//===========================================================================================================================
//	Program : SkipList Interface, code provided by Dr.Balaji
//===========================================================================================================================
//	@author: Karthika, Nevhetha, Kritka
// 	Date created: 2016/11/15
//===========================================================================================================================
/** See  http://en.wikipedia.org/wiki/Skip_list
 */

import java.lang.Comparable;
import java.util.Iterator;

public interface SkipList<T extends Comparable<? super T>> {

    boolean add(T x);  // Add an element x to the list.
		       // Returns true if x is new, false otherwise.

    boolean contains(T x);  // Is x in the list?

    boolean isEmpty();  // Is the list empty?

    T remove(T x);  // Remove x from this list; returns false if x is not in list

    int size();  // Number of elements in the list
}
