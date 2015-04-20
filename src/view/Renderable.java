package view;

import java.awt.Graphics;

public interface Renderable {
	public abstract void render(Graphics graphics, ViewTransform transform);
}
