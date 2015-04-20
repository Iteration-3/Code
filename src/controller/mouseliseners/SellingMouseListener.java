package controller.mouseliseners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.entity.Avatar;
import model.entity.Entity;
import model.item.TakeableItem;

public final class SellingMouseListener implements MouseListener {
	private Entity seller;
	private Avatar buyer;
	int slotNumber;
	
	public SellingMouseListener(Entity seller, Avatar buyer, int slotNumber) {
		this.seller = seller;
		this.buyer = buyer;
		this.slotNumber = slotNumber;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			TakeableItem takeableItem = seller.getItem(slotNumber);
			if (takeableItem != null) {
				int itemPrice = takeableItem.getBarteredCost(buyer);
				if (buyer.hasMoney(itemPrice)) {
					buyer.removeMoney(itemPrice);
					seller.removeItem(slotNumber);
					buyer.addItem(takeableItem);
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
