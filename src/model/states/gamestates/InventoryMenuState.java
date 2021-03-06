package model.states.gamestates;

import model.entity.Avatar;
import model.entity.Entity;
import view.layout.InventoryMenuLayout;
import controller.InventoryMenuController;

public class InventoryMenuState extends GameState {
	private InventoryMenuLayout layout;
	private InventoryMenuController controller;
	private Entity entity;
	
    public InventoryMenuState(Avatar avatar) {
    	//TODO  need to change this so that Avatar does not have getInventoryView()
    	layout = new InventoryMenuLayout(avatar.getInventoryView(),avatar.getEquipmentView());
    	this.entity = avatar;
    }
    
    @Override
    public void onEnter() {
    	super.onEnter();
    	
    	controller = new InventoryMenuController(getContext(),this.entity);
    	layout.attachController(controller);
    }

    @Override
    protected InventoryMenuLayout getLayout() {
        return layout;
    }
    
    @Override
    protected InventoryMenuController getController() {
    	return controller;
    }
}
