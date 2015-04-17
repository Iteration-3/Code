package menuactions;

import model.Model;
import model.states.gamestates.GameState;
import model.states.gamestates.MainMenuState;

public class MainMenu extends StatePush {

    public MainMenu(Model model) {
        super(model);
    }

    @Override
    protected GameState stateToPush() {
       return new MainMenuState();
    }

}
