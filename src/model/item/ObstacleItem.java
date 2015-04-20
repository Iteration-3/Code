package model.item;

import model.entity.Entity;
import model.map.tile.ItemTile;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class ObstacleItem extends Item {

	public ObstacleItem(ItemView itemView) {
		super(itemView);
	}
	
	public ObstacleItem(StructuredMap map) {
		super(map);
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
	}

    @Override
    public StructuredMap getStructuredMap() {
        return super.getStructuredMap();
    }

	@Override
	protected String getType() {
		return "obstacleItem";
	}

}
