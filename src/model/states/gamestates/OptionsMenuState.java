package model.states.gamestates;

import controller.OptionsMenuController;
import view.layout.OptionsMenuLayout;

public class OptionsMenuState extends GameState {
	private OptionsMenuLayout layout;
	private OptionsMenuController controller;
	
    public OptionsMenuState() {
    	layout = new OptionsMenuLayout();
    }
    
    @Override
    public void onEnter() {
    	super.onEnter();
    	
    	controller = new OptionsMenuController(getContext());
    	layout.attachController(controller);
    }

    @Override
    protected OptionsMenuLayout getLayout() {
        return layout;
    }
    
    @Override
    protected OptionsMenuController getController() {
    	return controller;
    }
}