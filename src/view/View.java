package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import view.layout.Layout;

@SuppressWarnings("serial")
public class View extends JFrame {
	private int currentLayer;
	private List<Layout> activeLayouts;
	private JLayeredPane layeredPane;
	
	public View() {
		layeredPane = getLayeredPane();
		setPreferredSize(new Dimension(1024, 768));
		currentLayer = 500;
		
		activeLayouts = new LinkedList<Layout>();
		
		setupFrame();

		addResizeListener();
	}

	private void setupFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setVisible(true);
		pack();
		setLocationRelativeTo(null);
	}
	
	public void addGameLayout(Layout layout) {
		Dimension contentSize = layeredPane.getSize();
		layout.setSize(getSize());
		layeredPane.add(layout, new Integer(++currentLayer));
		activeLayouts.add(layout);
		revalidate();
	}
	
	public void removeGameLayout(Layout layout) {
		layeredPane.remove(layout);
		activeLayouts.remove(layout);
		--currentLayer;
		revalidate();
	}
	
	@Override
	public void revalidate() {
		Dimension paneSize = getContentPane().getSize();

		
		for(Layout activeLayout : activeLayouts) {
			activeLayout.setBounds(0, 0, paneSize.width, paneSize.height);
			activeLayout.revalidate();
			activeLayout.repaint();
		}
		
		super.revalidate();
	}
	
	private void addResizeListener() {
		this.getRootPane().addComponentListener(new ComponentAdapter() {
	        @Override
			public void componentResized(ComponentEvent e) {
	        	revalidate();
	        }
	    });
	}
}
