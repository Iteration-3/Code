package model.states.gamestates;

import model.entity.Avatar;
import model.entity.Entity;
import view.layout.BarterMenuLayout;
import controller.barter.BarterMenuController;

public class BarterState extends GameState {
	private BarterMenuLayout layout;
	private BarterMenuController controller;
	private Entity npc;
	private Avatar avatar;
	
	public BarterState(Entity npc, Avatar avatar) {
		setLayout(new BarterMenuLayout(npc.getInventoryView(), avatar.getInventoryView()));
		setNPC(npc);
		setAvatar(avatar);
	}
	
	@Override
	public void onEnter() {
		super.onEnter();
		setController(new BarterMenuController(getContext(), getNPC(), getAvatar()));
		getLayout().attachController(getController());
	}

	@Override
	protected BarterMenuLayout getLayout() {
		return layout;
	}

	@Override
	protected BarterMenuController getController() {
		return controller;
	}

	private Entity getNPC() {
		return npc;
	}

	private void setNPC(Entity npc) {
		this.npc = npc;
	}

	private Avatar getAvatar() {
		return avatar;
	}

	private void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	private void setLayout(BarterMenuLayout layout) {
		this.layout = layout;
	}

	private void setController(BarterMenuController controller) {
		this.controller = controller;
	}

}
