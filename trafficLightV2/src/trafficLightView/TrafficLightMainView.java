package trafficLightView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import trafficLightController.TrafficLightAddGraphicalEventHandler;
import trafficLightController.TrafficLightAddTextEventHandler;
import trafficLightController.TrafficLightAdvanceCycleEventHandler;
import trafficLightController.TrafficLightOnOffEventHandler;

public class TrafficLightMainView extends JFrame
{
	
	//attributes
	private ArrayList<TrafficLightGraphicalView> graphicalViews;
	private ArrayList<TrafficLightTextView> textViews;
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem menuItemAddGraphical;
	private JMenuItem menuItemAddText;
	
	private TrafficLightOnOffEventHandler eventHandlerOnOff;
	private TrafficLightAdvanceCycleEventHandler eventHandlerAdvanceCycle;
	
	private TrafficLightAddGraphicalEventHandler eventHandlerAddGraphical;
	private TrafficLightAddTextEventHandler eventHandlerAddText;
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// constructor
	public TrafficLightMainView(int graphicalViews, int textViews)
	{
		
		this.setTitle("Traffic light main view");
		this.setSize(800,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		// creating event handlers (one for each action)
		this.eventHandlerOnOff = new TrafficLightOnOffEventHandler(this);
		this.eventHandlerAdvanceCycle = new TrafficLightAdvanceCycleEventHandler(this);
		
		// creating a desktop pane and adding the two sub frames (internal frames)
		JDesktopPane jdp = new JDesktopPane();
		
		// creating the sub frames & binding event handlers to buttons & adding all to the panel
		this.graphicalViews = new ArrayList<TrafficLightGraphicalView>();
		this.textViews = new ArrayList<TrafficLightTextView>();
		
		for (int i = 0; i < graphicalViews; i++)
		{
			TrafficLightGraphicalView g = new TrafficLightGraphicalView();
			g.getButtonOnOff().addActionListener(this.eventHandlerOnOff);
			g.getButtonAdvanceCycle().addActionListener(this.eventHandlerAdvanceCycle);
			this.graphicalViews.add(g);
			jdp.add(g);
		}
		
		for (int i = 0; i < textViews; i++)
		{
			TrafficLightTextView t = new TrafficLightTextView();
			t.getButtonOnOff().addActionListener(this.eventHandlerOnOff);
			t.getButtonAdvanceCycle().addActionListener(this.eventHandlerAdvanceCycle);
			this.textViews.add(t);
			jdp.add(t);
		}
		
		
		// creating a menu bar
		this.menuBar = new JMenuBar();
		this.menu = new JMenu("Options");
		this.menu.setMnemonic(KeyEvent.VK_A);
		this.menu.getAccessibleContext().setAccessibleDescription("Opening program options");
		this.menuBar.add(this.menu);
				
		// adding a new graphical window
		this.menuItemAddGraphical = new JMenuItem("Add a new graphical window", KeyEvent.VK_T);
		this.menuItemAddGraphical.getAccessibleContext().setAccessibleDescription("This adds a new graphical window");
		this.menu.add(this.menuItemAddGraphical);
		this.eventHandlerAddGraphical = new TrafficLightAddGraphicalEventHandler(this);
		this.menuItemAddGraphical.addActionListener(this.eventHandlerAddGraphical);
				
		// adding a new text window
		this.menuItemAddText = new JMenuItem("Add a new text window", KeyEvent.VK_T);
		this.menuItemAddText.getAccessibleContext().setAccessibleDescription("This adds a new text window");
		this.menu.add(this.menuItemAddText);
		this.eventHandlerAddText = new TrafficLightAddTextEventHandler(this);
		this.menuItemAddText.addActionListener(this.eventHandlerAddText);
			
		this.setJMenuBar(this.menuBar);
		
		
		// setting the desktop pane as content of the current window
		this.setContentPane(jdp);
		
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
	
	
	// adds a new graphical view
	public void addGraphicalView()
	{		
		TrafficLightGraphicalView gui = new TrafficLightGraphicalView();
		gui.getButtonOnOff().addActionListener(this.eventHandlerOnOff);
		gui.getButtonAdvanceCycle().addActionListener(this.eventHandlerAdvanceCycle);
		this.graphicalViews.add(gui);
		this.getContentPane().add(gui);
	}
	
	
	
	// adds a new graphical view
	public void addTextView()
	{		
		TrafficLightTextView gui = new TrafficLightTextView();
		gui.getButtonOnOff().addActionListener(this.eventHandlerOnOff);
		gui.getButtonAdvanceCycle().addActionListener(this.eventHandlerAdvanceCycle);
		this.textViews.add(gui);
		this.getContentPane().add(gui);
	}
	
	
	// updates both views (graphical & text)
	public void update(String instruction, Color color)
	{
		for (int i = 0; i < this.graphicalViews.size(); i++)
		{
			this.graphicalViews.get(i).update(color);
		}
		
		for (int i = 0; i < this.textViews.size(); i++)
		{
			this.textViews.get(i).update(instruction);
		}
	}
}
