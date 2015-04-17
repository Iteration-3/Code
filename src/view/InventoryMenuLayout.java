package view;

import java.awt.Color;
import java.awt.Dimension;

import controller.InventoryMenuController;
import view.components.MenuButton;

@SuppressWarnings("serial")
public class InventoryMenuLayout extends Layout {
    private MenuButton backButton;

    public InventoryMenuLayout() {
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

    public void attachController(InventoryMenuController controller) {   	
    	backButton.addActionListener(controller.getBackAction());
    }
}
