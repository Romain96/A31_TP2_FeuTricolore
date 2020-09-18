package trafficLightView;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TrafficLightGraphicalView extends JInternalFrame
{
	
	// attributes
	private JButton buttonOnOff;
	private JButton buttonAdvanceCycle;
	private JLabel labelTrafficLightColor;
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLightGraphicalView()
	{
		this.setTitle("Traffic light (graphical view)");
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
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// updates the displayed color
	public void update(Color color)
	{
		this.labelTrafficLightColor.setBackground(color);
		this.labelTrafficLightColor.setOpaque(true);
	}
}
