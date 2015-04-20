package model.ability.sneak;

import java.util.ArrayList;

import model.ability.Ability;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.entity.Avatar;
import model.item.Item;
import model.map.ItemMap;
import model.skillmanager.SneakSkillManager;

public class DetectTrap extends Ability {
	
	private SneakSkillManager manager;
	
	public DetectTrap(SneakSkillManager sneakSkillManager) {
		super();
		this.manager = sneakSkillManager;
	}

	@Override
	public void perform(Avatar avatar) {
		TileCoordinate avatarLocation = avatar.getLocation();
		ArrayList<Item> items = ItemMap.getInstance().getItems(new RadialArea(5, avatarLocation));
		for (Item item : items) {
			item.setVisibility(true);
		}
	}


}
