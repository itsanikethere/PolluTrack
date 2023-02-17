package pollutrack.model;

public record AQIRecord(String airQuality, String pm2_5Concentration, String pm10Concentration, String so2Concentration,
                        String no2Concentration, String o3Concentration, String coConcentration) {
}
