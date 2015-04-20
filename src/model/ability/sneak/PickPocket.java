package model.ability.sneak;

import model.ability.Ability;
import model.area.TileCoordinate;
import model.entity.Avatar;
import model.entity.Entity;
import model.entity.EntityManager;
import model.entity.behavior.npc.TrooperBehavior;
import model.item.TakeableItem;
import model.skillmanager.SneakSkillManager;

public class PickPocket extends Ability {
	
	private SneakSkillManager manager;
	
	public PickPocket(SneakSkillManager sneakSkillManager) {
		super();
		this.setManaCost(10);
		this.manager = sneakSkillManager;
	}

	@Override
	public void perform(Avatar avatar) {
		if (hasMana(avatar)) {
			removeMana(avatar);
			int pickpocketSkill = manager.getPickPocketSkill();
			if (Math.random() + pickpocketSkill / 100 < 0.75) {
				TileCoordinate nextLocation = avatar.nextLocation();
				Entity entity = EntityManager.getSingleton().getEntityAtLocation(nextLocation);
				if (entity != null) {
					TakeableItem[] items = entity.getItems();
					int countItems = 0;
					for (int i = 0; i < items.length; ++i) {
						if (items[i] != null) {
							++countItems;
						}
					}
					int randomCount = (int) (Math.random() * countItems);
					TakeableItem randomItem = null;
					for (int i = 0; i < items.length; ++i) {
						if (items[i] != null) {
							if (randomCount-- == 0) {
								randomItem = items[i];
								break;
							}
						}
					}
					entity.removeItem(randomItem);
					avatar.addItem(randomItem);
				}
			} else {
				Entity entity = EntityManager.getSingleton().getEntityAtLocation(avatar.nextLocation());
				if (entity != null) {
					entity.push(new TrooperBehavior(7));
				}
			}
		}
	}
}
