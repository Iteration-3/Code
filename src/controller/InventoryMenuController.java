package controller;

import java.awt.event.MouseListener;

import controller.listener.ToggleAction;
import controller.mouseListeners.EquipmentMouseListener;
import controller.mouseListeners.InventoryMouseListener;
import model.Model;

public class InventoryMenuController extends Controller {
	private Model model;
	private ToggleAction backAction;
	private InventoryMouseListener inventoryMouseListener;
	private EquipmentMouseListener equipmentMouseListener;
	
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
		this.inventoryMouseListener = new InventoryMouseListener(); 
		this.equipmentMouseListener = new EquipmentMouseListener();
	}
	
	public InventoryMouseListener getInventoryMouseListener(){
		return this.inventoryMouseListener;
	}
	
	public EquipmentMouseListener getEquipmentMouseListener(){
		return this.equipmentMouseListener;
	}
	
	public ToggleAction getBackAction() {
		return backAction;
	}
	
	public void toggle() {
		backAction.toggle();
	}
	
}
