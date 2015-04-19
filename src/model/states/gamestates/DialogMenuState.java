package model.states.gamestates;

import controller.DialogMenuController;
import view.layout.DialogMenuLayout;
import model.entity.Avatar;
import model.entity.NPC;

public class DialogMenuState extends GameState {
	private DialogMenuLayout layout;
	private DialogMenuController controller;
	private NPC npc;
	private Avatar avatar;
	
	public DialogMenuState(NPC npc, Avatar avatar) {
		setLayout(new DialogMenuLayout(npc.getDialogTree()));
		setNPC(npc);
		setAvatar(avatar);
	}
	
	@Override
	public void onEnter() {
		super.onEnter();
		setController(new DialogMenuController(getContext(), getNPC(), getAvatar()));
		getLayout().attachController(getController());
	}
	
	@Override
	protected DialogMenuLayout getLayout() {
		return layout;
	}
	
	protected void setLayout(DialogMenuLayout layout) {
		this.layout = layout;
	}
	
	@Override
	protected DialogMenuController getController() {
		return this.controller;
	}
	
	protected void setController(DialogMenuController controller) {
		this.controller = controller;
	}
	
	private void setNPC(NPC npc) {
		this.npc = npc;
	}
	
	private NPC getNPC() {
		return this.npc;
	}
	
	private void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}
	
	private Avatar getAvatar() {
		return this.avatar;
	}
}
