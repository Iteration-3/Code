package utilities.structuredmap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class JsonScanner {
	private static final String INTEGER_REGEX = "[-]?(0|[1-9]\\d*)";
	private static final String DOUBLE_REGEX = "[-]?(0|[1-9]\\d*)\\.[0-9]+([eE][-+]?\\d+)?";
	private static final String STRING_REGEX = "\\\"[^\"]*\\\"";
	private static final String[] SIMPLE_TOKEN_REGEXES = { "\\{", "\\}", "\\[", "\\]",":", ",", "true", "false", "null"};
	
	private static final Pattern INTEGER_PATTERN = Pattern.compile(INTEGER_REGEX);
	private static final Pattern DOUBLE_PATTERN = Pattern.compile(DOUBLE_REGEX);
	private static final Pattern STRING_PATTERN = Pattern.compile(STRING_REGEX);
	private static final Pattern tokenizer = Pattern.compile(getTokenizationString());
	
	private static final HashMap<String, JsonToken> tokenLookup = new HashMap<String, JsonToken>();
	static {
		tokenLookup.put("{", new JsonToken(JsonTokenType.LBRACE, "{"));
		tokenLookup.put("}", new JsonToken(JsonTokenType.RBRACE, "}"));
		tokenLookup.put("[", new JsonToken(JsonTokenType.LBRACKET, "["));
		tokenLookup.put("]", new JsonToken(JsonTokenType.RBRACKET, "]"));
		tokenLookup.put(":", new JsonToken(JsonTokenType.COLON, ":"));
		tokenLookup.put(",", new JsonToken(JsonTokenType.COMMA, ","));
		tokenLookup.put("true", new JsonToken(JsonTokenType.TRUE, "true"));
		tokenLookup.put("false", new JsonToken(JsonTokenType.FALSE, "false"));
		tokenLookup.put("null", new JsonToken(JsonTokenType.NULL, "null"));
	}
	
	public static Queue<JsonToken> tokenize(String json) {
		Queue<JsonToken> tokens = new LinkedList<JsonToken>();
		Matcher matcher = tokenizer.matcher(json);
		
		while (matcher.find()) {
			String token = matcher.group();
			System.out.println("___ : " + token);
			if(tokenLookup.containsKey(token)) {
				tokens.offer(tokenLookup.get(token));
			} else if (DOUBLE_PATTERN.matcher(token).matches()) {
				tokens.offer(new JsonToken(JsonTokenType.DOUBLE, token));
			} else if (INTEGER_PATTERN.matcher(token).matches()) {
				tokens.offer(new JsonToken(JsonTokenType.INTEGER, token));
			} else if (STRING_PATTERN.matcher(token).matches()) {
				tokens.offer(new JsonToken(JsonTokenType.STRING, stripQuotes(token)));
			} else {
				throw new IllegalArgumentException(token + " is not a valid JSON token.");
			}
		}
		
		return tokens;
	}
	
	private static String stripQuotes(String str) {
		return str.substring(1, str.length() - 1);
	}
	
	private static String getTokenizationString() {
		StringJoiner joiner = new StringJoiner(")|(");
		
		joiner.add(DOUBLE_REGEX);
		joiner.add(STRING_REGEX);
		
		for (String simpleRegex : SIMPLE_TOKEN_REGEXES) {
			joiner.add(simpleRegex);
		}
		
		return "(" + joiner.toString() + ")";
	}
}