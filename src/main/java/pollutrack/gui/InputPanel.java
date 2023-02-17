package pollutrack.gui;

import pollutrack.gui.util.ImageLoader;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class InputPanel extends JPanel {

    private static final String PANEL_BORDER_TITLE = "Coordinates";
    private static final Dimension PANEL_PREFERRED_SIZE = new Dimension(200, 0);

    private final InputForm inputForm;
    private JLabel appIconLabel;

    public InputPanel(InputForm inputForm) {
        this.inputForm = inputForm;

        configureComponents();
        layoutComponents();
    }

    private void configureComponents() {
        configurePanel();
        configureAppIconLabel();
    }

    private void layoutComponents() {
        add(appIconLabel, BorderLayout.NORTH);
        add(inputForm, BorderLayout.CENTER);
    }

    private void configurePanel() {
        Border outerBorder = BorderFactory.createEmptyBorder(5, 2, 2, 2);
        Border innerBorder = BorderFactory.createTitledBorder(PANEL_BORDER_TITLE);
        Border border = BorderFactory.createCompoundBorder(outerBorder, innerBorder);

        setBorder(border);
        setLayout(new BorderLayout());
        setPreferredSize(PANEL_PREFERRED_SIZE);
    }

    private void configureAppIconLabel() {
        appIconLabel = new JLabel(ImageLoader.loadImageIcon("/icons/form/search.png"));
        appIconLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
    }
}
