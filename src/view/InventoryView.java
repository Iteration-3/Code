package view;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;

import utilities.ImageProcessing;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import controller.SlotViewMouseListenerFactory;

@SuppressWarnings("serial")
public class InventoryView extends JComponent implements Saveable {
	private static String backgroundPath = "/images/slotImage.png";

	private static BufferedImage slotBackground;
	private static int COL = 5;
	private static int ROW = 5;
	private static double ITEM_DIAMETER = 50;

	private int slotWidth = 100;
	private int slotHeight = 100;

	private int width = slotWidth * ROW;
	private int height = slotHeight * COL;

	private int widthOffset;
	private int heightOffset;

	private HashMap<Integer, SlotView> slots;

	public InventoryView() {
		setLayout(null);// new GridLayout(ROW,COL));
		this.slots = new HashMap<Integer, SlotView>();
		setVisible(true);
		setFocusable(true);
	}
	
	public InventoryView(StructuredMap map) {
		backgroundPath = map.getString("path");
		COL = map.getInteger("col");
		ROW = map.getInteger("row");
		ITEM_DIAMETER = map.getDouble("itemDiameter");
		slotHeight = map.getInteger("slotHeight");
		slotWidth = map.getInteger("slotWidth");
		StructuredMap[] array = map.getStructuredMapArray("viewMap");
		this.slots = new HashMap<Integer, SlotView>();
		for(int i =0; i < array.length; i++) {
			slots.put(array[i].getInteger("key"), new SlotView(array[i].getStructuredMap("value")));
		}
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("path", backgroundPath);
		map.put("col", COL);
		map.put("row", ROW);
		map.put("itemDiameter", ITEM_DIAMETER);
		map.put("slotHeight", slotHeight);
		map.put("slotWidth", slotWidth);
		StructuredMap[] array = new StructuredMap[slots.size()];
		int i = 0;
		for(Map.Entry<Integer, SlotView> set : slots.entrySet()) {
			StructuredMap tempMap = new StructuredMap();
			tempMap.put("key", set.getKey());
			tempMap.put("value", set.getValue().getStructuredMap());
			array[i++] = tempMap;
		}
		
		map.put("viewMap", array);
		
		return map;
	}

	public void register(SlotView slotView, int location) {
		slots.put(location, slotView);
		slotView.setBackground(this.getBackgroundImage(), backgroundPath);
		int height = slotHeight * (location / ROW) + this.heightOffset;
		int width = slotWidth * (location % COL) + this.widthOffset;
		slotView.setBounds(width, height, slotWidth, slotHeight);
		add(slotView);
	}

	private BufferedImage getBackgroundImage() {
		if (slotBackground != null) {
			return slotBackground;
		} else {
			slotBackground = ImageProcessing.scaleImage(slotWidth,
					slotHeight, backgroundPath);
			return slotBackground;
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(slotWidth * COL, slotHeight * ROW);
	}

	public void setBounds(int x, int y) {
		this.setBounds(x, y, this.width, this.height);
	}

	@Override
	public int getWidth() {
		return (this.slots.values().size() / COL) * (slotWidth);
	}

	@Override
	public int getHeight() {
		return (this.slots.values().size() / ROW) * (slotHeight);
	}

	public void setOffsets(int width, int height) {
		this.widthOffset = width;
		this.heightOffset = height;
	}

	public void add(SlotViewMouseListenerFactory controller){
		for (int i:slots.keySet()){
			slots.get(i).addMouseListener(controller.makeSlotMouseListener(i));
		}
	}
	
	public void resetSlotDimensions() { 
		for (int i : slots.keySet()) {
			int height = slotHeight * (i/ ROW) + this.heightOffset;
			int width = slotWidth * (i % COL) + this.widthOffset;
			slots.get(i).setBounds(width, height, slotWidth, slotHeight);
		}
		
	}

	public void setSlotDimensions(int width, int height) {
		this.slotWidth = width;
		this.slotHeight = height;
		this.resetSlotDimensions();
	}

	
}
