package trafficLightView;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TrafficLightGraphicalView extends JInternalFrame {
	
	// attributes
	private JButton buttonOnOff;
	private JButton buttonAdvanceCycle;
	private JLabel labelTrafficLightColor;
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLightGraphicalView()
	{
		this.setTitle("Traffic light (graphical view)");
		this.setSize(250,250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		// creating components (buttons and label)
		this.buttonOnOff = new JButton("On/Off");
		this.buttonAdvanceCycle = new JButton("Advance cycle");
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

}
