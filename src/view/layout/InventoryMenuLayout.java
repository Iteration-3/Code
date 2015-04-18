package view.layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;

import controller.InventoryMenuController;
import view.EquipmentView;
import view.InventoryView;
import view.components.MenuButton;

@SuppressWarnings("serial")
public class InventoryMenuLayout extends Layout {
	private static int inventoryOffsetX;
	private static int inventoryOffsetY;
	private static int equipmentOffsetX;
	private static int equipmentOffsetY;
	private int inventoryWidth;
	private int inventoryHeight;
	private int equipmentWidth;
	private int equipmentHeight;

	private MenuButton backButton;
	private InventoryView inventoryView;
	private EquipmentView equipmentView;
	private MouseListener inventoryMouseListener;

	public InventoryMenuLayout(InventoryView inventoryView,
			EquipmentView equipmentView) {
		setLayout(null);
		setPreferredSize(new Dimension(1024, 768));
		setInventoryView(inventoryView);
		setEquipmentView(equipmentView);
		initButtons();
		addViews();
		setFocusable(true);
	}

	private void addViews() {
		addButtons();
		add(inventoryView);
		add(equipmentView);
		this.setOffsets();
	}

	private void setOffsets() {
		inventoryOffsetX = 0;
		inventoryOffsetY = 0;
		equipmentOffsetX = inventoryWidth + 100;
		equipmentOffsetY = 0;
		this.inventoryView.setBounds(inventoryOffsetX, inventoryOffsetY);
		this.equipmentView.setBounds(equipmentOffsetX, equipmentOffsetY);
		this.backButton.setBounds(600, 600,
				this.backButton.getPreferredSize().width,
				this.backButton.getPreferredSize().height);
	}

	private void initButtons() {
		backButton = new MenuButton("GO BACK");
		backButton.setColor(Color.CYAN);
	}

	private void addButtons() {
		add(backButton);
	}

	public void attachController(InventoryMenuController controller) {
		backButton.addActionListener(controller.getBackAction());
		this.inventoryMouseListener = controller.getInventoryMouseListener();
		this.addViews();
		this.inventoryView.addMouseListener(this.inventoryMouseListener);
	}

	public void setInventoryView(InventoryView inventoryView) {
		this.inventoryView = inventoryView;
		this.inventoryWidth = inventoryView.getWidth();
		this.inventoryHeight = inventoryView.getHeight();
	}

	public void setEquipmentView(EquipmentView equipmentView) {
		this.equipmentView = equipmentView;
		this.equipmentWidth = equipmentView.getWidth();
		this.equipmentHeight = equipmentView.getHeight();
	}
}
