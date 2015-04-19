package view.layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import controller.MainMenuController;
import view.components.MenuButton;

@SuppressWarnings("serial")
public class MainMenuLayout extends Layout {	
    private MenuButton newGameButton;
    private MenuButton loadGameButton;
    private MenuButton exitGameButton;

    public MainMenuLayout() {
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
    
    public void attachController(MainMenuController controller) {
    	newGameButton.addActionListener(controller.getNewGameAction());
    	
    	loadGameButton.addActionListener(controller.getLoadGameAction());
    	
    	exitGameButton.addActionListener(controller.getExitAction());
    }  
}
