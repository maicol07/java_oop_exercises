package it.unibo.oop.lab.collections1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
        /*
         * 8) Compute the population of the world
         */
    	var list = new ArrayList<Integer>();
    	for (int i = 1000; i < 2000; i++) {
			list.add(i);
		}
    	
    	var linked = new LinkedList<Integer>();
    	linked.addAll(list);
    	
    	final int tmp = list.get(0);
    	list.set(0, list.get(list.size() - 1));
    	list.set(list.size() - 1, tmp);
    	
    	for (Integer n : list) {
			System.out.println(n);
		}
    	
    	long time = System.nanoTime();
    	for (int i = 0; i < 100000; i++) {
    		list.add(0, i);
    	}
    	
    	time = System.nanoTime() - time;
    	System.out.println("Elapsed time: " + time / 1_000_000 + "ms");
    	
    	var map = new TreeMap<String, Long>();
    	map.put("Africa", 1_110_635_000L);
    	map.put("Americas", 972_005_000L);
    	map.put("Antarctica", 0L);
    	map.put("Asia", 4_298_723_000L);
    	map.put("Europe", 742_452_000L);
    	map.put("Oceania", 38_304_000L);
    	
    	var total = 0L;
    	for (Map.Entry<String, Long> entry : map.entrySet()) {
			total += entry.getValue();
		}
    	
    	System.out.println("Total population: " + total);
    }
}
