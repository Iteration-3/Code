package model.states.gamestates;

import controller.Controller;
import controller.GameplayController;
import controller.MainMenuController;
import menuactions.ExitGame;
import menuactions.NewGame;
import model.Model;
import model.states.State;
import view.Layout;
import view.MainMenuLayout;

public class MainMenuState extends GameState {
    
    private MainMenuLayout layout;
    private MainMenuController controller;

    public MainMenuState(Model model) {
        super(model);
        this.layout = new MainMenuLayout(new NewGame(model), new ExitGame());
        this.controller = new MainMenuController();
    }

   

    @Override
    protected Controller getController() {
        return controller;
    }

    @Override
    protected Layout getLayout() {
        return this.layout;
    }

}
