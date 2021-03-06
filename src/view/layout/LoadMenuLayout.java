package view.layout;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import view.components.MenuButton;
import controller.LoadMenuController;

@SuppressWarnings("serial")
public class LoadMenuLayout extends Layout {
    private MenuButton backButton;
    private MenuButton load1;
    private MenuButton load2;
    private MenuButton load3;
    private MenuButton load4;
    private MenuButton load5;

    public LoadMenuLayout() {
        setLayout(new GridLayout(6, 1));

        initButtons();
        addButtons();
    }

    private void initButtons() {
        backButton = new MenuButton("GO BACK");
        backButton.setColor(Color.CYAN);

        load1 = new MenuButton("load SLOT ONE");
        load1.setColor(Color.GRAY);

        load2 = new MenuButton("load SLOT TWO");
        load2.setColor(Color.CYAN);

        load3 = new MenuButton("load SLOT THREE");
        load3.setColor(Color.GRAY);

        load4 = new MenuButton("load SLOT FOUR");
        load4.setColor(Color.CYAN);

        load5 = new MenuButton("load SLOT FIVE");
        load5.setColor(Color.GRAY);
    }

    private void addButtons() {
        add(load1);
        add(load2);
        add(load3);
        add(load4);
        add(load5);
        add(backButton);
    }

    public void attachController(LoadMenuController controller) {
        backButton.addActionListener(controller.getBackAction());
        load1.addActionListener(new AbstractAction() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		controller.loadGame(1);
        	}
        });
        load2.addActionListener(new AbstractAction() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		controller.loadGame(2);
        	}
        });
        load3.addActionListener(new AbstractAction() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		controller.loadGame(3);
        	}
        });
        load4.addActionListener(new AbstractAction() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		controller.loadGame(4);
        	}
        });
        load5.addActionListener(new AbstractAction() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		controller.loadGame(5);
        	}
        });
    }
}
