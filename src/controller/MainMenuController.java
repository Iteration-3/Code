package controller;

import controller.listener.ToggleAction;
import model.Model;
import model.states.gamestates.CharacterSelectionState;
import model.states.gamestates.LoadMenuState;

public class MainMenuController extends Controller{
	private Model model;
	private ToggleAction newGameAction;
	private ToggleAction loadGameAction;
	private ToggleAction exitGameAction;
	
    public MainMenuController(Model model) {
    	this.model = model;
    	initActions();
    }

    @SuppressWarnings("serial")
	private void initActions() {
    	newGameAction =
	    	new ToggleAction() {
	    		@Override
	    		public void action() {
	    		model.pushState(new CharacterSelectionState());
	    		}
	    	};
	    
	    loadGameAction =
	    	new ToggleAction() {
	    		@Override
	    		public void action() {
	    		model.pushState(new LoadMenuState());
	    		}
    		};
    		
    	exitGameAction = 
			new ToggleAction() {
	    		@Override
		    		public void action() {
		    		System.exit(0);
	    		}
	    	};
    }
    
	public ToggleAction getNewGameAction() {
    	return newGameAction;
   	}
 
	public ToggleAction getLoadGameAction() {
    	return loadGameAction;
    }
    
	public ToggleAction getExitAction() {
    	return exitGameAction;
    }
    
    public void toggle() {
    	newGameAction.toggle();
    	loadGameAction.toggle();
    	exitGameAction.toggle();
    }
}
