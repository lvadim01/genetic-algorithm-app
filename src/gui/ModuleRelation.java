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
public class ModuleRelation {
	
	//  the variables needed to hold the data from the relation
	private String module_id;
	private String module_name;
	private String time;
	private int dem_req,hours;
	
	private static final String start = "DataStart", end = "DataEnd";
	
	/**
	 * Constructor with a parameter
	 * @param str
	 */
	public ModuleRelation(String str){
		
		Scanner in = new Scanner(str);
        in.useDelimiter(",");
        module_id = in.next();
        module_name = in.next();
        time = in.next();
        dem_req = in.nextInt();
        hours = in.nextInt();
		
	}
	
	// setter and getter methods
	public String getModule_Id() {
	      return module_id;
	   }
	
	public void setModule_Id(String mod_id) {
	      module_id = mod_id;
	   }
	
	public String getMod_Name() {
	      return module_name;
	   }
	
	public void setMod_Name(String new_mod_name) {
	      module_name = new_mod_name;
	   }
	
	public String getTime() {
	      return time;
	   }
	
	public void setTime(String newtime) {
	      time = newtime;
	   }
	
	public int getDem_Req() {
	      return dem_req;
	   }
	
	public void setHours(int new_hours) {
	      hours = new_hours;
	   }	
	public int getHours() {
	      return hours;
	   }
	
	public void setDem_Req(int new_dem_req) {
	      dem_req = new_dem_req;
	   }	
	
	
	/**
	 * The method fills an arraylist  with the data loaded
	 * @param file
	 * @return modulerelation
	 * @throws FileNotFoundException
	 */
	public static ArrayList<ModuleRelation> LoadModuleRelation(File file) throws FileNotFoundException{
        ArrayList<ModuleRelation>  modulerelation = new ArrayList<ModuleRelation>();
        String str;
        Scanner in = new Scanner(file);

      //find first line
        while (!in.nextLine().equals(start));
        //process until the last line
        str = in.nextLine(); 
        while (!str.equals(end)){
            modulerelation.add(modulerelation.size(),new ModuleRelation(str)); 
            str = in.nextLine(); 
        }

        in.close();
        return(modulerelation);
    } 
	
	
		

}

