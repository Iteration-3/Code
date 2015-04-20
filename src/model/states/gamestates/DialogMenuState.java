package model.states.gamestates;

import controller.DialogMenuController;
import view.layout.DialogMenuLayout;
import model.entity.Avatar;
import model.entity.Entity;
import model.entity.dialog.DialogTree;

public class DialogMenuState extends GameState {
	private DialogMenuLayout layout;
	private DialogMenuController controller;
	private Entity npc;
	private Avatar avatar;
	private DialogTree dialogTree;
	
	public DialogMenuState(Entity npc, Avatar avatar, DialogTree dialogTree) {
		setLayout(new DialogMenuLayout(dialogTree));
		setEntity(npc);
		setAvatar(avatar);
		setDialogTree(dialogTree);
	}
	
	@Override
	public void onEnter() {
		super.onEnter();
		setController(new DialogMenuController(getContext(), getNPC(), getAvatar(), this.dialogTree));
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
	
	private void setEntity(Entity npc) {
		this.npc = npc;
	}
	
	private Entity getNPC() {
		return this.npc;
	}
	
	private void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}
	
	private Avatar getAvatar() {
		return this.avatar;
	}
	
	private void setDialogTree(DialogTree dialogTree){
		this.dialogTree = dialogTree;
	}
}
