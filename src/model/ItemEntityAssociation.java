package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.area.RealCoordinate;
import model.area.TileCoordinate;
import model.entity.Entity;
import model.item.Item;
import model.map.ItemMap;

public class ItemEntityAssociation implements ActionListener {
	private ItemMap itemMap = new ItemMap();
	private Entity entity;

	public ItemEntityAssociation(Entity entity) {
		this.entity = entity;
		startTimer();
	}
	
	public ItemMap getItemMap(){
		return itemMap;
	}
	
	public void addItem(Item item, TileCoordinate position) {
		itemMap.add(item, position);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// This can't be good.
		// It is quite verbose to just get the Tile in front of you.
		TileCoordinate tilePositionInFrontOfEntity = entity.getLocation().nextLocation(entity.getDirection());
		itemMap.touch(entity, tilePositionInFrontOfEntity);
	}

	private void startTimer() {
		Timer t = new Timer(1000 / 30, this);
		t.start();
	}

}
