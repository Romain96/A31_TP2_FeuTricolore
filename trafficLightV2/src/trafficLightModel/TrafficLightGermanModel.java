package trafficLightModel;

public class TrafficLightGermanModel implements TrafficLightColorCycle 
{
	
	// attributes
	private TrafficLightColor currentColor;
	private TrafficLightColor nextColor;
	private boolean isRunning;
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLightGermanModel()
	{
		this.currentColor = TrafficLightColor.GREY;
		this.nextColor = TrafficLightColor.RED;
		this.isRunning = false;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// Note: German 4-steps : GREEN -> ORANGE -> RED -> ORANGE --> GREEN...
	public void advanceCycle() 
	{
		if (this.isRunning)
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
		else
		{
			this.currentColor = TrafficLightColor.GREY;
			this.nextColor = TrafficLightColor.RED;
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
	
	
	public void reset()
	{
		this.isRunning = false;
		this.currentColor = TrafficLightColor.GREY;
		this.nextColor = TrafficLightColor.RED;
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