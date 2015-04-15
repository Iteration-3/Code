package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class View extends JFrame implements ActionListener {
	
	private static final int FPS = 30;
	private static final int REDRAW_INTERVAL = 1000 / FPS;
	
	public View() {
		setupFrame();

		setLayout(new BorderLayout());
		
		initRedrawTimer();
	}
	
	private void setupFrame() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setResizable(false);
		setVisible(true);
	}
	
	private void initRedrawTimer() {
		Timer t = new Timer(REDRAW_INTERVAL, this);
		t.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
