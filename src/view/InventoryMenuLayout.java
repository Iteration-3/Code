package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;


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
    	backButton.addActionListener(new AbstractAction(){
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			controller.back();
    		}
    	});
    }
}
