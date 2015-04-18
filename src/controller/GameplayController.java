package controller;

import model.Model;
import model.event.EventManager;
import model.trigger.TriggerManager;
import controller.listener.Listener;

public class GameplayController extends Controller {
    private EntityController entityController;
    private Thread updateThread;
    private Model model;
    private boolean threadIsRunning;

    public GameplayController(Model model) {
    	threadIsRunning = false;
        this.entityController = new EntityController();
        this.model = model;
    }

    public void addEntityListener(Listener listener) {
        entityController.addListener(listener);
    }
    
    private void doUpdates() {
		model.update();
		TriggerManager.getSingleton().update();
		EventManager.getSingleton().update();
    }
    
    public void spawnUpdateThread() {
    	updateThread = new Thread(
    		new Runnable() {
    			@Override
    			public void run() {
    				while(true) {
    					if(Thread.interrupted()) {
    					   	threadIsRunning = false;
    						return;
    					}
    					doUpdates();
    				}
    			}
    		});
    	updateThread.start();
    	threadIsRunning = true;
    }
    
    public void terminateUpdateThread() {
    	if(updateThread != null)
    		updateThread.interrupt();
    	updateThread = null;
     }

    public void toggle() {
    	if(threadIsRunning) {
    		terminateUpdateThread();
    	} else {
    		spawnUpdateThread();
    	}
    }

    public void removeListeners() {
        entityController.removeListeners();
    }
}
