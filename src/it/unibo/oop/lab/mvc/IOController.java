package it.unibo.oop.lab.mvc;

import java.util.ArrayList;
import java.util.List;

public class IOController implements Controller {

    private final List<String> history = new ArrayList<>();
    private int current = 0;

    public IOController() {
    }

    @Override
    public void setNextString(final String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        this.history.add(string);
    }

    @Override
    public String getNextString() {
        return this.history.get(this.current + 1);
    }

    @Override
    public List<String> getStringsHistory() {
        return this.history.subList(0, this.current);
    }

    @Override
    public void printCurrentString() {
        final var string = this.history.get(this.current);
        if (string == null) {
            throw new IllegalStateException();
        }

        System.out.println(string);
        this.current++;
    }

}
