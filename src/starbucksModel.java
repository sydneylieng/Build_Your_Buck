import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class starbucksModel {
	// Global Variables
	private String[] drinkArray;
	private String[] resultArray;
	
	// Method that reads the drinks file
	public String[] readDrinksMethod(){
		String token1 = "";

	    // create Scanner inFile1
	    try{
	    //File must be saved in project root
		Scanner inFile1 = new Scanner(new File("Group07_DrinkDatabase.csv")).useDelimiter("\n");
	    List<String> temps = new ArrayList<String>();

	    // while loop
	    while (inFile1.hasNext()) {
	    	// find next line
	    	token1 = inFile1.next();
	    	temps.add(token1);
	    }
	    inFile1.close();
	    drinkArray = temps.toArray(new String[0]);
	    }
	    catch (Exception e){
			System.out.println(e);
		}
		return drinkArray;
	}
	
	// Method that searches for the key words
	public static String[] searchIngredients(String pat, String[] txt) {
        ArrayList<String>temp = new ArrayList<String>();

    	int M = pat.length();
        int O = txt.length;
        
        if(O != 0){							// If the array is not empty
        	for (int k = 0; k < O; k++){	// Go through array 
        		int N = txt[k].length();	// Length of characters in array at index k
		        for (int i = 0; i <= N - M; i++) {	
		        	int j;
		        	for (j = 0; j < M; j++) {
		                if (txt[k].charAt(i+j) != pat.charAt(j)){ // Searches for the pattern
		                    break;
		                }
		            }
		            if (j == M){			// If pattern is found,
		            	temp.add(txt[k]); 	// Adds the element to the end of the arrayList
		            }
		        }
        	}
            String[] tempArray = new String[temp.size()];
            tempArray = temp.toArray(tempArray); // Turns arrayList into a regular array
	        return tempArray; 
        }
        return txt; // If txt is empty, then just return the same one
    }
	
	// Method that sorts the results of the search by ingredients
	private void sortResults(String[] results){
		String[] temp;
		
		resultArray = new String[results.length];
		results = (String[]) Insertion.sort(results);
		
		for(int i = 0; i < results.length; i++){			// Iterate through the array
			temp = results[i].split(",");
			if(temp[4] != " 2%" || temp[4] != "2%"){		
				resultArray[i] = temp[4] + " " + temp[0];
			} else{
				resultArray[i] = temp[0];
			}
		}
	}
	
	// Method that initiates the building of your buck
	public void buildBuck(String[] items){
    	String[] temp = readDrinksMethod();
    	
    	
    	for(int i = 0; i < 4; i++){
    		temp = searchIngredients(items[i], temp);
    	}
    	
    	sortResults(temp);
	}
	
	// Method that initiates the search for the drink
	public void findValue(String[] tokens){
		String toBeCapped = "";
		
		for(int i = 0; i < tokens.length; i++){
		    char capLetter = Character.toUpperCase(tokens[i].charAt(0));
		    toBeCapped +=  " " + capLetter + tokens[i].substring(1, tokens[i].length());
		}
		String[] resultArray = searchIngredients(toBeCapped, readDrinksMethod());
		
		sortDrinks(resultArray);
	}
	
	// Method that sorts the final drinks by searching or drinks
	public void sortDrinks(String[] resultArray){
		resultArray = (String[]) Insertion.sort(resultArray);
		this.resultArray = resultArray;
	}
	
	// Get Method
	String[] getResultArray(){
		return resultArray;
	}
	
	void addResults(String[] resultArray){
		for(int i = 0; i < resultArray.length; i++){
			System.out.println(resultArray[i] + "\n");
		}
	}
	
}
