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
import trafficLightController.TrafficLightChooseFrenchEventHandler;
import trafficLightController.TrafficLightChooseGermanEventHandler;
import trafficLightController.TrafficLightOnOffEventHandler;

public class TrafficLightMainView extends JFrame
{
	
	//attributes
	private ArrayList<TrafficLightGraphicalView> graphicalViews;	// all graphical views
	private ArrayList<TrafficLightTextView> textViews;				// all text views
	
	private JMenuBar menuBar;
	private JMenu menu;
	
	private JMenu submenuChangeTrafficLight;	// switch traffic light type (French/German)
	private JMenu submenuAddView;				// add new views (graphical/text)
	private JMenu submenuRemoveView;			// remove views (graphical/text)
	private JMenu submenuRemoveGraphical;
	private JMenu submenuRemoveText;
	
	private JMenuItem menuItemChooseFrench;		// choosing a French traffic light - submenuChangeTrafficLight
	private JMenuItem menuItemChooseGerman;		// choosing a German traffic light - submenuChangeTrafficLight
	
	private JMenuItem menuItemAddGraphical;		// adding a new graphical view - submenuAddView
	private JMenuItem menuItemAddText;			// adding a new text view - submenuAddView
	
	private TrafficLightOnOffEventHandler eventHandlerOnOff;
	private TrafficLightAdvanceCycleEventHandler eventHandlerAdvanceCycle;
	
	private TrafficLightChooseFrenchEventHandler eventHandlerChooseFrench;
	private TrafficLightChooseGermanEventHandler eventHandlerChooseGerman;
	
	private TrafficLightAddGraphicalEventHandler eventHandlerAddGraphical;
	private TrafficLightAddTextEventHandler eventHandlerAddText;
	
	private ArrayList<JMenuItem> menuItemGraphicalViews;
	private ArrayList<JMenuItem> menuItemTextViews;
	
	
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
		
		this.menuItemGraphicalViews = new ArrayList<JMenuItem>();
		this.menuItemTextViews = new ArrayList<JMenuItem>();
		
		// creating a desktop pane and adding the two sub frames (internal frames)
		JDesktopPane jdp = new JDesktopPane();
		
		// creating the sub frames & binding event handlers to buttons & adding all to the panel
		this.graphicalViews = new ArrayList<TrafficLightGraphicalView>();
		this.textViews = new ArrayList<TrafficLightTextView>();
		
		for (int i = 0; i < graphicalViews; i++)
		{
			// creating a new graphical view
			TrafficLightGraphicalView g = new TrafficLightGraphicalView();
			
			// binding both buttons to event handlers
			g.getButtonOnOff().addActionListener(this.eventHandlerOnOff);
			g.getButtonAdvanceCycle().addActionListener(this.eventHandlerAdvanceCycle);
			
			// setting the parent view of the removal event handler
			g.getEventHandlerRemoveGraphical().setParentView(this);
			
			// adding a new item into the menu
			JMenuItem item = new JMenuItem("remove #" + g.getId());
			item.addActionListener(g.getEventHandlerRemoveGraphical());
			this.menuItemGraphicalViews.add(item);
			this.graphicalViews.add(g);
			
			// adding the window to the JFrame
			jdp.add(g);
		}
		
		for (int i = 0; i < textViews; i++)
		{
			// creating a new graphical view
			TrafficLightTextView t = new TrafficLightTextView();
			
			// binding both buttons to event handlers
			t.getButtonOnOff().addActionListener(this.eventHandlerOnOff);
			t.getButtonAdvanceCycle().addActionListener(this.eventHandlerAdvanceCycle);
			
			// setting the parent view of the removal event handler
			t.getEventHandlerRemoveText().setParentView(this);
			
			// adding a new item into the menu
			JMenuItem item = new JMenuItem("remove #" + t.getId());
			item.addActionListener(t.getEventHandlerRemoveText());
			this.menuItemTextViews.add(item);
			this.textViews.add(t);
			
			// adding the window to the JFrame
			jdp.add(t);
		}
		
		
		// creating a menu bar
		this.menuBar = new JMenuBar();
		this.menu = new JMenu("Options");
		this.menu.setMnemonic(KeyEvent.VK_A);
		this.menu.getAccessibleContext().setAccessibleDescription("Opening program options");
		this.menuBar.add(this.menu);
		
		// creating a sub menu dedicated to traffic light cycle choice
		this.submenuChangeTrafficLight  = new JMenu("Choose traffic light");
		this.submenuChangeTrafficLight.setMnemonic(KeyEvent.VK_A);
		this.submenuChangeTrafficLight.getAccessibleContext().setAccessibleDescription("Choose a traffic light type");
		this.menu.add(this.submenuChangeTrafficLight);
		
		// choosing a French traffic light
		this.menuItemChooseFrench = new JMenuItem("French 3-steps", KeyEvent.VK_T);
		this.menuItemChooseFrench.getAccessibleContext().setAccessibleDescription("This changes the traffic light to a French model");
		this.submenuChangeTrafficLight.add(this.menuItemChooseFrench);
		this.eventHandlerChooseFrench = new TrafficLightChooseFrenchEventHandler(this);
		this.menuItemChooseFrench.addActionListener(this.eventHandlerChooseFrench);
		
		// choosing a German traffic light
		this.menuItemChooseGerman = new JMenuItem("German 4-steps", KeyEvent.VK_T);
		this.menuItemChooseGerman.getAccessibleContext().setAccessibleDescription("This changes the traffic light to a German model");
		this.submenuChangeTrafficLight.add(this.menuItemChooseGerman);
		this.eventHandlerChooseGerman = new TrafficLightChooseGermanEventHandler(this);
		this.menuItemChooseGerman.addActionListener(this.eventHandlerChooseGerman);
				
		// creating a sub menu dedicated to view addition
		this.submenuAddView = new JMenu("Adding windows");
		this.submenuAddView.setMnemonic(KeyEvent.VK_A);
		this.submenuAddView.getAccessibleContext().setAccessibleDescription("Adding graphical or text windows");
		this.menu.addSeparator();
		this.menu.add(this.submenuAddView);
		
		// adding a new graphical window
		this.menuItemAddGraphical = new JMenuItem("Add a new graphical window", KeyEvent.VK_T);
		this.menuItemAddGraphical.getAccessibleContext().setAccessibleDescription("This adds a new graphical window");
		this.submenuAddView.add(this.menuItemAddGraphical);
		this.eventHandlerAddGraphical = new TrafficLightAddGraphicalEventHandler(this);
		this.menuItemAddGraphical.addActionListener(this.eventHandlerAddGraphical);
				
		// adding a new text window
		this.menuItemAddText = new JMenuItem("Add a new text window", KeyEvent.VK_T);
		this.menuItemAddText.getAccessibleContext().setAccessibleDescription("This adds a new text window");
		this.submenuAddView.add(this.menuItemAddText);
		this.eventHandlerAddText = new TrafficLightAddTextEventHandler(this);
		this.menuItemAddText.addActionListener(this.eventHandlerAddText);
		
		// creating a sub menu dedicated to view removal
		this.submenuRemoveView = new JMenu("Removing windows");
		this.submenuRemoveView.setMnemonic(KeyEvent.VK_A);
		this.submenuRemoveView.getAccessibleContext().setAccessibleDescription("Removing graphical or text windows");
		this.menu.addSeparator();
		this.menu.add(this.submenuRemoveView);
		
		// creating a sub sub menu dedicated to graphical view removal
		this.submenuRemoveGraphical = new JMenu("Removing graphical windows");
		this.submenuRemoveGraphical.setMnemonic(KeyEvent.VK_A);
		this.submenuRemoveGraphical.getAccessibleContext().setAccessibleDescription("Removing a graphical windows");
		this.submenuRemoveView.addSeparator();
		this.submenuRemoveView.add(this.submenuRemoveGraphical);
		
		// removing a graphical window
		for (int i = 0; i < this.menuItemGraphicalViews.size(); i++)
		{
			this.submenuRemoveGraphical.add(this.menuItemGraphicalViews.get(i));
		}
		
		// creating a sub sub menu dedicated to text view removal
		this.submenuRemoveText = new JMenu("Removing text windows");
		this.submenuRemoveText.setMnemonic(KeyEvent.VK_A);
		this.submenuRemoveText.getAccessibleContext().setAccessibleDescription("Removing a text windows");
		this.submenuRemoveView.addSeparator();
		this.submenuRemoveView.add(this.submenuRemoveText);
				
		// removing a graphical window
		for (int i = 0; i < this.menuItemTextViews.size(); i++)
		{
			this.submenuRemoveText.add(this.menuItemTextViews.get(i));
		}
			
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
	
	
	public TrafficLightAddGraphicalEventHandler getEventHandlerAddGraphgical()
	{
		return this.eventHandlerAddGraphical;
	}
	
	
	public TrafficLightAddTextEventHandler getEventHandlerAddText()
	{
		return this.eventHandlerAddText;
	}
	
	
	public TrafficLightChooseFrenchEventHandler getEventHandlerChooseFrench()
	{
		return this.eventHandlerChooseFrench;
	}
	
	
	public TrafficLightChooseGermanEventHandler getEventHandlerChooseGerman()
	{
		return this.eventHandlerChooseGerman;
	}


	public TrafficLightAdvanceCycleEventHandler getEventHandlerAdvanceCycle() {
		return eventHandlerAdvanceCycle;
	}


	public void setEventHandlerAdvanceCycle(TrafficLightAdvanceCycleEventHandler eventHandlerAdvanceCycle) {
		this.eventHandlerAdvanceCycle = eventHandlerAdvanceCycle;
	}
	
	
	public void setEventHandlerChooseFrench(TrafficLightChooseFrenchEventHandler eventHandlerChooseFrench)
	{
		this.eventHandlerChooseFrench = eventHandlerChooseFrench;
	}
	
	
	public void setEventHandlerChooseGerman(TrafficLightChooseGermanEventHandler eventHandlerChooseGerman)
	{
		this.eventHandlerChooseGerman = eventHandlerChooseGerman;
	}
	
	
	public void setEventHandlerAddGraphival(TrafficLightAddGraphicalEventHandler eventHandlerAddGraphical)
	{
		this.eventHandlerAddGraphical = eventHandlerAddGraphical;
	}
	
	
	public void setEventHandlerAddText(TrafficLightAddTextEventHandler eventHandlerAddText)
	{
		this.eventHandlerAddText = eventHandlerAddText;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	
	// adds a new graphical view
	public void addGraphicalView()
	{		
		// creating a new window
		TrafficLightGraphicalView gui = new TrafficLightGraphicalView();
		
		// binding both buttons to event handlers
		gui.getButtonOnOff().addActionListener(this.eventHandlerOnOff);
		gui.getButtonAdvanceCycle().addActionListener(this.eventHandlerAdvanceCycle);
		
		// setting parent (JFrame) for the removal event handler
		gui.getEventHandlerRemoveGraphical().setParentView(this);
		
		// creating a new menu item & binding the removal event handler to this item
		JMenuItem item = new JMenuItem("remove #" + gui.getId());
		item.addActionListener(gui.getEventHandlerRemoveGraphical());
		
		// adding the item to the menu
		this.menuItemGraphicalViews.add(item);
		this.submenuRemoveGraphical.add(item);
		
		// and the window to the JFrame
		this.graphicalViews.add(gui);
		this.getContentPane().add(gui);
	}
	
	
	// adds a new graphical view
	public void addTextView()
	{		
		// creating a new window
		TrafficLightTextView gui = new TrafficLightTextView();
		
		// binding both buttons to event handlers
		gui.getButtonOnOff().addActionListener(this.eventHandlerOnOff);
		gui.getButtonAdvanceCycle().addActionListener(this.eventHandlerAdvanceCycle);
		
		// setting parent (JFrame) for the removal event handler
		gui.getEventHandlerRemoveText().setParentView(this);
		
		// creating a new menu item & binding the removal event handler to this item
		JMenuItem item = new JMenuItem("remove #" + gui.getId());
		item.addActionListener(gui.getEventHandlerRemoveText());
		
		// adding the item to the menu
		this.menuItemTextViews.add(item);
		this.submenuRemoveText.add(item);
		
		// and the window to the JFrame
		this.textViews.add(gui);
		this.getContentPane().add(gui);
	}
	
	
	public void removeGraphicalView(int id)
	{
		// finding the item of the graphical window
		for (int i = 0; i < this.graphicalViews.size(); i++)
		{
			if (this.graphicalViews.get(i).getId() == id)
			{
				this.submenuRemoveGraphical.remove(i);
				this.menuItemGraphicalViews.remove(i);
				this.graphicalViews.get(i).dispose();
				this.graphicalViews.remove(i);
			}
		}
	}
	
	
	
	public void removeTextView(int id)
	{
		// finding the item of the text window
		for (int i = 0; i < this.textViews.size(); i++)
		{
			if (this.textViews.get(i).getId() == id)
			{
				this.submenuRemoveText.remove(i);
				this.menuItemTextViews.remove(i);
				this.textViews.get(i).dispose();
				this.textViews.remove(i);
			}
		}
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
