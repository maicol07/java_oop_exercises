package it.unibo.oop.lab.advanced;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class DrawNumberViewStdOut implements DrawNumberView {
    private static final String NEW_GAME = ": a new game starts!";

    private DrawNumberViewObserver observer;

    public DrawNumberViewStdOut() {
      // Not needed
    }

    @Override
    public void setObserver(final DrawNumberViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void start() {
        this.write("Starting the game!");
    }

    @Override
    public void numberIncorrect() {
        this.write("Incorrect Number.. try again");
    }

    @Override
    public void result(final DrawResult res) {
        switch (res) {
        case YOURS_HIGH:
        case YOURS_LOW:
            this.write(res.getDescription());
            return;
        case YOU_WON:
            this.write(res.getDescription() + NEW_GAME);
            break;
        default:
            throw new IllegalStateException("Unexpected result: " + res);
        }
        this.observer.resetGame();
    }

    @Override
    public void limitsReached() {
        this.write("You lost" + NEW_GAME);
    }

    @Override
    public void displayError(final String message) {
        this.write(message);
    }

    private void write(final String message) {
        System.out.println(message);
    }

}
