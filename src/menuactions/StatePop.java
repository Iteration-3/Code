package menuactions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;

public class StatePop implements ActionListener {

    private Model model;

    public StatePop(Model model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        model.popState();
    }

}
