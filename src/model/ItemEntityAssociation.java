package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.area.RealCoordinate;
import model.entity.Entity;
import model.item.TakeableItem;
import model.map.TakeableItemMap;

public class ItemEntityAssociation implements ActionListener {
	private TakeableItemMap itemMap = new TakeableItemMap();
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
		itemMap.touch(entity);
	}

	private void startTimer() {
		Timer t = new Timer(1000 / 30, this);
		t.start();
	}

}
