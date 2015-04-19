package utilities.structuredmap;

class JsonToken {
  private String token;
  private JsonTokenType type;

  public JsonToken(JsonTokenType type, String token) {
    this.token = token;
    this.type = type;
  }

  @Override
  public String toString() {
    return token;
  }

  public JsonTokenType getTokenType() {
    return type;
  }
}

enum JsonTokenType {
  LBRACE, RBRACE, LBRACKET, RBRACKET, COLON, COMMA, TRUE, FALSE, NULL, STRING, DOUBLE, INTEGER
}