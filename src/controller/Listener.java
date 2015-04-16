package controller;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

import view.Layout;
import model.ability.Ability;

public class Listener {
	private KeyStroke key;
	private Ability ability;
	private boolean down = false;
	private KeyState keyDownState;
	private KeyState keyUpState; 
	
	public Listener(KeyStroke keystroke, Ability abil){
		key = keystroke;
		ability = abil;
	}
	
	@SuppressWarnings("serial")
	public void addAsBinding(Layout panel){

		// Anonymous Classes...
		keyDownState = new KeyState(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				down = true;
				System.out.println("I've been pressed down=" + down);
				// TODO: gameAction.perform();
			}
			
		});
		
		keyUpState = new KeyState(new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				down = false;
				System.out.println("I've been released.  down=" + down);
			}
			
		});

		// Register KeyDown Event
		panel.getInputMap().put(KeyStroke.getKeyStroke("typed " + Character.toString(key.getKeyChar())), keyDownState);
		panel.getActionMap().put(keyDownState, keyDownState.getAction());

		// Register KeyReleased Event
		panel.getInputMap().put(KeyStroke.getKeyStroke("released " + Character.toString(Character.toUpperCase(key.getKeyChar()))), keyUpState);
		panel.getActionMap().put(keyUpState, keyUpState.getAction());
		
	}
	
}
