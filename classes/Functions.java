import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Functions {

    public static String createDistanceMatrixURL(double sourcelat, double sourcelog,
                                                 double destlat, double destlog, String mode) {
        return "https://maps.googleapis.com/maps/api/distancematrix/json?" + "origins=" + Double.toString(sourcelat) + "," + Double.toString(sourcelog) + "&destinations=" + Double.toString(destlat) + "," + Double.toString(destlog) + "&mode=" + mode;
    }

    public static class JSONParser {
        private InputStream is;
        private String json = "";

        public String getJSONFromUrl(String url) {
            try {
                URLConnection connection = new URL(url).openConnection();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                json = sb.toString();
                is.close();
            } catch (Exception ignored) {
            }
            return json;
        }
    }

    public static void main(String[] args) {
        System.out.println(getDistance(48.725069, 2.419203, 48.864527821, 2.41617072443, "walking"));
        System.out.println(getDuration(48.725069, 2.419203, 48.864527821, 2.41617072443, "walking"));
    }

    public static double getDistance(double sourcelat, double sourcelon,
                                     double destlat, double destlon, String mode) {
        JSONParser jsonParser = new JSONParser();
        JSONObject json;
        try {
            String url = createDistanceMatrixURL(sourcelat, sourcelon, destlat, destlon, mode);
            json = new JSONObject(jsonParser.getJSONFromUrl(url));
            JSONObject rows = (JSONObject) json.getJSONArray("rows").get(0);
            JSONObject elements = (JSONObject) rows.getJSONArray("elements").get(0);
            JSONObject distance = elements.getJSONObject("distance");
            return distance.getDouble("value");
        } catch (JSONException ignored) {
        }
        return -1;
    }

    public static double walkingTime(double sourcelat, double sourcelon, String position) {
        String[] pos = position.split(",");
        try {
            Thread.sleep(500);
        } catch (Exception ignored) {

        }
        return getDuration(sourcelat, sourcelon, Double.parseDouble(pos[0]), Double.parseDouble(pos[1]), "walking");
    }

    public static double walkingDistance(double lat1, double lon1, String pos2) {
        double lon2, lat2;
        String[] p2 = pos2.split(",");
        lat2 = Double.parseDouble(p2[0]);
        lon2 = Double.parseDouble(p2[1]);
        try {
            Thread.sleep(500);
        } catch (Exception ignored) {

        }
        return getDistance(lat1, lon1, lat2, lon2, "walking");
    }

    public static double getDuration(double sourcelat, double sourcelon,
                                     double destlat, double destlon, String mode) {
        JSONParser jsonParser = new JSONParser();
        JSONObject json;
        try {
            String url = createDistanceMatrixURL(sourcelat, sourcelon, destlat, destlon, mode);
            json = new JSONObject(jsonParser.getJSONFromUrl(url));
            JSONObject rows = (JSONObject) json.getJSONArray("rows").get(0);
            JSONObject elements = (JSONObject) rows.getJSONArray("elements").get(0);
            JSONObject duration = elements.getJSONObject("duration");
            return Math.round(duration.getDouble("value"));
        } catch (JSONException ignored) {
        }
        return -1;
    }


    public static double geometricDistance(double lat1, double lon1, String pos2, String unit) {
        double lon2, lat2;
        String[] p2 = pos2.split(",");
        lat2 = Double.parseDouble(p2[0]);
        lon2 = Double.parseDouble(p2[1]);
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit.equals("K")) {
            dist = dist * 1.609344;
        } else if (unit.equals("N")) {
            dist = dist * 0.8684;
        }
        return (dist);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}
