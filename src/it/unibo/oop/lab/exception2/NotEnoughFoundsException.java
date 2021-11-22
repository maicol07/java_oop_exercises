package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends IllegalStateException {

	public NotEnoughFoundsException() {
	}

	@Override
	public String toString() {
		return "NotEnoughFoundsException [There is not enough money to complete the operation]";
	}
}
