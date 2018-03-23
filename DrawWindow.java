package Application;
//These imports have been initialized by Eclipse WindowBuilder 2018
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
//import GeometryPack.GeometryPack;
//for when the GeometryPack is a package in github MainApp
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * This class is build to contain all the necessary components 
 * of the user friendly interface of the geometry application build by the 
 * class Data Structure Spring 2018. It hosts the instantiations of the canvas
 * J object and the listeners of the panels that contain the buttons.
 * This class contains no logic but rather builds the graphic design for the application. 
 * 
 * @author Ioanna Deni
 * @contributor Kiera McCabe
 * @version Feb. 2018
 *
 */

public class DrawWindow extends JComponent implements ActionListener{
	//Since it is a frame it extends JComponents and has general listeners
	//that apply to the windows functionality
	
	//Instance of the database - TO BE EDITTED
	private DB db = new DB();
	DecimalFormat df = new DecimalFormat("###.###");
	
	
	//Frame for the application that is divided in 5 parts
	private JFrame frame; 
	
	
	
	//PART 1: THE TOP PANEL - MENUBAR
	
	//This menu hosts the different tabs like "File" "Edit" and "Help"
	private final JMenuBar menuBar = new JMenuBar(); 
	//Drop-down options in the menu bar 
	private final JMenu mnMenu = new JMenu("File"); 
	private final JMenu mnSettings = new JMenu("Settings");
	private final JMenu mnHelp = new JMenu("Help");
	private final JMenu mnEdit = new JMenu("Edit");
	// The different items added have temporary names and no functionality 
	// *THEY ARE EXAMPLES*
	private final JMenuItem mntmNewFile = new JMenuItem("New File");
	private final JMenuItem mntmSave = new JMenuItem("Save");
	private final JMenuItem mntmExport = new JMenuItem("Export");
	private final JMenuItem Exit = new JMenuItem("Exit");
	private final JMenuItem mntmUndo = new JMenuItem("Undo");
	private final JMenuItem mntmRedo = new JMenuItem("Redo");
	private final JMenuItem mntmCopy = new JMenuItem("Copy");
	private final JMenuItem mntmMouseMode = new JMenuItem("Mouse Mode");
	private final JMenuItem mntmSystem = new JMenuItem("System");
	private final JMenuItem mntmContactUs = new JMenuItem("Contact us");
	
	
	
	//PART 2: THE SECOND TOP PANEL - SHORTCUTS BUTTONS
	
	//This toolBar will host the buttons on the top of the window under the menuBar
	private final JToolBar toolBar = new JToolBar();	
	// The different buttons added have temporary names and no functionality 
	// *THEY ARE EXAMPLES*
	private final JButton cutButton = new JButton("");
	private final JButton copyButton = new JButton("");
	private final JButton pasteButton = new JButton("");
	private final JButton redoButton = new JButton("");
	private final JButton undoButton = new JButton("");
	private final JButton thicknessButton = new JButton("");
	private final JButton wordsButton = new JButton("");
	private final JButton newFileButton = new JButton("");
	private final JButton playButton = new JButton("");
	private final JButton saveButton = new JButton("");
	private final JButton lineModeButton = new JButton("");
	private final JButton angleButton = new JButton("");	
	
	
	//PART 3: MIDDLE CANVAS AREA
	
	//This is temporary the name of the canvas object
	private DrawLineAndPoint canvasGUI = new DrawLineAndPoint(db);
	
	
	
//	//PART 4: LEFT PANEL - SIDE BUTTONS 
//	
//	//This second toolBar hosts the side buttons of the window
//	private final JToolBar toolBar_1 = new JToolBar();
//	// The different buttons added have temporary names and no functionality 
//	// *THEY ARE EXAMPLES*
//	private final JButton revTriangle = new JButton("");
//	private final JButton triangle = new JButton("");
//	private final JButton squares = new JButton("");
//	private final JButton circle = new JButton("");
//	private final JButton lineRight = new JButton("");
//	private final JButton lineUp = new JButton("");
//	private final JButton lineLeft = new JButton("");
//	private final JButton makeBigger = new JButton("");
//	private final JButton makeSmaller = new JButton("");
	
	
	
	//PART 5: BOTTOM LABEL - CANVAS TAB
	
	//This label is at the bottom of the window and exist because we aim to be able to work in 
	//multiple canvases at the same time like excel and tabs
	private final JLabel bottomLabel = new JLabel("Canvas 1");
	
	//For initializing the geometry pathway
	private GeometryPack geom = new GeometryPack();
	
	// THE FOLLOWING COMMENTED LINES ARE IMPORTANT
	// **DO NOT DELETE**
	// They are used in window builder as coordinates to make the presentation 
	// If deleted the window will not be generated - but they remain the same so 
	// if copy pasted they should work
		
	/**
	 * @wbp.nonvisual location=64,179
	 */
	/**
	 * Launch the application.
	 *
	 */
	public static void main(String[] args) {
		// this is the main function necessary to run the application
		EventQueue.invokeLater(new Runnable() {
			// It runs - so we can add animations too 
			public void run() {
				try {
					//Creates a new window and makes it visible
					DrawWindow window = new DrawWindow();
					window.frame.setVisible(true);
					// and catches exceptions generated by the window builder
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DrawWindow() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//Creates the frame for the application and sets its size and 
		//closing procedure
		frame = new JFrame();
		frame.setBounds(100, 100, 873, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		//adds the different JComponents in the frame
		frame.setJMenuBar(menuBar);
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		frame.getContentPane().add(canvasGUI, BorderLayout.CENTER);
		frame.getContentPane().add(bottomLabel, BorderLayout.SOUTH);
//		frame.getContentPane().add(toolBar_1, BorderLayout.WEST);
		
		
		//adds the buttons in the top menuBar   
		menuBar.add(mnMenu);
		mnMenu.add(mntmNewFile);
		mnMenu.add(mntmSave);
		mnMenu.add(mntmExport);
		mnMenu.add(Exit);
		menuBar.add(mnEdit);
		mnEdit.add(mntmUndo);
		mnEdit.add(mntmRedo);
		mnEdit.add(mntmCopy);
		menuBar.add(mnSettings);
		mnSettings.add(mntmMouseMode);
		mnSettings.add(mntmSystem);
		menuBar.add(mnHelp);
		mnHelp.add(mntmContactUs);
		// This will give a better color and fond to the Menu options on the menu bar
		mnMenu.setForeground(SystemColor.menuText);
		mnHelp.setForeground(SystemColor.menuText);
		mnSettings.setForeground(SystemColor.menuText);
		mnEdit.setForeground(SystemColor.menuText);
		
		// adds the buttons to the toolBar at the top of the window under the menuBar
		toolBar.add(newFileButton);
		toolBar.add(saveButton);
		toolBar.add(cutButton);
		toolBar.add(copyButton);
		toolBar.add(pasteButton);
		toolBar.add(redoButton);
		toolBar.add(undoButton);
		toolBar.add(thicknessButton);
		toolBar.add(wordsButton);
		toolBar.add(playButton);
		toolBar.add(lineModeButton);
		toolBar.add(angleButton);
		// These buttons have no displayed text only an icon provided by eclipse - see readme for more info
		newFileButton.setIcon(new ImageIcon(DrawWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/file.gif")));
		saveButton.setIcon(new ImageIcon(DrawWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		cutButton.setIcon(new ImageIcon(DrawWindow.class.getResource("/com/sun/javafx/scene/web/skin/Cut_16x16_JFX.png")));
		copyButton.setIcon(new ImageIcon(DrawWindow.class.getResource("/com/sun/javafx/scene/web/skin/Copy_16x16_JFX.png")));
		pasteButton.setIcon(new ImageIcon(DrawWindow.class.getResource("/com/sun/javafx/scene/web/skin/Paste_16x16_JFX.png")));
		redoButton.setIcon(new ImageIcon(DrawWindow.class.getResource("/com/sun/javafx/scene/web/skin/Redo_16x16_JFX.png")));
		undoButton.setIcon(new ImageIcon(DrawWindow.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		thicknessButton.setIcon(new ImageIcon(DrawWindow.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		wordsButton.setIcon(new ImageIcon(DrawWindow.class.getResource("/com/sun/javafx/scene/web/skin/Bold_16x16_JFX.png")));
		playButton.setIcon(new ImageIcon(DrawWindow.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaPlayDisabled.png")));		
		lineModeButton.setIcon(new ImageIcon(DrawWindow.class.getResource("/com/sun/javafx/scene/web/skin/DrawHorizontalLine_16x16_JFX.png")));
		angleButton.setIcon(new ImageIcon(DrawWindow.class.getResource("/com/sun/javafx/scene/control/skin/modena/dialog-more-details.png")));
		// and the buttons listeners - TO BE EDITED
		newFileButton.addActionListener(this);
		saveButton.addActionListener(this);
		cutButton.addActionListener(this);
		copyButton.addActionListener(this);
		pasteButton.addActionListener(this);
		redoButton.addActionListener(this);
		undoButton.addActionListener(this);
		thicknessButton.addActionListener(this);
		wordsButton.addActionListener(this);
		playButton.addActionListener(this);
		saveButton.addActionListener(this);
		lineModeButton.addActionListener(this);
		angleButton.addActionListener(this);
		
		
//		// adds the buttons to the secondary toolBar at the side of the window under the menuBar
//		toolBar_1.add(triangle);
//		toolBar_1.add(squares);
//		toolBar_1.add(revTriangle);
//		toolBar_1.add(circle);
//		toolBar_1.add(lineUp);
//		toolBar_1.add(lineRight);
//		toolBar_1.add(lineLeft);
//		toolBar_1.add(makeBigger);
//		toolBar_1.add(makeSmaller);
//		// This allows the toolBar to be vertical instead of horizontal
//		toolBar_1.setOrientation(SwingConstants.VERTICAL);
//		// These buttons have no displayed text only an icon provided by eclipse - see readme for more info
//		triangle.setIcon(new ImageIcon(DrawWindow.class.getResource("/javax/swing/plaf/metal/icons/sortUp.png")));
//		revTriangle.setIcon(new ImageIcon(DrawWindow.class.getResource("/javax/swing/plaf/metal/icons/sortDown.png")));
//		squares.setIcon(new ImageIcon(DrawWindow.class.getResource("/com/sun/javafx/scene/control/skin/caspian/pattern-transparent.png")));
//		lineRight.setIcon(new ImageIcon(DrawWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed-rtl.gif")));
//		circle.setIcon(new ImageIcon(DrawWindow.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeLeaf.gif")));
//		lineRight.setIcon(new ImageIcon(DrawWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed-rtl.gif")));
//		lineUp.setIcon(new ImageIcon(DrawWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/expanded.gif")));
//		lineLeft.setIcon(new ImageIcon(DrawWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/collapsed.gif")));
//		makeBigger.setIcon(new ImageIcon(DrawWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/maximize.gif")));
//		makeSmaller.setIcon(new ImageIcon(DrawWindow.class.getResource("/javax/swing/plaf/metal/icons/ocean/iconify-pressed.gif")));
//		// and the buttons listeners - TO BE EDITED
//		triangle.addActionListener(this);
//		revTriangle.addActionListener(this);
//		squares.addActionListener(this);
//		circle.addActionListener(this);
//		lineRight.addActionListener(this);
//		lineUp.addActionListener(this);
//		lineLeft.addActionListener(this);
//		makeBigger.addActionListener(this);
//		makeSmaller.addActionListener(this);
		
		// We set the bottom label to be more user friendly 
		bottomLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		bottomLabel.setForeground(UIManager.getColor("EditorPane.selectionBackground"));
		
		//Initializes the button labels
		initializeMouseListeners();
		}

	/**
	 * This method has been generated for the distribution of the listeners of the buttons.
	 * It is responsible for updating the window and allowing functions for the listeners of the buttons 
	 * It calls methods holding the functions according to what button was pressed.
	 * 
	 * Supplemented Kiera McCabe's idea of popping message warning window
	 * ALL BUTTONS HAVE THE SAME FUNCTION - TO BE EDITTED
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		
		// Takes x and y values from a point
		Point[] lineArray = new Point[2];
		
		//Finds the source - the button that has been clicked
		Object source = event.getSource();
		
		//Text message in the popped window
		String buttonPressed;
		
		//**THIS IS AN EXAMPLE**
		// the code for now will identify the buttons clicked and write on the console the name + "was clicked."
		if(source == saveButton){
			System.out.println("save was clicked.");
			buttonPressed="Save button";
			setWarningMsg(buttonPressed);}
		else if(source == cutButton){
			System.out.println("cut was clicked.");
			buttonPressed="Cut button";
			setWarningMsg(buttonPressed);
			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
			}
		else if(source == copyButton){
			System.out.println("copy was clicked.");
			buttonPressed="Copy button";
			setWarningMsg(buttonPressed);
			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
			}
		else if(source == pasteButton){
			System.out.println("paste was clicked.");
			buttonPressed="Paste button";
			setWarningMsg(buttonPressed);
			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
			}
		else if(source == redoButton){
			System.out.println("redo was clicked.");
			buttonPressed="Redo button";
			setWarningMsg(buttonPressed);
			canvasGUI.addLastShape();
			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
			}
		else if(source == undoButton){
			System.out.println("undo was clicked.");
			buttonPressed="Undos button";
			setWarningMsg(buttonPressed);
			canvasGUI.deleteLastShape();
			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
			}
		else if(source == thicknessButton){
			System.out.println("highlight was clicked.");
			buttonPressed="Thickness button";
			setWarningMsg(buttonPressed);
			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
			}
		else if(source == wordsButton){
			System.out.println("letter was clicked.");
			buttonPressed="Words button";
			setWarningMsg(buttonPressed);
			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
			}
		else if(source == playButton){
			System.out.println("play was clicked.");
			buttonPressed="Play button";
			setWarningMsg(buttonPressed);
			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
			}
		else if(source == newFileButton){
			System.out.println("file was clicked.");
			buttonPressed="New File button";
			setWarningMsg(buttonPressed);
			
			//WE NEED A CLEAR ALL BUTTON, USING NEW FILE FOR NOW.
			canvasGUI.clearAll();
			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
			}
		else if(source == lineModeButton){
			System.out.println("line was clicked.");
			buttonPressed="Line Mode button";
			setWarningMsg(buttonPressed);
			canvasGUI.switchLineMode();
			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
			}
		else if (source == angleButton){
			System.out.println("angle was clicked.");
			double angleValue = setAngle();
			System.out.println(angleValue);
			lineArray = db.returnPoint();
			int length = 0;
			
			if (lineArray!=null){
				length = geom.lineLength( lineArray[0], lineArray[1]);
				
				Point newPoint = geom.lineAtAngle(lineArray[1], length, angleValue);
				
				Point[] addition = new Point[2];
				addition[0] = lineArray[1];
				addition[1]= new Point((int)newPoint.getX(), (int)newPoint.getY());
				
				db.Add(addition);
				
				canvasGUI.canvasRepaint();
			}
		}
//		else if(source == revTriangle){
//			System.out.println("reverse triangle was clicked.");
//			buttonPressed="Reversebutton";
//			setWarningMsg(buttonPressed);
//			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
//			}
//		else if(source == triangle){
//			System.out.println("triangle was clicked.");
//			buttonPressed="Triangle button";
//			setWarningMsg(buttonPressed);
//			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
//			}
//		else if(source == circle){
//			System.out.println("circle was clicked.");
//			buttonPressed="Circle button";
//			setWarningMsg(buttonPressed);
//			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
//			}
//		else if(source == lineUp){
//			System.out.println("line up was clicked.");
//			buttonPressed="Line up button";
//			setWarningMsg(buttonPressed);
//			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
//			}
//		else if(source == lineRight){
//			System.out.println("line right was clicked.");
//			buttonPressed="line right button";
//			setWarningMsg(buttonPressed);
//			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
//			}
//		else if(source == squares){
//			System.out.println("squares was clicked.");
//			buttonPressed="Squares button";
//			setWarningMsg(buttonPressed);
//			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
//			}
//		else if(source == lineLeft){
//			System.out.println("line left was clicked.");
//			buttonPressed="line left button";
//			setWarningMsg(buttonPressed);
//			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
//			}
//		else if(source == makeBigger){
//			System.out.println("make bigger was clicked.");
//			buttonPressed="make bigger button";
//			setWarningMsg(buttonPressed);
//			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
//			}
//		else if(source == makeSmaller){
//			System.out.println("make small was clicked.");
//			buttonPressed="make small button";
//			setWarningMsg(buttonPressed);
//			//JOptionPane.showInputDialog(buttonPressed+"was pressed");
//			}
		}
	
	/**
	 * This method allows the function of a button.
	 * It pops up a new window in the middle of the screen with a warning message and an option to click okay.
	 * If okay button is pressed or the window is terminated (click on the x symbol on the top of the tool bar)
	 * another window will pop up with instructions and allowing the user to enter information.
	 * 
	 * @author Kiera McCabe
	 * @author of comments Ioanna Deni
	 * @param text message to be displayed
	 */
	public static void setWarningMsg(String text){
		
		//This gets the defaults of the location and path of events of the pop up window 
	    Toolkit.getDefaultToolkit().beep();
	    
	    //This allow the instructions displayed to be equal to our parameter 
	    JOptionPane optionPane = new JOptionPane(text,JOptionPane.WARNING_MESSAGE);
	    
	    //This sets the title of the window
	    JDialog dialog = optionPane.createDialog("Warning!");
	    
	    //Sets the whole pop up window visible
	    dialog.setAlwaysOnTop(true);
	    dialog.setVisible(true);
	}
	
	/**
	 * This method adds listeners to the buttons that are then used to display a 
	 * JLabel with the name of the button at the right hand side of the tool bar.
	 * This label pops up every time the mouse enters the button.  The label goes
	 * away when the user moves the mouse outside of the button.
	 * 
	 * @author Emilyann Nault
	 * @version March 6, 2018
	 */
	public void initializeMouseListeners(){
	
		//For each button in the tool bar, a label is added that pops up when 
		//the mouse enters a button and disappears when the mouse leaves the button 
		newFileButton.addMouseListener(new MouseAdapter()
	    {
			JLabel newFileBLabel = null;
	        public void mouseEntered(MouseEvent evt)
	        {
				newFileBLabel = new JLabel("New File");
				toolBar.add(newFileBLabel);
				newFileBLabel.setLocation(11*newFileButton.getWidth(), -11);
				newFileBLabel.setSize(newFileBLabel.getWidth() + 11,50);
				Border border = LineBorder.createGrayLineBorder();
				newFileBLabel.setBorder(border);
				newFileBLabel.setForeground(Color.RED);
				repaint();
	        }
	        public void mouseExited(MouseEvent evt)
	        {
	        		newFileBLabel.setVisible(false);
	        }
	    });
		
		saveButton.addMouseListener(new MouseAdapter()
	    {
			JLabel saveBLabel = null;
	        public void mouseEntered(MouseEvent evt)
	        {
				saveBLabel = new JLabel("Save");
				toolBar.add(saveBLabel);
				saveBLabel.setLocation(11*saveButton.getWidth(), -11);
				saveBLabel.setSize(saveBLabel.getWidth() + 11,50);
				Border border = LineBorder.createGrayLineBorder();
				saveBLabel.setBorder(border);
				saveBLabel.setForeground(Color.RED);
				repaint();
	        }
	        public void mouseExited(MouseEvent evt)
	        {
	        		saveBLabel.setVisible(false);
	        }
	    });
		
		cutButton.addMouseListener(new MouseAdapter()
		{
			JLabel cutBLabel = null;
	        public void mouseEntered(MouseEvent evt)
	        {
				cutBLabel = new JLabel("Cut");
				toolBar.add(cutBLabel);
				cutBLabel.setLocation(11*cutButton.getWidth(), -11);
				cutBLabel.setSize(cutBLabel.getWidth() + 11,50);
				Border border = LineBorder.createGrayLineBorder();
				cutBLabel.setBorder(border);
				cutBLabel.setForeground(Color.RED);
				repaint();
	        }
	        public void mouseExited(MouseEvent evt)
	        {
	        		cutBLabel.setVisible(false);
	        }
	    });
		
		copyButton.addMouseListener(new MouseAdapter()
		{
			JLabel copyBLabel = null;
	        public void mouseEntered(MouseEvent evt)
	        {
				copyBLabel = new JLabel("Copy");
				toolBar.add(copyBLabel);
				copyBLabel.setLocation(11*copyButton.getWidth(), -11);
				copyBLabel.setSize(copyBLabel.getWidth() + 11,50);
				Border border = LineBorder.createGrayLineBorder();
				copyBLabel.setBorder(border);
				copyBLabel.setForeground(Color.RED);
				repaint();
	        }
	        public void mouseExited(MouseEvent evt)
	        {
	        		copyBLabel.setVisible(false);
	        }
	    });
		
		pasteButton.addMouseListener(new MouseAdapter()
		{
			JLabel pasteBLabel = null;
	        public void mouseEntered(MouseEvent evt)
	        {
				pasteBLabel = new JLabel("Paste");
				toolBar.add(pasteBLabel);
				pasteBLabel.setLocation(11*pasteButton.getWidth(), -11);
				pasteBLabel.setSize(pasteBLabel.getWidth() + 11,50);
				Border border = LineBorder.createGrayLineBorder();
				pasteBLabel.setBorder(border);
				pasteBLabel.setForeground(Color.RED);
				repaint();
	        }
	        public void mouseExited(MouseEvent evt)
	        {
	        		pasteBLabel.setVisible(false);
	        }
	    });
		
		redoButton.addMouseListener(new MouseAdapter()
		{
			JLabel redoBLabel = null;
	        public void mouseEntered(MouseEvent evt)
	        {
				redoBLabel = new JLabel("Redo");
				toolBar.add(redoBLabel);
				redoBLabel.setLocation(11*redoButton.getWidth(), -11);
				redoBLabel.setSize(redoBLabel.getWidth() + 11,50);
				Border border = LineBorder.createGrayLineBorder();
				redoBLabel.setBorder(border);
				redoBLabel.setForeground(Color.RED);
				repaint();
	        }
	        public void mouseExited(MouseEvent evt)
	        {
	        		redoBLabel.setVisible(false);
	        }
	    });
		
		undoButton.addMouseListener(new MouseAdapter()
		{
			JLabel undoBLabel = null;
	        public void mouseEntered(MouseEvent evt)
	        {
				undoBLabel = new JLabel("Undo");
				toolBar.add(undoBLabel);
				undoBLabel.setLocation(11*undoButton.getWidth(), -11);
				undoBLabel.setSize(undoBLabel.getWidth() + 11,50);
				Border border = LineBorder.createGrayLineBorder();
				undoBLabel.setBorder(border);
				undoBLabel.setForeground(Color.RED);
				repaint();
	        }
	        public void mouseExited(MouseEvent evt)
	        {
	        		undoBLabel.setVisible(false);
	        }
	    });
		
		thicknessButton.addMouseListener(new MouseAdapter()
		{
			JLabel thicknessBLabel = null;
	        public void mouseEntered(MouseEvent evt)
	        {
				thicknessBLabel = new JLabel("Thickness");
				toolBar.add(thicknessBLabel);
				thicknessBLabel.setLocation(11*thicknessButton.getWidth(), -11);
				thicknessBLabel.setSize(thicknessBLabel.getWidth() + 11,50);
				Border border = LineBorder.createGrayLineBorder();
				thicknessBLabel.setBorder(border);
				thicknessBLabel.setForeground(Color.RED);
				repaint();
	        }
	        public void mouseExited(MouseEvent evt)
	        {
	        		thicknessBLabel.setVisible(false);
	        }
	    });
		
		wordsButton.addMouseListener(new MouseAdapter()
		{
			JLabel wordsBLabel = null;
	        public void mouseEntered(MouseEvent evt)
	        {
				wordsBLabel = new JLabel("Text");
				toolBar.add(wordsBLabel);
				wordsBLabel.setLocation(11*wordsButton.getWidth(), -11);
				wordsBLabel.setSize(wordsBLabel.getWidth() + 11,50);
				Border border = LineBorder.createGrayLineBorder();
				wordsBLabel.setBorder(border);
				wordsBLabel.setForeground(Color.RED);
				repaint();
	        }
	        public void mouseExited(MouseEvent evt)
	        {
	        		wordsBLabel.setVisible(false);
	        }
	    });
		
		playButton.addMouseListener(new MouseAdapter()
		{
			JLabel playBLabel = null;
	        public void mouseEntered(MouseEvent evt)
	        {
				playBLabel = new JLabel("Play");
				toolBar.add(playBLabel);
				playBLabel.setLocation(11*playButton.getWidth(), -11);
				playBLabel.setSize(playBLabel.getWidth() + 11,50);
				Border border = LineBorder.createGrayLineBorder();
				playBLabel.setBorder(border);
				playBLabel.setForeground(Color.RED);
				repaint();
	        }
	        
	        public void mouseExited(MouseEvent evt)
	        {
	        		playBLabel.setVisible(false);
	        }
	    });
		lineModeButton.addMouseListener(new MouseAdapter()
		{
			JLabel lineModeBLabel = null;
	        public void mouseEntered(MouseEvent evt)
	        {
				lineModeBLabel = new JLabel("Line Mode");
				toolBar.add(lineModeBLabel);
				lineModeBLabel.setLocation(11*playButton.getWidth(), -11);
				lineModeBLabel.setSize(lineModeBLabel.getWidth() + 11,50);
				Border border = LineBorder.createGrayLineBorder();
				lineModeBLabel.setBorder(border);
				lineModeBLabel.setForeground(Color.RED);
				repaint();
	        }
	        
	        public void mouseExited(MouseEvent evt)
	        {
	        		lineModeBLabel.setVisible(false);
	        }
	    });
	
		angleButton.addMouseListener(new MouseAdapter()
		{
			JLabel angleBLabel = null;
	        public void mouseEntered(MouseEvent evt)
	        {
				angleBLabel = new JLabel("Create Line at Angle");
				toolBar.add(angleBLabel);
				angleBLabel.setLocation(11*playButton.getWidth(), -11);
				angleBLabel.setSize(angleBLabel.getWidth() + 11,50);
				Border border = LineBorder.createGrayLineBorder();
				angleBLabel.setBorder(border);
				angleBLabel.setForeground(Color.RED);
				repaint();
	        }
	        
	        public void mouseExited(MouseEvent evt)
	        {
	        		angleBLabel.setVisible(false);
	        }
	    });
	}
	
	/**
	 * This method allows the function the angle button.
	 * It pops up a new window in the middle of the screen with an input area for the user to input an angle. 
	 * If click on the x symbol on the top of the tool bar the function will be terminated.
	 * 
	 * @author Ioanna Deni
	 */
	public double setAngle(){
		
		String value = (String)JOptionPane.showInputDialog("Input an anlge in radians", JOptionPane.INFORMATION_MESSAGE);
		System.out.println("Clicked");

		//If a value was returned returns it
		if ((value != null) && (value.length() > 0)) {
			
			int number = Integer.parseInt(value);
		    return (double)number;
		}
		else{
			return 0;
		}
	}
}
