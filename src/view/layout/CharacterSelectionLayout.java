package view.layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.components.MenuButton;
import controller.CharacterSelectionController;

@SuppressWarnings("serial")
public class CharacterSelectionLayout extends Layout {

    private MenuButton smasherButton;
    private MenuButton summonerButton;
    private MenuButton sneakButton;
    private MenuButton backButton;

    public CharacterSelectionLayout() {
        setPreferredSize(new Dimension(1024, 768));
        setLayout(new GridLayout(1, 3));

        initButtons();
        addButtons();
    }

    private void initButtons() {
        smasherButton = new MenuButton("SMASHER");
        smasherButton.setColor(Color.CYAN);

        summonerButton = new MenuButton("SUMMONER");
        summonerButton.setColor(Color.GRAY);

        sneakButton = new MenuButton("SNEAK");
        sneakButton.setColor(Color.CYAN);

        backButton = new MenuButton("BACK");
        backButton.setColor(Color.GRAY);
    }

    private void addButtons() {
        add(smasherButton);
        add(summonerButton);
        add(sneakButton);
        add(backButton);
    }

    public void setController(CharacterSelectionController controller) {
        smasherButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startNewSmasherGame();
            }
        });

        summonerButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startNewSummonerGame();
            }
        });

        sneakButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.startNewSneakGame();
            }
        });

        backButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.goBack();
            }
        });
    }
}
