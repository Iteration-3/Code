package model.states.gamestates;

import controller.SaveMenuController;
import view.layout.SaveMenuLayout;

public class SaveMenuState extends GameState {
	private SaveMenuLayout layout;
	
    public SaveMenuState() { 
    	layout = new SaveMenuLayout();
    }

    @Override
    public void onEnter() {
    	super.onEnter();
    	
    	SaveMenuController controller = new SaveMenuController(getContext());
    	layout.attachController(controller);
    }

    @Override
    protected SaveMenuLayout getLayout() {
        return layout;
    }
}
