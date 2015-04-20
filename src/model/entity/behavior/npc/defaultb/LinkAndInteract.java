package model.entity.behavior.npc.defaultb;

import utilities.Direction;
import model.entity.Entity;

public class LinkAndInteract {
		private Entity chosen;
		private Entity target;
		private int ticker = 300;
		private int count;

		public LinkAndInteract(Entity chosen, Entity target) {
			this.chosen = chosen;
			this.target = target;
		}

		public void perform() {
			if (count++ == ticker){
				this.chosen.move(Direction.PRODUCE_A_ANGLE.getNearestAngleTowardTarget(
						this.chosen.getLocation(), this.target.getLocation()));
				count = 0;
			}
		}
}
