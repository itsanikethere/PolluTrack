package pollutrack.controller;

import pollutrack.ApplicationConstants;
import pollutrack.gui.OutputForm;
import pollutrack.model.AQIFetcher;
import pollutrack.model.AQIRecord;

import javax.swing.*;

public class Controller {

    private final JFrame dialogParent;
    private final OutputForm outputForm;
    private final AQIFetcher aqiFetcher;

    public Controller(JFrame dialogParent, OutputForm outputForm) {
        this.dialogParent = dialogParent;
        this.outputForm = outputForm;

        aqiFetcher = new AQIFetcher();
    }

    public void fetchAQI(String apiKey, String latitude, String longitude) {
        aqiFetcher.fetchAQI(apiKey, latitude, longitude);

        int code = aqiFetcher.getCode();

        String message = null;
        switch (code) {
            case AQIFetcher.CONNECTION_ERROR -> message = "Connection to OpenWeatherMap could not be made.";
            case AQIFetcher.PARSING_ERROR -> message = "Response from OpenWeatherMap could not be parsed.";
            case AQIFetcher.API_KEY_INVALID -> message = "The OWM key is not valid. Verify your key.";
            case AQIFetcher.API_KEY_OVERUSED -> message = "The OWM Key is overused. Try again later.";
        }

        if (code == AQIFetcher.CONNECTION_ERROR || code == AQIFetcher.PARSING_ERROR || code == AQIFetcher.API_KEY_INVALID || code == AQIFetcher.API_KEY_OVERUSED) {
            JOptionPane.showMessageDialog(dialogParent, message, ApplicationConstants.APP_NAME, JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (code != 200) {
            JOptionPane.showMessageDialog(dialogParent, "An unexpected error has occurred. Please try again later.", ApplicationConstants.APP_NAME, JOptionPane.ERROR_MESSAGE);
            return;
        }

        AQIRecord aqiRecord = aqiFetcher.getAqiRecord();
        outputForm.setAirQuality(aqiRecord.airQuality());
        outputForm.setPm2_5Concentration(aqiRecord.pm2_5Concentration());
        outputForm.setPm10Concentration(aqiRecord.pm10Concentration());
        outputForm.setSo2Concentration(aqiRecord.so2Concentration());
        outputForm.setNo2Concentration(aqiRecord.no2Concentration());
        outputForm.setO3Concentration(aqiRecord.o3Concentration());
        outputForm.setCoConcentration(aqiRecord.coConcentration());
    }
}
