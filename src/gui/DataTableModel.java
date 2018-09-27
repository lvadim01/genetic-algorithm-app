package gui;
	


import javax.swing.table.*;


	/**
	 *   
	 * @author Vadim
	 *
	 */
    public class DataTableModel extends AbstractTableModel {
	  
		  /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String[] columnNames = {"Demonstrator ID", "Module Name"};
		  ProcessDataFrame x = ProcessDataFrame.getProcessDataFrame();
          
		 		  
	  
	    public String getColumnName(int column) {
	        return columnNames[column];
	    }

	    public int getColumnCount() {
	        return 2;
	    }

	    public int getRowCount() {
	        return x.genetic.candidatesolution.size();
	    }

	    public Object getValueAt(int rowIndex, int columnIndex) {
	        if(columnIndex==0){
	            return x.genetic.candidatesolution.get(rowIndex).getDemonstrator().getDemonstrator_Name();
	            
	        }
	        else if(columnIndex==1){
	            return x.genetic.candidatesolution.get(rowIndex).getModule().getMod_Name();
	        }
	        	             
	        return null;
	    }
	}
	
	
	


