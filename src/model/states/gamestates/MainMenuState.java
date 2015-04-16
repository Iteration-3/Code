package model.states.gamestates;

import menuactions.ExitGame;
import menuactions.LoadGame;
import menuactions.NewGame;
import model.Model;
import view.Layout;
import view.MainMenuLayout;
import controller.Controller;
import controller.MainMenuController;

public class MainMenuState extends GameState {
    
    private MainMenuLayout layout;
    private MainMenuController controller;

    public MainMenuState(Model model) {
        super(model);
        this.layout = new MainMenuLayout(new NewGame(model), new LoadGame(), new ExitGame());
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
