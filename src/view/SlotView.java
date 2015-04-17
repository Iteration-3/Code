package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utilities.ImageProcessing;
import view.item.ItemView;
import model.area.RealCoordinate;

public class SlotView {
	private static final String backgroundPath = "src/resources/images/slotImage.png";
	private static BufferedImage slotBackground;
	private int height;
	private int width;
	private float itemDiameter;
	private ItemView itemView;
	
	public SlotView(){}
	
	public void register(ItemView itemView){
		this.itemView = itemView;
	}
	
	public boolean hasItem(){
		return this.itemView != null;
	}
	
	public void render(Graphics g,int x,int y, int itemDiameter){
		this.drawBackGround(g, x, y);
		if (this.hasItem()){
			this.itemView.render(g, new RealCoordinate (x,y), itemDiameter );
		}
	}
	
	public void drawBackGround(Graphics g, int x, int y){
		g.drawImage(getBackgroundImage(), x, y, null);
	}
	
	private BufferedImage getBackgroundImage(){
		if (slotBackground != null){
			return slotBackground;
		}
		else{
			slotBackground = ImageProcessing.scaleImage(this.width,this.height,backgroundPath);
			return slotBackground;
		}
	}
	
	public void setWidth(int width){
		this.width = width;
	}
	
	public void setHeight(int height){
		this.height = height;
	}
	
	public void setImageDiameter(float diameter){
		this.itemDiameter = diameter;
	}
	

}
