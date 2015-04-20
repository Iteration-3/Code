package view.map.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;

public class Hexagon {
	private Polygon hexagon;
	private Color color;
	private static final int PRECISION_MULTIPLIER = 1_000_000; // used to simulate floating-point for scaling
															   // hexagons since all coordinates must be ints

	public Hexagon(Color color) {
		this.color = color;
		hexagon = new Polygon();
		computePath();
	}
	
	public void render(Graphics graphics, float x, float y, float diameter) {
		Graphics2D graphics2D = (Graphics2D) graphics;
		// save the old transform
		AffineTransform savedTransform = graphics2D.getTransform();
	
		// create a new transform to position & scale the hexagon
		AffineTransform positionAndScale = new AffineTransform();
		positionAndScale.translate(x, y);
		positionAndScale.scale(diameter / PRECISION_MULTIPLIER, diameter / PRECISION_MULTIPLIER);
		
		// apply the transform
		graphics2D.setTransform(positionAndScale);

		// enable antialiasing
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
		             						   RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2D.setRenderingHints(rh);
		
		// render the hexagon
		graphics2D.setColor(color);
		graphics2D.fillPolygon(hexagon);
		
		// restore the previous transform
		graphics2D.setTransform(savedTransform);
	}
	
	// computes a flat-topped hexagon one unit wide.
	private void computePath() {
		for (int i = 0; i < 6; ++i) {
			double currentAngle = i * Math.PI / 3;
			int pointX = (int) (Math.cos(currentAngle) * 0.5 * PRECISION_MULTIPLIER);
			int pointY = (int) (Math.sin(currentAngle) * 0.5 * PRECISION_MULTIPLIER);
			hexagon.addPoint(pointX, pointY);
		}
	}
}
