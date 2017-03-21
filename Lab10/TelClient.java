import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TelClient{
	public static void main(String[] args){
		ArrayList<TelDirectory> a1 = new ArrayList<TelDirectory>();
		a1.add(new TelDirectory("John Smith", "5553458942"));
		a1.add(new TelDirectory("Peter Jackson", "5552329945"));
		a1.add(new TelDirectory("Quentin Tarentino", "5556783920"));
		a1.add(new TelDirectory("Darren Aronofsky", "2318914578"));
		a1.add(new TelDirectory("Samuel Clemens", "1234567890"));
		a1.add(new TelDirectory("Matt Stone", "6782342233"));
		a1.add(new TelDirectory("Amy Adams", "4041128943"));
		a1.add(new TelDirectory("Ridley Scott", "9872324411"));
		a1.add(new TelDirectory("Brad Marchand", "2127853420"));
		a1.add(new TelDirectory("Brad Marchand", "4839231123"));
		
		for(int i = 0; i<10; i++){
			System.out.println(a1.get(i).toString());
		}
		
		System.out.println();
		
		Collections.sort(a1);
		
		for(int i = 0; i<10; i++){
			System.out.println(a1.get(i).toString());
		}
		
	}
}