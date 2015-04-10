package model.entity;

import model.area.Location;
import model.item.Item;
import model.item.ItemManager;
import model.item.TakeableItem;
import statistics.EntityStatistics;
import utilities.Angle;
import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public abstract class Entity implements SavableLoadable {
	private String name_= null;
	private EntityStatistics stats_ = null;
	private EntityView view_ = null;
	private Location location = null;

	/**
	 * Abstract methods
	 */
	public abstract void attack();
	public abstract StructuredMap getStructuredMap();
	public abstract void load(StructuredMap map);
	public abstract void update();
	//All entities have an ItemManager, but subclasses need specific ones, so it can't be 
	//Contained in the super class, subclasses provide a way to get it via this. 
	protected abstract ItemManager getItemManager();
	
/**
* Concrete methods begin here
* 
*/
	
	/**
	 * @param takeable
	 */
	public void addItem(TakeableItem takeable){
			this.getItemManager().addItem(takeable);
	}
	/**
	 * @param takable
	 */
	public void removeItem(TakeableItem takeable){
		this.getItemManager().removeItem(takeable);
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
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}

}
