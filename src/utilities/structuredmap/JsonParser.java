package utilities.structuredmap;

import java.util.ArrayList;
import java.util.Queue;

public class JsonParser {
	private static final IllegalArgumentException INVALID_JSON = new IllegalArgumentException("The JSON provided is invalid.");
	
	public static StructuredMap parse(String json) {
		return parse(JsonScanner.tokenize(json));
	}
	
	private static StructuredMap parse(Queue<JsonToken> tokens) {
		StructuredMap sm = new StructuredMap();

		// JSON must contain a minimum of {}, otherwise, it is invalid.
		if(tokens.size() >= 2) {
			// JSON must always begin with '{'
			if(tokens.poll().getTokenType() != JsonTokenType.LBRACE)
				throw INVALID_JSON;
			
			insertKeyValuePairs(sm, tokens);
			
			// JSON must always end with '}'
			if(tokens.poll().getTokenType() != JsonTokenType.RBRACE)
				throw INVALID_JSON;
		} else {
			throw INVALID_JSON;
		}
			
		return sm;
	}
	
	private static void insertKeyValuePairs(StructuredMap sm, Queue<JsonToken> tokens) {
		while (!tokens.isEmpty()) {
	
			// All key / value pairs start with a String key
			JsonToken curToken = tokens.poll();
			if(curToken.getTokenType() != JsonTokenType.STRING)
				throw INVALID_JSON;
			
			String key = curToken.toString();
			
			// and must be followed by a ':'
			curToken = tokens.poll();
			if(curToken.getTokenType() != JsonTokenType.COLON)
				throw INVALID_JSON;
			
			// now peek ahead to see what kind of value we have
			curToken = tokens.element();		
			switch (curToken.getTokenType()) {
				case LBRACE: // we've encountered an array
					insertArrayValue(sm, key, tokens);
					break; // no token consumption here--it's done inside the helper function
					
				case LBRACKET: // we've encountered a nested object
					sm.put(key, parse(tokens));
					break; // no token consumption here--it's done inside the helper function
				
				case INTEGER:
					sm.put(key, Integer.valueOf(curToken.toString()));
					tokens.poll(); // pop the consumed token
					break;
					
				case DOUBLE:
					sm.put(key, Integer.valueOf(curToken.toString()));
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
					
				case COMMA: // we have another key / value pair, keep going
					continue;
				
				case RBRACKET: // we're done with this object
					return;
				
				default:
					throw INVALID_JSON;
			}
		}
	}
	
	private static void insertArrayValue(StructuredMap sm, String key, Queue<JsonToken> tokens) {
		// JSON arrays must start with '['
		JsonToken curToken = tokens.poll();
		if(curToken.getTokenType() != JsonTokenType.LBRACKET)
			throw INVALID_JSON;
		
		// peek ahead and see what kind of array this is
		curToken = tokens.element();
		if (curToken.getTokenType() == JsonTokenType.INTEGER)  // we've got an int array
			insertIntArray(sm, key, tokens);
		else if (curToken.getTokenType() == JsonTokenType.LBRACE) // we've got a nested object
			insertStructuredMapArray(sm, key, tokens);
		else // we only support two types: integer & SM--anything else is an error
			throw INVALID_JSON; //TODO: (Daniel) consider what happens with an empty array...
		
		
		// and JSON arrays must also end with ']'
		curToken = tokens.poll();
		if(curToken.getTokenType() != JsonTokenType.RBRACKET)
			throw INVALID_JSON;
	}
	
	private static void insertIntArray(StructuredMap sm, String key, Queue<JsonToken> tokens) {
		ArrayList<Integer> intBuffer = new ArrayList<Integer>();
		
		JsonToken curToken = tokens.element();
		while(!tokens.isEmpty()) {
			// the next element must be an int
			if(curToken.getTokenType() == JsonTokenType.INTEGER) {
				intBuffer.add(Integer.valueOf(curToken.toString()));
				tokens.poll(); // pop the consumed int
			} else {
				throw INVALID_JSON;
			}
			
			// which may be followed by
			if(curToken.getTokenType() == JsonTokenType.RBRACE) // the end of the array
				break;
			else if(curToken.getTokenType() == JsonTokenType.COMMA) // or a ',', signifying another int
				continue;
			else // otherwise this is not an int aray
				throw INVALID_JSON;
		}
		

	    int[] intArray = new int[intBuffer.size()];
	    for(int i = 0; i < intArray.length; ++i) {
	      intArray[i] = intBuffer.get(i);
	    }
	    
	    sm.put(key, intArray);
	}
	
	private static void insertStructuredMapArray(StructuredMap sm, String key, Queue<JsonToken> tokens) {
		ArrayList<StructuredMap> smBuffer = new ArrayList<StructuredMap>();
		
		JsonToken curToken = tokens.element();
		while(!tokens.isEmpty()) {
			// the next element must be a StructuredMap
			if(curToken.getTokenType() == JsonTokenType.LBRACE) {
				smBuffer.add(parse(tokens));
			} else {
				throw INVALID_JSON;
			}
			
			// which may be followed by
			if(curToken.getTokenType() == JsonTokenType.RBRACE) // the end of the array
				break;
			else if(curToken.getTokenType() == JsonTokenType.COMMA) // or a ',', signifying another StructuredMap
				continue;
			else // otherwise this is not an StructuredMap aray
				throw INVALID_JSON;
		}
		
		StructuredMap[] smArray = new StructuredMap[smBuffer.size()];
	    for(int i = 0; i < smArray.length; ++i) {
	      smArray[i] = smBuffer.get(i);
	    }
	    
	    sm.put(key, smArray);
	}
}	
