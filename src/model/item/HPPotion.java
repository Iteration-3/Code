package model.item;

import model.entity.Entity;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class HPPotion extends TakeableItem {
	private int healAmount;

	public HPPotion(ItemView itemView, Price price, int healAmount, String name) {
		super(itemView, price, name);
		this.healAmount = healAmount;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void use(Entity entity){
		entity.addHealth(healAmount);
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("healAmount", healAmount);
		return map;
	}
	
	@Override
	protected String getType() {
		return "healItem";
	}
	
	public HPPotion(StructuredMap map){
		super(map);
		this.healAmount = map.getInteger("healAmount");
	}


}
