package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import utilities.ImageProcessing;

public class InventoryView {
	private static final String backgroundPath = "src/resources/images/slotImage.png";
	private static BufferedImage slotBackground;
	private final static int SLOT_HEIGHT= 100;
	private final static int SLOT_WIDTH = 100;
	private final static int COL = 5;
	private final static int ROW = 5;
	private final static float ITEM_DIAMETER = 50;
	
	
	private HashMap<Integer,SlotView> slots;
	
	public InventoryView(){
		this.slots = new HashMap<Integer,SlotView>();
	}
	
	
	public void register(SlotView[] slotViews){
		for (int i= 0; i< slotViews.length ; i ++){
			this.register(slotViews[i],i);
		}
	}
	
	public void register(SlotView slotView, int location){
		slots.put(location, slotView);
		slotView.setBackground(this.getBackgroundImage());
	}
	
	private BufferedImage getBackgroundImage(){
		if (slotBackground != null){
			return slotBackground;
		}
		else{
			slotBackground = ImageProcessing.scaleImage(SLOT_WIDTH,SLOT_HEIGHT,backgroundPath);
			return slotBackground;
		}
	}
	
	
	public void render(Graphics g, int x, int y){
		ArrayList<SlotView> slotViews = new ArrayList<SlotView>(slots.values());
		for (int i = 0 ; i < slotViews.size(); i++ ){
			int height= SLOT_HEIGHT * (i/ROW) + y;
			int width= SLOT_WIDTH * (i%COL) + x;
			slotViews.get(i).render(g,width,height, ITEM_DIAMETER);
		}
	}
	
	public int getWidth(){
		return (this.slots.values().size()/COL) * (SLOT_WIDTH);
	}

	public int getHeight(){
		return (this.slots.values().size()/ROW) * (SLOT_HEIGHT);
	}
	
}
