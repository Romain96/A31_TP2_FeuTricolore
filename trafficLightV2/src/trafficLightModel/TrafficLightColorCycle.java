package trafficLightModel;

public interface TrafficLightColorCycle
{
	// method to be implemented for specific traffic light types (French, German...)
	// takes the current traffic light's color and returns the new one
	public void advanceCycle();
	
	// to get the color
	public TrafficLightColor getCurrentColor();
}
