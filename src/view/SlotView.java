package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import utilities.ImageProcessing;
import view.item.ItemView;

@SuppressWarnings("serial")
public class SlotView extends JButton {
	private BufferedImage background;
	private ItemView itemView;

	public SlotView() {
		super();
		setToolTipText("hello");
		setBorder(null);
	}

	public SlotView(BufferedImage background) {
		this.background = background;
	}

	public void register(ItemView itemView) {
		System.out.println(itemView);
		this.itemView = itemView;
	}

	public boolean hasItem() {
		return this.itemView != null;
	}

	@Override
	public void paintComponent(Graphics g) {
		this.setImage();
		super.paintComponent(g);
	}

	private void setImage() {
		if (this.hasItem()) {
			System.out.println(this.itemView + "   " + this.hashCode());
			this.setIcon( new ImageIcon( ImageProcessing.overlayImages(background, this.itemView.getImage(40, 40),40 , 40)));
		}
		else{
			this.setIcon(new ImageIcon(background));
		}
	}

	public void drawBackGround(Graphics g, int x, int y) {
		g.drawImage(background, x, y, null);
	}

	public void setBackground(BufferedImage background) {
		this.background = background;
	}
}
