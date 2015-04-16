package model.states.gamestates;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.Timer;

import model.Model;
import model.area.RealCoordinate;
import model.entity.Avatar;
import model.entity.EntityManager;
import model.entity.Smasher;
import model.map.GameTerrain;
import model.map.tile.PassableTile;
import view.EntityView;
import view.GameplayLayout;
import view.map.BasicTileView;
import view.map.TileView;
import controller.GameplayController;
import controller.Listener;

public class GameplayState extends GameState {
	private GameplayController controller;
	private GameplayLayout layout;
	private GameTerrain gameMap;
	
	public GameplayState(Model model) {
		super(model);
		
		layout = new GameplayLayout();
		controller = new GameplayController();
		gameMap = new GameTerrain();
		this.addTilesTest();
		this.addEntityTest();
	}

	public void addEntityTest(){
		RealCoordinate loc = new RealCoordinate(50,50);
		EntityView eView = new EntityView(new Color(200, 200, 0), Color.orange, loc);
		Avatar avatar = new Smasher("Smasher", eView, loc);
		Collection<Listener> listeners = avatar.getListeners();
		for (Listener listener : listeners) {
			listener.addAsBinding(getLayout());
			controller.addEntityListener(listener);
		}
		EntityManager.getSingleton().setAvatar(avatar);
		eView.registerWithGameMapView(layout.getGameEntityView(), loc);
	}

	public void addTilesTest(){
		for(int x = 0; x < 100; ++x) {
			for(int y = 0; y < 100; ++y) {//Hardcoded for as long as the area is
				TileView view = new BasicTileView(new Color(0, 200, 200), Color.WHITE);
				RealCoordinate p = new RealCoordinate(x,y);
				view.registerWithGameMapView(layout.getGameTerrainView(),p);
				gameMap.add(new PassableTile(view),p);
						
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
