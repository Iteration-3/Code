package controller;

import java.io.File;

import model.Model;
import model.entity.Summoner;
import model.states.gamestates.GameplayState;
import controller.listener.ToggleAction;

public class LoadMenuController extends Controller {
	private Model model;
	private ToggleAction backAction;
	
	public LoadMenuController(Model model) {
		this.model = model;
		initActions();
	}
	
	@SuppressWarnings("serial")
	private void initActions() {
		backAction =
			new ToggleAction() {
				@Override
				public void action() {
					model.popState();
				}
			};
	}
	
	public void loadGame(int i) {
		String filename = "save" + i + ".json";
		File f = new File("gamedata/" + filename);
		if(f.exists())
			model.pushState(new GameplayState(filename, new Summoner()));
	}
	
	public ToggleAction getBackAction() {
		return backAction;
	}
	
	@Override
	public void toggle() {
		backAction.toggle();
	}
}