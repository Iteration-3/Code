package controller;

import model.Model;
import model.entity.EntityManager;
import model.event.EventManager;
import model.trigger.TriggerManager;
import controller.listener.Listener;

public class GameplayController extends Controller {
    private EntityController entityController;
    private Thread updateThread;
    private boolean threadIsRunning;
    private long previousTime;

    public GameplayController(Model model) {
    	threadIsRunning = false;
        this.entityController = new EntityController();
    }

    public void addEntityListener(Listener listener) {
        entityController.addListener(listener);
    }
    
    private void doUpdates(double deltaTime) {
		TriggerManager.getSingleton().update(deltaTime);
		EventManager.getSingleton().update(deltaTime);
		EntityManager.getSingleton().update(deltaTime);
    }
    
    public void spawnUpdateThread() {
    	previousTime = System.nanoTime();
    	updateThread = new Thread(
    		new Runnable() {
    			@Override
    			public void run() {
    				while(true) {
    					if(Thread.interrupted()) {
    					   	threadIsRunning = false;
    						return;
    					}
    					double deltaTime = (System.nanoTime()  - previousTime) / 1000000000.0d;
    					doUpdates(deltaTime);
    					System.out.println(deltaTime);
    					previousTime = System.nanoTime();
    					
    					try {
    						Thread.sleep(1);
    					} catch (InterruptedException e) {
    						Thread.currentThread().interrupt();
    					}
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
