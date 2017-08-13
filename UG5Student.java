import java.util.ArrayList;

public class UG5Student extends Student{
	private int extraLevel9s;
	
	public UG5Student(String name,String uun,int value){
		super(name, uun, 5);
		extraLevel9s = value;
	}
	
	public UG5Student(){
		this("not set","not set", 0);
	}
	
	public int level9s(){
		Course[] course = super.getCourses();
		int index =0;
		for(int i = 0;i<course.length;i++){
			if(course[i].getLevel() ==9){
				index++;
			}
		}
		return index;
	}
	
	public boolean addCourse(Course course){
		if(course.getLevel() ==9 ){
		if((1+extraLevel9s)>this.level9s()){
			super.addCourse(course);
			return true;
		}
		return false;
	}
		else{
			return super.addCourse(course);
		}	

	}
	
	public String toString(){
		String output = "";
		output += super.toString()+"\n";
		if(this.level9s()>1){
			output += "Taking extra level 9s. Permission for  " +  extraLevel9s + " extra.";
		}
		
		for(Course course:super.getCourses()){
			output += course.getName()+"\n";
		}
		
		return output;
	}
	

}