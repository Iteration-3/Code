package gameactions;

import model.Model;
import model.states.gamestates.PauseMenuState;

public class GameActionStateSwitchPause extends GameActionStateSwitch {

    public GameActionStateSwitchPause(Model model) {
        super(model);
    }

    @Override
    public void perform() {
        getModel().pushState(new PauseMenuState(getModel()));
    }

}
