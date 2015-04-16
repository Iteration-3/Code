package menuactions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import model.states.gamestates.GameplayState;

public class NewGame implements ActionListener {

    private Model model;

    public NewGame(Model model) { 
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.pushState(new GameplayState(model));
    }

}
