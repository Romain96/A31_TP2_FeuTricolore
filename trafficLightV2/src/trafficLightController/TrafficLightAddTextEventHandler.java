package trafficLightController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import trafficLightView.TrafficLightMainView;

public class TrafficLightAddTextEventHandler implements ActionListener
{
	
	// attributes
	private TrafficLightMainView gui;
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLightAddTextEventHandler(TrafficLightMainView gui)
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
		this.gui.addTextView();
	}

}

