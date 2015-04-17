package model.states.gamestates;

import view.Layout;
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
        layout.setController(controller);        
    }

    @Override
    protected Layout getLayout() {
        return this.layout;
    }

}
