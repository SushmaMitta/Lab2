package com.sushmamitta.sushm.weatherinfo.service;

import com.sushmamitta.sushm.weatherinfo.data.Channel;

/**
 * Created by sushm on 2/3/2016.
 */
public interface WeatherServiceCallback {
    void serviceSuccess(Channel channel);

    void  serviceFailure(Exception exception);
}
