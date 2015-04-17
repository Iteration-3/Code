package model.states;

public abstract class State {
	public abstract void onEnter();
	
	public abstract void onPause();
	
	public abstract void onResume();
	
	public abstract void onExit();
}
