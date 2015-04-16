package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import view.map.GameMapView;

@SuppressWarnings("serial")
public class GameplayLayout extends Layout {
	GameMapView test;
	
	public GameplayLayout() {
		test = new GameMapView();
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(1024, 768));
	}
	
	public GameMapView getGameMapView(){
		return test;
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		test.render(graphics, this.getWidth(), this.getHeight());
	}
}
