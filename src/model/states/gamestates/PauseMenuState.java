package model.states.gamestates;

import view.PauseMenuLayout;
import controller.PauseMenuController;

public class PauseMenuState extends GameState {
    private PauseMenuLayout layout;
    private PauseMenuController controller;

    @Override
    public void onEnter() {
    	layout = new PauseMenuLayout();
        
    	super.onEnter();

    	controller = new PauseMenuController(getContext());
        layout.attachController(controller);
    }
    
    @Override
    public PauseMenuLayout getLayout() {
        return layout;
    }

    @Override
    protected PauseMenuController getController() {
    	return controller;
    }
}
