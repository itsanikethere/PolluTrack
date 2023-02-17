package pollutrack;

import pollutrack.gui.Frame;

import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Frame().setVisible(true));
    }
}
