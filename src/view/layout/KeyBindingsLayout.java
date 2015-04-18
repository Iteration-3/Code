package view.layout;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

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

    private MenuButton rebindAbility0;
    private TextLabel ability0Label;

    private MenuButton rebindAbility1;
    private TextLabel ability1Label;

    private MenuButton rebindAbility2;
    private TextLabel ability2Label;

    private MenuButton rebindAbility3;
    private TextLabel ability3Label;

    private MenuButton rebindAbility4;
    private TextLabel ability4Label;

    private MenuButton rebindAbility5;
    private TextLabel ability5Label;

    private MenuButton rebindAbility6;
    private TextLabel ability6Label;

    private MenuButton rebindAbility7;
    private TextLabel ability7Label;

    private MenuButton rebindAbility8;
    private TextLabel ability8Label;

    private MenuButton rebindAbility9;
    private TextLabel ability9Label;

    public KeyBindingsLayout() {
        setPreferredSize(new Dimension(1024, 768));

        initLabels();
        initButtons();
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
        ability0Label = new TextLabel();
        ability1Label = new TextLabel();
        ability2Label = new TextLabel();
        ability3Label = new TextLabel();
        ability4Label = new TextLabel();
        ability5Label = new TextLabel();
        ability6Label = new TextLabel();
        ability7Label = new TextLabel();
        ability8Label = new TextLabel();
        ability9Label = new TextLabel();
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

        add(rebindAbility1);
        add(ability1Label);
        add(rebindAbility2);
        add(ability2Label);
        add(rebindAbility3);
        add(ability3Label);
        add(rebindAbility4);
        add(ability4Label);
        add(rebindAbility5);
        add(ability5Label);
        add(rebindAbility6);
        add(ability6Label);
        add(rebindAbility7);
        add(ability7Label);
        add(rebindAbility8);
        add(ability8Label);
        add(rebindAbility9);
        add(ability9Label);
        add(rebindAbility0);
        add(ability0Label);

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

        rebindAbility0 = new MenuButton("REBIND ABILITY TEN");
        rebindAbility0.setColor(Color.GRAY);

        rebindAbility1 = new MenuButton("REBIND ABILITY ONE");
        rebindAbility1.setColor(Color.GRAY);

        rebindAbility2 = new MenuButton("REBIND ABILITY TWO");
        rebindAbility2.setColor(Color.GRAY);

        rebindAbility3 = new MenuButton("REBIND ABILITY THREE");
        rebindAbility3.setColor(Color.GRAY);

        rebindAbility4 = new MenuButton("REBIND ABILITY FOUR");
        rebindAbility4.setColor(Color.GRAY);

        rebindAbility5 = new MenuButton("REBIND ABILITY FIVE");
        rebindAbility5.setColor(Color.GRAY);

        rebindAbility6 = new MenuButton("REBIND ABILITY SIX");
        rebindAbility6.setColor(Color.GRAY);

        rebindAbility7 = new MenuButton("REBIND ABILITY SEVEN");
        rebindAbility7.setColor(Color.GRAY);

        rebindAbility8 = new MenuButton("REBIND ABILITY EIGHT");
        rebindAbility8.setColor(Color.GRAY);

        rebindAbility9 = new MenuButton("REBIND ABILITY NINE");
        rebindAbility9.setColor(Color.GRAY);

    }

    public void attachController(KeyBindingsController controller) {
        backButton.addActionListener(controller.goBackAction());
        rebindUp.addActionListener(controller.getRebindUpAction());
        rebindDown.addActionListener(controller.getRebindDownAction());
        rebindUpLeft.addActionListener(controller.getRebindUpLeftAction());
        rebindUpRight.addActionListener(controller.getRebindUpRightAction());
        rebindDownLeft.addActionListener(controller.getRebindDownLeftAction());
        rebindDownRight.addActionListener(controller.getRebindDownRightAction());
        rebindAbility0.addActionListener(controller.getRebindAbility0());
        rebindAbility1.addActionListener(controller.getRebindAbility1());
        rebindAbility2.addActionListener(controller.getRebindAbility2());
        rebindAbility3.addActionListener(controller.getRebindAbility3());
        rebindAbility4.addActionListener(controller.getRebindAbility4());
        rebindAbility5.addActionListener(controller.getRebindAbility5());
        rebindAbility6.addActionListener(controller.getRebindAbility6());
        rebindAbility7.addActionListener(controller.getRebindAbility7());
        rebindAbility8.addActionListener(controller.getRebindAbility8());
        rebindAbility9.addActionListener(controller.getRebindAbility9());
        rebindInventory.addActionListener(controller.getRebindInventory());
        rebindSkills.addActionListener(controller.getRebindSkills());
        rebindPause.addActionListener(controller.getRebindPause());
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

        List<KeyStroke> abilities = preferences.getAbilities();
        ability0Label.setText(formatKey(abilities.get(0)));
        ability1Label.setText(formatKey(abilities.get(1)));
        ability2Label.setText(formatKey(abilities.get(2)));
        ability3Label.setText(formatKey(abilities.get(3)));
        ability4Label.setText(formatKey(abilities.get(4)));
        ability5Label.setText(formatKey(abilities.get(5)));
        ability6Label.setText(formatKey(abilities.get(6)));
        ability7Label.setText(formatKey(abilities.get(7)));
        ability8Label.setText(formatKey(abilities.get(8)));
        ability9Label.setText(formatKey(abilities.get(9)));
    }

    private String formatKey(KeyStroke stroke) {
        return stroke.toString().replaceAll("(pressed|typed) ", "");
    }

}
