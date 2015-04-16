package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

import view.components.MenuButton;

@SuppressWarnings("serial")
public class MainMenuLayout extends Layout {

    private MenuButton button1;
    private MenuButton button2;
    private MenuButton button3;

    public MainMenuLayout(ActionListener newGame, ActionListener exitGame) {

        setPreferredSize(new Dimension(1024, 768));

        this.button1 = new MenuButton("New Game");
        this.button1.addActionListener(newGame);
        this.button1.setLocation(0, 0);
        this.button1.setIcon(new ImageIcon("./src/resources/Boo-and-Buddy.png"));

        this.button2 = new MenuButton("Load Game");
        this.button2.setLocation(100, 100);
        this.button2.setIcon(new ImageIcon("./src/resources/Boo-and-Buddy.png"));
        this.button3 = new MenuButton("Exit Game");
        this.button3.addActionListener(exitGame);
        this.button3.setLocation(200, 200);
        this.button3.setIcon(new ImageIcon("./src/resources/Boo-and-Buddy.png"));
        setLayout(new GridLayout(3, 1));
        add(button1);
        add(button2);
        add(button3);
    }

}
