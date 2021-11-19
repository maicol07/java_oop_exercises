package it.unibo.oop.lab05.ex4;

import it.unibo.oop.lab05.ex3.ProductImpl;

public class ComparableProduct extends ProductImpl implements Comparable<ComparableProduct> {

	public ComparableProduct(String name, int quantity) {
		super(name, quantity);
	}

	public ComparableProduct(String name) {
		super(name);
	}
	
	public int compareTo(String o1, String o2) {
		var n1 = Double.parseDouble(o1);
		var n2 = Double.parseDouble(o2);
		return Double.compare(n1, n2);
	}

	@Override
	public int compareTo(ComparableProduct o) {
		return this.getName().compareTo(o.getName());
	}
}
