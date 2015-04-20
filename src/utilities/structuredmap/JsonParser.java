package utilities.structuredmap;

import java.util.ArrayList;
import java.util.Queue;

public class JsonParser {
	private static final String INVALID_JSON = "The JSON provided is invalid.";
	
	public static StructuredMap parse(String json) {
		Queue<JsonToken> tokens = JsonScanner.tokenize(json);
		for(JsonToken token : tokens);
			//System.out.println(token + "::" + token.getTokenType());
		return parse(JsonScanner.tokenize(json));
	}
	
	private static StructuredMap parse(Queue<JsonToken> tokens) {
		StructuredMap sm = new StructuredMap();

		// JSON must contain a minimum of {}, otherwise, it is invalid.
		if(tokens.size() >= 2) {
			// JSON must always begin with '{'
			JsonToken curToken = tokens.poll();
			if(curToken.getTokenType() != JsonTokenType.LBRACE)
				throw new IllegalArgumentException(INVALID_JSON + " Objects must begin with '{'. @" + curToken);
			
			insertKeyValuePairs(sm, tokens);
			
			// JSON must always end with '}'
			curToken = tokens.poll();
			if(curToken.getTokenType() != JsonTokenType.RBRACE) { 
				tokens.forEach(System.out::println);
				throw new IllegalArgumentException(INVALID_JSON + " Objects must end with '}'. @" + curToken);
			}
		} else {
			throw new IllegalArgumentException(INVALID_JSON + " Objects must contain at least '{' & '}'. @");
		}
			
		return sm;
	}
	
	private static void insertKeyValuePairs(StructuredMap sm, Queue<JsonToken> tokens) {
		while (!tokens.isEmpty()) {
			
			JsonToken curToken = tokens.element();
			if(curToken.getTokenType() == JsonTokenType.RBRACE) {
				return;
			} 
			
			// All key / value pairs start with a String key
			curToken = tokens.poll();
			if(curToken.getTokenType() != JsonTokenType.STRING) {
				tokens.forEach(System.out::println);
				throw new IllegalArgumentException(INVALID_JSON + " Contents of an object must begin with a \"Key\". @" + curToken);
			}
			String key = curToken.toString();
			
			// and must be followed by a ':'
			curToken = tokens.poll();
			if(curToken.getTokenType() != JsonTokenType.COLON)
				throw new IllegalArgumentException(INVALID_JSON + " Keys must be followed by ':'. @" + curToken);
			
			// now peek ahead to see what kind of value we have
			curToken = tokens.element();		
			switch (curToken.getTokenType()) {
				case LBRACKET: // we've encountered an array
					insertArrayValue(sm, key, tokens);
					break; // no token consumption here--it's done inside the helper function
					
				case LBRACE: // we've encountered a nested object
					sm.put(key, parse(tokens));
					break; // no token consumption here--it's done inside the helper function
				
				case INTEGER:
					sm.put(key, Integer.valueOf(curToken.toString()));
					tokens.poll(); // pop the consumed token
					break;
					
				case DOUBLE:
					sm.put(key, Double.valueOf(curToken.toString()));
					tokens.poll(); // pop the consumed token
					break;
					
				case STRING:
					sm.put(key, curToken.toString());
					tokens.poll(); // pop the consumed token
					break;
					
				case TRUE:
					sm.put(key, true);
					tokens.poll(); // pop the consumed token
					break;
				
				case FALSE:
					sm.put(key, false);
					tokens.poll(); // pop the consumed token
					break;
					
				case NULL:
					sm.put(key, (Boolean) null); 	// Boolean in particular is not important in this cast.
					tokens.poll(); // consume token // we just need something to disambiguate which "put" method
					break;						 	// will be used in order to insert a null value. This will not
												 	// be important when the value is read back out.
							
				default:
					throw new IllegalArgumentException(INVALID_JSON + " Invalid Value type for key value pair. @" + curToken);
			}
			//System.out.println(curToken);
			curToken = tokens.element();
			//System.out.println(curToken);
			if(curToken.getTokenType() == JsonTokenType.COMMA) { // we have another key / value pair, keep going
				tokens.poll(); // munch the ','
				continue;
			} else if(curToken.getTokenType() == JsonTokenType.RBRACE) { // we're done with this object
				return;
			} else {
				throw new IllegalArgumentException(INVALID_JSON + " Key / Value entries must be followed by a ',' or a closing '}'. @" + curToken);
			}
		}
	}
	
	private static void insertArrayValue(StructuredMap sm, String key, Queue<JsonToken> tokens) {
		// JSON arrays must start with '['
		JsonToken curToken = tokens.poll();
		if(curToken.getTokenType() != JsonTokenType.LBRACKET)
			throw new IllegalArgumentException(INVALID_JSON + " Arrays must begin with '['. @" + curToken);;
		
		// peek ahead and see what kind of array this is
		curToken = tokens.element();
		if (curToken.getTokenType() == JsonTokenType.INTEGER)  // we've got an int array
			insertIntArray(sm, key, tokens);
		else if (curToken.getTokenType() == JsonTokenType.LBRACE) // we've got a nested object
			insertStructuredMapArray(sm, key, tokens);
		else // we only support two types: integer & SM--anything else is an error
			throw new IllegalArgumentException(INVALID_JSON + " Arrays must contain an int or a nested StructuredMap. @" + curToken);; //TODO: (Daniel) consider what happens with an empty array...
		
		
		// and JSON arrays must also end with ']'
		curToken = tokens.poll();
		if(curToken.getTokenType() != JsonTokenType.RBRACKET)
			throw new IllegalArgumentException(INVALID_JSON + " Arrays must end with ']'. @" + curToken);
	}
	
	private static void insertIntArray(StructuredMap sm, String key, Queue<JsonToken> tokens) {
		ArrayList<Integer> intBuffer = new ArrayList<Integer>();
		
		while(!tokens.isEmpty()) {
			JsonToken curToken = tokens.element();
			// the next element must be an int
			if(curToken.getTokenType() == JsonTokenType.INTEGER) {
				intBuffer.add(Integer.valueOf(curToken.toString()));
				tokens.poll(); // pop the consumed int
			} else {
				throw new IllegalArgumentException(INVALID_JSON + " Integer arrays must only contain ints. @" + curToken);
			}
			
			// which may be followed by
			curToken = tokens.element();
			if(curToken.getTokenType() == JsonTokenType.RBRACKET) { // the end of the array
				break; // don't munch the ']', it gets pulled off from the general array processing function
			} else if(curToken.getTokenType() == JsonTokenType.COMMA) { // or a ',', signifying another int
				tokens.poll(); // eat the ','
				continue; 
			} else {// otherwise this is not an int aray
				throw new IllegalArgumentException(INVALID_JSON + " Integer array entries must be followed by a ',' or a closing ']'. @" + curToken);
			}
		}
		

	    int[] intArray = new int[intBuffer.size()];
	    for(int i = 0; i < intArray.length; ++i) {
	      intArray[i] = intBuffer.get(i);
	    }
	    
	    sm.put(key, intArray);
	}
	
	private static void insertStructuredMapArray(StructuredMap sm, String key, Queue<JsonToken> tokens) {
		ArrayList<StructuredMap> smBuffer = new ArrayList<StructuredMap>();
		
		while(!tokens.isEmpty()) {
			JsonToken curToken = tokens.element();
			// the next element must be a StructuredMap
			if(curToken.getTokenType() == JsonTokenType.LBRACE) {
				smBuffer.add(parse(tokens));
			} else {
				throw new IllegalArgumentException(INVALID_JSON + " StructuredMaps must only contain StructuredMaps '{'. @" + curToken);
			}
			
			// which may be followed by
			curToken = tokens.element();
			if(curToken.getTokenType() == JsonTokenType.RBRACKET) { // the end of the array
				break; // don't munch the '}', it gets pulled off from the general array processing function
			} else if(curToken.getTokenType() == JsonTokenType.COMMA) { // or a ',', signifying another StructuredMap
				tokens.poll(); // munch the ','
				continue;
			} else { // otherwise this is not an StructuredMap aray
				throw new IllegalArgumentException(INVALID_JSON + " StructuredMap array entries ',' or a closing ']'. @" + curToken);
			}
		}
		
		StructuredMap[] smArray = new StructuredMap[smBuffer.size()];
	    for(int i = 0; i < smArray.length; ++i) {
	      smArray[i] = smBuffer.get(i);
	    }
	    
	    sm.put(key, smArray);
	}
}	
