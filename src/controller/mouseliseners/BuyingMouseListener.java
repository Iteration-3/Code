package controller.mouseliseners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.entity.Avatar;
import model.entity.NPC;
import model.item.TakeableItem;

public final class BuyingMouseListener implements MouseListener {
	private NPC seller;
	private Avatar buyer;
	int slotNumber;
	
	public BuyingMouseListener(NPC seller, Avatar buyer, int slotNumber) {
		setSeller(seller);
		setBuyer(buyer);
		setSlotNumber(slotNumber);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			// TODO(jraviles) Check prices
			TakeableItem takeableItem = getBuyer().removeItem(getSlotNumber());
			if (takeableItem != null) {
				getSeller().addItem(takeableItem);
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

	private NPC getSeller() {
		return seller;
	}

	private void setSeller(NPC seller) {
		this.seller = seller;
	}

	private Avatar getBuyer() {
		return buyer;
	}

	private void setBuyer(Avatar buyer) {
		this.buyer = buyer;
	}

	private int getSlotNumber() {
		return slotNumber;
	}

	private void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

}
