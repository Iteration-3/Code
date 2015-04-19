package view.components;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import utilities.FontResources;

@SuppressWarnings("serial")
public class MenuButton extends JButton {
	
	public MenuButton(ImageIcon icon){
		super(icon);
        this.setSettings();
	}

	public MenuButton(String buttonText) {
        super(buttonText);
        this.setSettings();
    }
    
    private void setSettings(){
    	setFont(FontResources.getPrimaryFont().deriveFont(24f));
        setBorderPainted(false);
        setFocusPainted(false);
    }
    
    public void setColor(Color color) {
      setBackground(color);
    }  
}
