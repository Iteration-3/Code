package controller;

import model.Model;

public class InventoryMenuController {
	private Model model;
	
	public InventoryMenuController(Model model) {
		this.model = model;
	}
	public void back() {
		model.popState();
	}
}
