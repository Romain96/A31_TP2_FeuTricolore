import trafficLightModel.*;
import trafficLightView.*;

public class Main {
	
	public static void main(String[] args)
	{
		// creating one and only one traffic light
		TrafficLight tl = new TrafficLight(new TrafficLightGermanModel());

		// creating a main window
		TrafficLightMainView mv = new TrafficLightMainView();
		
		// adding the traffic light instance to all event handlers of the main window
		mv.getEventHandlerOnOff().setTrafficLight(tl);
		mv.getEventHandlerAdvanceCycle().setTrafficLight(tl);
	}
}
