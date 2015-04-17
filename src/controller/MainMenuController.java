package controller;

import model.Model;
import model.states.gamestates.GameplayState;
import model.states.gamestates.LoadMenuState;

public class MainMenuController {
	private Model model;
	
    public MainMenuController(Model model) {
    	this.model = model;
    }

    public void newGame() {
    	model.pushState(new GameplayState());
    }
 
    public void loadGame() {
    	model.pushState(new LoadMenuState());
    }
    
    public void exitGame() {
    	System.exit(0);
    }
}
