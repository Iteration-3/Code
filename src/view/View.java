package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.JFrame;

import model.ability.Ability;
import model.ability.SelfAbility;
import controller.Listener;

@SuppressWarnings("serial")
public class View extends JFrame implements ActionListener {
	
	private static final int FPS = 30;
	private static final int REDRAW_INTERVAL = 1000 / FPS;
	
	public View() {
		setupFrame();

		setLayout(new BorderLayout());
		
		initRedrawTimer();
		
		/* Let's test the Listener */
		Listener listener = new Listener(KeyStroke.getKeyStroke('1'), null);
		//listener.addAsBinding();
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
