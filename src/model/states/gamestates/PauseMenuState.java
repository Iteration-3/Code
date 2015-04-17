package model.states.gamestates;

import menuactions.MainMenu;
import menuactions.Options;
import menuactions.SaveGame;
import menuactions.StatePop;
import model.Model;
import view.Layout;
import view.PauseMenuLayout;
import controller.Controller;
import controller.PauseMenuController;

public class PauseMenuState extends GameState {

    private PauseMenuLayout pauseMenuLayout;
    private PauseMenuController pauseMenuController;

    public PauseMenuState(Model model) {
        super(model);
        this.pauseMenuLayout = new PauseMenuLayout(new StatePop(getModel()), new Options(getModel()), new SaveGame(
                getModel()), new MainMenu(getModel()));
        this.pauseMenuController = new PauseMenuController();
    }

    @Override
    protected Controller getController() {
        return pauseMenuController;
    }

    @Override
    protected Layout getLayout() {
        return pauseMenuLayout;
    }

}
