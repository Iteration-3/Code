package view;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.swing.JComponent;

import controller.InventoryMenuController;
import utilities.ImageProcessing;

@SuppressWarnings("serial")
public class InventoryView extends JComponent {
	private static final String backgroundPath = "src/resources/images/slotImage.png";
	private static BufferedImage slotBackground;
	private final static int SLOT_HEIGHT = 100;
	private final static int SLOT_WIDTH = 100;
	private final static int COL = 5;
	private final static int ROW = 5;
	private final static float ITEM_DIAMETER = 50;

	private int widthOffset;
	private int heightOffset;

	private HashMap<Integer, SlotView> slots;

	public InventoryView() {
		setLayout(null);//new GridLayout(ROW,COL));
		this.slots = new HashMap<Integer, SlotView>();
//		setFocusable(true);
		setVisible(true);
	}

	public void register(SlotView[] slotViews) {
		for (int i = 0; i < slotViews.length; i++) {
			this.register(slotViews[i], i);
		}
	}

	public void register(SlotView slotView, int location) {
		slots.put(location, slotView);
		slotView.setBackground(this.getBackgroundImage());
		int height = SLOT_HEIGHT * (location / ROW) + this.heightOffset;
		int width = SLOT_WIDTH * (location % COL) + this.widthOffset;
		slotView.setBounds(width, height, SLOT_WIDTH, SLOT_HEIGHT);
		add(slotView);
	}

	private BufferedImage getBackgroundImage() {
		if (slotBackground != null) {
			return slotBackground;
		} else {
			slotBackground = ImageProcessing.scaleImage(SLOT_WIDTH,
					SLOT_HEIGHT, backgroundPath);
			return slotBackground;
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(SLOT_WIDTH * COL, SLOT_HEIGHT * ROW);
	}


	public void setBounds(int x, int y) {
		this.setBounds(x, y, WIDTH, HEIGHT);
		this.revalidate();
	}

	public int getWidth() {
		return (this.slots.values().size() / COL) * (SLOT_WIDTH);
	}

	public int getHeight() {
		return (this.slots.values().size() / ROW) * (SLOT_HEIGHT);
	}

	public void setOffsets(int width, int height) {
		this.widthOffset = width;
		this.heightOffset = height;
	}
	
	public void add(InventoryMenuController controller){
		for (int i:slots.keySet()){
			slots.get(i).addActionListener(controller.makeInventoryActionListener(i));
		}
	}
}
