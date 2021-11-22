package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {
	private final int x;
    private final int y;

    /**
     * Construct new instance of the exception.
     * 
     * @param initX
     *            position on X that caused the exception
     * @param initY
     *            position on Y that caused the exception
     */
    public NotEnoughBatteryException(final int initX, final int initY) {
        super();
        this.x = initX;
        this.y = initY;
    }

	/**
     * 
     * @return the string representation of instances of this class
     */
    @Override
    public String toString() {
        return "Can not move to position(" + x + "," + y + "). Not enough battery.";
    }

    @Override
    public String getMessage() {
        return this.toString();
    }
}
