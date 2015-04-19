package model.states.gamestates;

import view.layout.Layout;
import controller.Controller;

public class BlankState extends GameState {

	@Override
	public void onEnter() {
	}

	@Override
	public void onPause() {
	}

	@Override
	public void onResume() {
	}

	@Override
	public void onExit() {
	}

	@Override
	protected Layout getLayout() {
		return null;
	}

	@Override
	protected Controller getController() {
		return null;
	}

}
