package view.components;

import java.awt.Color;

import javax.swing.JButton;

import utilities.FontResources;

@SuppressWarnings("serial")
public class MenuButton extends JButton {
    public MenuButton(String buttonText) {
        super(buttonText);
    	setFont(FontResources.getTitleFont().deriveFont(30f));
        setBorderPainted(false);
        setFocusPainted(false);
    }
    
    public void setColor(Color color) {
      setBackground(color);
    }  
}
