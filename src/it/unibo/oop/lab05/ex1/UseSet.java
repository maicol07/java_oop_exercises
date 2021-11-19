package it.unibo.oop.lab05.ex1;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Example class using {@link Set}.
 * 
 */
public final class UseSet {

    private UseSet() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        /*
         * Considering the content of "UseCollection, write a program which, in
         * order:
         * 
         * 1) Builds a TreeSet containing Strings
         * 
         * 2) Populates such Collection with all the Strings ranging from "1" to
         * "20"
         * 
         * 3) Prints its content
         * 
         * 4) Removes all those strings whose represented number is divisible by
         * three
         * 
         * 5) Prints the content of the Set using a for-each costruct
         * 
         * 6) Verifies if all the numbers left in the set are even
         */
    	
    	Set<String> treeSet = new TreeSet<String>();
    	for (int i = 1; i < 21; i++) {
    		treeSet.add(Integer.toString(i));
    	}
    	System.out.println(treeSet);
    	
    	Set<String> treeSet2 = new TreeSet<String>();
    	for (String element: treeSet) {
			if (Integer.parseInt(element) % 3 == 0) {
				treeSet2.add(element);
			}
		}
    	treeSet.removeAll(treeSet2);
    	
    	for (String string : treeSet) {
			System.out.print(string + " ");
		}
    	System.out.println();
    	
    	var even = true;
    	for (String string : treeSet) {
			if (Integer.parseInt(string) % 2 != 0) {
				even = false;
			}
		}
    	System.out.println("The left items are " + (even ? "all even" : "not even"));
    }
}
