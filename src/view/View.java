package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class View extends JFrame implements ActionListener {
	private static final int FPS = 30;
	private static final int REDRAW_INTERVAL = 1000 / FPS;
	
	private int i;
	
	private JLayeredPane contentPane;
	
	public View() {
		contentPane = getLayeredPane();//new JLayeredPane();
		setPreferredSize(new Dimension(1024, 768));
		i = 500;
		
		setupFrame();

		initRedrawTimer();
	}

	private void setupFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}
	
	private void initRedrawTimer() {
		Timer t = new Timer(REDRAW_INTERVAL, this);
		t.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
	
	public void addGameLayout(Layout layout) {
		layout.setBounds(new Rectangle(1024, 768));
		contentPane.add(layout, new Integer(i++));
	}
	
	public void removeGameLayout(Layout layout) {
		contentPane.remove(layout);
		--i;
	}
}
