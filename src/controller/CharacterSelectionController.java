package controller;

import model.Model;
import model.entity.Smasher;
import model.entity.Sneak;
import model.entity.Summoner;
import model.states.gamestates.GameplayState;
import controller.listener.ToggleAction;

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
        chooseSmasherAction = new ToggleAction() {
            @Override
            public void action() {
                model.switchState(new GameplayState(new Smasher()));
            }
        };

        chooseSummonerAction = new ToggleAction() {
            @Override
            public void action() {
                model.switchState(new GameplayState(new Summoner()));
            }
        };

        chooseSneakAction = new ToggleAction() {
            @Override
            public void action() {
                model.switchState(new GameplayState(new Sneak()));
            }
        };

        backAction = new ToggleAction() {
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
