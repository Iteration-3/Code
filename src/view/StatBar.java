package view;

import java.awt.Color;
import java.awt.Graphics;

public class StatBar {
	private int STAT_HEIGHT = 10;
	private int STAT_WIDTH = 50;
	private int ROUNDING = 10;
	private Color foreGround = Color.black;
	private Color backGround= Color.white;
	

	public StatBar(int height, int width, Color foreGround, Color backGround) {
		this.STAT_HEIGHT = height;
		this.STAT_WIDTH = width;
		this.foreGround = foreGround;
		this.backGround = backGround;
	}

	public StatBar() {

	}
	public StatBar(Color foreGround, Color backGround){
		this.foreGround = foreGround;
		this.backGround = backGround;
	}
	
	public void setColors(Color foreGround, Color backGround){
		this.foreGround = foreGround;
		this.backGround = backGround;
	}
	
	public void setSize(int height, int width){
		this.STAT_HEIGHT = height;
		this.STAT_WIDTH = width;
	}
	
	
	public void render(Graphics gr, double x, double y, Float percentage) {
		this.drawStatBar(gr, x, y, percentage);
	}

	private void drawStatBar(Graphics gr, double x, double y, Float percentage) {
		drawStatBarBackGround(gr, x, y, backGround);
		drawStatBarTop(gr, x, y, percentage, foreGround);
	}

	private void drawStatBarTop(Graphics graphics, double x, double y,
			float percentage, Color color) {
		this.drawRectangle(graphics, (int) x - STAT_WIDTH / 2, (int) y
				, (int) (STAT_WIDTH * percentage), STAT_HEIGHT,
				color);
	}

	private void drawStatBarBackGround(Graphics gr, double x, double y,
			Color color) {
		this.drawRectangle(gr, (int) x - (int) (STAT_WIDTH * 1.1) / 2, (int) y
				, (int) (STAT_WIDTH * 1.1),
				(int) (STAT_HEIGHT * 1.1), color);
	}

	private void drawRectangle(Graphics gr, int x, int y, int width,
			int height, Color color) {
		gr.setColor(color);
		gr.fillRoundRect(x, y, width, height, ROUNDING, ROUNDING);
	}
}
