package controller.barter;

import java.awt.event.MouseListener;

import model.entity.Avatar;
import model.entity.NPC;
import controller.SlotViewMouseListenerFactory;
import controller.mouseliseners.SellingMouseListener;

public class BarterSellingController implements SlotViewMouseListenerFactory {
	private NPC seller;
	private Avatar buyer;
	boolean toggledOn = true;
	
	public BarterSellingController(NPC seller, Avatar buyer) {
		setSeller(seller);
		setBuyer(buyer);
	}
	
	public void toggle() {
		toggledOn = !toggledOn;
	}

	@Override
	public MouseListener makeSlotMouseListener(int slotNumber) {
		return new SellingMouseListener(getSeller(), getBuyer(), slotNumber);
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

}
