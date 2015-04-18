package view.layout;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.KeyStroke;

import model.KeyPreferences;
import view.components.MenuButton;
import view.components.TextLabel;
import controller.KeyBindingsController;

@SuppressWarnings("serial")
public class KeyBindingsLayout extends Layout {

    private MenuButton backButton;

    private MenuButton rebindUp;
    private TextLabel upLabel;

    private MenuButton rebindDown;
    private TextLabel downLabel;

    private MenuButton rebindUpLeft;
    private TextLabel upLeftLabel;

    private MenuButton rebindUpRight;
    private TextLabel upRightLabel;

    private MenuButton rebindDownLeft;
    private TextLabel downLeftLabel;

    private MenuButton rebindDownRight;
    private TextLabel downRightLabel;

    private MenuButton rebindPause;
    private TextLabel pauseLabel;

    private MenuButton rebindInventory;
    private TextLabel inventoryLabel;

    private MenuButton rebindSkills;
    private TextLabel skillLabel;

    public KeyBindingsLayout() {
        setPreferredSize(new Dimension(1024, 768));

        initButtons();
        initLabels();
        addComponents();
    }

    private void initLabels() {
        upLabel = new TextLabel();
        downLabel = new TextLabel();
        upLeftLabel = new TextLabel();
        upRightLabel = new TextLabel();
        downLeftLabel = new TextLabel();
        downRightLabel = new TextLabel();
        pauseLabel = new TextLabel();
        skillLabel = new TextLabel();
        inventoryLabel = new TextLabel();
    }

    private void addComponents() {
        add(rebindUp);
        add(upLabel);
        add(rebindUpLeft);
        add(upLeftLabel);
        add(rebindUpRight);
        add(upRightLabel);
        add(rebindDown);
        add(downLabel);
        add(rebindDownLeft);
        add(downLeftLabel);
        add(rebindDownRight);
        add(downRightLabel);
        add(rebindPause);
        add(pauseLabel);
        add(rebindSkills);
        add(skillLabel);
        add(rebindInventory);
        add(inventoryLabel);
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

        rebindPause = new MenuButton("REBIND PAUSE");
        rebindPause.setColor(Color.GRAY);

        rebindSkills = new MenuButton("REBIND SKILLS");
        rebindSkills.setColor(Color.GRAY);

        rebindInventory = new MenuButton("REBIND INVENTORY");
        rebindInventory.setColor(Color.GRAY);

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

    public void updateKeyText(KeyPreferences preferences) {
        upLabel.setText(formatKey(preferences.getUpKey()));
        upLeftLabel.setText(formatKey(preferences.getUpLeftKey()));
        upRightLabel.setText(formatKey(preferences.getUpRightKey()));
        downLabel.setText(formatKey(preferences.getDownKey()));
        downLeftLabel.setText(formatKey(preferences.getDownLeftKey()));
        downRightLabel.setText(formatKey(preferences.getDownRightKey()));
        skillLabel.setText(formatKey(preferences.getSkillsKey()));
        pauseLabel.setText(formatKey(preferences.getPauseKey()));
        inventoryLabel.setText(formatKey(preferences.getInventoryKey()));
    }

    private String formatKey(KeyStroke stroke) {
        return stroke.toString().replaceAll("(pressed|typed) ", "");
    }

}
