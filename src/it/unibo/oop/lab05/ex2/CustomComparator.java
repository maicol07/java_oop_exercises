package it.unibo.oop.lab05.ex2;

public class CustomComparator implements java.util.Comparator<String> {

	public CustomComparator() {
	}
	
	@Override
	public int compare(String o1, String o2) {
		var n1 = Double.parseDouble(o1);
		var n2 = Double.parseDouble(o2);
		return Double.compare(n1, n2);
	}

}
