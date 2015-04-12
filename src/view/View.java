package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class View extends JFrame {
	public View() {
		setupFrame();

		setLayout(new BorderLayout());
	}
	
	private void setupFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setResizable(false);
		setVisible(true);
	}
}
