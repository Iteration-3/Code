package view.layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.components.MenuButton;
import controller.LoadMenuController;

@SuppressWarnings("serial")
public class LoadMenuLayout extends Layout {
	private MenuButton backButton;

    public LoadMenuLayout() {
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

    public void attachController(LoadMenuController controller) {   	
    	backButton.addActionListener(new AbstractAction(){
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			controller.back();
    		}
    	});
    }
}
