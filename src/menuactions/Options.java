package menuactions;

import model.Model;
import model.states.gamestates.GameState;
import model.states.gamestates.OptionsMenuState;

public class Options extends StatePush {

    public Options(Model model) {
        super(model);
    }

    @Override
    protected GameState stateToPush() {
      return new OptionsMenuState(getModel()); 
    }

}
