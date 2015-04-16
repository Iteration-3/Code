package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import view.map.GameEntityView;
import view.map.GameTerrainView;

@SuppressWarnings("serial")
public class GameplayLayout extends Layout {
	GameTerrainView gameTerrainView;
	GameEntityView gameEntityView;
	
	public GameplayLayout() {
		gameTerrainView = new GameTerrainView();
		gameEntityView = new GameEntityView();
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(1024, 768));
	}
	
	public GameTerrainView getGameTerrainView(){
		return gameTerrainView;
	}
	
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		gameTerrainView.render(graphics, this.getWidth(), this.getHeight());
		gameEntityView.render(graphics, this.getWidth(), this.getHeight());
	}

	public GameEntityView getGameEntityView() {
		return gameEntityView;
	}
}
