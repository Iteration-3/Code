package model.item;

import view.item.ItemView;
import model.entity.Entity;

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

}
