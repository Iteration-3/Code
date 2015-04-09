package model.states.gamestates;

import model.Model;
import controller.GameplayController;
import view.GameplayLayout;

public class GameplayState extends GameState {
	private GameplayController controller;
	private GameplayLayout layout;
	
	public GameplayState(Model model) {
		super(model);
		
		layout = new GameplayLayout();
		controller = new GameplayController();
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
