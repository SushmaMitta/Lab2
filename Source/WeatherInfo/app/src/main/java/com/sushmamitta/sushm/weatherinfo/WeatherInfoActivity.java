package com.sushmamitta.sushm.weatherinfo;

import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sushmamitta.sushm.weatherinfo.data.Channel;
import com.sushmamitta.sushm.weatherinfo.data.Item;
import com.sushmamitta.sushm.weatherinfo.service.WeatherServiceCallback;
import com.sushmamitta.sushm.weatherinfo.service.YahooWeatherService;

public class WeatherInfoActivity extends AppCompatActivity implements WeatherServiceCallback {

    private ImageView weatherIconImageView;
    private TextView temperatureTextVIew;
    private TextView conditionTextVIew;
    private TextView locationTextVIew;

    private YahooWeatherService service;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_info);

        weatherIconImageView = (ImageView) findViewById(R.id.weatherIconImageView);
        temperatureTextVIew = (TextView) findViewById(R.id.temperatureTextView);
        conditionTextVIew = (TextView) findViewById(R.id.conditionTextView);
        locationTextVIew = (TextView) findViewById(R.id.locationTextView);

        service = new YahooWeatherService(this);
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.show();

        service.refreshWeather("Nome, AK");

    }

    @Override
    public void serviceSuccess(Channel channel) {
        dialog.hide();

        Item item = channel.getItem();

        int resourceId = getResources().getIdentifier("drawable/icon_" + item.getCondition().getCode(),null,getPackageName());

        @SuppressWarnings("deprecation")
        Drawable weatherIconDrawable = getResources().getDrawable(resourceId);

        weatherIconImageView.setImageDrawable(weatherIconDrawable);

        temperatureTextVIew.setText(item.getCondition().getTemperature() + "\u00B0" + channel.getUnits().getTemperature());
        conditionTextVIew.setText(item.getCondition().getDescription());
        locationTextVIew.setText(service.getLocation());



    }

    @Override
    public void serviceFailure(Exception exception) {
        dialog.hide();
        Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
    }
}

