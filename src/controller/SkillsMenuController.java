package controller;

import model.Model;

public class SkillsMenuController {
	private Model model;
	
	public SkillsMenuController(Model model) {
		this.model = model;
	}
	public void back() {
		model.popState();
	}
}
