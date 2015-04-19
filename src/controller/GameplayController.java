package controller;

import model.Model;
import model.event.EventManager;
import model.trigger.TriggerManager;
import controller.listener.Listener;

public class GameplayController extends Controller {
    private EntityController entityController;
    private Thread updateThread;
    private boolean threadIsRunning;

    public GameplayController(Model model) {
    	threadIsRunning = false;
        this.entityController = new EntityController();
    }

    public void addEntityListener(Listener listener) {
        entityController.addListener(listener);
    }
    
    private void doUpdates(float deltaTime) {
		TriggerManager.getSingleton().update(deltaTime);
		EventManager.getSingleton().update(deltaTime);
    }
    
    public void spawnUpdateThread() {
    	long previousTime = System.currentTimeMillis();
    	updateThread = new Thread(
    		new Runnable() {
    			@Override
    			public void run() {
    				while(true) {
    					if(Thread.interrupted()) {
    					   	threadIsRunning = false;
    						return;
    					}
    					float deltaTime = (System.currentTimeMillis() - previousTime) / 1000f;
    					doUpdates(deltaTime);
    					previousTime = System.currentTimeMillis();
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
