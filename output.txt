CS 5V81.012 : Implementation of Data Structures and Algorithms
Optional Project 7 - Group 3

**************************************************************************************************************************************************************
Note: Timer.java needs to be compiled because most of the programs use it
so compile :  javac Timer.java
   run :      java Timer.java

***************************************************************************************************************************************************************
1. Find Distinct

compile : javac FindDistinct.java 
run : java FindDistinct 

Input:  Enter n :: 
	5
	Enter n numbers:: 
	1 3 2 4 3

Output: K distinct elements:: 4

******************************************************************************************************************************************************************
2. Most Frequent

compile : javac MostFrequent.java
run : java MostFrequent

Input : Enter k :: 
	6
	Enter k numbers:: 
	1 2 2 3 3 4  

Output : Most frequent :: 2

******************************************************************************************************************************************************************
3. Seperate Chaining and Two choice hashing - (Open Hashing)

compile : javac SeperateChaining.java 
run : java SeperateChaining

input : Random 100000 numbers of range 100000

output :

Max length of the list ::1045
Number of empty lists ::0

-----------------------------------------------------------------
compile : javac TwoChoiceHashing.java 
run : java TwoChoiceHashing

input : Random 100000 numbers of range 100000

output :

Max length of the list ::160
Number of empty lists ::14

******************************************************************************************************************************************************************

4. Closed Hashing techniques comparison with JAVA hashing

compile : javac DoubleHashing.java, javac Hashing.java, javac HopScotchHashing.java
run :  java DoubleHashing, java Hashing, java HopScotchHashing

input : Random 100000 numbers of range 100000

output :

DoubleHashing:
Time: 478 msec.
Memory: 52 MB / 150 MB.
---------------------------------------
HopScotchHashing:
Time: 500 msec.
Memory: 53 MB / 150 MB.
---------------------------------------
Hashing:
Time: 715 msec.
Memory: 53 MB / 204 MB.

******************************************************************************************************************************************************************

5. Compare Trees, List, SkipLists, Hashing

compile : javac ListClass.java
run : java ListClass [a1.txt]

output :
42
Time: 6 msec.
Memory: 1 MB / 119 MB.
---------------------------------------
compile : javac TreesClass.java
run : java TreesClass [a1.txt]

output :
42
Time: 6 msec.
Memory: 1 MB / 119 MB.
---------------------------------------
compile : javac SkipListDriver.java 
run : java SkipListDriver [a1.txt] 

output:
36
Time: 8 msec.
Memory: 1 MB / 119 MB.
---------------------------------------
compile : javac HashClass.java
run : java HashClass [a1.txt]

output :
36
Time: 9 msec.
Memory: 1 MB / 119 MB.


