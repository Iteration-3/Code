package view;

import java.awt.Color;
import java.awt.Dimension;

import view.components.MenuButton;
import controller.SaveMenuController;

@SuppressWarnings("serial")
public class SaveMenuLayout extends Layout {
	private MenuButton backButton;

    public SaveMenuLayout() {
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

    public void attachController(SaveMenuController controller) {   	
    	backButton.addActionListener(controller.getBackAction());
    }
}
