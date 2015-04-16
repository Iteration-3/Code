package controller;

import javax.swing.AbstractAction;

public class KeyState {
	private AbstractAction action;

	public KeyState(AbstractAction action) {
		this.action = action;
	}

	public AbstractAction getAction() {
		return action;
	}
}
