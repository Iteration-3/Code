package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utilities.ImageProcessing;

public class EquipmentView {
	private static final int WIDTH = 3;
	private static final int HEIGHT = 4;
	private static final int SLOT_HEIGHT = 100;
	private static final int SLOT_WIDTH = 100;
	private static final float EQUIPMENT_SCALE = 80;	//this is a percentage of the height and scale
	
	private static final String HELMET_PATH = "src/resources/images/helmet_slot.jpg";
	private static final String CHEST_PIECE_PATH = "src/resources/images/chest_piece_slot.jpg";
	private static final String LEGGINGS_PATH = "src/resources/images/leggings_slot.jpg";
	private static final String BOOTS_PATH = "src/resources/images/boots_slot.jpg";
	private static final String WEAPON_PATH = "src/resources/images/weapon_slot.jpg";
	private static final String SHIELD_PATH = "src/resources/images/shield_slot.jpg";
	private static final String PROJECTILE_PATH = "src/resources/images/projectile_slot.jpg";
	private static final String GLOVES_PATH = "src/resources/images/gloves_slot.jpg";
	
	private static final int helmetX = SLOT_WIDTH;
	private static final int helmetY = 0;
	private static final int chestPieceX = helmetX;
	private static final int chestPieceY = helmetY + SLOT_HEIGHT;
	private static final int leggingsX = chestPieceX;
	private static final int leggingsY = chestPieceY +SLOT_HEIGHT;
	private static final int bootsX = leggingsX;
	private static final int bootsY = leggingsY + SLOT_HEIGHT;
	private static final int weaponX = chestPieceX - SLOT_WIDTH;
	private static final int weaponY = chestPieceY;
	private static final int glovesX = leggingsX - SLOT_WIDTH;
	private static final int glovesY = leggingsY;
	private static final int shieldX = chestPieceX + SLOT_WIDTH;
	private static final int shieldY = chestPieceY;
	private static final int projectileX = helmetX + SLOT_WIDTH;
	private static final int projectileY = helmetY;

	private static BufferedImage helmetImage;
	private static BufferedImage chestPieceImage;
	private static BufferedImage leggingsImage;
	private static BufferedImage bootsImage;
	private static BufferedImage weaponImage;
	private static BufferedImage shieldImage;
	private static BufferedImage projectileImage;
	private static BufferedImage glovesImage;
	
	private static SlotView helmetView;
	private static SlotView chestPieceView;
	private static SlotView leggingsView;
	private static SlotView bootsView;
	private static SlotView weaponView;
	private static SlotView shieldView;
	private static SlotView projectileView;
	private static SlotView glovesView;
	
	public EquipmentView(){
		setImages();
	}
	
	private void setImages(){
		helmetImage = ImageProcessing.scaleImage(SLOT_WIDTH, SLOT_HEIGHT, HELMET_PATH);
		chestPieceImage = ImageProcessing.scaleImage(SLOT_WIDTH, SLOT_HEIGHT, CHEST_PIECE_PATH);
		leggingsImage = ImageProcessing.scaleImage(SLOT_WIDTH, SLOT_HEIGHT, LEGGINGS_PATH);
		bootsImage = ImageProcessing.scaleImage(SLOT_WIDTH,SLOT_HEIGHT, BOOTS_PATH);
		weaponImage = ImageProcessing.scaleImage(SLOT_WIDTH, SLOT_HEIGHT, WEAPON_PATH);
		shieldImage = ImageProcessing.scaleImage(SLOT_WIDTH, SLOT_HEIGHT, SHIELD_PATH);
		projectileImage = ImageProcessing.scaleImage(SLOT_WIDTH, SLOT_HEIGHT, PROJECTILE_PATH);
		glovesImage = ImageProcessing.scaleImage(SLOT_WIDTH, SLOT_HEIGHT, GLOVES_PATH);
	}
	
	private void setView(SlotView slot,BufferedImage image){
		slot.setBackground(image);
	}
	
	public void registerHelmet(SlotView slotView){
		helmetView = slotView;
		this.setView(slotView,helmetImage);
	}
	public void registerChestPiece(SlotView slotView){
		chestPieceView = slotView;
		this.setView(slotView,chestPieceImage);
	}
	public void registerLeggings(SlotView slotView){
		leggingsView = slotView;
		this.setView(slotView,leggingsImage);
	}
	public void registerBoots(SlotView slotView){
		bootsView = slotView;
		this.setView(slotView,bootsImage);
	}
	public void registerWeapon(SlotView slotView){
		weaponView = slotView;
		this.setView(slotView,weaponImage);
	}
	public void registerShield(SlotView slotView){
		shieldView = slotView;
		this.setView(slotView,shieldImage);
	}
	public void registerGloves(SlotView slotView){
		glovesView = slotView;
		this.setView(slotView,glovesImage);
	}
	public void registerProjectile(SlotView slotView){
		projectileView = slotView;
		this.setView(slotView,projectileImage);
	}
	
	public void render(Graphics g, int x, int y){
		float itemDiameter = 40;
		helmetView.render(g,helmetX + x ,helmetY + y , itemDiameter);
		chestPieceView.render(g,chestPieceX + x ,chestPieceY + y , itemDiameter);
		leggingsView.render(g,leggingsX + x ,leggingsY + y , itemDiameter);
		bootsView.render(g,bootsX + x ,bootsY + y , itemDiameter);
		weaponView.render(g,weaponX + x ,weaponY + y , itemDiameter);
		shieldView.render(g,shieldX + x ,shieldY + y , itemDiameter);
		projectileView.render(g ,projectileX + x ,projectileY + y , itemDiameter);
		glovesView.render(g,glovesX + x ,glovesY + y , itemDiameter);
	}
	
	public int getWidth(){
		return WIDTH * SLOT_WIDTH;
	}
	public int getHeight(){
		return HEIGHT * SLOT_HEIGHT;
	}
}
