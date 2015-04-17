package model.states.gamestates;

import view.MainMenuLayout;
import controller.MainMenuController;

public class MainMenuState extends GameState {
    
    private MainMenuLayout layout;
    private MainMenuController controller;

    public MainMenuState() {
    	layout = new MainMenuLayout();
    }
    
    @Override
    public void onEnter() {
        super.onEnter();
        controller = new MainMenuController(getContext());
        layout.attachController(controller);        
    }

    @Override
    protected MainMenuLayout getLayout() {
        return layout;
    }
    
    @Override
    protected MainMenuController getController() {
    	return controller;
    }

}
