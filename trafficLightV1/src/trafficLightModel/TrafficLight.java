package trafficLightModel;

public class TrafficLight {
	
	// attributes
	private boolean isRunning;	// whether the traffic light is running or not
	private TrafficLightColor color;	// current color
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLight()
	{
		this.isRunning = false;	// turned off by default
		this.color = TrafficLightColor.GREY;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// getters/setters
	public boolean getIsRunning()
	{
		return this.isRunning;
	}
	
	
	public TrafficLightColor getColor()
	{
		return this.color;
	}
	
	
	public void setRunning(boolean isRunning)
	{
		this.isRunning = isRunning;
	}
	
	
	public void setColor(TrafficLightColor color)
	{
		this.color = color;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// turn on/off the traffic light
	public void turnOnOff()
	{
		if (this.isRunning)
		{
			this.isRunning = false;
			this.color = TrafficLightColor.GREY;	// reset
		}
		else
		{
			this.isRunning = true;
			this.color = TrafficLightColor.RED;	// red by default when turning on the traffic light
		}
	}
	
	
	// moves one step forward in the traffic light cycle
	// using the 3-steps French cycle (G -> O -> R -> G...)
	public void advanceCycle()
	{
		// only changing color if the traffic light is running
		if (this.isRunning)
		{
			switch (this.color)
			{
			case GREEN: this.color = TrafficLightColor.ORANGE; break;
			case ORANGE: this.color = TrafficLightColor.RED; break;
			case RED: this.color = TrafficLightColor.GREEN; break;
			case GREY: break;	// not possible
			}
		}
	}
	
	
	// returns the instruction for drivers depending on the current traffic light's state
	// can be one of {"You can go", "Warning", "Stop", "The traffic light in not running."}
	public String getTrafficLightInstruction()
	{
		String instruction = "default instruction";
		
		if (this.isRunning)
		{
			switch (this.color)
			{
			case GREEN: instruction = "You can go !"; break;
			case ORANGE: instruction = "Warning !"; break;
			case RED: instruction = "Stop !"; break;
			case GREY: break;
			}
		}
		else
		{
			instruction = "The traffic light in not running.";
		}
		
		return instruction;
	}
	
	
	// overloading the toString method, useful for debugging
	public String toString()
	{
		String infos = "";
		infos = infos + "Traffic light state : " + this.isRunning + ", color : ";
		switch (this.color)
		{
		case GREEN: infos = infos + "Green"; break;
		case ORANGE: infos = infos + "Orange"; break;
		case RED: infos = infos + "Red"; break;
		case GREY: infos = infos + "Grey"; break;
		}
		
		return infos;
	}

}
