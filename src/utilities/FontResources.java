package utilities;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

public class FontResources {
	private static Font primaryFont;
	private static Font titleFont;
	
	static{
		primaryFont = loadFont("AldotheApache.ttf");
		titleFont = loadFont("frau-hex.ttf");
	}
	
	public static Font getPrimaryFont() {
		return primaryFont;
	}
	
	public static Font getTitleFont() {
		return titleFont;
	}
	
	private static Font loadFont(String fontName) {
		Font font = null;
		
		try {
			 InputStream fontStream = FontResources.class.getResourceAsStream("/fonts/" + fontName);
			 font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
		     GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(font);
		} catch (IOException|FontFormatException e) {
		     e.printStackTrace();
		}
		
		return font;
	}
}
