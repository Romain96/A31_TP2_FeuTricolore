package trafficLightModel;

public interface TrafficLightColorCycle
{
	// method to be implemented for specific traffic light types (French, German...)
	public void advanceCycle();
	// method to be implemented for turning on/off the traffic light
	public void turnOnOff();
	// method to be implemented for resetting the traffic light
	public void reset();
	
	// to get the color & the state
	public TrafficLightColor getCurrentColor();
	public boolean getIsRunning();
}
