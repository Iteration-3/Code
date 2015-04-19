package view.layout;

import java.awt.Color;

import javax.swing.border.EmptyBorder;

import view.InventoryView;
import view.components.MenuButton;
import controller.barter.BarterMenuController;

@SuppressWarnings("serial")
public final class BarterMenuLayout extends Layout {
	private InventoryView seller, buyer;
	private MenuButton exitButton;
	private final int OFFSET = 25;
	private final int SLOT_WIDTH = 75, SLOT_HEIGHT = 75;
	
	public BarterMenuLayout(InventoryView seller, InventoryView buyer) {
		setSeller(seller);
		setBuyer(buyer);
		
		setLayout(null);
		setBorder(new EmptyBorder(100, 300, 100, 300));
		setOpaque(false);
		
		addViews();
		addExitButton();
	}

	public void attachController(BarterMenuController controller) {
		getSeller().add(controller.getBarterSellingController());
		getBuyer().add(controller.getBarterBuyingController());
		getExitButton().addActionListener(controller.getExitActionListener());
	}
	
	private void addViews() {
		this.buyer.setSlotDimensions(SLOT_WIDTH, SLOT_HEIGHT);
		this.seller.setSlotDimensions(SLOT_WIDTH, SLOT_HEIGHT);
		int width = getSeller().getWidth();
		this.buyer.setBounds(0, 0);
		this.seller.setBounds(width + OFFSET, 0);
		add(getSeller());
		add(getBuyer());
	}
	
	private void addExitButton() {
		setExitButton(new MenuButton("Exit Bargaining"));
		getExitButton().setColor(Color.GRAY);
		getExitButton().setBounds(500, 500, 100, 100);
		add(getExitButton());
	}

	private InventoryView getSeller() {
		return seller;
	}

	private void setSeller(InventoryView seller) {
		this.seller = seller;
	}

	private InventoryView getBuyer() {
		return buyer;
	}

	private void setBuyer(InventoryView customer) {
		this.buyer = customer;
	}
	
	private void setExitButton(MenuButton exitButton) {
		this.exitButton = exitButton;
	}
	
	private MenuButton getExitButton() {
		return this.exitButton;
	}

}
