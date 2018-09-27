package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author Vadim
 *
 */
public class LoadDataFrame extends Frame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File file;
	public ArrayList<ModuleRelation> modulerelations;
	public ArrayList<DemonstratorRelation> demonstratorrelations;
	public  int counter; // variable to keep track of data loading process

/**
 * Constructor	
 */
public LoadDataFrame(){ 
	    
    	
	panel1 = new JPanel();
	 panel1.setBackground(new Color(0, 255, 102));
	  panel1.setLayout(null);
	   
	  addLoadDataPanels();
	  add(panel1);	
}

     
  /**
   * Adding panels needed
   */
  public void addLoadDataPanels(){
	  
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
	
	   addDemonstartorsRelationButton();
	   addModuleRelationButton();
	   panel1.add(panel2);
	
	 panel2 = new JPanel();
	  panel2.setBounds(10, 480, 750, 105);
	   panel2.setBackground(new Color(0, 255, 102));
	
	   progresstype = new String("Please add the data relations");
	   addBackButton();
	   addBottomInfoLabel();	
	   panel1.add(panel2);
	  
  }

	/**
	 * The button needed
	 */
	public void addDemonstartorsRelationButton(){
		
		
		panel2.setLayout(null);
		
		buton = new JButton("Load Demonstrator Relation");
		buton.setBounds(0, 211, 160, 23);
		buton.setFont(new Font("Varela Round", Font.PLAIN, 9));
		buton.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {
	        	//Executed when button is pressed
	        	file = LoadDataFiles();
	        	
	        	try {
	        		
	        		demonstratorrelations = DemonstratorRelation.LoadDemonstratorRelation(file);
	        		counter = 1;
				} catch (FileNotFoundException e1) {
					
					Component frame = new JFrame();   // massage for user
					JOptionPane.showMessageDialog(frame ,"The file with the data was not loaded.");
				}
	        	
	        	
	        }
	    }); 
		panel2.add(buton);
	}

	/**
	 * Button needed
	 */
	public void addModuleRelationButton(){
	
		buton = new JButton("Load Modules Relation");
		  buton.setBounds(0, 266, 160, 23);
		   buton.setFont(new Font("Varela Round", Font.PLAIN, 9));
		   buton.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {
	        	//Executed when button is pressed
	        	file = LoadDataFiles();
	        	
	        	try {
					modulerelations = ModuleRelation.LoadModuleRelation(file);
				} catch (FileNotFoundException e1) {
					Component frame = new JFrame();   // massage for user
					JOptionPane.showMessageDialog(frame ,"The file with the data was not loaded.");
				}
	        	
	        	
	        }
	    });                               
		panel2.add(buton);
		 
	}

	/**
	 * Back button addd
	 */
	public void addBackButton(){
	
		buton = new JButton("Back");
		buton.setBounds(600, 41, 130, 33);
		buton.setFont(new Font("Varela Round", Font.PLAIN, 9));
		buton.addActionListener(e -> {
            if (counter != 1){

                        Component frame = new JFrame();
                        JOptionPane.showMessageDialog(frame ,"The file with the data was not loaded.");
                        load.dispose();
            }
            else {
                load.dispose();
            }
        });
		panel2.add(buton);
		 
	}
    
	/**
	 * The method gets the file specified by the user
	 * @return file
	 */
	public File  LoadDataFiles(){
	       
	    	   	    
	    	   	 JFileChooser selectedfile = new JFileChooser();
	    
	    	   	 
	    	   	 int  returnVal = selectedfile.showOpenDialog(null);
	    if (returnVal == JFileChooser.APPROVE_OPTION)
	    {
	        file  = selectedfile.getSelectedFile();
	    }
	    else{
	    	Component frame = new JFrame();
			JOptionPane.showMessageDialog(frame ,"You are about to cancel the load data file process!");
	    }
	    return file;
	}
	/*
	 * The method returns the array of demonstrators loaded
	 * @return demonstratorrelations
	 */
	 public ArrayList<DemonstratorRelation> getden(){
	        return demonstratorrelations;
	 }	
 
	 /*
	  * The method returns the array of modules loaded
	  * @return modulerelations
	  */
	 public ArrayList<ModuleRelation> getmod(){
	        return modulerelations;
	 }
 }
	
	
	
	
	
	
	
	
	
	
	
	


