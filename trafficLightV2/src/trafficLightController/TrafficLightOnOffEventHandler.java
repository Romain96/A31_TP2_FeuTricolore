package trafficLightController;

import trafficLightModel.*;
import trafficLightView.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrafficLightOnOffEventHandler implements ActionListener
{
	
	// attributes
	private TrafficLightMainView gui;	// main interface (GUI)
	private TrafficLight tl;	// traffic light object (model)
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor (taking the interface object as parameter)
	public TrafficLightOnOffEventHandler(TrafficLightMainView gui)
	{
		this.gui = gui;	// keeping a reference to the view
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

	// method being executed when the "on/off" button is pressed
	public void actionPerformed(ActionEvent e)
	{
		// calling on/off method on TrafficLight & updating the view
		this.tl.turnOnOff();
		this.gui.update(this.tl.getTrafficLightInstruction(), this.tl.getDisplayColor());
	}

}
