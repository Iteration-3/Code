package model.item;

import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import model.entity.Avatar;

public class Price implements Saveable {
	private int cost;
	
	public Price() {
		this(10);
	}

	public Price(int cost) {
		setCost(cost);
	}
	
	public Price(StructuredMap map) {
		this.cost = map.getInteger("cost");
	}
	
	/**
	 * @param avatar  potential purchaser
	 * @return		  the apparent cost of the item to the avatar based on its still level
	 */
	public int getBarteredCost(Avatar avatar) {
		int barterSkill = avatar.getBarterSkill();
		return (int) Math.round(getCost() - Math.log(barterSkill) * 3);
	}
	
	private void setCost(int cost) {
		this.cost = cost;
	}
	
	private int getCost() {
		return cost;
	}

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("cost", cost);
		return map;
	}

}
