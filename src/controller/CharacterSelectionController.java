package controller;

import model.Model;
import model.states.gamestates.GameplayState;

public class CharacterSelectionController {
    private Model model;

    public CharacterSelectionController(Model model) {
        this.model = model;
    }

    public void startNewSmasherGame() {
        model.pushState(new GameplayState());
    }

    public void startNewSummonerGame() {
        model.pushState(new GameplayState());
    }

    public void startNewSneakGame() {
        model.pushState(new GameplayState());
    }

    public void goBack() {
       model.popState(); 
    }

}
