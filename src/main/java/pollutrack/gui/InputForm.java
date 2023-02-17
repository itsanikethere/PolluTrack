package pollutrack.gui;

import pollutrack.ApplicationConstants;
import pollutrack.gui.event.InputFormEvent;
import pollutrack.gui.event.InputFormListener;
import pollutrack.gui.util.ImageLoader;

import java.util.Arrays;

import java.awt.*;
import javax.swing.*;

public class InputForm extends JPanel {
    private final JFrame dialogParent;

    private InputFormListener inputFormListener;

    private JPasswordField apiKeyField;
    private JTextField latitudeField;
    private JTextField longitudeField;

    private JLabel apiKeyLabel;
    private JLabel latitudeLabel;
    private JLabel longitudeLabel;

    private JButton clearButton;
    private JButton fetchButton;

    public InputForm(JFrame dialogParent) {
        this.dialogParent = dialogParent;

        configureComponents();
        layoutComponents();
    }

    public void setApiKeyFieldText(String text) {
        apiKeyField.setText(text);
    }

    public void setLatitudeFieldText(String text) {
        latitudeField.setText(text);
    }

    public void setLongitudeFieldText(String text) {
        longitudeField.setText(text);
    }

    public void addInputPanelListener(InputFormListener inputFormListener) {
        this.inputFormListener = inputFormListener;
    }

    private void configureComponents() {
        configurePanel();
        configureFields();
        configureLabels();
        configureButtons();
    }

    private void layoutComponents() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;
        constraints.weighty = 1;

        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0, 0, 0, 4);
        add(apiKeyLabel, constraints);

        constraints.gridx++;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 4, 0, 0);
        add(apiKeyField, constraints);

        constraints.gridx--;
        constraints.gridy++;

        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0, 0, 0, 4);
        add(latitudeLabel, constraints);

        constraints.gridx++;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 4, 0, 0);
        add(latitudeField, constraints);

        constraints.gridx--;
        constraints.gridy++;

        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0, 0, 0, 4);
        add(longitudeLabel, constraints);

        constraints.gridx++;
        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 4, 0, 0);
        add(longitudeField, constraints);

        constraints.gridx--;
        constraints.gridy++;

        constraints.weighty = 0.5;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(0, 4, 0, 4);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.anchor = GridBagConstraints.LINE_END;
        add(fetchButton, constraints);

        constraints.gridx--;
        constraints.gridy++;

        constraints.anchor = GridBagConstraints.LINE_START;
        add(clearButton, constraints);
    }

    private void configurePanel() {
        setLayout(new GridBagLayout());
    }

    private void configureFields() {
        apiKeyField = new JPasswordField(8);
        latitudeField = new JTextField(8);
        longitudeField = new JTextField(8);
    }

    private void configureLabels() {
        apiKeyLabel = new JLabel("Key :");
        latitudeLabel = new JLabel("Latitude :");
        longitudeLabel = new JLabel("Longitude :");
    }

    private void configureButtons() {
        fetchButton = new JButton("Fetch");
        fetchButton.setIcon(ImageLoader.loadImageIcon("/icons/form/fetch.png"));

        clearButton = new JButton("Clear");
        clearButton.setIcon(ImageLoader.loadImageIcon("/icons/form/clear.png"));

        fetchButton.addActionListener(e -> {
            char[] apiKey = apiKeyField.getPassword();
            String apiKeyInString = new String(apiKey).trim();
            String latitudeInString = latitudeField.getText().trim();
            String longitudeInString = longitudeField.getText().trim();

            Arrays.fill(apiKey, '\0');

            if (apiKeyInString.isEmpty() || latitudeInString.isEmpty() || longitudeInString.isEmpty()) {
                JOptionPane.showMessageDialog(
                        dialogParent, "Please make sure any field is not empty.",
                        ApplicationConstants.APP_NAME, JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            double latitude;
            double longitude;
            try {
                latitude = Double.parseDouble(latitudeInString);
                longitude = Double.parseDouble(longitudeInString);

                if (latitude < -90.0 || latitude > 90.0 || longitude < -180.0 || longitude > 180.0)
                    throw new NumberFormatException();

            } catch (NumberFormatException exception) {
                JOptionPane.showMessageDialog(
                        dialogParent, "Please enter valid latitude & longitude.",
                        ApplicationConstants.APP_NAME, JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            InputFormEvent event = new InputFormEvent(this, apiKeyInString, latitudeInString, longitudeInString);
            inputFormListener.inputPanelEventOccurred(event);
        });

        clearButton.addActionListener(e -> {
            apiKeyField.setText("");
            latitudeField.setText("");
            longitudeField.setText("");
        });
    }
}
