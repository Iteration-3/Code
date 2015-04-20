package view.layout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.components.MenuButton;
import controller.SaveMenuController;

@SuppressWarnings("serial")
public class SaveMenuLayout extends Layout {
    private MenuButton backButton;
    private MenuButton save1;
    private MenuButton save2;
    private MenuButton save3;
    private MenuButton save4;
    private MenuButton save5;

    public SaveMenuLayout() {
        setLayout(new GridLayout(6, 1));

        initButtons();
        addButtons();
    }

    private void initButtons() {
        backButton = new MenuButton("GO BACK");
        backButton.setColor(Color.CYAN);

        save1 = new MenuButton("SAVE SLOT ONE");
        save1.setColor(Color.GRAY);

        save2 = new MenuButton("SAVE SLOT TWO");
        save2.setColor(Color.CYAN);

        save3 = new MenuButton("SAVE SLOT THREE");
        save3.setColor(Color.GRAY);

        save4 = new MenuButton("SAVE SLOT FOUR");
        save4.setColor(Color.CYAN);

        save5 = new MenuButton("SAVE SLOT FIVE");
        save5.setColor(Color.GRAY);

    }

    private void addButtons() {
        add(save1);
        add(save2);
        add(save3);
        add(save4);
        add(save5);
        add(backButton);
    }

    public void attachController(SaveMenuController controller) {
        backButton.addActionListener(controller.getBackAction());
        save1.addActionListener(new AbstractAction() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		controller.saveGame(1);
        	}
        });
        save2.addActionListener(new AbstractAction() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		controller.saveGame(2);
        	}
        });
        save3.addActionListener(new AbstractAction() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		controller.saveGame(3);
        	}
        });
        save4.addActionListener(new AbstractAction() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		controller.saveGame(4);
        	}
        });
        save5.addActionListener(new AbstractAction() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		controller.saveGame(5);
        	}
        });
    }
}
