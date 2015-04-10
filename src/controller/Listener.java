package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import model.Ability;

public class Listener {
	private KeyStroke key;
	private Ability ability;
	
	public Listener(KeyStroke keystroke, Ability abil){
		key = keystroke;
		ability = abil;
	}
	public void addAsBinding(JPanel panel){
		
		panel.getInputMap().put(key,this);
		panel.getActionMap().put(this,new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//The ActionEvent can be ignored, as it contains the key event, BUT
				//This event is only being triggered for this key anyway.
				//MAYBE later on add something to properly handle on release and on press?
				ability.perform();
				
			}
		});
	}
	
}
