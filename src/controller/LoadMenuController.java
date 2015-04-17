package controller;

import model.Model;

public class LoadMenuController {
	private Model model;
	
	public LoadMenuController(Model model) {
		this.model = model;
	}
	public void back() {
		model.popState();
	}
}