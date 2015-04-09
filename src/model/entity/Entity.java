package model.entity;

import view.EntityView;
import statistics.EntityStatistics;
import utilities.Angle;
import model.item.Item;
import model.item.TakeableItem;

public abstract class Entity {
	private String name_= null;
	private EntityStatistics stats_ = null;
	private EntityView view_ = null;
	
	public abstract boolean isFlying();
	public abstract void move(Angle d);
	public abstract void addItem(TakeableItem takeable);
	public abstract void removeItem(TakeableItem takable);
	public abstract void equipItem(Item item);
	public abstract void unequipItem(Item item);
	public abstract void attack();
	public abstract StructuredMap save();
	public abstract void load(StructuredMap map);
	public abstract void update();
	
	protected EntityStatistics getDerivedStats(){
		return stats_;
	};
	protected EntityView getEntityView(){
		return view_;
	}
	
	

}
