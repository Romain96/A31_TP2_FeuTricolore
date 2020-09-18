package trafficLightView;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import trafficLightController.TrafficLightRemoveTextEventHandler;

public class TrafficLightTextView extends JInternalFrame
{
	
	// attributes
	private static int uniqueIdGenerator = 1;
	
	private JButton buttonOnOff;
	private JButton buttonAdvanceCycle;
	private JLabel labelTrafficLightInstruction;
	private int id;
	private TrafficLightRemoveTextEventHandler eventHandlerRemoveText;
	
	
	///////////////////////////////////////////////////////////////////////////
		
		
	// constructor
	public TrafficLightTextView()
	{
		// generating GUI ID
		this.id = TrafficLightTextView.uniqueIdGenerator++;
		
		this.setTitle("Traffic light - text view #" + this.id);
		this.setSize(250,100);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		// creating components (buttons and label)
		this.buttonOnOff = new JButton("On/Off");
		this.buttonAdvanceCycle = new JButton("Advance");
		this.labelTrafficLightInstruction = new JLabel("The traffic light is not running.");	// empty text
		
		// creating a panel and adding components to the panel
		// using a FlowLayout as components placement manager
		JPanel jp = new JPanel(new FlowLayout());
		jp.add(this.buttonOnOff);
		jp.add(this.buttonAdvanceCycle);
		jp.add(this.labelTrafficLightInstruction);
		
		// adding the panel containing the 3 components as content of the current internal frame
		this.setContentPane(jp);
		
		// creating the destruction event handler (will be binded to the parent JFrame)
		this.eventHandlerRemoveText = new TrafficLightRemoveTextEventHandler(this);
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
		
		
	public JLabel getLabelTrafficLightInstruction()
	{
		return this.labelTrafficLightInstruction;
	}
	
	
	public int getId()
	{
		return this.id;
	}
	
	
	public TrafficLightRemoveTextEventHandler getEventHandlerRemoveText()
	{
		return this.eventHandlerRemoveText;
	}
		
		
	public void setButtonOnOff(JButton buttonOnOff)
	{
		this.buttonOnOff = buttonOnOff;
	}
		
		
	public void setButtonAdvanceCycle(JButton buttonAdvanceCycle)
	{
		this.buttonAdvanceCycle = buttonAdvanceCycle;
	}
		
		
	public void setLabelTrafficLightInstruction(JLabel trafficLightInstruction)
	{
		this.labelTrafficLightInstruction = trafficLightInstruction;
	}
	
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	
	public void setEventHandlerRemoveText(TrafficLightRemoveTextEventHandler eventHandlerRemoveText)
	{
		this.eventHandlerRemoveText = eventHandlerRemoveText;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// updates the displayed instruction
	public void update(String instruction)
	{
		this.labelTrafficLightInstruction.setText(instruction);
	}
}
