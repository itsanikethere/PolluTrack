package pollutrack.gui;

import java.awt.*;
import javax.swing.*;

public class OutputForm extends JPanel {

    private JTextField airQualityField;
    private JTextField pm2_5ConcentrationField;
    private JTextField pm10ConcentrationField;
    private JTextField so2ConcentrationField;
    private JTextField no2ConcentrationField;
    private JTextField o3ConcentrationField;
    private JTextField coConcentrationField;

    private JLabel airQualityLabel;
    private JLabel pm2_5ConcentrationLabel;
    private JLabel pm10ConcentrationLabel;
    private JLabel so2ConcentrationLabel;
    private JLabel no2ConcentrationLabel;
    private JLabel o3ConcentrationLabel;
    private JLabel coConcentrationLabel;

    public OutputForm() {
        configureComponents();
        layoutComponents();
    }

    public void setAirQuality(String airQuality) {
        airQualityField.setText(airQuality);
    }

    public void setPm2_5Concentration(String pm2_5Concentration) {
        pm2_5ConcentrationField.setText(pm2_5Concentration);
    }

    public void setPm10Concentration(String pm10Concentration) {
        pm10ConcentrationField.setText(pm10Concentration);
    }

    public void setSo2Concentration(String so2Concentration) {
        so2ConcentrationField.setText(so2Concentration);
    }

    public void setNo2Concentration(String no2Concentration) {
        no2ConcentrationField.setText(no2Concentration);
    }

    public void setO3Concentration(String o3Concentration) {
        o3ConcentrationField.setText(o3Concentration);
    }

    public void setCoConcentration(String coConcentration) {
        coConcentrationField.setText(coConcentration);
    }

    private void configureComponents() {
        configurePanel();
        configureFields();
        configureLabels();
    }

    private void layoutComponents() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1;

        constraints.weighty = 0;
        constraints.gridwidth = 4;
        add(new JLabel("Criteria pollutants determine air quality."), constraints);

        constraints.weighty = 0.1;
        constraints.gridwidth = 2;

        constraints.gridy++;

        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0, 0, 8, 4);
        add(airQualityLabel, constraints);

        constraints.gridx += 2;

        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 4, 8, 0);
        add(airQualityField, constraints);

        constraints.weighty = 0;
        constraints.gridwidth = 4;

        constraints.gridx = 0;
        constraints.gridy++;

        constraints.anchor = GridBagConstraints.BASELINE;
        constraints.insets = new Insets(0, 0, 0, 0);
        add(new JLabel("Criteria pollutants are expressed in µg/m³."), constraints);

        constraints.weighty = 0.1;
        constraints.gridwidth = 1;

        constraints.gridx = 0;
        constraints.gridy++;

        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0, 0, 0, 4);
        add(pm2_5ConcentrationLabel, constraints);

        constraints.gridx++;

        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 4, 0, 0);
        add(pm2_5ConcentrationField, constraints);

        constraints.gridx++;

        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0, 0, 0, 4);
        add(pm10ConcentrationLabel, constraints);

        constraints.gridx++;

        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 4, 0, 0);
        add(pm10ConcentrationField, constraints);

        constraints.gridx = 0;
        constraints.gridy++;

        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0, 0, 0, 4);
        add(so2ConcentrationLabel, constraints);

        constraints.gridx++;

        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 4, 0, 0);
        add(so2ConcentrationField, constraints);

        constraints.gridx++;

        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0, 0, 0, 4);
        add(no2ConcentrationLabel, constraints);

        constraints.gridx++;

        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 4, 0, 0);
        add(no2ConcentrationField, constraints);

        constraints.gridx = 0;
        constraints.gridy++;

        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0, 0, 0, 4);
        add(o3ConcentrationLabel, constraints);

        constraints.gridx++;

        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 4, 0, 0);
        add(o3ConcentrationField, constraints);

        constraints.gridx++;

        constraints.anchor = GridBagConstraints.LINE_END;
        constraints.insets = new Insets(0, 0, 0, 4);
        add(coConcentrationLabel, constraints);

        constraints.gridx++;

        constraints.anchor = GridBagConstraints.LINE_START;
        constraints.insets = new Insets(0, 4, 0, 0);
        add(coConcentrationField, constraints);

        constraints.weighty = 0;
        constraints.gridwidth = 4;

        constraints.gridx = 0;
        constraints.gridy++;

        constraints.anchor = GridBagConstraints.BASELINE;
        constraints.insets = new Insets(5, 0, 5, 0);
        add(new JLabel("OpenWeatherMap powers PolluTrack."), constraints);
    }

    private void configurePanel() {
        setLayout(new GridBagLayout());
    }

    private void configureFields() {
        airQualityField = new JTextField(7);
        pm2_5ConcentrationField = new JTextField(5);
        pm10ConcentrationField = new JTextField(5);
        so2ConcentrationField = new JTextField(5);
        no2ConcentrationField = new JTextField(5);
        o3ConcentrationField = new JTextField(5);
        coConcentrationField = new JTextField(5);

        airQualityField.setHorizontalAlignment(JTextField.CENTER);
        pm2_5ConcentrationField.setHorizontalAlignment(JTextField.CENTER);
        pm10ConcentrationField.setHorizontalAlignment(JTextField.CENTER);
        so2ConcentrationField.setHorizontalAlignment(JTextField.CENTER);
        no2ConcentrationField.setHorizontalAlignment(JTextField.CENTER);
        o3ConcentrationField.setHorizontalAlignment(JTextField.CENTER);
        coConcentrationField.setHorizontalAlignment(JTextField.CENTER);

        airQualityField.setEditable(false);
        pm2_5ConcentrationField.setEditable(false);
        pm10ConcentrationField.setEditable(false);
        so2ConcentrationField.setEditable(false);
        no2ConcentrationField.setEditable(false);
        o3ConcentrationField.setEditable(false);
        coConcentrationField.setEditable(false);
    }

    private void configureLabels() {
        airQualityLabel = new JLabel("Air Quality :");
        pm2_5ConcentrationLabel = new JLabel("PM2.5 :");
        pm10ConcentrationLabel = new JLabel("PM10 :");
        so2ConcentrationLabel = new JLabel("SO2 :");
        no2ConcentrationLabel = new JLabel("NO2 :");
        o3ConcentrationLabel = new JLabel("O3 :");
        coConcentrationLabel = new JLabel("CO :");
    }
}
