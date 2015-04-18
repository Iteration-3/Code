package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import view.item.ItemView;
import model.area.RealCoordinate;

public class SlotView {
	private BufferedImage background;
	private ItemView itemView;
	
	public SlotView(){}
	public SlotView(BufferedImage background){
		this.background = background;
	}
	
	public void register(ItemView itemView){
		this.itemView = itemView;
	}
	
	public boolean hasItem(){
		return this.itemView != null;
	}
	
	public void render(Graphics g,int x,int y, float itemDiameter){
		this.drawBackGround(g, x, y);
		if (this.hasItem()){
			int currentOffset = 15;
			int xLoc = x + currentOffset;
			int yLoc = y + currentOffset;
			this.itemView.render(g, new RealCoordinate (xLoc,yLoc), itemDiameter );
		}
	}
	
	public void drawBackGround(Graphics g, int x, int y){
		g.drawImage(background, x, y, null);
	}
	
	public void setBackground(BufferedImage background){
		this.background = background;
	}
}
