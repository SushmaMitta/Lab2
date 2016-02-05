package com.sushmamitta.sushm.weatherinfo.data;

//import com.sushmamitta.sushm.weatherinfo.data.JSONPopulator;

import org.json.JSONObject;

/**
 * Created by sushm on 2/3/2016.
 */
public class Units implements JSONPopulator {

    private String temperature;

    public String getTemperature() {
        return temperature;
    }

    @Override
    public void populate(JSONObject data) {
        temperature = data.optString("temperature");

    }
}
