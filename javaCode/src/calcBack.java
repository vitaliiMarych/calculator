import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.LinkedList;

public class calcBack {

	public static void main(String[] args) throws Exception {
    	
		LinkedList<String[]> calc = new LinkedList<>();
		
		try (Scanner scFile = new Scanner(new File("input.txt"))){
			while (scFile.hasNextLine())
				calc.addLast(scFile.nextLine().split(" "));	
	    }
		
		catch (Exception e) {
	        e.printStackTrace();
	    }

    	
    	double a,b;
    	String signs = "/*-+";
    	
    	try (FileWriter  pw = new FileWriter ("output.txt", false)) {
    		for (String[] c : calc) {
		    	try {
		    		
		    		a = Double.valueOf(c[0]);
		    		
		    		if (signs.indexOf(c[1]) == -1)
		    			throw new Exception("Operation Error!\n");
		    		
		    		b = Double.valueOf(c[2]);
		    		
		    		if (b == 0 && c[1].equals("/"))
		    			throw new Exception("Error! Division by zero\n");
		    		
		    		switch (c[1]) {
		    		
		    		case ("+"): 
		    			pw.write(Double.toString(a + b)+ "\n");
		    			break;
		    			
		    		case ("-"): 
		    			pw.write(Double.toString(a - b)+ "\n");
		    			break;
		    		
		    		case ("/"): 
		    			pw.write(Double.toString(a / b)+ "\n");
		    			break;
		    		
		    		case ("*"): 
		    			pw.write(Double.toString(a * b) + "\n");
		    			break;
		    		}
		    		
		    	}
    		
		    	catch (NumberFormatException e) {
		    		pw.write("Error! Not number\n");
		    	}
		    	
		    	catch (Exception e) {
		    		pw.write(e.getMessage());
		    	}
	    	}
    	}
        catch(IOException e){	
            System.out.println(e.getMessage());
        } 
    	
	}

}
