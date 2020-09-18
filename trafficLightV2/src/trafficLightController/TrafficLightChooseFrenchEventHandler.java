package trafficLightController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import trafficLightModel.TrafficLight;
import trafficLightModel.TrafficLightFrenchModel;
import trafficLightView.TrafficLightMainView;

public class TrafficLightChooseFrenchEventHandler implements ActionListener
{
	
	// attributes
	private TrafficLightMainView gui;
	private TrafficLight tl;
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLightChooseFrenchEventHandler(TrafficLightMainView gui)
	{
		this.gui = gui;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// getters/setters
	public TrafficLightMainView getView()
	{
		return this.gui;
	}
	
	
	public TrafficLight getTrafficLight()
	{
		return this.tl;
	}
	
	
	public void setView(TrafficLightMainView gui)
	{
		this.gui = gui;
	}
	
	
	public void setTrafficLight(TrafficLight tl)
	{
		this.tl = tl;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// setting the context in the traffic light to be a French cycle
	public void actionPerformed(ActionEvent e)
	{
		// creating a new context with a French traffic light
		this.tl.getCycleContext().setCycleStrategy(new TrafficLightFrenchModel());
		// resetting the traffic light
		this.tl.getCycleContext().getCycleStrategy().reset();
		this.gui.update(this.tl.getTrafficLightInstruction(), this.tl.getDisplayColor());
	}

}
