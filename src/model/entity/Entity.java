package model.entity;

import model.item.Item;
import model.item.TakeableItem;
import statistics.EntityStatistics;
import utilities.Angle;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public abstract class Entity {
	private String name_= null;
	private EntityStatistics stats_ = null;
	private EntityView view_ = null;

	/**
	 * UNIMPLEMENTED, but done the same across entites subclasses
	 * @param takeable
	 */
	public void addItem(TakeableItem takeable){
		
	}
	/**
	 * UNIMPLEMENTED, but done the same across entites subclasses
	 * @param takable
	 */
	public void removeItem(TakeableItem takable){
		
	}
	/**
	 * UNIMPLEMENTED, but done the same across entites subclasses
	 * @param item
	 */
	public void equipItem(Item item){
		
	}
	/**
	 * UNIMPLEMENTED, but done the same across entites subclasses
	 * @param item
	 */
	public void unequipItem(Item item){
		
	}
	public abstract void attack();
	public abstract StructuredMap save();
	public abstract void load(StructuredMap map);
	public abstract void update();
	
	protected EntityStatistics getDerivedStats(){
		return stats_;
	};
	/**
	 * NOT YET IMPLEMENTED
	 * Takes in the angle to move in, always
	 * moves one square
	 * @param d
	 */
	public void move(Angle d){
		
	}
	/**
	 * Defaults to false, should be overridden for flying shit
	 * @return
	 */
	public boolean isFlying() {
		return false;
	}
	protected EntityView getEntityView(){
		return view_;
	}
	
	public String getName(){
		return name_;
	}
	
	

}
