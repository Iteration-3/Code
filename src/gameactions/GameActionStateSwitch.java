package gameactions;

import model.Model;

public abstract class GameActionStateSwitch extends GameAction {

    private Model model;

    public GameActionStateSwitch(Model model) {
        this.model = model;
    }

    protected Model getModel() {
        return this.model;
    }

}
