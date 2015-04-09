package view;

import javax.swing.JPanel;

import controller.Controller;

public class Layout extends JPanel {
	
	public void setController(Controller controller) {
		controller.setLayout(this);
	}
}
