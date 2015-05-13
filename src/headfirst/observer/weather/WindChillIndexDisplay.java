package headfirst.observer.weather;

import javax.swing.JOptionPane;

public class WindChillIndexDisplay implements Observer, DisplayElement {
	float windChillIndex = 0.0f;
	private WeatherData weatherData;

	public WindChillIndexDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}


	public void update(float t, float speed) {
		windChillIndex = computeWindChillIndex(t,speed);
		display();
	}
	
	private float computeWindChillIndex(float t, float speed) {
		float index = (float)
				((35.74 + 0.6215*t) + (0.4275*t - 35.75) * Math.pow(speed, 0.16));
		return index;
	}

	public void display() {
		JOptionPane.showMessageDialog(null,"Wind Chill index is " + windChillIndex);
		
	}


	@Override
	public void update(float temp, float humidity, float pressure, float speed, float windChillIndex) {
		// TODO Auto-generated method stub
		
	}

}

