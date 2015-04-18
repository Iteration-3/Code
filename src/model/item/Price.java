package model.item;

import model.entity.Avatar;

public class Price {
	private int cost;
	
	public Price() {
		this(10);
	}

	public Price(int cost) {
		setCost(cost);
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

}
