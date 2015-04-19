package controller.barter;

import java.awt.event.MouseListener;

import controller.SlotViewMouseListenerFactory;
import controller.mouseliseners.BuyingMouseListener;
import model.entity.Avatar;
import model.entity.NPC;

public class BarterBuyingController implements SlotViewMouseListenerFactory {
	private NPC seller;
	private Avatar buyer;
	boolean toggledOn = true;
	
	public BarterBuyingController(NPC seller, Avatar buyer) {
		setSeller(seller);
		setBuyer(buyer);
	}
	
	public void toggle() {
		toggledOn = !toggledOn;
	}
	
	@Override
	public MouseListener makeSlotMouseListener(int slowNumber) {
		return new BuyingMouseListener(getSeller(), getBuyer(), slowNumber);
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
