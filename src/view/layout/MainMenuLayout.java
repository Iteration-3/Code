package view.layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import controller.MainMenuController;
import view.components.MenuButton;

@SuppressWarnings("serial")
public class MainMenuLayout extends Layout {	
    private MenuButton newGameButton;
    private MenuButton loadGameButton;
    private MenuButton exitGameButton;

    public MainMenuLayout() {
    	setPreferredSize(new Dimension(1024, 768));
        setLayout(new GridLayout(3, 1));
        
        initButtons();
        addButtons();
    }
    
    private void initButtons() {
        newGameButton = new MenuButton("NEW GAME");
        newGameButton.setColor(Color.CYAN);
        
        loadGameButton = new MenuButton("LOAD GAME");
        loadGameButton.setColor(Color.GRAY);

        exitGameButton = new MenuButton("EXIT GAME");
        exitGameButton.setColor(Color.CYAN);
    }
    
    private void addButtons() {
        add(newGameButton);
        add(loadGameButton);
        add(exitGameButton);
    }
    
    public void setController(MainMenuController controller) {
    	newGameButton.addActionListener(new AbstractAction(){
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			controller.newGame();
    		}
    	});
    	
    	loadGameButton.addActionListener(new AbstractAction(){
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			controller.loadGame();
    		}
    	});
    	
    	exitGameButton.addActionListener(new AbstractAction(){
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			controller.exitGame();
    		}
    	});
    }   
}
