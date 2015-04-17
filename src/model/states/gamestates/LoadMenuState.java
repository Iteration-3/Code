package model.states.gamestates;

import controller.LoadMenuController;
import view.layout.LoadMenuLayout;

public class LoadMenuState extends GameState {
	private LoadMenuLayout layout;
	
	public LoadMenuState() {
		layout = new LoadMenuLayout();
	}
	
    @Override
    public void onEnter() {
    	super.onEnter();
    	
    	LoadMenuController controller = new LoadMenuController(getContext());
    	layout.attachController(controller);
    }

	@Override
	protected LoadMenuLayout getLayout() {
		return layout;
	}
}
