package trafficLightController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import trafficLightModel.TrafficLight;
import trafficLightView.TrafficLightMainView;

public class TrafficLightAddGraphicalEventHandler implements ActionListener
{
	
	// attributes
	private TrafficLightMainView gui;
	private TrafficLight tl;
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLightAddGraphicalEventHandler(TrafficLightMainView gui)
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
	
	
	// adding a new graphical window (JInternalFrame)
	public void actionPerformed(ActionEvent e)
	{
		this.gui.addGraphicalView();
		this.gui.update(this.tl.getTrafficLightInstruction(), this.tl.getDisplayColor());
	}

}
