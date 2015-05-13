package headfirst.observer.weather;
import java.io.IOException;
import java.io.OutputStream;
 
import javax.swing.JOptionPane;
	
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private float speed;
	private float windChillIndex;
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	public void update(float temperature, float humidity, float pressure, float speed, float windChillIndex) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.speed = speed;
		this.windChillIndex = windChillIndex;
		display();
	}
	
	public void display() {
		JOptionPane.showMessageDialog(null, "Current conditions: " + temperature 
			+ "F degrees and " + humidity + "% humidity " + speed + " MPH" + " and The Wind Chill Index is: " + windChillIndex);
		JOptionPane.showMessageDialog(null, "Update");
		System.out.println("Current conditions: " + temperature 
			+ "F degrees and " + humidity + "% humidity " + speed + " MPH" );
	}
}
