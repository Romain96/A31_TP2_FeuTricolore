package trafficLightController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import trafficLightView.TrafficLightGraphicalView;
import trafficLightView.TrafficLightMainView;

public class TrafficLightRemoveGraphicalEventHandler implements ActionListener 
{
	
	// attributes
	private TrafficLightGraphicalView gui;
	private TrafficLightMainView parentGui;
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLightRemoveGraphicalEventHandler(TrafficLightGraphicalView gui)
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
		this.parentGui.removeGraphicalView(this.gui.getId());
	}

}
