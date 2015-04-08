package model.entity;

import model.item.Item;

public abstract class Entity {
	private String name_= null;
	private EntityStatistics stats_ = null;
	private EntityView view_ = null;
	
	public abstract boolean isFlying();
	public abstract void move(Direction d);
	public abstract void addItem(TakableItem takeable);
	public abstract void removeItem(TakableItem takable);
	public abstract void equipItem(Item item);
	public abstract void unequipItem(Item item);
	public abstract void attack();
	public abstract StructuredMap save();
	public abstract void load(StructuredMap map);
	
	protected EntityStatitistics getDerivedStats(){
		return stats_;
	};
	protected EntityView getEntityView(){
		return view_;
	}
	
	

}
