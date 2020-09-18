package trafficLightModel;

public class TrafficLightFrenchModel implements TrafficLightColorCycle 
{
	
	// attributes
	private TrafficLightColor currentColor;
	private boolean isRunning;
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLightFrenchModel()
	{
		this.currentColor = TrafficLightColor.GREY;
		this.isRunning = false;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// Note: French 3-steps : GREEN -> ORANGE -> RED --> GREEN...
	public void advanceCycle() 
	{
		if (this.isRunning)
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
		else
		{
			this.currentColor = TrafficLightColor.GREY;
		}
	}
	
	
	public void turnOnOff()
	{
		if (this.isRunning)
		{
			this.isRunning = false;
			this.currentColor = TrafficLightColor.GREY;
		}
		else
		{
			this.isRunning = true;
			this.currentColor = TrafficLightColor.RED;
		}
	}
	
	
	///////////////////////////////////////////////////////////////////////////

	
	// getters
	public TrafficLightColor getCurrentColor()
	{
		return this.currentColor;
	}
	
	
	public boolean getIsRunning()
	{
		return this.isRunning;
	}

}
