import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class calcBack {

	public static void main(String[] args) throws Exception {
    	
		String[] calc = new String[3];
		
		try {
			Scanner scFile = new Scanner(new File("file.txt"));
			
	    	calc = scFile.nextLine().split(" ");
	    	
	    	scFile.close();
		}
		
		catch (Exception e) {
	        e.printStackTrace();
	    }

    	
    	double a,b;
    	String signs = "/*-+";
    	
    	try (FileWriter  pw = new FileWriter ("file.txt", false)) {
    	
	    	try {
	    		
	    		a = Double.valueOf(calc[0]);
	    		
	    		if (signs.indexOf(calc[1]) == -1)
	    			throw new Exception("Operation Error!");
	    		
	    		b = Double.valueOf(calc[2]);
	    		
	    		if (b == 0 && calc[1].equals("/"))
	    			throw new Exception("Error! Division by zero");
	    		
	    		switch (calc[1]) {
	    		
	    		case ("+"): 
	    			pw.write(Double.toString(a + b));
	    			break;
	    			
	    		case ("-"): 
	    			pw.write(Double.toString(a - b));
	    			break;
	    		
	    		case ("/"): 
	    			pw.write(Double.toString(a / b));
	    			break;
	    		
	    		case ("*"): 
	    			pw.write(Double.toString(a * b));
	    			break;
	    		}
	    		
	    	}
	    	
	    	catch (NumberFormatException e) {
	    		pw.write("Error! Not number");
	    	}
	    	
	    	catch (Exception e) {
	    		pw.write(e.getMessage());
	    	}
    	}
    	
        catch(IOException e){	
            System.out.println(e.getMessage());
        } 
    	
	}

}
