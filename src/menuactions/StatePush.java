package menuactions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import model.states.gamestates.GameState;

public abstract class StatePush implements ActionListener {

    private Model model;

    public StatePush(Model model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        model.pushState(stateToPush());
    }

    protected abstract GameState stateToPush();

    protected Model getModel() {
        return this.model;
    }

}
