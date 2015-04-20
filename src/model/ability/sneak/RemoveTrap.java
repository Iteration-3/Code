package model.ability.sneak;

import model.ability.Ability;
import model.area.TileCoordinate;
import model.entity.Avatar;
import model.entity.EntityManager;
import model.entity.MineSweeper;
import model.skillmanager.SneakSkillManager;

public class RemoveTrap extends Ability {
	
	private SneakSkillManager manager;
	
	public RemoveTrap(SneakSkillManager sneakSkillManager) {
		super(10);
		this.manager = sneakSkillManager;
	}
	

	@Override
	public void perform(Avatar avatar) {
		if (hasMana(avatar)) {
			removeMana(avatar);
			// TODO (jraviles) make the skill matter
			System.out.println("Removing Trap!!");
			boolean success = Math.random() > 0.5;
			if (success) {
				TileCoordinate mineSweeperLocation = avatar.getLocation();
				MineSweeper mineSweeper = new MineSweeper(mineSweeperLocation);
				EntityManager.getSingleton().addPartyNpc(mineSweeper);
				mineSweeper.move(avatar.getDirection());
			} else {
				// You get pushed into the trap when you fail to remove it ;)
				avatar.move(avatar.getDirection());
			}
		}
	}


}
