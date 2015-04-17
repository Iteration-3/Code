package model.states.gamestates;

import controller.OptionsMenuController;
import view.OptionsMenuLayout;

public class OptionsMenuState extends GameState {
	private OptionsMenuLayout layout;
	
    public OptionsMenuState() {
    	layout = new OptionsMenuLayout();
    }
    
    @Override
    public void onEnter() {
    	super.onEnter();
    	
    	OptionsMenuController controller = new OptionsMenuController(getContext());
    	layout.attachController(controller);
    }

    @Override
    protected OptionsMenuLayout getLayout() {
        return layout;
    }
}