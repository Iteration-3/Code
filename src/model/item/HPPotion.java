package model.item;

import model.entity.Entity;
import view.item.ItemView;

public class HPPotion extends TakeableItem {
	private int healAmount;

	public HPPotion(ItemView itemView, Price price, int healAmount) {
		super(itemView, price);
		this.healAmount = healAmount;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void use(Entity entity){
		entity.addHealth(healAmount);
	}

}
