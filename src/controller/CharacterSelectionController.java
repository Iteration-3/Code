package controller;

import controller.listener.ToggleAction;
import model.Model;
import model.states.gamestates.GameplayState;
import model.states.gamestates.LoadMenuState;

public class CharacterSelectionController extends Controller {
    private Model model;
    private ToggleAction chooseSmasherAction;
    private ToggleAction chooseSummonerAction;
    private ToggleAction chooseSneakAction;
    private ToggleAction backAction;

    public CharacterSelectionController(Model model) {
        this.model = model;
        initActions();
    }

    @SuppressWarnings("serial")
	private void initActions() {
    	chooseSmasherAction =
			new ToggleAction() {
				@Override
				public void action() {
					model.switchState(new GameplayState());
				}
			};

		chooseSummonerAction =
			new ToggleAction() {
				@Override
				public void action() {
					model.switchState(new GameplayState());
				}
			};
		
		chooseSneakAction =
			new ToggleAction() {
				@Override
				public void action() {
			    	model.switchState(new GameplayState());
				}
			};

		backAction =
			new ToggleAction() {
				@Override
				public void action() {
					model.popState(); 
				}
			};
	}
    
    public ToggleAction getChooseSmasherAction() {
    	return chooseSmasherAction;
    }

    public ToggleAction getChooseSummonerAction() {
    	return chooseSummonerAction;
    }

    public ToggleAction getChooseSneakAction() {
    	return chooseSneakAction;
    }

    public ToggleAction getBackAction() {
       return backAction;
    }

	@Override
	public void toggle() {
	    chooseSmasherAction.toggle();
	    chooseSummonerAction.toggle();
	    chooseSneakAction.toggle();
	    backAction.toggle();
	}

}
