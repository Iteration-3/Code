package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import model.area.Location;
import view.tileviews.TileView;

public class GameplayLayout extends Layout {
	TileView test;
	
	public GameplayLayout() {
		test = new TileView();
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(1024, 768));
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		test.render(graphics, new Location(0, 0));
	}
}
