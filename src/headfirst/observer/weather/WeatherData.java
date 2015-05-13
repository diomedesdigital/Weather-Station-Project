package headfirst.observer.weather;

import java.util.*;


public class WeatherData implements Subject {
	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;
	private float speed;
	private float windChillIndex;
	
	public WeatherData() {
		observers = new ArrayList();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(temperature, humidity, pressure, speed, windChillIndex);
		}
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure, float speed, float windChillIndex) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.speed = speed;
		this.windChillIndex = windChillIndex;
		measurementsChanged();
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
	public float getSpeed(){
		return speed;
	}
	public float getWindChillIndex(){
		return windChillIndex;
	}
}
