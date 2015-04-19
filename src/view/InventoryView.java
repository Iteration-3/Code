package view;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.JComponent;

import utilities.ImageProcessing;
import controller.SlotViewMouseListenerFactory;

@SuppressWarnings("serial")
public class InventoryView extends JComponent {
	private static final String backgroundPath = "src/resources/images/slotImage.png";
	private static BufferedImage slotBackground;
	private final static int COL = 5;
	private final static int ROW = 5;
	private final static float ITEM_DIAMETER = 50;

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
		// setFocusable(true);
		setVisible(true);
		setFocusable(true);
	}

	public void register(SlotView slotView, int location) {
		slots.put(location, slotView);
		slotView.setBackground(this.getBackgroundImage());
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

	public Dimension getPreferredSize() {
		return new Dimension(slotWidth * COL, slotHeight * ROW);
	}

	public void setBounds(int x, int y) {
		this.setBounds(x, y, this.width, this.height);
	}

	public int getWidth() {
		return (this.slots.values().size() / COL) * (slotWidth);
	}

	public int getHeight() {
		return (this.slots.values().size() / ROW) * (slotHeight);
	}

	public void setOffsets(int width, int height) {
		this.widthOffset = width;
		this.heightOffset = height;
	}

	public void add(SlotViewMouseListenerFactory controller) {
		for (int i : slots.keySet()) {
			System.out.println(slots.get(i).hashCode());
			slots.get(i).addMouseListener(controller.makeSlotMouseListener(i));
		}
	}
	
	public void resetSlotDimensions(){
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
