package gui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * 
 * @author Vadim
 *
 */
public class GeneticAlgorithm extends Frame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/// the variables needed for algorithm run
	protected Assignment individual;
	public ArrayList<Assignment> candidatesolution = new ArrayList<Assignment>();
	public ArrayList<Assignment> finalsolution = null;
	private double mutation; 
	private int iterations;
	Random randomselection = new Random();
	int range = load.demonstratorrelations.size();
 	int index,fitness;
	
 	public GeneticAlgorithm(){
        
 		// get and transform the text to according data types
 		mutation = Double.parseDouble(process.mutation.getText()); 
 		iterations = Integer.parseInt(process.iteration.getText());
 	
 		
 	if (iterations == 0){
 		Component frame = new JFrame();   // massage for user
		JOptionPane.showMessageDialog(frame ,"The algorithm iteration is 0 so it will not run!.");
 	    }
 	else {
 		
 	 for (int iter = 1; iter < iterations; iter++){	  // number of algorithm run
        candidatesolution = initialPopulation(); // generate the initial solution
        boolean m,n,o,p; // parameters for computing the fitness
        int fitness;     // fitness value
       
        for (int i = 0; i<candidatesolution.size();i++){
 		       
 		    	  // the ids for needed for evaluation 
 		    	  String demid = candidatesolution.get(i).getDemonstrator().getDemonstrator_Id(); 
 		    	  String modid = candidatesolution.get(i).getModule().getModule_Id();
 		    	  
 		    	  m = evaluateForassignTimes(candidatesolution,demid);
 		    	  n = evaluateForAssignPref(candidatesolution,demid);
 		    	  o = evaluateForAssignHours(candidatesolution,demid);
 		    	  p = evaluateForAssignDemReq(candidatesolution,modid);
 		        
 		          fitness  = FitnessFunction(m,n,o,p);
 		          
 		          if (fitness < 75){
 		        	  
 		        	 candidatesolution.set(i,crossoverFunction(new Assignment(getRandomModule(randomselection.nextInt(range)),getRandomDemonstrator(randomselection.nextInt(range))),
  		        			new Assignment(getRandomModule(randomselection.nextInt(range)),getRandomDemonstrator(randomselection.nextInt(range))))) ;
 		        	 		        	 
 		          }
 		          
 		          
 		       }
 	        	
        finalsolution = candidatesolution;
        addMutation(finalsolution,mutation);
 	        	  
 	             }  
 	         }       
 	      }       
 		        
	/**
	 * The method assign randomly demonstrators to modules
	 * @return candidatesolution
	 */
	public ArrayList<Assignment> initialPopulation(){		
		
		 
		    for(int i = 0; i<load.demonstratorrelations.size(); i++ )
		    {
			
		    	index = randomselection.nextInt(range);
		    	individual = new Assignment(getRandomModule(index),getRandomDemonstrator(i));
			candidatesolution.add(individual);
		    }
		
		return candidatesolution;
		
	}
	    /**
	     * Crossover method Creates new generation individual
	     * @param parent1
	     * @param parent2
	     * @return childindividual
	     */
		public Assignment crossoverFunction(Assignment parent1,Assignment parent2){
				
				Assignment childindividual;
				
				childindividual = new Assignment(parent1.getModule(),parent2.getDemonstrator());
				
				
				return childindividual;			   
			
			}
	      
		  /**
		   * The method computes the fitness value of an individual
		   * @param prefgop
		   * @param timesgop
		   * @param hoursgop
		   * @param nrdemgop
		   * @return fitnessvalue
		   */
	      public int FitnessFunction(boolean prefgop,boolean timesgop,boolean hoursgop,boolean nrdemgop){
		   
			 int fitnessvalue = 0;   
						
			     if(prefgop){
				   	fitnessvalue = fitnessvalue + 25;
				    }  
					if(timesgop){
				    	fitnessvalue = fitnessvalue + 25;
					    }  
						if(hoursgop){
					      fitnessvalue = fitnessvalue + 25;
						  }  
						  if(nrdemgop){
						    fitnessvalue = fitnessvalue + 25;
						    }  					      
				return fitnessvalue; 	  
					        	  
					}
	/**
	 * The method evaluates if a dem is assigned to the same module   
	 * @param candidatesolution
	 * @param dem_id
	 * @return result
	 */
	public boolean evaluateForassignTimes(ArrayList<Assignment> candidatesolution, String dem_id){

	    boolean result = true;
	    ArrayList<String> temporaryarray = new ArrayList<String>(); // array to keep all times assigned
	    int redundant = 0; // var to keep track for assignment redundancy
	    
	    for (int i=0;i< candidatesolution.size();i++){
	    	
	    	String time = candidatesolution.get(i).getModule().getTime();
	    	String currentdem_id = candidatesolution.get(i).getDemonstrator().getDemonstrator_Id();
	    	
	    	if(dem_id == currentdem_id){
	    		
	    		temporaryarray.add(time);
	    	}
	    	
	    	for(int x = 0; x<temporaryarray.size();x++){
	    		
	    		String currenttime = temporaryarray.get(x);
	    		
		    		for (int y = x+1; y<temporaryarray.size()-1;y++){
		    		 
		    			 String nexttime = temporaryarray.get(y);
		    			 
		    			   if(currenttime == nexttime){
		    				   
		    				   redundant = 1;		    				   
		    			   }
		    			   else{
		    				   redundant = 0;   
		    			   }
		    			 
		    		}
	    	}
	    	
	    	
	    	
	    }
          
	    
	        if(redundant == 1){
	        	result  = false;
	        } else{
	        	result = true;  
	        }
	    
		return result;
	}
	
	/*
	 * The method compares the initial preference towards the assigned preference
	 * and returns true either false
	 * @ param candidatesolution, dem_id
	 * @return result
	 */
	public boolean evaluateForAssignPref(ArrayList<Assignment> candidatesolution, String dem_id){

		    boolean result= true;
		    double initialpref = 0.0;
		    double assignpref = 0.0;
	    
	    for (int i = 0; i<load.getden().size();i++){
	    	
	    	double add = load.getden().get(i).get_Preference();
	    	initialpref  = initialpref + add; 
	    	
	    }
	    
        for (int i = 0; i<candidatesolution.size();i++){
	    	
    	    double add = candidatesolution.get(i).getDemonstrator().get_Preference();
	    	assignpref = assignpref + add;
	    		    	
	    }
       
       
			       if (initialpref == assignpref ){
			    	   
			    	   result = false;
			       }
			       else{
			    	   result = true;
			       }
		
		return result;
	}
	
	/*
	 * The method compares the total hours required by the demonstrator towards the assigned 
	 * toal hours and returns true either false
	 * @ param candidatesolution, dem_id
	 * @return result
	 */
	public boolean evaluateForAssignHours(ArrayList<Assignment> candidatesolution, String dem_id){

		    boolean result= true;
		    int totalhoursreq = 0;
		    int totalhoursassigned = 0;
    
		    for (int i = 0; i<load.getden().size();i++){
		    	
		    	int add = load.getden().get(i).get_Hours();
		    	totalhoursreq  = totalhoursreq + add; 
		    	
		    }
    
		    for (int i = 0; i<candidatesolution.size();i++){
		    	
			    int add = Integer.valueOf(candidatesolution.get(i).getModule().getHours());
			    totalhoursassigned = totalhoursassigned + add;
		    		    	
		    }   
				       if (totalhoursreq < totalhoursassigned ){
				    	   
				    	   result = false;
				       }
				       else{
				    	   result = true;
				       }
	    
		return result;
	}
	
	/*
	 * The method compares the total number of required demonstrators for a module towards the assigned 
	 * demostrators to each module, and returns true either false
	 * @ param candidatesolution, mod_id
	 * @return result
	 */
	public boolean evaluateForAssignDemReq(ArrayList<Assignment> candidatesolution, String mod_id){

	    boolean result= true;
        int initialmoduledem_req = 0,assignedmoduledem_req = 0; 
        
	    for (int i = 0; i<load.getmod().size();i++){
	    	// adding total demonstrators for each module from the loaded data
	    	int add = load.getmod().get(i).getDem_Req();	    	 
	    	  if (mod_id == load.getmod().get(i).getModule_Id()){
	    		  initialmoduledem_req = initialmoduledem_req + add;
	    	 }
	    }  
	    	  for (int i = 0; i<candidatesolution.size();i++){
	  	    	// adding total demonstrators for each module from the assigned relations
	  	    	int add = candidatesolution.get(i).module.getDem_Req();	    	 
	  	    	  if (mod_id == candidatesolution.get(i).module.getModule_Id()){
	  	    		  assignedmoduledem_req = assignedmoduledem_req + add;
	  	    	 }  
	    }
	    	  
	    	 if(initialmoduledem_req > assignedmoduledem_req){
	    		 result = false;
	    	  }
	    	 else {
	    		 result = true; 
	    	   }
	    	  
		
		return result;
	}
	
	/**
	 * The method bring a random demonstrator
	 * @param index
	 * @return load.demonstratorrelations.get(index)
	 */
	public DemonstratorRelation getRandomDemonstrator(int index){	
		
		
		return load.demonstratorrelations.get(index);
		 
	}
	
   /**
    * The method bring a random demonstrator	
    * @param index
    * @return load.modulerelations.get(index)
    */
   public ModuleRelation getRandomModule(int index){	
		
		
		return load.modulerelations.get(index);
		 
	} 
   /**
    * The method changes the individuals between them
    * @param finalsolution
    * @param mutation
    */
   public void  addMutation(ArrayList<Assignment> finalsolution, double mutation){
	   
	   if (mutation > 0.5){
		  
		   for (int i=1; i<finalsolution.size();i++){
			   
			   individual = finalsolution.get(i);
			   finalsolution.set(i-1, individual);
			   
		   } 
		  	   
	   }
	   
	   
   }
	   
}
	
   
   
   
	

