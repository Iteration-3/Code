package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import view.components.MenuButton;

@SuppressWarnings("serial")
public class PauseMenuLayout extends MenuLayout {

    private MenuButton resumeButton;
    private MenuButton optionsButton;
    private MenuButton saveButton;
    private MenuButton mainMenuButton;

    public PauseMenuLayout(ActionListener resumeAction, ActionListener optionsAction, ActionListener saveAction,
            ActionListener mainAction) {
        super();
        resumeButton = new MenuButton("Resume Game");
        super.formatButton(resumeButton, Color.CYAN);
        resumeButton.addActionListener(resumeAction);

        optionsButton = new MenuButton("Options");
        super.formatButton(optionsButton, Color.GRAY);
        optionsButton.addActionListener(optionsAction);

        saveButton = new MenuButton("Save Game");
        super.formatButton(saveButton, Color.CYAN);
        saveButton.addActionListener(saveAction);

        mainMenuButton = new MenuButton("Return to Main Menu");
        super.formatButton(mainMenuButton, Color.GRAY);
        mainMenuButton.addActionListener(mainAction);
        
        super.setGridLayout(4, 1);
        
        add(resumeButton);
        add(optionsButton);
        add(saveButton);
        add(mainMenuButton);
    }

}
