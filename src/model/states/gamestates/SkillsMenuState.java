package model.states.gamestates;

import view.SkillsMenuLayout;
import controller.SkillsMenuController;

public class SkillsMenuState extends GameState {
	private SkillsMenuLayout layout;
	
    public SkillsMenuState() {
    	layout = new SkillsMenuLayout();
    }
    
    @Override
    public void onEnter() {
    	super.onEnter();
    	
    	SkillsMenuController controller = new SkillsMenuController(getContext());
    	layout.attachController(controller);
    }

    @Override
    protected SkillsMenuLayout getLayout() {
        return layout;
    }
}
