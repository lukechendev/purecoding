package com.londonappbrewery.climapm;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.lukechendev.climapm.ChangeCityController;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


public class WeatherController extends AppCompatActivity {

    // Constants:
    final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather";
    // App ID to use OpenWeather data
    final String APP_ID = "d3e656690aad9c2f867407e45f3881ed";
    // Time between location updates (5000 milliseconds or 5 seconds)
    final long MIN_TIME = 5000;
    // Distance between location updates (1000m or 1km)
    final float MIN_DISTANCE = 1000;
    // Request Code
    final int REQUEST_CODE = 10110;

    String LOCATION_PROVIDER = LocationManager.NETWORK_PROVIDER;


    // Member Variables:
    TextView mCityLabel;
    ImageView mWeatherImage;
    TextView mTemperatureLabel;

    LocationManager mLocationmanager;
    LocationListener mLocationListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Clima", "onCreate");

        setContentView(R.layout.weather_controller_layout);

        // Linking the elements in the layout to Java code
        mCityLabel = findViewById(R.id.locationTV);
        mWeatherImage = findViewById(R.id.weatherSymbolIV);
        mTemperatureLabel = findViewById(R.id.tempTV);
        ImageButton changeCityButton = findViewById(R.id.changeCityButton);

        changeCityButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent changeCity = new Intent(WeatherController.this, ChangeCityController.class);
               startActivity(changeCity);
           }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Clima", "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Clima", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Clima", "onResume");

        Intent startIntent = getIntent();
        String newCity = startIntent.getStringExtra("City");

        if (newCity != null && !newCity.isEmpty()) {
            getWeatherForCity(newCity);
        } else {
            getWeatherForCurrentLocation();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Clima", "onPause");

        if (mLocationmanager != null) {
            mLocationmanager.removeUpdates(mLocationListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Clima", "onStop (Could be killed at anytime so may not appear)");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            Log.d("Clima", "onDestroy finishing (Could be killed at anytime so might not appear / Called at rotation)");
        } else {
            Log.d("Clima", "onDestroy (Could be killed at anytime so might not appear / Called at rotation)");
        }
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Clima", "onRestoreInstanceState");
    }

    // invoked when the activity may be temporarily destroyed, save the instance state here
    @Override
    public void onSaveInstanceState(Bundle outState) {
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
        Log.d("Clima", "onSaveInstanceState");
    }

    private void getWeatherForCity(String city) {
        Log.d("Clima", "getWeatherForCity: " + city);
        RequestParams requestParams = new RequestParams();
        requestParams.add("q", city);
        requestParams.add("APPID", APP_ID);
        requestWeather(requestParams);
    }

    private void getWeatherForCurrentLocation() {
        Log.d("Clima", "getWeatherForCurrentLocation");
        mLocationmanager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        mLocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                String latitude = String.valueOf(location.getLatitude());
                String longitude = String.valueOf(location.getLongitude());

                Log.d("Clima", "onLocationChanged: " + latitude + ", " + longitude);

                RequestParams requestParams = new RequestParams();
                requestParams.add("lat", latitude);
                requestParams.add("lon", longitude);
                requestParams.add("APPID", APP_ID);
                requestWeather(requestParams);
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Log.d("Clima", "onProviderDisabled");
            }
        };

        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.INTERNET, Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_CODE);
            return;
        }
        mLocationmanager.requestLocationUpdates(LOCATION_PROVIDER, MIN_TIME, MIN_DISTANCE, mLocationListener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        for (int i = 0; i < permissions.length; ++i) {
            Log.d("Clima", permissions[i] + ": " + (grantResults[i] == PackageManager.PERMISSION_GRANTED ? "granted" : "denied"));
        }
    }

    private void requestWeather(RequestParams params) {
        AsyncHttpClient httpClient = new AsyncHttpClient();
        httpClient.get(WEATHER_URL, params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.d("Clima", response.toString());
                WeatherDataModel dataModel = WeatherDataModel.fromJson(response);
                updateUI(dataModel);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable e, JSONObject response) {
                Log.e("Clima", e.toString());
                Log.d("Clima", "Status code: " + statusCode);
                Toast.makeText(WeatherController.this, "Request failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void updateUI(WeatherDataModel dataModel) {
        mTemperatureLabel.setText(dataModel.getTemperature());
        mCityLabel.setText(dataModel.getCity());
        mWeatherImage.setImageResource(dataModel.getIcon());
    }
}
