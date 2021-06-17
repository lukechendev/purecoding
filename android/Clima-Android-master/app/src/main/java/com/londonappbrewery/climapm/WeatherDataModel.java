package com.londonappbrewery.climapm;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataModel {

    private String mTemperature;
    private int mCondition;
    private String mCity;
    private int mIcon;

    public static WeatherDataModel fromJson(JSONObject jsonObject) {
        WeatherDataModel dataModel = new WeatherDataModel();

        try {
            dataModel.mCity = jsonObject.getString("name");
            dataModel.mCondition = jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            dataModel.mIcon = updateWeatherIcon(dataModel.mCondition);

            double tempValue = jsonObject.getJSONObject("main").getDouble("temp") - 273.15;
            int rtempValue = (int) Math.rint(tempValue);
            dataModel.mTemperature = Integer.toString(rtempValue);


        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return dataModel;
    }

    private static int updateWeatherIcon(int condition) {

        if (condition >= 0 && condition < 300) {
            return R.drawable.tstorm1;
        } else if (condition >= 300 && condition < 500) {
            return R.drawable.light_rain;
        } else if (condition >= 500 && condition < 600) {
            return R.drawable.shower3;
        } else if (condition >= 600 && condition <= 700) {
            return R.drawable.snow4;
        } else if (condition >= 701 && condition <= 771) {
            return R.drawable.fog;
        } else if (condition >= 772 && condition < 800) {
            return R.drawable.tstorm3;
        } else if (condition == 800) {
            return R.drawable.sunny;
        } else if (condition >= 801 && condition <= 804) {
            return R.drawable.cloudy2;
        } else if (condition >= 900 && condition <= 902) {
            return R.drawable.tstorm3;
        } else if (condition == 903) {
            return R.drawable.snow5;
        } else if (condition == 904) {
            return R.drawable.sunny;
        } else if (condition >= 905 && condition <= 1000) {
            return R.drawable.tstorm3;
        }

        return 0;
    }

    public String getTemperature() {
        return mTemperature + "°";
    }

    public String getCity() {
        return mCity;
    }

    public int getIcon() {
        return mIcon;
    }
}
