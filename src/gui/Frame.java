/**
 * Aulthor Vadim Lesan
 */
package gui;




import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;




/**
 * 
 * @author Vadim
 *
 */
public class Frame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The panel that contains the buttons. */
    protected JPanel panel1,panel2;
	
        
    /** The button an the label */
    protected JButton buton;
    protected JLabel label;

    /** The Constant FRAME_WIDTH. */
    protected static final int width = 790;

    /** The Constant FRAME_HEIGHT. */
    protected static final int height = 650;
    
    public static LoadDataFrame load = null;
    
    public static ProcessDataFrame process = null;  // window class instances
	  
    public static WriteDataFrame write = null;
    
    /** The variable to hold the message for the user*/		
    protected String progresstype = new String("Welcome");
    
    public JTextArea infobar;
    public BufferedImage image;
    public JLabel picLabel;
    
    /**
     * Constructor
     */
    public Frame(){ 
	    
    	
       	panel1 = new JPanel();
    	 panel1.setLayout(null);
    	   panel1.setBackground(new Color(0, 255, 102));
    	 addPanelsmainFrame();
    	 add(panel1);
    	
    	
	        setSize(width,height);
	    }      

	/**
	 *  The method to add panels with the components to the main frame	
	 */
    public void addPanelsmainFrame(){
    	
    	panel2 = new JPanel();
    	 panel2.setBounds(10, 0, 750, 35);
    	  panel2.setBackground(new Color(0, 255, 102));
    	addTopInfoLabel();
    	panel1.add(panel2);
    	
    	panel2 = new JPanel();
    	 panel2.setBounds(10, 46, 580, 419);
    	  panel2.setBackground(new Color(0, 255, 102));
    	addPicture();
    	panel1.add(panel2);
    	
    	
    	panel2 = new JPanel();
    	 panel2.setBounds(600, 45, 160, 420);
    	  panel2.setBackground(new Color(0, 255, 102));
    	
    	 // method calls 
    	 addLoadDataButton();
    	 addProcessDataButton(); 
    	 addWriteDataButton();
    	
    	panel1.add(panel2);
    	
    	panel2 = new JPanel();
    	 panel2.setBounds(10, 480, 750, 105);
    	   panel2.setBackground(new Color(0, 255, 102));
    	
    	   addBottomInfoLabel();
    	
    	panel1.add(panel2);
    	
    }
    
    /**
     *  Adding top panel with the components
     */
    public void addTopInfoLabel(){
    	
    	panel2.setLayout(null);
    	
    	 label = new JLabel("Java Application to allocate demonstrators to modules");
    	  label.setBounds(75, 11, 330, 14);
    	   label.setFont(new Font("Varela Round", Font.PLAIN, 12));
    	
    	panel2.add(label);
    	
    }
  
	   /**
	    *  Adding the button needed 
	    */
	public void addLoadDataButton(){
		
		panel2.setLayout(null);
		
		buton = new JButton("Load Data");
		 buton.setBounds(10, 157, 140, 23);
		  buton.setFont(new Font("Varela Round", Font.PLAIN, 9));
		   buton.addActionListener(new ActionListener() {
			 
			// Listener for the button
	        public void actionPerformed(ActionEvent e)
	        {
	            //Execute when button is pressed
	        	load = new LoadDataFrame(); 
	        	load.setVisible(true);
	        	load.setSize(width,height);
	        	load.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        	
	        }
	    });      
		panel2.add(buton);
		
	}
	
	/**
	 *  Adding the button needed 
	 */	
	public void addProcessDataButton(){
	    
		buton = new JButton("Process Data");
		buton.setFont(new Font("Varela Round", Font.PLAIN, 9));
		buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Execute when button is pressed
				process = new ProcessDataFrame();
				process.setSize(790,650);
	        	process.setVisible(true);
	        	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        	}			
	    });     
		buton.setBounds(10, 211, 140, 23);
		panel2.add(buton);
	}
	
	/**
	 *  Adding the button needed 
	 */
	public void addWriteDataButton(){
		
		buton = new JButton("Write Data");
		buton.setFont(new Font("Varela Round", Font.PLAIN, 9));
		buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				write = new WriteDataFrame();
				write.setSize(790,650);
	        	write.setVisible(true);
	        	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		buton.setBounds(10, 266, 140, 23);
		panel2.add(buton);
	}
	
	/**
	 *  Adding the bottom panel with components 
	 */
	public void addBottomInfoLabel(){
		panel2.setLayout(null);
		
		label = new JLabel("Supervisor: David Weston");
		label.setBounds(6, 80, 149, 14);
		label.setFont(new Font("Varela Round", Font.PLAIN, 12));
		panel2.add(label);
		
		label = new JLabel("Author: Vadim Lesan");
		label.setBounds(6, 68, 120, 14);
		label.setFont(new Font("Varela Round", Font.PLAIN, 12));
		panel2.add(label);
		addInfoBar(progresstype);
		
		 }
	   /**
	    *  Adding the picture 
	    */
	public void addPicture(){
		
		panel2.setLayout(null);
		
		try {
			image = ImageIO.read(new File("ga4.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("noimage");
		}
		picLabel = new JLabel(new ImageIcon(image));
		picLabel.setBounds(10, 46, 580, 419);
		panel2.add(picLabel);
	}

	 /**
	    *  Adding the infobar
	    *  @param str  The message to add 
	    */
	public void addInfoBar(String str){
		
		infobar = new JTextArea(str);
		infobar.setBounds(10, 20, 730, 25);
		infobar.setBackground(new Color(0, 255, 102));
		infobar.setFont(new Font("Varela Round", Font.PLAIN, 9));
		
		panel2.add(infobar);
	}
    
	/**
	 * 
	 * @return procees The instance of the ProcessDataFrame class
	 * singleton patern
	 */
	public static ProcessDataFrame getProcessDataFrame() 
	{
	    
	    return process;
	}

}
