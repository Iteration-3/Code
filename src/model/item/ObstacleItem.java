package model.item;

import view.item.ItemView;
import model.entity.Entity;
import model.map.tile.ItemTile;

public class ObstacleItem extends Item {

	public ObstacleItem(ItemView itemView) {
		super(itemView);
	}

	@Override
	public void touch(Entity entity) {
		// playBeepNoise() ?? -- Joe
	}

	@Override
	public void use(Entity entity) {
		// Nothing??? -- Joe
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean isBlocking() {
		return true;
	}

	@Override
	public void attemptRemoveFrom(ItemTile itemTile) {
		// TODO This is bad...
		// You don't want to have a method that does nothing...
		System.out.println("Can't remove an Obstacle Item!");
	}

}
