package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import model.area.Location;
import view.tiles.BasicTileView;
import view.tiles.TileView;

@SuppressWarnings("serial")
public class GameplayLayout extends Layout {
	TileView test;
	
	public GameplayLayout() {
		test = new BasicTileView(new Color(0, 200, 200), Color.WHITE);
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(1024, 768));
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		test.render(graphics, new Location(32, 28), 64);
	}
}
