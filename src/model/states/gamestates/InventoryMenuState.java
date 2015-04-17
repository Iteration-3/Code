package model.states.gamestates;

import view.InventoryMenuLayout;
import controller.InventoryMenuController;

public class InventoryMenuState extends GameState {
	private InventoryMenuLayout layout;
	
    public InventoryMenuState() {
    	layout = new InventoryMenuLayout();
    }
    
    @Override
    public void onEnter() {
    	super.onEnter();
    	
    	InventoryMenuController controller = new InventoryMenuController(getContext());
    	layout.attachController(controller);
    }

    @Override
    protected InventoryMenuLayout getLayout() {
        return layout;
    }
}
