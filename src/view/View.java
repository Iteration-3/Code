package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class View extends JFrame {
	public View() {
		setupFrame();
		
		setLayout(new BorderLayout());
	}
	
	private void setupFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
