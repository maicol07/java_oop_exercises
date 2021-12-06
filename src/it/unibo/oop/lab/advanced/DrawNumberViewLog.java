package it.unibo.oop.lab.advanced;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class DrawNumberViewLog implements DrawNumberView {
    private static final String NEW_GAME = ": a new game starts!";

    private final File file;
    private DrawNumberViewObserver observer;

    public DrawNumberViewLog() {
        this.file = new File("match.log");
    }

    @Override
    public void setObserver(final DrawNumberViewObserver observer) {
        this.observer = observer;
    }

    @Override
    public void start() {
        this.writeOnFile("Starting the game!");
    }

    @Override
    public void numberIncorrect() {
        this.writeOnFile("Incorrect Number.. try again");
    }

    @Override
    public void result(final DrawResult res) {
        switch (res) {
        case YOURS_HIGH:
        case YOURS_LOW:
            this.writeOnFile(res.getDescription());
            return;
        case YOU_WON:
            this.writeOnFile(res.getDescription() + NEW_GAME);
            break;
        default:
            throw new IllegalStateException("Unexpected result: " + res);
        }
        this.observer.resetGame();
    }

    @Override
    public void limitsReached() {
        this.writeOnFile("You lost" + NEW_GAME);
    }

    @Override
    public void displayError(final String message) {
        this.writeOnFile(message);
    }

    private void writeOnFile(final String message) {
        try {
            final var mode = this.file.exists() ? StandardOpenOption.APPEND : StandardOpenOption.CREATE_NEW;
            Files.writeString(this.file.toPath(), message + "\n", mode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
