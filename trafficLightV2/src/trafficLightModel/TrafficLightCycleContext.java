package trafficLightModel;

public class TrafficLightCycleContext 
{
	
	// attributes
	private TrafficLightColorCycle cycleStrategy;
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor - choosing a concrete cycle implementation (French/German)
	public TrafficLightCycleContext(TrafficLightColorCycle cycleStrategy)
	{
		this.cycleStrategy = cycleStrategy;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// getters/setters
	public TrafficLightColorCycle getCycleStrategy()
	{
		return this.cycleStrategy;
	}
	
	
	public void setCycleStrategy(TrafficLightColorCycle cycleStrategy)
	{
		this.cycleStrategy = cycleStrategy;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// executing the strategy - changing color and returning the new one
	public void advanceCycle()
	{
		this.cycleStrategy.advanceCycle();
	}
	
}
