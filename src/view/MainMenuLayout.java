package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import view.components.MenuButton;

@SuppressWarnings("serial")
public class MainMenuLayout extends MenuLayout {

    private MenuButton newGameButton;
    private MenuButton loadGameButton;
    private MenuButton exitGameButton;

    public MainMenuLayout(ActionListener newGame, ActionListener loadGame, ActionListener exitGame) {

        this.newGameButton = new MenuButton("New Game");
        super.formatButton(newGameButton, Color.CYAN);
        this.newGameButton.addActionListener(newGame);

        this.loadGameButton = new MenuButton("Load Game");
        super.formatButton(loadGameButton, Color.GRAY);
        this.loadGameButton.addActionListener(loadGame);

        this.exitGameButton = new MenuButton("Exit Game");
        super.formatButton(exitGameButton, Color.CYAN);
        this.exitGameButton.addActionListener(exitGame);

        setLayout(new GridLayout(3, 1));

        add(newGameButton);
        add(loadGameButton);
        add(exitGameButton);
    }

}
