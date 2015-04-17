package menuactions;

import model.Model;
import model.states.gamestates.GameState;
import model.states.gamestates.SaveMenuState;

public class SaveGame extends StatePush {

    public SaveGame(Model model) {
        super(model);
    }

    @Override
    protected GameState stateToPush() {
        return new SaveMenuState();
    }

}
