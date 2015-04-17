package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import controller.PauseMenuController;
import view.components.MenuButton;

@SuppressWarnings("serial")
public class PauseMenuLayout extends Layout {
    private MenuButton resumeButton;
    private MenuButton optionsButton;
    private MenuButton saveButton;
    private MenuButton loadButton;
    private MenuButton mainMenuButton;

    public PauseMenuLayout() {
    	setPreferredSize(new Dimension(1024, 768));
        setLayout(new GridLayout(5, 1));
        
        initButtons();
        addButtons();
    }
    
    private void initButtons() {
        resumeButton = new MenuButton("RESUME GAME");
        resumeButton.setColor(Color.CYAN);

        saveButton = new MenuButton("SAVE GAME");
        saveButton.setColor(Color.GRAY);
        
        loadButton = new MenuButton("LOAD GAME");
        loadButton.setColor(Color.CYAN);
        
        optionsButton = new MenuButton("OPTIONS");
        optionsButton.setColor(Color.GRAY);
        
        mainMenuButton = new MenuButton("RETURN TO MAIN MENU");
        mainMenuButton.setColor(Color.CYAN);
    }
    
    private void addButtons() {
        add(resumeButton);
        add(saveButton);
        add(loadButton);
        add(optionsButton);
        add(mainMenuButton);
    }

    public void attachController(final PauseMenuController controller) {
    	resumeButton.addActionListener(new AbstractAction(){
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			controller.resumeGame();
    		}
    	});

    	saveButton.addActionListener(new AbstractAction(){
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			controller.saveGame();
    		}
    	});
    	
    	loadButton.addActionListener(new AbstractAction(){
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			controller.loadGame();
    		}
    	});

    	optionsButton.addActionListener(new AbstractAction(){
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			controller.optionsMenu();
    		}
    	});
    	
    	mainMenuButton.addActionListener(new AbstractAction(){
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			controller.mainMenu();
    		}
    	});
    }
}

