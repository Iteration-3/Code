package view;

import javax.swing.JPanel;

import controller.Controller;

@SuppressWarnings("serial")
public class Layout extends JPanel {
	
	public void setController(Controller controller) {
		controller.setLayout(this);
	}
}
