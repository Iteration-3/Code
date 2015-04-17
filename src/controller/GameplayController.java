package controller;

import controller.listener.Listener;
import view.GameplayLayout;
import view.Layout;

public class GameplayController {
	private EntityController entityController;
	private GameplayLayout layout;

	public GameplayController() {
		this.entityController = new EntityController();
	}

	public void setLayout(GameplayLayout layout) {
		this.layout = layout;
	}
	
	public void addEntityListener(Listener listener) {
		entityController.addListener(listener);
	}

	
}
