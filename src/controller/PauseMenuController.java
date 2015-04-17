package controller;

import model.Model;
import model.states.gamestates.LoadMenuState;
import model.states.gamestates.OptionsMenuState;
import model.states.gamestates.SaveMenuState;

public class PauseMenuController {
	private Model model;
	
	public PauseMenuController(Model model) {
		this.model = model;
	}
	   
    public void resumeGame() {
    	model.popState();
    }

    public void saveGame() {
    	model.pushState(new SaveMenuState());
    }
    
    public void loadGame() {
    	model.pushState(new LoadMenuState());
    }    
    
    public void optionsMenu() {
    	model.pushState(new OptionsMenuState());
    }
    
    public void mainMenu() {
    	model.popState(); // to before this menu
    	model.popState(); // and out of Gameplay
    }
}
