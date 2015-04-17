package controller;

import controller.listener.ToggleAction;
import model.Model;

public class SkillsMenuController extends Controller {
	private Model model;
	private ToggleAction backAction;
	
	public SkillsMenuController(Model model) {
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
	
	public void toggle() {
		backAction.toggle();
	}
}
