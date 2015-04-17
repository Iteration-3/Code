package controller;

import model.Model;

public class SaveMenuController {
	private Model model;
	
	public SaveMenuController(Model model) {
		this.model = model;
	}
	public void back() {
		model.popState();
	}
}