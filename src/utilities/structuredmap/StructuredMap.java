package utilities.structuredmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class StructuredMap {
	private Map<String, Object> data;
	
	public StructuredMap() {
		data = new HashMap<String, Object>();
	}
	
	public void put(String key, Boolean value) {
		data.put(key, value);
	}

	public void put(String key, Integer value) {
		data.put(key, value);
	}

	public void put(String key, Double value) {
		data.put(key, value);
	}

	public void put(String key, String value) {
		data.put(key, new QuotedString(value));
	}

	public void put(String key, StructuredMap value) {
		data.put(key, value);
	}

	public void put(String key, int[] values) {
		data.put(key, new IntArrayContainer(values));
	}

	public void put(String key, StructuredMap[] values) {
		data.put(key, new StructuredMapArrayContainer(values));
	}

	public Boolean getBoolean(String key) {
		return (Boolean) data.get(key);
	}

	public Double getDouble(String key) {
		return (Double) data.get(key);
	}

	public Integer getInteger(String key) {
		return (Integer) data.get(key);
 	}

	public String getString(String key) {
		QuotedString quoted = (QuotedString) data.get(key); // get the QuotedString object
		String backingString = quoted.toString(); // get the string literal inside the QuotedString
		return backingString.substring(1, backingString.length() - 1); // trim off the quotes
	}

	public StructuredMap getStructuredMap(String key) {
		return (StructuredMap) data.get(key);
	}

	public int[] getIntArray(String key) {
		IntArrayContainer container = (IntArrayContainer) data.get(key);
		return container.getArray();
	}

	public StructuredMap[] getStructuredMapArray(String key) {
		StructuredMapArrayContainer container = (StructuredMapArrayContainer) data.get(key);
		return container.getArray();
	}
	
	@Override
	public String toString() {
		return getJson();
	}
	
	// Returns a properly formatted String of Json data
	public String getJson() {
		StringJoiner joiner =  new StringJoiner(",\n");
		for (Map.Entry<String, Object> entry : data.entrySet()) {
			String valueString = prependTab(entry.getValue().toString());
			String formattedEntry = String.format("\"%s\":%s", entry.getKey(), valueString);
			joiner.add(formattedEntry);
		}
	
		return String.format("{\n%s\n}", joiner.toString());
	}
	
	// Adds a tab before every line of a multi-line String
	private String prependTab(String str) {
		String[] lines = str.split("\n");
		
		StringJoiner joiner = new StringJoiner("\n");
		for(String line : lines) {
			joiner.add(String.format("\t%s", line));
		}
		
		return joiner.toString();
	}
	
	////////////////////////////////////////////////////////////////
	// Helper classes for correct automatic toString() formatting //
	////////////////////////////////////////////////////////////////
	
	// Strings are a special case in for representing in json because, unlike with booleans, doubles, etc
	// the string is actually wrapped in quotes
	private static class QuotedString {
		private String str;
		
		public QuotedString(String str) {
			this.str = str;
		}
		
		@Override
		public String toString() {
			return String.format("\"%s\"", str);
		}
	}
	
	// The toString() method on arrays in java essentially gives us garbage. This wraps an array and overrides
	// toString() to use a proper array-to-string conversion facility
	private static class IntArrayContainer {
		private int[] array;
		
		public IntArrayContainer(int[] array) {
			this.array = array;
		}
		
		public int[] getArray() {
			return array;
		}
		
		@Override
		public String toString() {
			return Arrays.toString(array);
		}
	}
	
	// Ditto above. Just for StructuredMaps
	private static class StructuredMapArrayContainer {
		private StructuredMap[] array;
		
		public StructuredMapArrayContainer(StructuredMap[] array) {
			this.array = array;
		}
		
		public StructuredMap[] getArray() {
			return array;
		}
		
		@Override
		public String toString() {
			return Arrays.toString(array);
		}
	}
}
