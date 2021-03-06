package model.entity.dialog.action;

import model.Model;
import model.entity.Avatar;
import model.entity.Entity;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public abstract class DialogAction  implements Saveable{
	public abstract void perform(Model model, Entity npc, Avatar avatar);
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("type", getType());
		return map;
	}
	
	public abstract String getType();
}
