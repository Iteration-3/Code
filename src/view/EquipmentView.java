package view;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

import controller.InventoryMenuController;
import utilities.ImageProcessing;

@SuppressWarnings("serial")
public class EquipmentView extends JComponent {
	private float EQUIPMENT_SCALE = 80;	//this is a percentage of the height and scale
	
	private static final String HELMET_PATH = "/images/helmet_slot.jpg";
	private static final String CHEST_PIECE_PATH = "/images/chest_piece_slot.jpg";
	private static final String LEGGINGS_PATH = "/images/leggings_slot.jpg";
	private static final String BOOTS_PATH = "/images/boots_slot.jpg";
	private static final String WEAPON_PATH = "/images/weapon_slot.jpg";
	private static final String SHIELD_PATH = "/images/shield_slot.jpg";
	private static final String PROJECTILE_PATH = "/images/projectile_slot.jpg";
	private static final String GLOVES_PATH = "/images/gloves_slot.jpg";
	
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
	
	private void setView(SlotView slot,BufferedImage image,int x,int y){
		slot.setBackground(image);
		add(slot);
	}
	
	public void registerHelmet(SlotView slotView){
		helmetView = slotView;
		this.setView(slotView,helmetImage,helmetX,helmetY);
	}
	public void registerChestPiece(SlotView slotView){
		chestPieceView = slotView;
		this.setView(slotView,chestPieceImage,chestPieceX,chestPieceY);
	}
	public void registerLeggings(SlotView slotView){
		leggingsView = slotView;
		this.setView(slotView,leggingsImage , leggingsX , leggingsY);
	}
	public void registerBoots(SlotView slotView){
		bootsView = slotView;
		this.setView(slotView,bootsImage , bootsX , bootsY);
	}
	public void registerWeapon(SlotView slotView){
		weaponView = slotView;
		this.setView(slotView,weaponImage , weaponX , weaponY);
	}
	public void registerShield(SlotView slotView){
		shieldView = slotView;
		this.setView(slotView,shieldImage , shieldX , shieldY);
	}
	public void registerGloves(SlotView slotView){
		glovesView = slotView;
		this.setView(slotView,glovesImage , glovesX , glovesY);
	}
	public void registerProjectile(SlotView slotView){
		projectileView = slotView;
		this.setView(slotView,projectileImage , projectileX , projectileY);
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
		this.setView(shieldView ,shieldImage , shieldX , shieldY);
		this.setView(glovesView ,glovesImage , glovesX , glovesY);
		this.setView(projectileView ,projectileImage , projectileX , projectileY);
		this.setView(helmetView ,helmetImage,helmetX,helmetY);
		this.setView(chestPieceView ,chestPieceImage,chestPieceX,chestPieceY);
		this.setView(leggingsView ,leggingsImage , leggingsX , leggingsY);
		this.setView(bootsView ,bootsImage , bootsX , bootsY);
		this.setView(weaponView ,weaponImage , weaponX , weaponY);
	}
}
