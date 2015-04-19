package view.layout;

import java.awt.Color;
import java.awt.Dimension;
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
	
	private int width = 100;
	private int height = 100;

	private MenuButton backButton;
	private InventoryView inventoryView;
	private EquipmentView equipmentView;
	private MouseListener inventoryMouseListener;

	public InventoryMenuLayout(InventoryView inventoryView,
			EquipmentView equipmentView) {
		setLayout(null);
		this.equipmentView = equipmentView;
		this.inventoryView = inventoryView;
		setPreferredSize(new Dimension(1024, 764));
		setInventoryView(inventoryView);
		setEquipmentView(equipmentView);
		initButtons();
		addViews();
	}

	private void addViews() {
		add(inventoryView);
		add(equipmentView);
		add(backButton);
		this.setOffsets();
	}

	private void setOffsets() {
		inventoryOffsetX = 0;
		inventoryOffsetY = 0;
		equipmentOffsetX = inventoryWidth + 100;
		equipmentOffsetY = 0;
		this.inventoryView.setSlotDimensions(this.width,this.height);
		this.inventoryView.setBounds(inventoryOffsetX, inventoryOffsetY);
		this.equipmentView.setSlotDimensions(this.width,this.height);
		this.equipmentView.setBounds(equipmentOffsetX, equipmentOffsetY);
		this.backButton.setBounds(600, 600,
				this.backButton.getPreferredSize().width,
				this.backButton.getPreferredSize().height);
	}

	private void initButtons() {
		backButton = new MenuButton("GO BACK");
		backButton.setColor(Color.CYAN);
	}

	public void attachController(InventoryMenuController controller) {
		backButton.addActionListener(controller.getBackAction());
		this.inventoryView.add(controller);
//		this.inventoryView.addMouseMotionListener(controller.makeInventoryMouseListener());
		this.equipmentView.add(controller);
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
	
	public void setDimensions(int width, int height){
		this.width = width;
		this.height = height;
	}
}
