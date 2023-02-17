package pollutrack.gui;

import pollutrack.ApplicationConstants;
import pollutrack.controller.Controller;
import pollutrack.gui.dialog.AQIScaleDialog;
import pollutrack.gui.dialog.AboutDialog;
import pollutrack.gui.util.ImageLoader;

import java.util.prefs.Preferences;

import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {

    private static final Dimension FRAME_SIZE = new Dimension(480, 400);

    private JMenuBar menuBar;
    private InputForm inputForm;
    private InputPanel inputPanel;
    private OutputForm outputForm;
    private OutputPanel outputPanel;
    private Preferences preferences;
    private Controller controller;

    public Frame() {
        super(ApplicationConstants.APP_NAME);
        configureComponents();
        layoutComponents();
        loadPreferences();
    }

    private void configureComponents() {
        configureFrame();
        configureMenuBar();
        configureInputForm();
        configureInputPanel();
        configureOutputForm();
        configureOutputPanel();
        configureController();
    }

    private void layoutComponents() {
        add(inputPanel, BorderLayout.WEST);
        add(outputPanel, BorderLayout.CENTER);
        setJMenuBar(menuBar);
    }

    private void loadPreferences() {
        String className = this.getClass().getName();
        preferences = Preferences.userRoot().node(className);

        String apiKey = preferences.get("api-key", null);
        String latitude = preferences.get("latitude", null);
        String longitude = preferences.get("longitude", null);

        if (apiKey == null || latitude == null || longitude == null)
            return;

        inputForm.setApiKeyFieldText(apiKey);
        inputForm.setLatitudeFieldText(latitude);
        inputForm.setLongitudeFieldText(longitude);
    }

    private void configureFrame() {
        setIconImage(ApplicationConstants.APP_ICON);
        setSize(FRAME_SIZE);

        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void configureMenuBar() {
        menuBar = new JMenuBar();

        JMenu help = new JMenu("Help");
        help.setIcon(ImageLoader.loadImageIcon("/icons/menu/help.png"));

        JMenuItem aqiScale = new JMenuItem("AQI Scale");
        JMenuItem about = new JMenuItem("About");

        aqiScale.addActionListener(e -> new AQIScaleDialog(this).setVisible(true));
        about.addActionListener(e -> new AboutDialog(this).setVisible(true));

        aqiScale.setIcon(ImageLoader.loadImageIcon("/icons/menu-items/aqi-scale.png"));
        about.setIcon(ImageLoader.loadImageIcon("/icons/menu-items/about.png"));

        help.add(aqiScale);
        help.add(about);

        menuBar.add(help);
    }

    private void configureInputForm() {
        inputForm = new InputForm(this);

        inputForm.addInputPanelListener(e -> {
            String apiKey = e.getApiKey();
            String latitude = e.getLatitude();
            String longitude = e.getLongitude();

            preferences.put("api-key", apiKey);
            preferences.put("latitude", latitude);
            preferences.put("longitude", longitude);

            controller.fetchAQI(apiKey, latitude, longitude);
        });
    }

    private void configureInputPanel() {
        inputPanel = new InputPanel(inputForm);
    }

    private void configureOutputForm() {
        outputForm = new OutputForm();
    }

    private void configureOutputPanel() {
        outputPanel = new OutputPanel(outputForm);
    }

    private void configureController() {
        controller = new Controller(this, outputForm);
    }
}
