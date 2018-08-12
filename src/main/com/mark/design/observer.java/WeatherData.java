package main.com.mark.design.observer.java;

import java.util.Observable;

/**
 * 可被观察类
 */
public class WeatherData extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData () {}

    public void measurementsChanges() {
        /**
         * 状态改变
         */
        setChanged();
        /**
         * 通知观察者
         */
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanges();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }


}