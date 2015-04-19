package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StringFileReader {
	private static final String resourcesPath = "src/resources/";
	
	// Dumps the entire contents of a file to a String
	public static String readFileContentsAsString(String filename) {
	    String fullyQualifiedFilename = resourcesPath + filename;
	    
	    BufferedReader reader = null;
	    try {
	      File mapFile = new File(fullyQualifiedFilename);
	      reader = new BufferedReader(new FileReader(mapFile));
	      StringBuilder sb = new StringBuilder();
	      
	      String curLine;
	      while((curLine = reader.readLine()) != null) {
	        sb.append(curLine + "\n");
	      }
	      
	      return sb.toString();
	    } catch (IOException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        reader.close();
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	    }

	    return null;
	}
}
