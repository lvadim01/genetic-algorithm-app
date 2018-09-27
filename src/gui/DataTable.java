package gui;
import javax.swing.*;

import java.awt.*;
/**
 * 
 * @author Vadim
 *
 */
public class DataTable extends JFrame {
	
	
		  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public DataTable() {
		    
			  JFrame frame1 = new JFrame();
		       frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        frame1.setVisible(true);
		         frame1.setSize(790,650);
			 
		         JPanel panelx = new JPanel();
			     panelx.setBackground(new Color(0, 255, 102));
					
			        JTable table;
				    DataTableModel model;
				    Font f;

		    f = new Font("SanSerif",Font.PLAIN,24);
		    setFont(f);
		    setLayout(new BorderLayout());

		    model = new DataTableModel(); // dat modeling in table

		    table = new JTable(model);
		    table.createDefaultColumnsFromModel();
		   
		    JScrollPane scrollpane = new JScrollPane(table); // scroll panel for table
		    panelx.add(scrollpane);
		    frame1.add(panelx);
		    
	
	
	
	
	}

}
