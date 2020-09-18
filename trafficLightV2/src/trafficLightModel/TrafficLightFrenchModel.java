package trafficLightModel;

public class TrafficLightFrenchModel implements TrafficLightColorCycle 
{
	
	// attributes
	private TrafficLightColor currentColor;
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLightFrenchModel()
	{
		this.currentColor = TrafficLightColor.RED;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// assuming this method only gets called when the traffic light is running
	// it modifies its attribute.
	// Note: French 3-steps : GREEN -> ORANGE -> RED --> GREEN...
	public void advanceCycle() 
	{
		switch (this.currentColor)
		{
		case GREEN: 
			this.currentColor = TrafficLightColor.ORANGE;
			break;
		
		case ORANGE:
			this.currentColor = TrafficLightColor.RED;
			break;
		
		case RED:
			this.currentColor = TrafficLightColor.GREEN;
			break;
		
		case GREY:
			this.currentColor = TrafficLightColor.GREY;
			break;
		}
	}
	
	
	public TrafficLightColor getCurrentColor()
	{
		return this.currentColor;
	}

}
