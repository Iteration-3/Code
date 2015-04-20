package view.layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import utilities.ImageProcessing;
import view.EquipmentView;
import view.InventoryView;
import view.components.MenuButton;
import controller.InventoryMenuController;

@SuppressWarnings("serial")
public class InventoryMenuLayout extends Layout {
	private static final String BACKGROUND_PATH = "/images/inventoryLayout.jpg";
	private static BufferedImage background;
	private static int inventoryOffsetX;
	private static int inventoryOffsetY;
	private static int equipmentOffsetX;
	private static int equipmentOffsetY;
	private int inventoryWidth;
	private int inventoryHeight;
	private int equipmentWidth;
	private int equipmentHeight;
	
	private int width = 1024;
	private int height = 764;
	
	private int slotWidth = 100;
	private int slotHeight = 100;

	private MenuButton backButton;
	private InventoryView inventoryView;
	private EquipmentView equipmentView;
	private MouseListener inventoryMouseListener;

	public InventoryMenuLayout(InventoryView inventoryView,
			EquipmentView equipmentView) {
		setLayout(null);
		this.equipmentView = equipmentView;
		this.inventoryView = inventoryView;
		setPreferredSize(new Dimension(this.width, this.height));
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
		this.inventoryView.setSlotDimensions(this.slotWidth,this.slotHeight);
		this.inventoryView.setBounds(inventoryOffsetX, inventoryOffsetY);
		this.equipmentView.setSlotDimensions(this.slotWidth,this.slotHeight);
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
		this.resetBackgroundImage();
	}
	
	public void setSlotDimensions(int width,int height){
		this.slotWidth = width;
		this.slotHeight = height;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(this.getBackgroundImage(),0, 0, null);
	}
	
	private void resetBackgroundImage(){
		background = ImageProcessing.scaleImage(this.width, this.height, BACKGROUND_PATH);
	}
	
	private BufferedImage getBackgroundImage(){
		if (background != null){
			return background;
		}
		else{
			background = ImageProcessing.scaleImage(this.width, this.height, BACKGROUND_PATH);
			return background;
		}
	}
}
