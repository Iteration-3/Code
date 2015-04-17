package model.states.gamestates;

import controller.LoadMenuController;
import view.layout.LoadMenuLayout;

public class LoadMenuState extends GameState {
	private LoadMenuLayout layout;
	private LoadMenuController controller;
	
	public LoadMenuState() {
		layout = new LoadMenuLayout();
	}
	
    @Override
    public void onEnter() {
    	super.onEnter();
    	
    	controller = new LoadMenuController(getContext());
    	layout.attachController(controller);
    }

	@Override
	protected LoadMenuLayout getLayout() {
		return layout;
	}
	
    @Override
    protected LoadMenuController getController() {
    	return controller;
    }
}
