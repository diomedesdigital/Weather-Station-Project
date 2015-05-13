package headfirst.observer.weather;

import java.util.*;
import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JOptionPane;

public class ForecastDisplay implements Observer, DisplayElement {
	private float currentPressure = 29.92f;  
	private float lastPressure;
	private WeatherData weatherData;

	public ForecastDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temp, float humidity, float pressure, float speed, float windChillIndex) {
                lastPressure = currentPressure;
		currentPressure = pressure;

		display();
	}

	public void display() {
		JOptionPane.showMessageDialog(null, "Forecast: ");
		if (currentPressure > lastPressure) {
			JOptionPane.showMessageDialog(null,"Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			JOptionPane.showMessageDialog(null,"More of the same");
		} else if (currentPressure < lastPressure) {
			JOptionPane.showMessageDialog(null, "Watch out for cooler, rainy weather");
		}
	}
}
