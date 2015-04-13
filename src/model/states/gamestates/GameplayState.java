package model.states.gamestates;

import java.awt.Color;

import model.Model;
import model.map.GameMap;
import model.map.tile.PassableTile;
import controller.GameplayController;
import utilities.Point;
import view.GameplayLayout;
import view.map.BasicTileView;

public class GameplayState extends GameState {
	private GameplayController controller;
	private GameplayLayout layout;
	private GameMap gameMap;
	
	public GameplayState(Model model) {
		super(model);
		
		layout = new GameplayLayout();
		controller = new GameplayController();
		gameMap = new GameMap();
		this.addTilesTest();
	}
	
	public void addTilesTest(){
		for(int x = 0; x < 100; ++x) {
			for(int y = 0; y < 100; ++y) {//Hardcoded for as long as the area is
				gameMap.equals(new PassableTile(new BasicTileView(new Color(0, 200, 200), Color.WHITE),
						layout.getGameMapView(),new Point(x,y)));
			}
		}
	}
	@Override
	public GameplayController getController() {
		return controller;
	}
	
	@Override
	public GameplayLayout getLayout() {
		return layout;
	}
}
