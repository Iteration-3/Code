package controller.listener;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

@SuppressWarnings("serial")
public abstract class ToggleAction extends AbstractAction {
	private boolean isActive = true;
	
	public abstract void action();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(isActive)
			action();
	}
	
	public void toggle() {
		isActive = !isActive;
	}
}
