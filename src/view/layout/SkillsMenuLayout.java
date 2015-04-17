package view.layout;

import java.awt.Color;
import java.awt.Dimension;

import view.components.MenuButton;
import controller.SkillsMenuController;

@SuppressWarnings("serial")
public class SkillsMenuLayout extends Layout {
    private MenuButton backButton;

    public SkillsMenuLayout() {
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

    public void attachController(SkillsMenuController controller) {   	
    	backButton.addActionListener(controller.getBackAction());
    }
}
