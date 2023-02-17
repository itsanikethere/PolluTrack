package pollutrack.model;

import com.squareup.okhttp.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class AQIFetcher {

    public static final int CONNECTION_ERROR = -1;
    public static final int PARSING_ERROR = -2;

    public static final int API_KEY_INVALID = 401;
    public static final int API_KEY_OVERUSED = 429;

    private int code;
    private AQIRecord aqiRecord;

    public void fetchAQI(String apiKey, String latitude, String longitude) {
        String url = buildUrl(apiKey, latitude, longitude);

        Response httpResponse;
        try {
            httpResponse = sendHttpRequest(url);

        } catch (IOException e) {
            code = CONNECTION_ERROR;
            return;
        }

        code = httpResponse.code();
        if (code != 200)
            return;

        parseHttpResponse(httpResponse);
    }

    private String buildUrl(String apiKey, String latitude, String longitude) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse("http://api.openweathermap.org/data/2.5/air_pollution").newBuilder();

        urlBuilder.addQueryParameter("appid", apiKey);
        urlBuilder.addQueryParameter("lat", latitude);
        urlBuilder.addQueryParameter("lon", longitude);

        return urlBuilder.build().toString();
    }

    private Response sendHttpRequest(String url) throws IOException {
        OkHttpClient httpClient = new OkHttpClient();
        Request httpRequest = new Request.Builder().url(url).build();

        return httpClient.newCall(httpRequest).execute();
    }

    private void parseHttpResponse(Response httpResponse) {
        String responseBodyInString;
        try {
            ResponseBody responseBody = httpResponse.body();
            responseBodyInString = responseBody.string();
            responseBody.close();

        } catch (IOException e) {
            code = PARSING_ERROR;
            return;
        }

        JSONObject root = new JSONObject(responseBodyInString);
        JSONArray list = root.getJSONArray("list");

        String airQuality = null;
        String pm2_5;
        String pm10;
        String so2;
        String no2;
        String o3;
        String co;
        try {
            switch (list.getJSONObject(0).getJSONObject("main").getInt("aqi")) {
                case 1 -> airQuality = "Good";
                case 2 -> airQuality = "Moderate";
                case 3 -> airQuality = "Unhealthy";
                case 4 -> airQuality = "V-Unhealthy";
                case 5 -> airQuality = "Hazardous";
            }

            pm2_5 = String.valueOf(list.getJSONObject(0).getJSONObject("components").getDouble("pm2_5"));
            pm10 = String.valueOf(list.getJSONObject(0).getJSONObject("components").getDouble("pm10"));
            so2 = String.valueOf(list.getJSONObject(0).getJSONObject("components").getDouble("so2"));
            no2 = String.valueOf(list.getJSONObject(0).getJSONObject("components").getDouble("no2"));
            o3 = String.valueOf(list.getJSONObject(0).getJSONObject("components").getDouble("o3"));
            co = String.valueOf(list.getJSONObject(0).getJSONObject("components").getDouble("co"));

        } catch (JSONException e) {
            code = PARSING_ERROR;
            return;
        }

        aqiRecord = new AQIRecord(airQuality, pm2_5, pm10, so2, no2, o3, co);
    }

    public int getCode() {
        return code;
    }

    public AQIRecord getAqiRecord() {
        return aqiRecord;
    }
}
