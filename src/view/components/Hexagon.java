package view.components;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.Color;

import model.area.Location;

public class Hexagon {
	private Path2D hexagon;
	private Color fillColor;
	private Color outlineColor;
	
	public Hexagon() {
		hexagon = new Path2D.Double();
		
		fillColor = new Color(0, 200, 200);
		outlineColor = Color.WHITE;
		
		definePath(32);
	}
	
	public void render(Graphics graphics, Location location) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setColor(fillColor);
		graphics2D.fill(hexagon);
		graphics2D.setColor(outlineColor);
		graphics2D.setStroke(new BasicStroke(4));
		graphics2D.draw(hexagon);
	}
	
	private void definePath(double radius) {
		hexagon.moveTo(radius * 2, radius);
		
		for(int i = 1; i < 6; ++i) {
			double currentAngle = i * Math.PI / 3;
			hexagon.lineTo(Math.cos(currentAngle) * radius + radius, Math.sin(currentAngle) * radius + radius);
		}
		
		hexagon.closePath();
	}
}
