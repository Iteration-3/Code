import java.util.concurrent.TimeUnit;

import model.Model;
import model.event.EventManager;
import model.trigger.TriggerManager;


public class GameLoop {
	private Model model;
	public GameLoop(Model model){
		this.model = model;
	}
	public void startLoop(){
		this.gameLoop();
	}
	private void gameLoop(){
		while(true){
			model.update();
			TriggerManager.getSingleton().update();
			EventManager.getSingleton().update();
			try{
				TimeUnit.MILLISECONDS.sleep(18);
			} catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
