package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

import view.layout.Layout;

@SuppressWarnings("serial")
public class View extends JFrame implements ActionListener {
	private static final int FPS = 30;
	private static final int REDRAW_INTERVAL = 1000 / FPS;
	
	private int currentLayer;
	private List<Layout> activeLayouts;
	
	private JLayeredPane layeredPane;
	
	public View() {
		layeredPane = getLayeredPane();
		setPreferredSize(new Dimension(1024, 768));
		currentLayer = 500;
		
		activeLayouts = new LinkedList<Layout>();
		
		setupFrame();

		initRedrawTimer();
		
		addResizeListener();
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
		Dimension contentSize = layeredPane.getSize();
		layout.setSize(getSize());
		layeredPane.add(layout, new Integer(++currentLayer));
		activeLayouts.add(layout);
	}
	
	public void removeGameLayout(Layout layout) {
		layeredPane.remove(layout);
		activeLayouts.remove(layout);
		--currentLayer;
	}
	
	@Override
	public void revalidate() {
		for(Layout activeLayout : activeLayouts) {
			activeLayout.setBounds(0, 0, getSize().width, getSize().height);
			activeLayout.revalidate();
		}
		super.revalidate();
	}
	
	private void addResizeListener() {
		this.getRootPane().addComponentListener(new ComponentAdapter() {
	        public void componentResized(ComponentEvent e) {
	        	revalidate();
	        }
	    });
	}
}
