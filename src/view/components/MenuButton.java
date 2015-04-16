package view.components;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MenuButton extends JButton {
    
    private String description;
    
    public MenuButton() {
        super("Default Button");
    }
    
    public MenuButton(String description) {
        super(description);
        this.description = description;
    }

}
