package trafficLightView;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import trafficLightController.TrafficLightRemoveGraphicalEventHandler;

public class TrafficLightGraphicalView extends JInternalFrame
{
	
	// attributes
	private static int uniqueIdGenerator = 1;
	
	private JButton buttonOnOff;
	private JButton buttonAdvanceCycle;
	private JLabel labelTrafficLightColor;
	private int id;
	private TrafficLightRemoveGraphicalEventHandler eventHandlerRemoveGraphical;
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLightGraphicalView()
	{
		// generating GUI ID
		this.id = TrafficLightGraphicalView.uniqueIdGenerator++;
		
		this.setTitle("Traffic light - graphical view #" + this.id);
		this.setSize(250,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		// creating components (buttons and label)
		this.buttonOnOff = new JButton("On/Off");
		this.buttonAdvanceCycle = new JButton("Advance");
		this.labelTrafficLightColor = new JLabel("      ");	// empty text
		this.labelTrafficLightColor.setOpaque(true);
		this.labelTrafficLightColor.setBackground(Color.gray);
		
		// creating a panel and adding components to the panel
		// using a FlowLayout as components placement manager
		JPanel jp = new JPanel(new FlowLayout());
		jp.add(this.buttonOnOff);
		jp.add(this.buttonAdvanceCycle);
		jp.add(this.labelTrafficLightColor);
		
		// adding the panel containing the 3 components as content of the current internal frame
		this.setContentPane(jp);
		
		// creating the destruction event handler (will be binded to the parent JFrame)
		this.eventHandlerRemoveGraphical = new TrafficLightRemoveGraphicalEventHandler(this);
	}
	

	///////////////////////////////////////////////////////////////////////////
	
	
	// getters/setters
	public JButton getButtonOnOff()
	{
		return this.buttonOnOff;
	}
	
	
	public JButton getButtonAdvanceCycle()
	{
		return this.buttonAdvanceCycle;
	}
	
	
	public JLabel getLabelTrafficLightColor()
	{
		return this.labelTrafficLightColor;
	}
	
	
	public int getId()
	{
		return this.id;
	}
	
	
	public TrafficLightRemoveGraphicalEventHandler getEventHandlerRemoveGraphical()
	{
		return this.eventHandlerRemoveGraphical;
	}
	
	
	public void setButtonOnOff(JButton buttonOnOff)
	{
		this.buttonOnOff = buttonOnOff;
	}
	
	
	public void setButtonAdvanceCycle(JButton buttonAdvanceCycle)
	{
		this.buttonAdvanceCycle = buttonAdvanceCycle;
	}
	
	
	public void setLabelTrafficLightColor(JLabel trafficLightColor)
	{
		this.labelTrafficLightColor = trafficLightColor;
	}
	
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	
	public void setEventHandlerRemoveGraphical(TrafficLightRemoveGraphicalEventHandler eventHandlerRemoveGraphical)
	{
		this.eventHandlerRemoveGraphical = eventHandlerRemoveGraphical;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// updates the displayed color
	public void update(Color color)
	{
		this.labelTrafficLightColor.setBackground(color);
		this.labelTrafficLightColor.setOpaque(true);
	}
}
