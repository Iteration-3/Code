package controller;

import model.Model;
import model.states.gamestates.KeyBindingsState;
import controller.listener.ToggleAction;

public class OptionsMenuController extends Controller {
    private Model model;
    private ToggleAction backAction;
    private ToggleAction keyMappingAction;

    public OptionsMenuController(Model model) {
        this.model = model;
        initActions();
    }

    @SuppressWarnings("serial")
    private void initActions() {
        backAction = new ToggleAction() {
            @Override
            public void action() {
                model.popState();
            }
        };

        keyMappingAction = new ToggleAction() {
            @Override
            public void action() {
                model.pushState(new KeyBindingsState());
            }
        };
    }

    public ToggleAction getBackAction() {
        return backAction;
    }

    public void toggle() {
        backAction.toggle();
    }

    public ToggleAction getKeyBindingsAction() {
        return keyMappingAction;
    }

}