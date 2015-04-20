package model.states.gamestates;

import view.layout.SaveMenuLayout;
import controller.SaveMenuController;

public class SaveMenuState extends GameState {
	private SaveMenuLayout layout;
	private SaveMenuController controller;
	
    public SaveMenuState() { 
    	layout = new SaveMenuLayout();
    }

    @Override
    public void onEnter() {
    	super.onEnter();
    	
    	controller = new SaveMenuController(getContext());
    	layout.attachController(controller);
    }

    @Override
    protected SaveMenuLayout getLayout() {
        return layout;
    }

    @Override
    protected SaveMenuController getController() {
    	return controller;
    }
}
