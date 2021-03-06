package view.layout;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.border.EmptyBorder;

import model.entity.dialog.DialogEntry;
import model.entity.dialog.DialogTree;
import view.components.MenuButton;
import controller.DialogMenuController;

@SuppressWarnings("serial")
public class DialogMenuLayout extends Layout {
	Collection<DialogEntry> dialogEntries;
	Collection<MenuButton> dialogButtons;
	
	public DialogMenuLayout(DialogTree dialogTree) {
		dialogEntries = dialogTree.getDialogEntries();
		int numEntries = dialogEntries.size();

		setLayout(new GridLayout(numEntries, 1));
		setBorder(new EmptyBorder(100, 300, 100, 300));
		setOpaque(false);
		
		initButtons();
		addButtons();
	}
	
	public void attachController(DialogMenuController controller) {
		Iterator<MenuButton> buttonIterator = dialogButtons.iterator();
		Iterator<DialogEntry> entryIterator = dialogEntries.iterator();
		while (buttonIterator.hasNext() && entryIterator.hasNext()) {
			MenuButton button = buttonIterator.next();
			DialogEntry dialogEntry = entryIterator.next();
			button.addActionListener(controller.getActionListener(dialogEntry));
		}
	}
	
	private void initButtons() {
		dialogButtons = new ArrayList<MenuButton>(dialogEntries.size());
		int colorCounter = 0;
		for (DialogEntry dialogEntry : dialogEntries) {
			MenuButton button = new MenuButton(dialogEntry.getEntryText());
			button.setColor(colorCounter % 2 == 0 ? Color.CYAN : Color.GRAY);
			dialogButtons.add(button);
		}
	}
	
	private void addButtons() {
		for (MenuButton button : dialogButtons) {
			add(button);
		}
	}

}
