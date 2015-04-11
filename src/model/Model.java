package model;

import view.Layout;
import view.View;
import controller.Controller;
import model.entity.Avatar;
import model.states.StateMachine;
import model.states.gamestates.GameState;

public class Model extends StateMachine<GameState> {
	private View view;

	public Model() {
		view = new View();
	}
	
	public void setLayout(Layout layout) {
		view.add(layout);
		view.pack();
	}
	
	public Avatar getAvatar() {
		// TODO link in when we have stuff for the model class
		return null;
	}
}
