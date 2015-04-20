package controller;

import model.Model;
import model.states.gamestates.LoadMenuState;
import model.states.gamestates.OptionsMenuState;
import model.states.gamestates.SaveMenuState;
import controller.listener.ToggleAction;

public class PauseMenuController extends Controller {
	private Model model;
	private ToggleAction resumeGameAction;
	private ToggleAction saveGameAction;
	private ToggleAction loadGameAction;
	private ToggleAction optionsAction;
	private ToggleAction mainMenuAction;
	
	public PauseMenuController(Model model) {
		this.model = model;
		initActions();
	}
	
	@SuppressWarnings("serial")
	private void initActions() {
		resumeGameAction =
			new ToggleAction() {
				@Override
				public void action() {
					model.popState();
				}
			};

		saveGameAction =
			new ToggleAction() {
				@Override
				public void action() {
					model.pushState(new SaveMenuState());
				}
			};
		
		loadGameAction =
			new ToggleAction() {
				@Override
				public void action() {
			    	model.pushState(new LoadMenuState());
				}
			};

		optionsAction =
			new ToggleAction() {
				@Override
				public void action() {
			    	model.pushState(new OptionsMenuState());
				}
			};
				
		mainMenuAction =
			new ToggleAction() {
				@Override
				public void action() {
			    	model.popState(); // to before this menu
			    	model.popState(); // and out of Gameplay
				}
			};
	}
	   
    public ToggleAction getResumeGameAction() {
    	return resumeGameAction;
    }

    public ToggleAction getSaveGameAction() {
    	return saveGameAction;
    }
    
    public ToggleAction getLoadGameAction() {
    	return loadGameAction;
    }    
    
    public ToggleAction getOptionsAction() {
    	return optionsAction;
    }
    
    public ToggleAction getMainMenuAction() {
    	return mainMenuAction;
    }
    
	@Override
	public void toggle() {
		resumeGameAction.toggle();
		saveGameAction.toggle();
		loadGameAction.toggle();
		optionsAction.toggle();
		mainMenuAction.toggle();
	}
}
