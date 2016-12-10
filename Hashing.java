//===========================================================================================================================
//	Program : To perform Hashing to compare with Closed hashing
//===========================================================================================================================
//	@author: Karthika, Nevhetha, Kritka
// 	Date created: 2016/11/15
//===========================================================================================================================
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class Hashing<T extends Comparable<? super T>> {
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
		Hashing<Integer> t=new Hashing<>();
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

