package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author Vadim
 *
 */
public class ProcessDataFrame extends Frame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField mutation,iteration; // text fields needed
	public GeneticAlgorithm genetic = null;
	
	/**
	 * Constructor
	 */
	public ProcessDataFrame(){
		
		
		panel1 = new JPanel();
		panel1.setBackground(new Color(0, 255, 102));
    	panel1.setLayout(null);
    	addProcessPanels();
    	add(panel1);
    	
    	
	}
	
	/**
	 * Panels needed added
	 */
	public void addProcessPanels(){
		
		panel2 = new JPanel();
    	panel2.setBounds(10, 0, 750, 35);
    	panel2.setBackground(new Color(0, 255, 102));
    	addTopInfoLabel();
    	panel1.add(panel2);
    	
    	panel2 = new JPanel();
    	panel2.setBounds(10, 46, 580, 419); 
    	panel2.setBackground(new Color(0, 255, 102));
    	addMutationRate();
    	addAlgorithmIteration();
    	panel1.add(panel2);
    	
    	panel2 = new JPanel();
    	panel2.setBounds(600, 45, 160, 420);
    	panel2.setBackground(new Color(0, 255, 102));
    	addProcessFrameButtons();
    	panel1.add(panel2);
    	
    	panel2 = new JPanel();
    	panel2.setBounds(10, 480, 750, 105);
    	panel2.setBackground(new Color(0, 255, 102));
    	progresstype = new String("Please enter the GA parameters!");
    	addBackButton();
    	addBottomInfoLabel();
    	panel1.add(panel2);
	}
	
	/**
	 *  Buttons needed add
	 */
	public void addProcessFrameButtons(){
		
		panel2.setLayout(null);
		
		buton = new JButton("GO");
		buton.setBounds(10, 345, 140, 38);
		buton.setFont(new Font("Varela Round", Font.PLAIN, 9));
    	buton.addActionListener(new ActionListener() {
      		 
            public void actionPerformed(ActionEvent e) 
            {  genetic = new GeneticAlgorithm();
            }
        });      
    		
    	panel2.add(buton);
    	
    	
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
	        	        	process.dispose();
	        	
	        }
	    });                               
		panel2.add(buton);
		 
	}
	
	/**
	 * Mutation component added
	 */
	public void addMutationRate(){
		panel2.setLayout(null);
		
		JLabel mutationratelabel = new JLabel("Mutation rate:");
		mutationratelabel.setForeground(SystemColor.textHighlight);
		mutationratelabel.setFont(new Font("Varela Round", Font.BOLD, 16));
		mutationratelabel.setBackground(SystemColor.control);
		mutationratelabel.setBounds(70, 140, 140, 50);
		panel2.add(mutationratelabel);
		
		mutation = new JTextField("0.5");
		mutation.setBounds(212, 151, 151, 30);
		panel2.add(mutation);
		mutation.setColumns(10);
		mutationratelabel.setLabelFor(mutation);
		
	}
	
	/**
	 * Iteration component added
	 */
	public void addAlgorithmIteration(){
		
		JLabel algorithmitaerations = new JLabel("Algorithm itaerations:");
		algorithmitaerations.setForeground(SystemColor.textHighlight);
		algorithmitaerations.setFont(new Font("Varela Round", Font.BOLD, 16));
		algorithmitaerations.setBackground(SystemColor.control);
		algorithmitaerations.setBounds(10, 217, 200, 50);
		panel2.add(algorithmitaerations);
		
		iteration = new JTextField("2");
		iteration.setBounds(212, 225, 151, 30);
		panel2.add(iteration);
		iteration.setColumns(10);
		algorithmitaerations.setLabelFor(iteration);
		
	}
	
}
