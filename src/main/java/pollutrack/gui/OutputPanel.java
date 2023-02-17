package pollutrack.gui;

import pollutrack.ApplicationConstants;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class OutputPanel extends JPanel {

    private static final String PANEL_BORDER_TITLE = "AQI";

    private final OutputForm outputForm;
    private JLabel appIconLabel;

    public OutputPanel(OutputForm outputForm) {
        this.outputForm = outputForm;

        configureComponents();
        layoutComponents();
    }

    private void configureComponents() {
        configurePanel();
        configureAppIconLabel();
    }

    private void layoutComponents() {
        add(appIconLabel, BorderLayout.NORTH);
        add(outputForm, BorderLayout.CENTER);
    }

    private void configurePanel() {
        Border innerBorder = BorderFactory.createEmptyBorder(5, 2, 2, 2);
        Border outerBorder = BorderFactory.createTitledBorder(PANEL_BORDER_TITLE);
        Border border = BorderFactory.createCompoundBorder(innerBorder, outerBorder);

        setBorder(border);
        setLayout(new BorderLayout());
    }

    private void configureAppIconLabel() {
        appIconLabel = new JLabel(ApplicationConstants.APP_ICON_SMALL);
        appIconLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));
    }
}
