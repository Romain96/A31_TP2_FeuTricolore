package trafficLightView;

import java.awt.Color;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

import trafficLightController.TrafficLightAdvanceCycleEventHandler;
import trafficLightController.TrafficLightOnOffEventHandler;

public class TrafficLightMainView extends JFrame
{
	
	//attributes
	private TrafficLightGraphicalView graphicalView;
	private TrafficLightTextView textView;
	
	private TrafficLightOnOffEventHandler eventHandlerOnOff;
	private TrafficLightAdvanceCycleEventHandler eventHandlerAdvanceCycle;
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLightMainView()
	{
		this.setTitle("Traffic light main view");
		this.setSize(1000,1000);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		// creating the two sub frames
		this.graphicalView = new TrafficLightGraphicalView();
		this.textView = new TrafficLightTextView();
		
		// creating a desktop pane and adding the two sub frames (internal frames)
		JDesktopPane jdp = new JDesktopPane();
		jdp.add(this.graphicalView);
		jdp.add(this.textView);
		
		// setting the desktop pane as content of the current window
		this.setContentPane(jdp);
		
		// creating event handlers
		this.eventHandlerOnOff = new TrafficLightOnOffEventHandler(this);
		this.eventHandlerAdvanceCycle = new TrafficLightAdvanceCycleEventHandler(this);
		
		// binding the 2 event handlers to the 4 buttons (2 by 2)
		this.graphicalView.getButtonOnOff().addActionListener(this.eventHandlerOnOff);
		this.textView.getButtonOnOff().addActionListener(this.eventHandlerOnOff);
		this.graphicalView.getButtonAdvanceCycle().addActionListener(this.eventHandlerAdvanceCycle);
		this.textView.getButtonAdvanceCycle().addActionListener(this.eventHandlerAdvanceCycle);
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// getters/setters
	public TrafficLightOnOffEventHandler getEventHandlerOnOff() {
		return eventHandlerOnOff;
	}


	public void setEventHandlerOnOff(TrafficLightOnOffEventHandler eventHandlerOnOff) {
		this.eventHandlerOnOff = eventHandlerOnOff;
	}


	public TrafficLightAdvanceCycleEventHandler getEventHandlerAdvanceCycle() {
		return eventHandlerAdvanceCycle;
	}


	public void setEventHandlerAdvanceCycle(TrafficLightAdvanceCycleEventHandler eventHandlerAdvanceCycle) {
		this.eventHandlerAdvanceCycle = eventHandlerAdvanceCycle;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// updates both views (graphical & text)
	public void update(String instruction, Color color)
	{
		this.graphicalView.update(color);
		this.textView.update(instruction);
	}
}
