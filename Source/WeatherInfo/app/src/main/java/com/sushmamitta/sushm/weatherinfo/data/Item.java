package com.sushmamitta.sushm.weatherinfo.data;


import org.json.JSONObject;

/**
 * Created by sushm on 2/3/2016.
 */
public class Item implements JSONPopulator {

    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void populate(JSONObject data) {
        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));
    }
}
