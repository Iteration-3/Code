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
	
	public void render(Graphics g,int x,int y, float itemDiameter){
		this.drawBackGround(g, x, y);
		if (this.hasItem()){
			int xLoc = x + 15;
			int yLoc = y + 15;
			this.itemView.render(g, new RealCoordinate (xLoc,yLoc), itemDiameter );
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
