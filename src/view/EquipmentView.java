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
	
	
	public EquipmentView(){
		setImages();
	}
	
	private void setImages(){
		this.helmetImage = ImageProcessing.scaleImage(SLOT_WIDTH, SLOT_HEIGHT, HELMET_PATH);
		this.chestPieceImage = ImageProcessing.scaleImage(SLOT_WIDTH, SLOT_HEIGHT, CHEST_PIECE_PATH);
		this.leggingsImage = ImageProcessing.scaleImage(SLOT_WIDTH, SLOT_HEIGHT, LEGGINGS_PATH);
		this.bootsImage = ImageProcessing.scaleImage(SLOT_WIDTH,SLOT_HEIGHT, BOOTS_PATH);
		this.weaponImage = ImageProcessing.scaleImage(SLOT_WIDTH, SLOT_HEIGHT, WEAPON_PATH);
		this.shieldImage = ImageProcessing.scaleImage(SLOT_WIDTH, SLOT_HEIGHT, SHIELD_PATH);
		this.projectileImage = ImageProcessing.scaleImage(SLOT_WIDTH, SLOT_HEIGHT, PROJECTILE_PATH);
		this.glovesImage = ImageProcessing.scaleImage(SLOT_WIDTH, SLOT_HEIGHT, GLOVES_PATH);
	}
	
	public void render(Graphics g){
		
	}



}
