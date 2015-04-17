package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.border.EmptyBorder;

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
        setBorder(new EmptyBorder(100,300,100,300));
        setOpaque(false);
        
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

    public void attachController(PauseMenuController controller) {
    	resumeButton.addActionListener(controller.getResumeGameAction());

    	saveButton.addActionListener(controller.getSaveGameAction());
    	
    	loadButton.addActionListener(controller.getLoadGameAction());

    	optionsButton.addActionListener(controller.getOptionsAction());
    	
    	mainMenuButton.addActionListener(controller.getMainMenuAction());
    }
}

