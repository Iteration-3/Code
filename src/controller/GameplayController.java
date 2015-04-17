package controller;

import controller.listener.Listener;

public class GameplayController {
	private EntityController entityController;

	public GameplayController() {
		this.entityController = new EntityController();
	}
	
	public void addEntityListener(Listener listener) {
		entityController.addListener(listener);
	}
}
