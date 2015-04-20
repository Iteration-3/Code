package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Sprite {
	private BufferedImage[] images;
	private int counter = 0;
	private boolean animated = true;

	public Sprite(BufferedImage[] images) {
		this.images = images;
	}

	private BufferedImage getCurrentFrame() {
		BufferedImage temp = images[counter];
		return temp;
	}

	private void advanceCounter() {
		++counter;
		if (counter >= images.length) {
			counter = 0;
		}
	}

	public void resumeAnimation() {
		this.animated = true;
	}

	public void stopAnimation() {
		this.animated = false;
	}

	public boolean isAnimatedATM() {
		return this.animated;
	}

	public void render(Graphics graphics, float x, float y, float diameter) {
		BufferedImage image = getCurrentFrame();
		
		if (isAnimatedATM()) {
			advanceCounter();
		}
		
		graphics.drawImage(image, (int)(x - diameter / 2), (int)(y - diameter / 2), (int)diameter, (int)diameter, null);
	}

}
