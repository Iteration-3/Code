package view;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import utilities.ImageProcessing;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import controller.InventoryMenuController;

@SuppressWarnings("serial")
public class EquipmentView extends JComponent implements Saveable {
	private float EQUIPMENT_SCALE = 80;	//this is a percentage of the height and scale
	
	private static String HELMET_PATH = "/images/helmet_slot.jpg";
	private static String CHEST_PIECE_PATH = "/images/chest_piece_slot.jpg";
	private static String LEGGINGS_PATH = "/images/leggings_slot.jpg";
	private static String BOOTS_PATH = "/images/boots_slot.jpg";
	private static String WEAPON_PATH = "/images/weapon_slot.jpg";
	private static String SHIELD_PATH = "/images/shield_slot.jpg";
	private static String PROJECTILE_PATH = "/images/projectile_slot.jpg";
	private static String GLOVES_PATH = "/images/gloves_slot.jpg";
	
	public EquipmentView(StructuredMap map) {
		HELMET_PATH = map.getString("helmet");
		CHEST_PIECE_PATH = map.getString("chestPiece");
		LEGGINGS_PATH = map.getString("leggings");
		BOOTS_PATH = map.getString("boots");
		WEAPON_PATH = map.getString("weapon");
		SHIELD_PATH = map.getString("shield");
		PROJECTILE_PATH = map.getString("projectile");
		GLOVES_PATH = map.getString("gloves");
		this.slotHeight = map.getInteger("slotHeight");
		this.slotWidth = map.getInteger("slotWidth");
		this.helmetX = map.getInteger("helmetX");
		helmetY = map.getInteger("helmetY");
		chestPieceX = map.getInteger("chestPieceX");
		chestPieceY = map.getInteger("chestPieceY");
		leggingsX = map.getInteger("leggingsX");
		leggingsY = map.getInteger("leggingsY");
		bootsX = map.getInteger("bootsX");
		bootsY = map.getInteger("bootsY");
		weaponX = map.getInteger("weaponX");
		weaponY = map.getInteger("weaponY");
		glovesX = map.getInteger("glovesX");
		glovesY = map.getInteger("glovesY");
		shieldX = map.getInteger("shieldX");
		shieldY = map.getInteger("shieldY");
		projectileX = map.getInteger("projectileX");
		projectileY = map.getInteger("projectileY");
		
		setImages();
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("helmet", HELMET_PATH);
		map.put("chestPiece", CHEST_PIECE_PATH);
		map.put("leggings", LEGGINGS_PATH);
		map.put("boots", BOOTS_PATH);
		map.put("weapon", WEAPON_PATH);
		map.put("shield", SHIELD_PATH);
		map.put("projectile", PROJECTILE_PATH);
		map.put("gloves", GLOVES_PATH);
		map.put("slotHeight", slotHeight);
		map.put("slotWidth", slotWidth);
		map.put("helmetX", helmetX);
		map.put("helmetY", helmetY);
		map.put("chestPieceX", chestPieceX);
		map.put("chestPieceY", chestPieceY);
		map.put("leggingsX", leggingsX);
		map.put("leggingsY", leggingsY);
		map.put("bootsX", bootsX);
		map.put("bootsY", bootsY);
		map.put("weaponX", weaponX);
		map.put("weaponY", weaponY);
		map.put("glovesX", glovesX);
		map.put("glovesY", glovesY);
		map.put("shieldX", shieldX);
		map.put("shieldY", shieldY);
		map.put("projectileX", projectileX);
		map.put("projectileY", projectileY);
	
		return map;
	}

	

	
	private int helmetX;
	private int helmetY;
	private int chestPieceX;
	private int chestPieceY;
	private int leggingsX;
	private int leggingsY;
	private int bootsX;
	private int bootsY;
	private int weaponX;
	private int weaponY;
	private int glovesX;
	private int glovesY;
	private int shieldX;
	private int shieldY;
	private int projectileX;
	private int projectileY;
	private int slotHeight = 100;
	private int slotWidth = 100;

	private static BufferedImage helmetImage;
	private static BufferedImage chestPieceImage;
	private static BufferedImage leggingsImage;
	private static BufferedImage bootsImage;
	private static BufferedImage weaponImage;
	private static BufferedImage shieldImage;
	private static BufferedImage projectileImage;
	private static BufferedImage glovesImage;
	
	private SlotView helmetView;
	private SlotView chestPieceView;
	private SlotView leggingsView;
	private SlotView bootsView;
	private SlotView weaponView;
	private SlotView shieldView;
	private SlotView projectileView;
	private SlotView glovesView;
	
	public EquipmentView(){
		setLayout(null);
		this.setVisible(true);
		this.setFocusable(true);
		this.setImages();
	}
	
	private void setImages(){
		helmetImage = ImageProcessing.scaleImage(slotHeight, slotHeight, HELMET_PATH);
		chestPieceImage = ImageProcessing.scaleImage(slotHeight, slotHeight, CHEST_PIECE_PATH);
		leggingsImage = ImageProcessing.scaleImage(slotHeight, slotHeight, LEGGINGS_PATH);
		bootsImage = ImageProcessing.scaleImage(slotHeight,slotHeight, BOOTS_PATH);
		weaponImage = ImageProcessing.scaleImage(slotHeight, slotHeight, WEAPON_PATH);
		shieldImage = ImageProcessing.scaleImage(slotHeight, slotHeight, SHIELD_PATH);
		projectileImage = ImageProcessing.scaleImage(slotHeight, slotHeight, PROJECTILE_PATH);
		glovesImage = ImageProcessing.scaleImage(slotHeight, slotHeight, GLOVES_PATH);
	}
	
	private void setView(SlotView slot,BufferedImage image, String imagePath, int x,int y){
		slot.setBackground(image, imagePath );
		add(slot);
	}
	
	public void registerHelmet(SlotView slotView){
		helmetView = slotView;
		this.setView(slotView,helmetImage, HELMET_PATH, helmetX,helmetY);
	}
	public void registerChestPiece(SlotView slotView){
		chestPieceView = slotView;
		this.setView(slotView,chestPieceImage,CHEST_PIECE_PATH, chestPieceX,chestPieceY);
	}
	public void registerLeggings(SlotView slotView){
		leggingsView = slotView;
		this.setView(slotView,leggingsImage , LEGGINGS_PATH, leggingsX , leggingsY);
	}
	public void registerBoots(SlotView slotView){
		bootsView = slotView;
		this.setView(slotView,bootsImage , BOOTS_PATH, bootsX , bootsY);
	}
	public void registerWeapon(SlotView slotView){
		weaponView = slotView;
		this.setView(slotView,weaponImage , WEAPON_PATH, weaponX , weaponY);
	}
	public void registerShield(SlotView slotView){
		shieldView = slotView;
		this.setView(slotView,shieldImage , SHIELD_PATH, shieldX , shieldY);
	}
	public void registerGloves(SlotView slotView){
		glovesView = slotView;
		this.setView(slotView,glovesImage ,GLOVES_PATH , glovesX , glovesY);
	}
	public void registerProjectile(SlotView slotView){
		projectileView = slotView;
		this.setView(slotView,projectileImage ,PROJECTILE_PATH, projectileX , projectileY);
	}
	
	public void setBounds(int x, int y){
		this.setBounds(x,y,this.getWidth(), this.getHeight());
	}
	
	public int getWidth(){
		return 3 * slotHeight;
	}
	public int getHeight(){
		return 4 * slotHeight;
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(this.getWidth(),this.getHeight());
	}
	
	public void add(InventoryMenuController controller){
		helmetView.addMouseListener(controller.makeHelmetListener());
		leggingsView.addMouseListener(controller.makeLeggingsListener());
		glovesView.addMouseListener(controller.makeGlovesListener());
		bootsView.addMouseListener(controller.makeBootsListener());
		projectileView.addMouseListener(controller.makeProjectileListener());
		weaponView.addMouseListener(controller.makeWeaponListener());
		shieldView.addMouseListener(controller.makeShieldListener());
		chestPieceView.addMouseListener(controller.makeChestPieceListener());
	}
	
	public void setSlotDimensions(int width,int height){
		this.slotHeight = height;
		this.slotWidth = width;
		setSlotDimensions();
	}
	
	private void setSlotDimensions(){
		helmetX = slotHeight;
		helmetY = 0;
		chestPieceX = helmetX;
		chestPieceY = helmetY + slotHeight;
		leggingsX = chestPieceX;
		leggingsY = chestPieceY +slotHeight;
		bootsX = leggingsX;
		bootsY = leggingsY + slotHeight;
		weaponX = chestPieceX - slotHeight;
		weaponY = chestPieceY;
		glovesX = leggingsX - slotHeight;
		glovesY = leggingsY;
		shieldX = chestPieceX + slotHeight;
		shieldY = chestPieceY;
		projectileX = helmetX + slotHeight;
		projectileY = helmetY;
		helmetView.setBounds(helmetX , helmetY , slotHeight, slotHeight);
		leggingsView.setBounds(leggingsX , leggingsY , slotHeight, slotHeight);
		glovesView.setBounds(glovesX , glovesY , slotHeight, slotHeight);
		weaponView.setBounds(weaponX , weaponY , slotHeight, slotHeight);
		bootsView.setBounds(bootsX , bootsY , slotHeight, slotHeight);
		shieldView.setBounds(shieldX , shieldY , slotHeight, slotHeight);
		projectileView.setBounds(projectileX , projectileY , slotHeight, slotHeight);
		chestPieceView.setBounds(chestPieceX , chestPieceY , slotHeight, slotHeight);
		this.setImages();
		this.setView(shieldView ,shieldImage , SHIELD_PATH, shieldX , shieldY);
		this.setView(glovesView ,glovesImage ,GLOVES_PATH, glovesX , glovesY);
		this.setView(projectileView ,projectileImage , PROJECTILE_PATH, projectileX , projectileY);
		this.setView(helmetView ,helmetImage, HELMET_PATH,helmetX,helmetY);
		this.setView(chestPieceView ,chestPieceImage, CHEST_PIECE_PATH,chestPieceX,chestPieceY);
		this.setView(leggingsView ,leggingsImage , LEGGINGS_PATH, leggingsX , leggingsY);
		this.setView(bootsView ,bootsImage , BOOTS_PATH, bootsX , bootsY);
		this.setView(weaponView ,weaponImage ,WEAPON_PATH, weaponX , weaponY);
	}

	
}
