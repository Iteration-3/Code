package model.entity.behavior.npc.interact;

import model.entity.Entity;
import model.entity.EntiyVisitorable;

public interface InteractableBehaviorState extends EntiyVisitorable {
	
	public void interact(Entity entity);

}
