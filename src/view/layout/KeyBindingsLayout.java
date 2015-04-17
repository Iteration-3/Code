package view.layout;

import java.awt.Color;
import java.awt.Dimension;

import view.components.MenuButton;
import controller.KeyBindingsController;

@SuppressWarnings("serial")
public class KeyBindingsLayout extends Layout {

    private MenuButton backButton;
    private MenuButton rebindUp;

    public KeyBindingsLayout() {
        setPreferredSize(new Dimension(1024, 768));

        initButtons();
        addButtons();
    }

    private void addButtons() {
        add(backButton);
        add(rebindUp);
    }

    private void initButtons() {
        backButton = new MenuButton("BACK");
        backButton.setColor(Color.CYAN);

        rebindUp = new MenuButton("REBIND UP");
        rebindUp.setColor(Color.GRAY);
    }
    
    public void attachController(KeyBindingsController controller) {
        
    }

}
