package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalStateException {

	public WrongAccountHolderException() {
	}

	@Override
	public String toString() {
		return "WrongAccountHolderException [The operation has been executed from an unauthorized account]";
	}
	
	@Override
    public String getMessage() {
        return this.toString();
    }
}
