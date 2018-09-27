package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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
public class WriteDataFrame extends Frame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File filetowrite; 
	PrintWriter dataWriter ;
	String stringfile = null;
	
	/**
	 * Constructor
	 */
	public WriteDataFrame(){
		
	 	
		panel1 = new JPanel();
		panel1.setBackground(new Color(0, 255, 102));
		panel1.setLayout(null);
		addWriteDataPanels();
		add(panel1);	    	
    			
	}
    
	/**
	 * Panels added
	 */
	public void addWriteDataPanels(){
		
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
		addWritedataButton();
		addViewtableButton();
		panel1.add(panel2);
		
		panel2 = new JPanel();
		panel2.setBounds(10, 480, 750, 105);
		panel2.setBackground(new Color(0, 255, 102));
		progresstype = new String("Please choose to save data in file or to view it in table");
		addBackButton();
		addBottomInfoLabel();
		panel1.add(panel2);
	}
	
	/**
	 * Button
	 */
	public void addWritedataButton(){
		
		panel2.setLayout(null);
		
		buton = new JButton("Write Data to file");
		buton.setBounds(0, 211, 160, 23);
		buton.setFont(new Font("Varela Round", Font.PLAIN, 9));
		buton.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {
	        	
	        	//Executed when button is pressed
            	filetowrite = new File(WriteThedatatoFile());
            	try {
					writeDatatoNewFile();
				} catch (FileNotFoundException e1) {
					System.out.println("There is a problem with the file to write!");
				}
            }
			
            }); 
		panel2.add(buton);
		
	}
	/**
	 * Button
	 */
    public void addViewtableButton(){
    	
		buton = new JButton("View data in table");
		buton.setBounds(0, 266, 160, 23);
		buton.setFont(new Font("Varela Round", Font.PLAIN, 9));
		buton.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {
	        	DataTable table = new DataTable();
	        	
	        	
	        }
	    }); 
		panel2.add(buton);
    }
    
    /**
     *  The method return the path to the directory user have chosen
     * @return String file
     */
    public String WriteThedatatoFile(){
	       
   	    
	   	 JFileChooser filetoselect = new JFileChooser();

	   	 
	   	 int  returnVal = filetoselect.showOpenDialog(null);
			if (returnVal == JFileChooser.APPROVE_OPTION)
			{
			  filetowrite  = filetoselect.getSelectedFile();
			  
			} else {
				Component frame = new JFrame();
				JOptionPane.showMessageDialog(frame ,"Your data will not be written to the file");
			}
   
    stringfile = filetowrite.getParentFile().toString();  
   
   
    return stringfile;
    }
    /**
     * Back button
     */
    public void addBackButton(){

    	buton = new JButton("Back");
    	buton.setBounds(600, 41, 130, 33);
    	buton.setFont(new Font("Varela Round", Font.PLAIN, 9));
    	buton.addActionListener(new ActionListener() {
    		 
            public void actionPerformed(ActionEvent e)
            {
            	        	write.dispose();
            	
            }
        });                               
    	panel2.add(buton);
    	 
    }
	
    /**
     * The method writes the data from the soltuion to the file 
     * @throws FileNotFoundException
     */
	public void writeDatatoNewFile() throws FileNotFoundException{
		
		dataWriter = new PrintWriter(stringfile + "/writendata.txt");
		dataWriter.println("Assigned Demonstrators to Modules");
				
		for(int i = 0; i<process.genetic.finalsolution.size(); i++){
		
		dataWriter.print(process.genetic.finalsolution.get(i).getDemonstrator().getDemonstrator_Id());
		dataWriter.print(", ");
	    dataWriter.print(process.genetic.finalsolution.get(i).getDemonstrator().getDemonstrator_Name());			
		dataWriter.print(" = ");
		dataWriter.print(process.genetic.finalsolution.get(i).getModule().getModule_Id());
		dataWriter.print(", ");
		dataWriter.print(process.genetic.finalsolution.get(i).getModule().getMod_Name());
		dataWriter.print(", ");
		dataWriter.print(process.genetic.finalsolution.get(i).getModule().getTime());
		dataWriter.println();
		
		}
		dataWriter.close();
	}
}

