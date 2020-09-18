package trafficLightController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import trafficLightView.TrafficLightMainView;
import trafficLightView.TrafficLightTextView;

public class TrafficLightRemoveTextEventHandler implements ActionListener
{
	
	// attributes
	private TrafficLightTextView gui;
	private TrafficLightMainView parentGui;
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLightRemoveTextEventHandler(TrafficLightTextView gui)
	{
		this.gui = gui;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// getters/setters
	public TrafficLightMainView getParentView()
	{
		return this.parentGui;
	}
	
	
	public void setParentView(TrafficLightMainView parentGui)
	{
		this.parentGui = parentGui;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// calls the removeGraphical method of the main view (parent of the caller's frame)
	// with the id of the internal frame as argument
	public void actionPerformed(ActionEvent e)
	{
		this.parentGui.removeTextView(this.gui.getId());
	}

}

