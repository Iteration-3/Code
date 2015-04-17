package gameactions;

import model.Model;
import model.states.gamestates.GameState;

public class GameActionStatePush extends GameAction {
    private Model model;
    private GameState state;

    public GameActionStatePush(Model model, GameState state) {
        this.model = model;
        this.state = state;
    }
    
    @Override
    public void perform() {
    	model.pushState(state);
    }
}
