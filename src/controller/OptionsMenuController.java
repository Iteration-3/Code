package controller;

import model.Model;

public class OptionsMenuController {
	private Model model;
	
	public OptionsMenuController(Model model) {
		this.model = model;
	}
	public void back() {
		model.popState();
	}
}