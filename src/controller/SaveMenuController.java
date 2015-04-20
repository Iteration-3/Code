package controller;

import model.Model;
import controller.listener.ToggleAction;

public class SaveMenuController extends Controller {
	private Model model;
	private ToggleAction backAction;
	
	public SaveMenuController(Model model) {
		this.model = model;
		initActions();
	}
	
	public void saveGame(int i) {
		String filename = "save" + i + ".json";
		model.save(filename);
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
	
	public ToggleAction getBackAction() {
		return backAction;
	}
	
	@Override
	public void toggle() {
		backAction.toggle();
	}
}