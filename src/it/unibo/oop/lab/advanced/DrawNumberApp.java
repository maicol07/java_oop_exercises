package it.unibo.oop.lab.advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 */
public final class DrawNumberApp implements DrawNumberViewObserver {

    private int min;
    private int max;
    private int attempts;
    private final DrawNumber model;
    private final List<DrawNumberView> views = new ArrayList<>();

    /**
     * 
     */
    public DrawNumberApp() {
        final var config = ClassLoader.getSystemResourceAsStream("config.yml");
        String line;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(config))) {
            line = br.readLine();
            while (line != null) {
                final var split = line.split(": ");
                final var name = split[0];
                final var value = Integer.parseInt(split[1]);

                switch (name) {
                    case "minimum":
                        this.min = value;
                        break;
                    case "maximum":
                        this.max = value;
                        break;
                    case "attempts":
                        this.attempts = value;
                        break;
                    default:
                        break;
                }

                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.model = new DrawNumberImpl(min, max, attempts);

        final var view1 = new DrawNumberViewImpl();
        view1.setObserver(this);
        view1.start();
        this.views.add(view1);

        final var view2 = new DrawNumberViewLog();
        view2.setObserver(this);
        view2.start();
        this.views.add(view2);

        final var view3 = new DrawNumberViewStdOut();
        view3.setObserver(this);
        view3.start();
        this.views.add(view3);
    }

    @Override
    public void newAttempt(final int n) {
        try {
            final DrawResult result = model.attempt(n);
            for (final DrawNumberView view : views) {
                view.result(result);
            }
        } catch (IllegalArgumentException e) {
            for (final DrawNumberView view : views) {
                view.numberIncorrect();
            }
        } catch (AttemptsLimitReachedException e) {
            for (final DrawNumberView view : views) {
                view.limitsReached();
            }
        }
    }

    @Override
    public void resetGame() {
        this.model.reset();
    }

    @Override
    public void quit() {
        System.exit(0);
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String... args) {
        new DrawNumberApp();
    }

}
