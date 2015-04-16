package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import view.map.GameTerrainView;

@SuppressWarnings("serial")
public class GameplayLayout extends Layout {
	GameTerrainView test;
	
	public GameplayLayout() {
		test = new GameTerrainView();
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(1024, 768));
	}
	
	public GameTerrainView getGameMapView(){
		return test;
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		test.render(graphics, this.getWidth(), this.getHeight());
	}
}
