package generics.examples;

import java.util.ArrayList;
import java.util.List;

class MixedLegacyAndGenerics {
	 public static void main(String[] args) {
	 List<Integer> myList = new ArrayList<Integer>();
	 myList.add(4);
	 myList.add(6);
	 Inserter in = new Inserter();
	 in.insert(myList); // pass List<Integer> to legacy code
	 }
	}
	class Inserter {
	 // method with a non-generic List argument
	 void insert(List list) {
	 list.add(new Integer(42)); // adds to the incoming list
	 }
	 
	 //what happens now ?
//	 void insert2(List list) {
//		 list.add(new String("42")); // put a String in the list
//		 // passed in
//		}
	 
	 
	}
