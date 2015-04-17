import java.util.concurrent.TimeUnit;

import model.Model;


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
			try{
			TimeUnit.MILLISECONDS.sleep(18);
			}catch(Exception e){
				
			}
		}
	}
}
