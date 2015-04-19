package controller.mouseliseners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.entity.Avatar;
import model.entity.NPC;
import model.item.TakeableItem;

public final class SellingMouseListener implements MouseListener {
	private NPC seller;
	private Avatar buyer;
	int slotNumber;
	
	public SellingMouseListener(NPC seller, Avatar buyer, int slotNumber) {
		this.seller = seller;
		this.buyer = buyer;
		this.slotNumber = slotNumber;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			// TODO(jraviles) Check prices
			TakeableItem takeableItem = seller.removeItem(slotNumber);
			if (takeableItem != null) {
				buyer.addItem(takeableItem);
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
