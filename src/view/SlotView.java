package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JButton;

import utilities.ImageProcessing;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;
import factories.ItemViewFactory;

@SuppressWarnings("serial")
public class SlotView extends JButton implements Saveable {
	private String backgroundPath;
	private BufferedImage background;
	private ItemView itemView;
	
	public SlotView(StructuredMap map) {
		this.itemView = map.getStructuredMap("itemView") == null ? null :ItemViewFactory.createItemView(map.getStructuredMap("itemView"));
		this.backgroundPath = map.getString("background");
	
		this.background = ImageProcessing.getImage(backgroundPath);
		
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("background", backgroundPath);
	
		map.put("itemView", itemView == null ? null : itemView.getStructuredMap());
		return map;
	}

	public SlotView() {
		super();
		setToolTipText("hello");
		setBorder(null);
	}

	public SlotView(BufferedImage background, String backgroundPath) {
		this.background = background;
	}

	public void register(ItemView itemView) {
		this.itemView = itemView;
	}

	public boolean hasItem() {
		return this.itemView != null;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setImage(g);
	}

	private void setImage(Graphics g) {
		g.drawImage(background, 0, 0, null);
		if (this.hasItem()) {
			g.drawImage(this.itemView.getImage(40, 40), 40, 40, null);
		}
	}
	public void setBackground(BufferedImage background, String backgroundPath) {
		this.backgroundPath = backgroundPath;
		this.background = background;
	}

	
}
