
import java.util.Scanner;

public class calcBack {

	public static void main(String[] args) throws Exception {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	String[] calc = sc.nextLine().split(" ");
    	
    	double a,b;
    	String signs = "/*-+";
    	
    	try {
    		
    		a = Double.valueOf(calc[0]);
    		
    		if (signs.indexOf(calc[1]) == -1)
    			throw new Exception("Operation Error!");
    		
    		b = Double.valueOf(calc[2]);
    		
    		if (b == 0 && calc[1].equals("/"))
    			throw new Exception("Error! Division by zero");
    		
    		switch (calc[1]) {
    		
    		case ("+"): 
    			System.out.print(a + b);
    			break;
    			
    		case ("-"): 
    			System.out.print(a - b);
    			break;
    		
    		case ("/"): 
    			System.out.print(a / b);
    			break;
    		
    		case ("*"): 
    			System.out.print(a * b);
    			break;
    		}
    		
    	}
    	
    	catch (NumberFormatException e) {
    		System.out.println("Error! Not number");
    	}
    	
    	catch (Exception e) {
    		System.out.println(e.getMessage());
    	}

	}

}
