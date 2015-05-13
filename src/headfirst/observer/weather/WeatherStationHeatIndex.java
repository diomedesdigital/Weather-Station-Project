package headfirst.observer.weather;

import java.util.*;

public class WeatherStationHeatIndex {

	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);
		
		weatherData.setMeasurements(10, 40, 30.50f, 20, -9);
		weatherData.setMeasurements(0, 30, 30.70f,10, -16);
		weatherData.setMeasurements(-10, 20, 29.8f,15, -32);
	}
}
