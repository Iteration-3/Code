package view;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

public class InventoryView {
	private final static int SLOT_HEIGHT= 50;
	private final static int SLOT_WIDTH = 50;
	private final static int COL = 5;
	private final static int ROW = 5;
	private final static float ITEM_DIAMETER = 20;
	
	
	private HashMap<Integer,SlotView> slots;
	
	public InventoryView(){
		this.slots = new HashMap<Integer,SlotView>();
	}
	
	
	public void register(SlotView[] slotViews){
		for (int i= 0; i< slotViews.length ; i ++){
			this.register(slotViews[i],i);
		}
	}
	
	private void setDimensions(SlotView slot){
		slot.setHeight(SLOT_HEIGHT);
		slot.setWidth(SLOT_WIDTH);
		slot.setImageDiameter(ITEM_DIAMETER);
	}
	
	public void register(SlotView slotView, int location){
		slots.put(location, slotView);
		this.setDimensions(slotView);
	}
	
	public void render(Graphics g){
		ArrayList<SlotView> slotViews = new ArrayList<SlotView>(slots.values());
		for (int i = 0 ; i < slotViews.size(); i++ ){
			int height= SLOT_HEIGHT * (i/ROW);
			int width= SLOT_WIDTH * (i%COL);
			slotViews.get(i).render(g,height,width, ITEM_DIAMETER);
		}
	}
	
}
