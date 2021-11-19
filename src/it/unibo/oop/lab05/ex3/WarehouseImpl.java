package it.unibo.oop.lab05.ex3;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class WarehouseImpl implements Warehouse {
	Set<Product> products = new LinkedHashSet<Product>();

	public WarehouseImpl() {
	}

	@Override
	public void addProduct(Product p) {
		products.add(p);
	}

	@Override
	public Set<String> allNames() {
		Set<String> names = new LinkedHashSet<String>();
		for (Product product : this.products) {
			names.add(product.getName());
		}
		return names;
	}

	@Override
	public Set<Product> allProducts() {
		Set<Product> products = new LinkedHashSet<Product>();
		for (Product product : this.products) {
			products.add(product);
		}
		return products;
	}

	@Override
	public boolean containsProduct(Product p) {
		return this.products.contains(p);
	}

	@Override
	public double getQuantity(String name) {
		for (Product product : this.products) {
			if (product.getName() == name) {
				return product.getQuantity();
			}
		}
		return 0;
	}

}
