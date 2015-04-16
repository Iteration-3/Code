package controller;

import gameactions.GameAction;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import view.Layout;

public class Listener {
	private KeyStroke key;
	private GameAction gameAction;
	
	public Listener(KeyStroke keystroke, GameAction gameAction){
		key = keystroke;
		this.gameAction = gameAction;
	}
	
	@SuppressWarnings("serial")
	public void addAsBinding(Layout panel){
		
		panel.getInputMap().put(key,this);
		panel.getActionMap().put(this, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//The ActionEvent can be ignored, as it contains the key event, BUT
				//This event is only being triggered for this key anyway.
				//MAYBE later on add something to properly handle on release and on press?
				gameAction.perform();
			}
		});
	}
	
}
