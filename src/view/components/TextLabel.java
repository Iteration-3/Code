package view.components;

import javax.swing.JLabel;

import utilities.FontResources;

@SuppressWarnings("serial")
public class TextLabel extends JLabel {
	{
	   setFont(FontResources.getPrimaryFont().deriveFont(24f));
	}
	
	public TextLabel() {
		super();
	}
	
	public TextLabel(String text) {
		super(text);
	}
}
