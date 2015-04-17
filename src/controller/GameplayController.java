package controller;

import controller.listener.Listener;
import view.Layout;

public class GameplayController extends Controller {
	private EntityController entityController; 

	public GameplayController() {
		this.entityController = new EntityController();
	}

	@Override
	public void setLayout(Layout layout) {

	}
	
	public void addEntityListener(Listener listener) {
		entityController.addListener(listener);
	}

	
}
