package view.layout;

import java.awt.Color;
import java.awt.Dimension;

import controller.OptionsMenuController;
import view.components.MenuButton;

@SuppressWarnings("serial")
public class OptionsMenuLayout extends Layout {
    private MenuButton backButton;

    public OptionsMenuLayout() {
    	setPreferredSize(new Dimension(1024, 768));
     
        initButtons();
        addButtons();
    }
    
    private void initButtons() {
        backButton = new MenuButton("GO BACK");
        backButton.setColor(Color.CYAN);
    }
    
    private void addButtons() {
        add(backButton);
    }

    public void attachController(OptionsMenuController controller) {   	
    	backButton.addActionListener(controller.getBackAction());
    }
}

