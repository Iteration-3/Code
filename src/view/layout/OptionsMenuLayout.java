package view.layout;

import java.awt.Color;
import java.awt.GridLayout;

import controller.OptionsMenuController;
import view.components.MenuButton;

@SuppressWarnings("serial")
public class OptionsMenuLayout extends Layout {
    private MenuButton backButton;
    private MenuButton changeUpKeyButton;

    public OptionsMenuLayout() {
        setLayout(new GridLayout(2, 1));
        initButtons();
        addButtons();
    }

    private void initButtons() {
        changeUpKeyButton = new MenuButton("REBIND KEYS");
        changeUpKeyButton.setColor(Color.GRAY);

        backButton = new MenuButton("GO BACK");
        backButton.setColor(Color.CYAN);
    }

    private void addButtons() {
        add(changeUpKeyButton);
        add(backButton);
    }

    public void attachController(OptionsMenuController controller) {
        backButton.addActionListener(controller.getBackAction());
        changeUpKeyButton.addActionListener(controller.getKeyBindingsAction());
    }
}
