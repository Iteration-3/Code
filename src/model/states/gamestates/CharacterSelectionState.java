package model.states.gamestates;

import controller.CharacterSelectionController;
import view.layout.CharacterSelectionLayout;
import view.layout.Layout;

public class CharacterSelectionState extends GameState {

    private CharacterSelectionLayout layout;
    private CharacterSelectionController controller;
    
    public CharacterSelectionState() {
        this.layout = new CharacterSelectionLayout();
    }

    @Override
    public void onEnter() {
        super.onEnter();
        controller = new CharacterSelectionController(getContext());
        layout.setController(controller);
    }
    
    @Override
    protected Layout getLayout() {
       return this.layout; 
    }
    
    @Override
    protected CharacterSelectionController getController() {
    	return controller;
    }

}
