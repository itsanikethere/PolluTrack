package pollutrack.gui.event;

import java.util.EventObject;

public class InputFormEvent extends EventObject {

    private final String apiKey;
    private final String latitude;
    private final String longitude;

    public InputFormEvent(Object source,
                          String apiKey,
                          String latitude,
                          String longitude) {
        super(source);

        this.apiKey = apiKey;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
