package model;

import view.Layout;
import view.View;
import controller.Controller;
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
}
