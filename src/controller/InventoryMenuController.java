package controller;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import controller.listener.ToggleAction;
import model.Model;

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
	
	public MouseMotionListener makeInventoryMouseListener(){
		return new InventoryMouseListener();
	}
	
	public MouseListener makeSlotMouseListener(int i){
		return new SlotMouseListener(i);
	}
	
}
