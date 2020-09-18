package trafficLightView;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;

public class TrafficLightMainView extends JFrame {
	
	//attributes
	private TrafficLightGraphicalView graphicalView;
	private TrafficLightTextView textView;
	
	
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
	}

}
