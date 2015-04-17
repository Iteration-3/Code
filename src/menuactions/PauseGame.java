package menuactions;

import model.Model;
import model.states.gamestates.GameState;
import model.states.gamestates.PauseMenuState;

public class PauseGame extends StatePush {

    public PauseGame(Model model) {
        super(model);
    }

    @Override
    protected GameState stateToPush() {
        return new PauseMenuState();
    }

}
