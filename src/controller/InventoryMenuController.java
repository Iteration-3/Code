package controller;

import java.awt.event.ActionListener;

import model.Model;
import controller.listener.ToggleAction;

public class InventoryMenuController extends Controller {
	private Model model;
	private ToggleAction backAction;
	
	public InventoryMenuController(Model model) {
		this.model = model;
		initActions();
	}
	
	@SuppressWarnings("serial")
	private void initActions() {
		backAction = new ToggleAction() {
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
	
	public ActionListener makeInventoryActionListener(int i){
		return new InventoryActionListener(i);
	}
	
}
