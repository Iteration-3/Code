package controller;

import model.Model;
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
	
	public ToggleAction getBackAction() {
		return backAction;
	}
	
	@Override
	public void toggle() {
		backAction.toggle();
	}
}