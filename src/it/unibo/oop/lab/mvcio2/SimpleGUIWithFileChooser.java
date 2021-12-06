package it.unibo.oop.lab.mvcio2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.unibo.oop.lab.mvcio.Controller;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {
    private final Controller controller = new Controller();

    /*
     * TODO: Starting from the application in mvcio:
     * 
     * 1) Add a JTextField and a button "Browse..." on the upper part of the
     * graphical interface.
     * Suggestion: use a second JPanel with a second BorderLayout, put the panel
     * in the North of the main panel, put the text field in the center of the
     * new panel and put the button in the line_end of the new panel.
     * 
     * 2) The JTextField should be non modifiable. And, should display the
     * current selected file.
     * 
     * 3) On press, the button should open a JFileChooser. The program should
     * use the method showSaveDialog() to display the file chooser, and if the
     * result is equal to JFileChooser.APPROVE_OPTION the program should set as
     * new file in the Controller the file chosen. If CANCEL_OPTION is returned,
     * then the program should do nothing. Otherwise, a message dialog should be
     * shown telling the user that an error has occurred (use
     * JOptionPane.showMessageDialog()).
     * 
     * 4) When in the controller a new File is set, also the graphical interface
     * must reflect such change. Suggestion: do not force the controller to
     * update the UI: in this example the UI knows when should be updated, so
     * try to keep things separated.
     */

    private final JFrame frame = new JFrame();

    /**
     * builds a new {@link SimpleGUI}.
     */
    public SimpleGUIWithFileChooser() {
        /*
         * Make the frame half the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected.
         * 
         * In order to deal coherently with multimonitor setups, other
         * facilities exist (see the Java documentation about this issue). It is
         * MUCH better than manually specify the size of a window in pixel: it
         * takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);

        final var panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.setContentPane(panel);

        final var filePanel = new JPanel();
        filePanel.setLayout(new BorderLayout());
        panel.add(filePanel, BorderLayout.NORTH);

        final var textfield = new JTextField(controller.getFilePath());
        textfield.setEditable(false);
        filePanel.add(textfield, BorderLayout.CENTER);
        final var browse = new JButton("Browse...");
        filePanel.add(browse, BorderLayout.LINE_END);


        final var textarea = new JTextArea(15, 30);
        panel.add(textarea, BorderLayout.CENTER);

        final var save = new JButton("Save");
        panel.add(save, BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final var chooser = new JFileChooser();
                final var result = chooser.showSaveDialog(frame);
                switch (result) {
                    case JFileChooser.APPROVE_OPTION:
                        final var file = chooser.getSelectedFile();
                        controller.setCurrentFile(file);
                        textfield.setText(file.getPath());
                        return;
                    case JFileChooser.CANCEL_OPTION:
                        return;
                    default:
                        JOptionPane.showMessageDialog(frame, "Error!");
                }
            }
        });

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.setContents(textarea.getText());
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(frame, e1.getMessage());
                    e1.printStackTrace();
                }
            }
        });
    }

    public static void main(final String...args) {
        new SimpleGUIWithFileChooser();
    }

}
