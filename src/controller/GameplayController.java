package controller;

import controller.listener.Listener;

public class GameplayController extends Controller {
    private EntityController entityController;

    public GameplayController() {
        this.entityController = new EntityController();
    }

    public void addEntityListener(Listener listener) {
        entityController.addListener(listener);
    }

    public void toggle() {

    }

    public void removeListeners() {
        entityController.removeListeners();

    }
}
