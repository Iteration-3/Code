package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import view.components.MenuButton;

@SuppressWarnings("serial")
public class MainMenuLayout extends Layout {

    private MenuButton button1;
    private MenuButton button2;
    private MenuButton button3;

    public MainMenuLayout(ActionListener newGame,  ActionListener loadGame, ActionListener exitGame) {

        setPreferredSize(new Dimension(1024, 768));

        this.button1 = new MenuButton("New Game");
        this.button1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        this.button1.setBackground(Color.CYAN);
        this.button1.setBorderPainted(false);
        this.button1.setFocusPainted(false);
        this.button1.addActionListener(newGame);
        
        this.button2 = new MenuButton("Load Game");
        this.button2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        this.button2.setBorderPainted(false);
        this.button2.setFocusPainted(false);
        this.button2.setBackground(Color.GRAY);
        this.button2.addActionListener(loadGame);

        this.button3 = new MenuButton("Exit Game");
        this.button3.setBorderPainted(false);
        this.button3.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        this.button3.setBackground(Color.CYAN);
        this.button3.setFocusPainted(false);
        this.button3.addActionListener(exitGame);

        setLayout(new GridLayout(3, 1));
        
        add(button1);
        add(button2);
        add(button3);
    }

}
