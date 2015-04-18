package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utilities.ImageProcessing;

public class EquipmentView {
	private static final int SLOT_HEIGHT = 80;
	private static final int SLOT_WIDTH = 80;
	private static final int EQUIPMENT_SCALE = 80;	//this is a percentage of the height and scale
	
	private static final String HELMET_PATH = "src/resources/images/helmet_slot.jpg";
	private static final String CHEST_PIECE_PATH = "src/resources/images/chest_piece_slot.jpg";
	private static final String LEGGINGS_PATH = "src/resources/images/leggings_slot.jpg";
	private static final String BOOTS_PATH = "src/resources/images/boots_slot.jpg";
	private static final String WEAPON_PATH = "src/resources/images/weapon_slot.jpg";
	private static final String SHIELD_PATH = "src/resources/images/shield_slot.jpg";
	private static final String PROJECTILE_PATH = "src/resources/images/projectile_slot.jpg";
	private static final String GLOVES_PATH = "src/resources/images/gloves_slot.jpg";
	
	
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
		slot = new SlotView(image);
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
	
	public void render(Graphics g){
		float itemDiameter = 40;
		helmetView.render(g, SLOT_WIDTH, SLOT_HEIGHT, itemDiameter);
		chestPieceView.render(g, SLOT_WIDTH, SLOT_HEIGHT, itemDiameter);
		leggingsView.render(g,SLOT_WIDTH, SLOT_HEIGHT, itemDiameter);
		bootsView.render(g,SLOT_WIDTH, SLOT_HEIGHT, itemDiameter);
		weaponView.render(g,SLOT_WIDTH, SLOT_HEIGHT, itemDiameter);
		shieldView.render(g,SLOT_WIDTH, SLOT_HEIGHT, itemDiameter);
		projectileView.render(g , SLOT_WIDTH, SLOT_HEIGHT, itemDiameter);
		glovesView.render(g, SLOT_WIDTH, SLOT_HEIGHT, itemDiameter);
	}
}
