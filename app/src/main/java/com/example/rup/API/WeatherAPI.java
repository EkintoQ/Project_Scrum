package com.example.rup.API;

import android.os.AsyncTask;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherAPI extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;

        try {
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();
            String line = "";

            while ((line = reader.readLine()) != null)
                buffer.append(line).append("\n");

            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        JSONObject info = null;
        try {
            info = new JSONObject(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject day = null;
        try {
            day = info.getJSONObject("forecast")
                    .getJSONArray("forecastday")
                    .getJSONObject(0)
                    .getJSONObject("day");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        double avgTemp = 0;
        try {
            avgTemp = day.getDouble("avgtemp_c");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject condition = null;
        try {
            condition = day.getJSONObject("condition");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String weather = null;
        try {
            weather = condition.getString("text");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // GetApiDataWeather getApiDataWeather = new GetApiDataWeather(avgTemp, weather);
        // getApiDataWeather.getWeather();
        // getApiDataWeather.getAvg_Temp();
    }
}