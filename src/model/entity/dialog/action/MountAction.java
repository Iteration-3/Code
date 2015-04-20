package model.entity.dialog.action;

import model.Model;
import model.entity.Avatar;
import model.entity.Mount;
import model.entity.NPC;
import model.entity.dialog.DialogManager;

public final class MountAction extends DialogAction {

	@Override
	public void perform(Model model, NPC npc, Avatar avatar) {
		Mount mount = (Mount)npc;
		mount.setRider(avatar);
		model.setMount(mount);
		DialogManager.getSingleton().exit();
	}

	@Override
	public String getType() {
		return "mount";
	}

}
