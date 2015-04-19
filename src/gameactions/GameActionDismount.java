package gameactions;

import model.Model;

public class GameActionDismount extends GameAction {
	Model model;
	
	public GameActionDismount(Model model) {
		this.model = model;
	}

	@Override
	public void perform() {
		model.dismount();
	}

}
