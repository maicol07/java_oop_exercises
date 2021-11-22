package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends IllegalStateException {

	public TransactionsOverQuotaException() {
	}

	@Override
	public String toString() {
		return "TransactionsOverQuotaException [The transactions count has got over the maximum allowed]";
	}
}
