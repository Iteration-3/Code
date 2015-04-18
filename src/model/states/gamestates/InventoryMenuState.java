package model.states.gamestates;

import model.entity.Avatar;
import view.layout.InventoryMenuLayout;
import controller.InventoryMenuController;

public class InventoryMenuState extends GameState {
	private InventoryMenuLayout layout;
	private InventoryMenuController controller;
	
    public InventoryMenuState(Avatar avatar) {
    	//TODO  need to change this so that Avatar does not have getInventoryView()
    	System.out.println("Creating");
    	layout = new InventoryMenuLayout(avatar.getInventoryView(),avatar.getEquipmentView());
    }
    
    @Override
    public void onEnter() {
    	super.onEnter();
    	
    	controller = new InventoryMenuController(getContext());
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
