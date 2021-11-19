package it.unibo.oop.lab05.ex5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 */
public final class Utilities {

    private Utilities() { }

    /**
     * @param setA
     *            a set
     * @param setB
     *            another set
     * @param <X>
     *            Returned collection type
     * @return a new set that is the union of the input sets.
     */
    public static <X> Set<X> setUnion(final Set<? extends X> setA, final Set<? extends X> setB) {
        Set<X> newSet = new TreeSet<X>(setA);
        newSet.addAll(setB);
        return newSet;
    }

    /**
     * @param setA
     *            a set
     * @param setB
     *            another set
     * @param <X>
     *            Returned collection type
     * @return a new set that is the intersection of the input sets.
     */
    public static <X> Set<X> setIntersection(final Set<? extends X> setA, final Set<? extends X> setB) {
    	Set<X> newSet = new TreeSet<X>();
        for (X element : setA) {
			if (setB.contains(element)) {
				newSet.add(element);
			}
		}
        return newSet;
    }

    /**
     * @param setA
     *            a set
     * @param setB
     *            another set
     * @param <X>
     *            Returned collection type
     * @return a new set that is the symmetric difference of the input sets.
     */
    public static <X> Set<X> setSymmetricDifference(final Set<? extends X> setA, final Set<? extends X> setB) {
    	Set<X> newSetA = new TreeSet<X>(setA);
    	Set<X> newSetB = new TreeSet<X>(setB);
    	Set<X> intersectionSet = setIntersection(setA, setB);
    	
    	newSetA.removeAll(intersectionSet);
    	newSetB.removeAll(intersectionSet);
    	newSetA.addAll(newSetB);
    	
        return newSetA;
    }

    /**
     * @param coll
     *            the collection
     * @param <X>
     *            collection type
     * @return a random element from the collection
     *
     */
    public static <X> X getRandomElement(final Collection<X> coll) {
    	var rand = new Random();
        return (X) coll.toArray()[rand.nextInt(coll.size())];
    }

    /**
     * @param first
     *            first collection
     * @param second
     *            second collection
     * @param <X>
     *            First collection type
     * @param <Y>
     *            Second collection type
     * @return a pair with two random elements
     */
    public static <X, Y> Pair<X, Y> getRandomPair(final Collection<X> first, final Collection<Y> second) {
        return new Pair<X, Y>(getRandomElement(first), getRandomElement(second));
    }
}
