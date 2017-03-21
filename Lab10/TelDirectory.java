import java.util.*;

public class TelDirectory implements Comparable<TelDirectory>{
	private String name;
	private String number;
	
	public TelDirectory(String name, String number){
		this.name  = name;
		this.number = number;
	}
	
	public void setNumber(String number){
		this.number = number;
	}
	
	public String getNumber(){
		return number;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name + " " + number;
	}
	
	public int compareTo(TelDirectory b){
		int retVal = this.getName().compareTo(b.getName());
		if(retVal == 0){
			retVal = this.getNumber().compareTo(b.getNumber());
		}
		return retVal;
	}
}
