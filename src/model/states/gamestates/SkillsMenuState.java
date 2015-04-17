package model.states.gamestates;

import view.layout.SkillsMenuLayout;
import controller.SkillsMenuController;

public class SkillsMenuState extends GameState {
	private SkillsMenuLayout layout;
	private SkillsMenuController controller;
	
    public SkillsMenuState() {
    	layout = new SkillsMenuLayout();
    }
    
    @Override
    public void onEnter() {
    	super.onEnter();
    	
    	controller = new SkillsMenuController(getContext());
    	layout.attachController(controller);
    }

    @Override
    protected SkillsMenuLayout getLayout() {
        return layout;
    }
    
    @Override
    protected SkillsMenuController getController() {
    	return controller;
    }
    @Override
    public void update(){
    	layout.updateLabelText();
    }
}
