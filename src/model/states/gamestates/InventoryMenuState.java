package model.states.gamestates;

import view.InventoryMenuLayout;
import controller.InventoryMenuController;

public class InventoryMenuState extends GameState {
	private InventoryMenuLayout layout;
	private InventoryMenuController controller;
	
    public InventoryMenuState() {
    	layout = new InventoryMenuLayout();
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
