package view.layout;

import java.awt.Color;
import java.awt.Dimension;

import controller.OptionsMenuController;
import view.components.MenuButton;

@SuppressWarnings("serial")
public class OptionsMenuLayout extends Layout {
    private MenuButton backButton;
    private MenuButton changeUpKeyButton;

    public OptionsMenuLayout() {
    	setPreferredSize(new Dimension(1024, 768));
     
        initButtons();
        addButtons();
    }
    
    private void initButtons() {
        changeUpKeyButton = new MenuButton("REBIND KEYS");
        changeUpKeyButton.setColor(Color.GRAY);
        
        backButton = new MenuButton("GO BACK");
        backButton.setColor(Color.CYAN);
    }
    
    private void addButtons() {
        add(backButton);
        add(changeUpKeyButton);
    }

    public void attachController(OptionsMenuController controller) {   	
    	backButton.addActionListener(controller.getBackAction());
    	changeUpKeyButton.addActionListener(controller.getKeyBindingsAction());
    }
}
