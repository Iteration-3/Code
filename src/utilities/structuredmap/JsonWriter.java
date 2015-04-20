package utilities.structuredmap;

 import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class JsonWriter {
	public void writeStructuredMap(StructuredMap data, String filename) {
		writeString(data.getJson(), filename);
	}
	
	private void writeString(String data, String filename) {
		File file = new File(filename);
		file.getParentFile().mkdirs();
		
		PrintWriter out = null;
		try {
			out = new PrintWriter(file);
			out.println(data);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
}
