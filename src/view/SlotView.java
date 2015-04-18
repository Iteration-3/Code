package view;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		setBorder(null);
		addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("hdsfkjjdsf");
			}
		});
	}

	public SlotView(BufferedImage background) {
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
		this.setImage();
		super.paintComponent(g);
	}

	private void setImage() {
		if (this.hasItem()) {
			this.setIcon( new ImageIcon( ImageProcessing.overlayImages(background, this.itemView.getImage(20, 20),25 , 25)));
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
