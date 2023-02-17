package pollutrack.gui.dialog;

import pollutrack.ApplicationConstants;

import java.awt.*;
import javax.swing.*;

public class AboutDialog extends JDialog {

    private static final String DEVELOPER_NAME = "Aniket Panchal";

    private static final Dimension DIALOG_SIZE = new Dimension(360, 110);
    private static final String DIALOG_TITLE = "About";

    private final JFrame dialogParent;
    private JLabel appIconLabel;
    private JPanel appInfoPanel;

    public AboutDialog(JFrame dialogParent) {
        super(dialogParent, DIALOG_TITLE);
        this.dialogParent = dialogParent;

        configureComponents();
        layoutComponents();
    }

    private void configureComponents() {
        configureDialog();
        configureAppIconLabel();
        configureAppInfoPanel();
    }

    private void layoutComponents() {
        add(appIconLabel, BorderLayout.WEST);
        add(appInfoPanel, BorderLayout.CENTER);
    }

    private void configureDialog() {
        setIconImage(ApplicationConstants.APP_ICON);
        setSize(DIALOG_SIZE);

        setResizable(false);
        setLocationRelativeTo(dialogParent);
    }

    private void configureAppIconLabel() {
        appIconLabel = new JLabel(ApplicationConstants.APP_ICON_SMALL);
    }

    private void configureAppInfoPanel() {
        appInfoPanel = new JPanel(new FlowLayout());

        String labelFontName = new JLabel().getFont().getFontName();
        Font appNameLabelFont = new Font(labelFontName, Font.BOLD, 20);
        Font devNameLabelFont = new Font(labelFontName, Font.PLAIN, 12);

        JLabel appNameLabel = new JLabel(ApplicationConstants.APP_NAME);
        appNameLabel.setFont(appNameLabelFont);

        JLabel devNameLabel = new JLabel(DEVELOPER_NAME + "'s PolluTrack, for real-time AQI.");
        devNameLabel.setFont(devNameLabelFont);

        appNameLabel.setHorizontalAlignment(JLabel.CENTER);
        devNameLabel.setHorizontalAlignment(JLabel.CENTER);

        appInfoPanel.add(appNameLabel);
        appInfoPanel.add(devNameLabel);
    }
}
