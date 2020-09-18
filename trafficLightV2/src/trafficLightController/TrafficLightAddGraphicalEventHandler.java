package trafficLightController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import trafficLightView.TrafficLightMainView;

public class TrafficLightAddGraphicalEventHandler implements ActionListener
{
	
	// attributes
	private TrafficLightMainView gui;
	
	
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
	
	
	public void setView(TrafficLightMainView gui)
	{
		this.gui = gui;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// adding a new graphical window (JInternalFrame)
	public void actionPerformed(ActionEvent e)
	{
		this.gui.addGraphicalView();
	}

}
