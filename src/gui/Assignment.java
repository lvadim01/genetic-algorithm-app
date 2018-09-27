package gui;

public class Assignment {
	
	public ModuleRelation module;
	public DemonstratorRelation demonstrator;
	
	
	public Assignment(ModuleRelation mod,DemonstratorRelation dem){
		
		
		this.module = mod;
		this.demonstrator = dem;		
		
		
	}
	
	
	public ModuleRelation getModule(){
		
		return module;
		
	}
	
	public DemonstratorRelation getDemonstrator(){
		
		return demonstrator;
	}
	
	

}
