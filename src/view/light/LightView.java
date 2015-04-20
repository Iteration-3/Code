package view.light;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import model.area.TileCoordinate;
import view.map.components.Hexagon;

public class LightView {
	
	private TileCoordinate location;
	private boolean locked;
	private int strength;
	private int prevStrength;
	private long timed;
	private boolean isEmpty;
	private Integer copyStrength;
	private Integer copyPrevStrength;
	private Long copyTimed;
	private Boolean copyIsEmpty;
	
	public LightView(TileCoordinate location) {
		this.location = location;
		this.locked = false;
	}
	
	public void lock() {
		locked = true;
	}
	
	public void release() {
		locked = false;
		if (copyStrength != null) {
			strength = copyStrength;
			copyStrength = null;
		}
		if (copyPrevStrength != null) {
			prevStrength = copyPrevStrength;
			copyPrevStrength = null;
		}
		if (copyTimed != null) {
			timed = copyTimed;
			copyTimed = null;
		}
		if (copyIsEmpty != null) {
			isEmpty = copyIsEmpty;
			copyIsEmpty = null;
		}
	}
	
	public int getStrength() {
		return strength;
	}
	
	public int getPrevStrength() {
		return prevStrength;
	}
	
	public long getTimed() {
		return timed;
	}
	
	public boolean isEmpty() {
		return isEmpty;
	}
	
	public void setStrength(int strength) {
		if (locked) {
			copyStrength = strength;
		} else {
			this.strength = strength;
		}
	}
	
	public void setPrevStrength(int prevStrength) {
		if (locked) {
			copyPrevStrength = prevStrength;
		} else {
			this.prevStrength = prevStrength;
		}
	}
	
	public void setTimed(long timed) {
		if (locked) {
			copyTimed = timed;
		} else {
			this.timed = timed;
		}
	}
	
	public void setIsEmpty(boolean isEmpty) {
		if (locked) {
			copyIsEmpty = isEmpty;
		} else {
			this.isEmpty = isEmpty;
		}
	}

	public void render(Graphics graphics, float renderX,
			float renderY, float tileSize, long time) {
		if (isEmpty()) {
			// do dim sum
			long timeDelta = time
					- getTimed();
			double percentage;
			if (timeDelta > GameLightView.TIME_TO_DIM) {
				percentage = 1.0;
			} else {
				percentage = ((double) timeDelta) / GameLightView.TIME_TO_DIM;
			}
			percentage = 1 - percentage;
			int strength = getPrevStrength();
			if (strength > 255)
				strength = 255;
			if (strength > 80) {
				int delt = strength - 80;
				int amt = (int) (delt * percentage);
				strength = strength - Math.abs(delt - amt);
				if (strength > 255)
					strength = 255;
				if (strength < 0)
					strength = 0;
			} else {
				if (timeDelta != time) // seen
					strength = 80;
			}
			Color col = new Color(84, 84, 84, 255 - strength);
			Hexagon hex = new Hexagon(col);

			hex.render(graphics, renderX, renderY, tileSize);
		} else {
			int strength = getStrength();

			if (strength > 255)
				strength = 255;
			if (strength < 0)
				strength = 0;
			Color col = new Color(84, 84, 84, 255 - strength);
			Hexagon hex = new Hexagon(col);

			hex.render(graphics, renderX, renderY, tileSize);
		}
	}
	
	private ArrayList<GameLightView> registeredViews = new ArrayList<GameLightView>();
	
	public void registerWithGameLightView(GameLightView gv) {
		gv.addLightView(location, this);
		registeredViews.add(gv);
	}
	
	public void unregisterWithGameLightView() {
		for (GameLightView gv : registeredViews) {
			gv.removeLightView(location, this);
		}
	}
}
