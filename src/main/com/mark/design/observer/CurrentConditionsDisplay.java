package main.com.mark.design.observer;

/**
 * 状况布告板，观察者(实现了Observer))
 * 实现了Observer接口所以可以从WeatherData对象中得以改变
 * 实现了DisplayElement接口，所有的布告板都需要此接口
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    /**
     * 在实例化之后注册
     */
    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        /**
         * 当update被调用时，我们把温度和湿度保存起来，然后调用display
         */
        display();        
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humdity");
    }
}