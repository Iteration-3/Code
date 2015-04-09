package model.states.gamestates;

import view.Layout;
import controller.Controller;
import model.Model;
import model.states.State;

public abstract class GameState extends State {
	private Model model;
	
	public GameState(Model model) {
		this.model = model;
	}
	
	@Override
	public void onEnter() {
		getModel().setLayout(getLayout());
		getLayout().setController(getController());
	}
	
	@Override
	public void onPause() {}
	
	@Override
	public void onResume() {}
	
	@Override
	public void onExit() {}
	
	public Model getModel() {
		return model;
	}
	
	protected abstract Controller getController();
	
	protected abstract Layout getLayout();
}
