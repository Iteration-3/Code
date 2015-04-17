package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import view.item.ItemView;
import model.area.RealCoordinate;

public class SlotView {
	private BufferedImage slotBackground;
	private float itemDiameter;
	private ItemView itemView;
	
	public SlotView(){}
	
	public void register(ItemView itemView){
		this.itemView = itemView;
	}
	
	public boolean hasItem(){
		return this.itemView != null;
	}
	
	public void render(Graphics g,int x,int y){
		g.drawImage(slotBackground, x, y, null);
		if (this.hasItem()){
			this.itemView.render(g, new RealCoordinate (x,y), itemDiameter );
		}
	}

}
