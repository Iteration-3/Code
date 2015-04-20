package model.states.gamestates;

import view.layout.LoadMenuLayout;
import controller.LoadMenuController;

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
