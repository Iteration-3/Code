package controller;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.Model;
import model.entity.Entity;
import controller.commands.Unequip;
import controller.listener.ToggleAction;
import controller.mouseliseners.EquipmentMouseListener;
import controller.mouseliseners.InventoryMouseListener;
import controller.mouseliseners.InventorySlotMouseListener;

public class InventoryMenuController extends Controller implements SlotViewMouseListenerFactory {
	private Model model;
	private ToggleAction backAction;
	private Entity entity;
	
	public InventoryMenuController(Model model,Entity entity) {
		this.entity = entity;
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
		return new InventorySlotMouseListener(this.entity,i);
	}
	
	public MouseListener makeHelmetListener(){
		return new EquipmentMouseListener(this.entity,Unequip.HELMET);
	}
	public MouseListener makeLeggingsListener(){
		return new EquipmentMouseListener(this.entity,Unequip.LEGGINGS);
	}
	public MouseListener makeWeaponListener(){
		return new EquipmentMouseListener(this.entity,Unequip.WEAPON);
	}
	public MouseListener makeGlovesListener(){
		return new EquipmentMouseListener(this.entity,Unequip.GLOVES);
	}
	public MouseListener makeChestPieceListener(){
		return new EquipmentMouseListener(this.entity,Unequip.CHESTPIECE);
	}
	public MouseListener makeBootsListener(){
		return new EquipmentMouseListener(this.entity,Unequip.BOOTS);
	}
	public MouseListener makeShieldListener(){
		return new EquipmentMouseListener(this.entity,Unequip.SHIELD);
	}
	public MouseListener makeProjectileListener(){
		return new EquipmentMouseListener(this.entity,Unequip.PROJECTILE);
	}

}
