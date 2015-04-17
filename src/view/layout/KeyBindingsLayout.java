package view.layout;

import java.awt.Color;
import java.awt.Dimension;

import view.components.MenuButton;
import controller.KeyBindingsController;

@SuppressWarnings("serial")
public class KeyBindingsLayout extends Layout {

    private MenuButton backButton;
    private MenuButton rebindUp;
    private MenuButton rebindDown;
    private MenuButton rebindUpLeft;
    private MenuButton rebindUpRight;
    private MenuButton rebindDownLeft;
    private MenuButton rebindDownRight;

    public KeyBindingsLayout() {
        setPreferredSize(new Dimension(1024, 768));

        initButtons();
        addButtons();
    }

    private void addButtons() {
        add(rebindUp);
        add(rebindUpLeft);
        add(rebindUpRight);
        add(rebindDown);
        add(rebindDownLeft);
        add(rebindDownRight);
        add(backButton);
    }

    private void initButtons() {
        backButton = new MenuButton("BACK");
        backButton.setColor(Color.CYAN);

        rebindUp = new MenuButton("REBIND UP");
        rebindUp.setColor(Color.GRAY);

        rebindDown = new MenuButton("REBIND DOWN");
        rebindDown.setColor(Color.GRAY);

        rebindUpLeft = new MenuButton("REBIND UP LEFT");
        rebindUpLeft.setColor(Color.GRAY);

        rebindUpRight = new MenuButton("REBIND UP RIGHT");
        rebindUpRight.setColor(Color.GRAY);

        rebindDownLeft = new MenuButton("REBIND DOWN LEFT");
        rebindDownLeft.setColor(Color.GRAY);

        rebindDownRight = new MenuButton("REBIND DOWN RIGHT");
        rebindDownRight.setColor(Color.GRAY);

    }

    public void attachController(KeyBindingsController controller) {
        backButton.addActionListener(controller.goBackAction());
        rebindUp.addActionListener(controller.getRebindUpAction());
        rebindDown.addActionListener(controller.getRebindDownAction());
        rebindUpLeft.addActionListener(controller.getRebindUpLeftAction());
        rebindUpRight.addActionListener(controller.getRebindUpRightAction());
        rebindDownLeft.addActionListener(controller.getRebindDownLeftAction());
        rebindDownRight.addActionListener(controller.getRebindDownRightAction());
    }

}
