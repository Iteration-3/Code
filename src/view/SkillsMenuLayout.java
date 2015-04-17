package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

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

    public void attachController(final SkillsMenuController controller) {   	
    	backButton.addActionListener(new AbstractAction(){
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			controller.back();
    		}
    	});
    }
}
