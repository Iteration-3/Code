package model;

import model.entity.Avatar;
import model.states.StateMachine;
import model.states.gamestates.GameState;
import view.View;
import view.layout.Layout;

public class Model extends StateMachine<GameState> {
	private View view;

	public Model() {
		view = new View();
	}
	
	@Override
	public void pushState(GameState state){
		state.setContext(this); // must be called before super.pushState() so that the
								// GameState may safely call getContext() in its onEnter()
		super.pushState(state);
	}
	
	public void setLayout(Layout layout) {
		view.add(layout);
		view.pack();
		view.setLocationRelativeTo(null);
	}
	
	public void removeLayout(Layout layout) {
	    view.remove(layout);
	}
	
	public Avatar getAvatar() {
		// TODO link in when we have stuff for the model class
		return null;
	}
}
