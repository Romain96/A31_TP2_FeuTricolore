package trafficLightModel;

public class TrafficLightGermanModel implements TrafficLightColorCycle 
{
	
	// attributes
	private TrafficLightColor currentColor;
	private TrafficLightColor nextColor;
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLightGermanModel()
	{
		this.currentColor = TrafficLightColor.RED;
		this.nextColor = TrafficLightColor.ORANGE;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// assuming this method only gets called when the traffic light is running
	// it modifies its attribute.
	// Note: German 4-steps : GREEN -> ORANGE -> RED -> ORANGE --> GREEN...
	public void advanceCycle() 
	{
		switch (this.currentColor)
		{
		case GREEN: 
			this.currentColor = TrafficLightColor.ORANGE;
			this.nextColor = TrafficLightColor.RED;
			break;
		
		case ORANGE:
			
			if (this.nextColor == TrafficLightColor.GREEN)
			{
				this.currentColor = TrafficLightColor.GREEN;
				this.nextColor = TrafficLightColor.ORANGE;
			}
			else if (this.nextColor == TrafficLightColor.RED)
			{
				this.currentColor = TrafficLightColor.RED;
				this.nextColor = TrafficLightColor.ORANGE;
			}
			break;
		
		case RED:
			this.currentColor = TrafficLightColor.ORANGE;
			this.nextColor = TrafficLightColor.GREEN;
			break;
		
		case GREY:
			this.currentColor = TrafficLightColor.GREY;
			this.nextColor = TrafficLightColor.GREY;
			break;
		}
	}
	
	
	public TrafficLightColor getCurrentColor()
	{
		return this.currentColor;
	}

}