package model.states.gamestates;

import view.layout.KeyBindingsLayout;
import view.layout.Layout;
import controller.Controller;
import controller.KeyBindingsController;

public class KeyBindingsState extends GameState {
    
    private KeyBindingsController controller;
    private KeyBindingsLayout layout;

    public KeyBindingsState() {
        layout = new KeyBindingsLayout();
    }
    
    @Override
    public void onEnter() {
        super.onEnter();
        controller = new KeyBindingsController(getContext());
        controller.setLayout(layout);
        layout.attachController(controller);
    }
    @Override
    protected Layout getLayout() {
        return layout;
    }

    @Override
    protected Controller getController() {
       return controller; 
    }

}
