package trafficLightModel;

import java.awt.Color;

public class TrafficLight {
	
	// attributes
	private TrafficLightCycleContext cycleContext;	// context containing a appropriate cycle implementation
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLight(TrafficLightColorCycle trafficLightType)
	{
		// creating a new cycle context using the given traffic light type
		this.cycleContext = new TrafficLightCycleContext(trafficLightType);
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// getters/setters	
	public TrafficLightCycleContext getCycleContext()
	{
		return this.cycleContext;
	}
	
	
	public void setCycleContext(TrafficLightCycleContext cycleContext)
	{
		this.cycleContext = cycleContext;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// turn on/off the traffic light
	public void turnOnOff()
	{
		this.cycleContext.getCycleStrategy().turnOnOff();
	}
	
	
	// moves one step forward in the traffic light cycle using the strategy provided in the context
	public void advanceCycle()
	{
		this.cycleContext.advanceCycle();
	}
	
	
	// returns the instruction for drivers depending on the current traffic light's state
	// can be one of {"You can go", "Warning", "Stop", "The traffic light in not running."}
	public String getTrafficLightInstruction()
	{
		String instruction = "default instruction";
		TrafficLightColor color = this.cycleContext.getCycleStrategy().getCurrentColor();
		
		if (this.cycleContext.getCycleStrategy().getIsRunning())
		{
			switch (color)
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
	
	
	// returns the color to display in the view (java.awt.color)
	public Color getDisplayColor()
	{
		Color color = Color.gray;
		TrafficLightColor currentColor = this.cycleContext.getCycleStrategy().getCurrentColor();
		
		switch (currentColor)
		{
		case GREEN: color = Color.green; break;
		case ORANGE: color = Color.orange; break;
		case RED: color = Color.red; break;
		case GREY: color = Color.gray; break;
		}
		
		return color;
	}
	
	
	// overloading the toString method, useful for debugging
	public String toString()
	{
		String infos = "";
		infos = infos + "Traffic light state : " + this.cycleContext.getCycleStrategy().getIsRunning() + ", color : ";
		TrafficLightColor currentColor = this.cycleContext.getCycleStrategy().getCurrentColor();
		
		switch (currentColor)
		{
		case GREEN: infos = infos + "Green"; break;
		case ORANGE: infos = infos + "Orange"; break;
		case RED: infos = infos + "Red"; break;
		case GREY: infos = infos + "Grey"; break;
		}
		
		return infos;
	}

}
