package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.area.RealCoordinate;
import model.area.TileCoordinate;
import model.entity.Entity;
import model.item.TakeableItem;
import model.map.ItemMap;

public class ItemEntityAssociation implements ActionListener {
	private ItemMap itemMap = new ItemMap();
	private Entity entity;

	public ItemEntityAssociation(Entity entity) {
		this.entity = entity;
		startTimer();
	}
	
	public void addItem(TakeableItem takeableItem, RealCoordinate position) {
		itemMap.add(takeableItem, position);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// This can't be good.
		// It is quite verbose to just get the Tile in front of you.
		TileCoordinate tilePositionInFrontOfEntity = entity.getLocation().nextLocation(entity.getDirection());
		System.out.println(tilePositionInFrontOfEntity);
		itemMap.touch(entity, tilePositionInFrontOfEntity);
	}

	private void startTimer() {
		Timer t = new Timer(1000 / 30, this);
		t.start();
	}

}
