package trafficLightController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import trafficLightModel.TrafficLight;
import trafficLightModel.TrafficLightGermanModel;
import trafficLightView.TrafficLightMainView;

public class TrafficLightChooseGermanEventHandler implements ActionListener
{
	
	// attributes
	private TrafficLightMainView gui;
	private TrafficLight tl;
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLightChooseGermanEventHandler(TrafficLightMainView gui)
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
	
	
	// setting the context in the traffic light to be a German cycle
	public void actionPerformed(ActionEvent e)
	{
		// creating a new context with a German traffic light
		this.tl.getCycleContext().setCycleStrategy(new TrafficLightGermanModel());
		// resetting the traffic light
		this.tl.getCycleContext().getCycleStrategy().reset();
		this.gui.update(this.tl.getTrafficLightInstruction(), this.tl.getDisplayColor());
	}

}

