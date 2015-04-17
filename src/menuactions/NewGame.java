package menuactions;

import model.Model;
import model.states.gamestates.GameState;
import model.states.gamestates.GameplayState;

public class NewGame extends StatePush {

    public NewGame(Model model) {
        super(model);
    }

    @Override
    protected GameState stateToPush() {
        return new GameplayState();
    }

}
