package it.unibo.oop.lab05.ex4;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import it.unibo.oop.lab05.ex3.Product;
import it.unibo.oop.lab05.ex3.WarehouseImpl;

public class OrderedWarehouse extends WarehouseImpl {

	public OrderedWarehouse() {
	}

	@Override
	public Set<Product> allProducts() {
		var products = super.allProducts();
		var sortedProducts = new TreeSet<Product>();
		for (Product product : products) {
			sortedProducts.add(product);
		}
		return sortedProducts;
	}
}
