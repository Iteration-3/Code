package view;

import model.entity.Avatar;
import model.entity.Entity;

@SuppressWarnings("serial")
public class BarterInventoryView extends InventoryView {
	private Entity seller;
	private Avatar buyer;
	
	public BarterInventoryView(Entity seller, Avatar buyer) {
		super();
		setSeller(seller);
		setBuyer(buyer);
	}

	private Entity getSeller() {
		return seller;
	}

	private void setSeller(Entity seller) {
		this.seller = seller;
	}

	private Avatar getBuyer() {
		return buyer;
	}

	private void setBuyer(Avatar buyer) {
		this.buyer = buyer;
	}

}
