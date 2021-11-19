package it.unibo.oop.lab05.ex3;

public class ProductImpl implements Product {
	String name;
	int quantity = 0;

	public ProductImpl(final String name, final int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	public ProductImpl(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getQuantity() {
		return this.quantity;
	}

	@Override
	public String toString() {
		return String.format("ProductImpl [name=%s, quantity=%s]", name, quantity);
	}

}
