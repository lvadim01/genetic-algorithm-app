package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Vadim
 *
 */
public class DemonstratorRelation {
	
		
    //  the variables needed to hold the data from the relation
	private String demonstrator_id;
	private String demonstrator_name;
	private String required_module_id;
	private String required_module_name;
	private double preference;
	private int hours;
	private static final String start = "DataStart", end = "DataEnd";
	
	/**
	 * Constructor with a parameter
	 * @param str
	 */
	public DemonstratorRelation(String str){
				
		Scanner in = new Scanner(str);
        in.useDelimiter(",");
        demonstrator_id = in.next();
        demonstrator_name = in.next();
        required_module_id = in.next();
        required_module_name = in.next();
        preference = in.nextDouble();
        hours = in.nextInt();
			
	}
	// geter and setter methods
	public String getDemonstrator_Id() {
	      return demonstrator_id;
	   }
	
	public void setDemonstrator_Id(String dem_id) {
	      demonstrator_id = dem_id;
	   }
	
	public String getDemonstrator_Name() {
	      return demonstrator_name;
	   }
	
	public void setDemonstrator_Name(String dem_name) {
	      demonstrator_name = dem_name;
	   }
	
	public String getRequired_Module_Id() {
	      return required_module_id;
	   }
	
	public void setRequired_Module_Id(String req_mod_id) {
	      required_module_id = req_mod_id;
	   }	
	
	public String getRequired_Module_Name() {
	      return required_module_name;
	   }
	
	public void setRequired_Module_Name(String req_mod_name) {
	      required_module_name = req_mod_name;
	   }	
	
	public double get_Preference() {
	      return preference;
	   }
	
	public void setPreference(double new_pref) {
	      preference = new_pref;
	   }	
	
	public int get_Hours() {
	      return hours;
	   }
	
	public void setHours(int new_pref) {
	      preference = new_pref;
	   }
	
	/**
	 * The method fills an arraylist  with the data loaded
	 * @param file
	 * @return demonstratorrelation
	 * @throws FileNotFoundException
	 */
	public static ArrayList<DemonstratorRelation> LoadDemonstratorRelation(File file) throws FileNotFoundException{
        ArrayList<DemonstratorRelation>  demonstratorrelation = new ArrayList<DemonstratorRelation>();
        String str;
        Scanner in = new Scanner(file) ;

        //find start line

        while (!in.nextLine().equals(start)); 

        //process until the end line
        str = in.nextLine(); 
        while (!str.equals(end)){
            demonstratorrelation.add(demonstratorrelation.size(),new DemonstratorRelation(str)); 
            str = in.nextLine(); 
        }

        in.close();
        return(demonstratorrelation);
     }
}
