package model.map.tile;

import model.entity.Entity;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.map.TileView;
import factories.TileViewFactory;

public abstract class Tile implements Saveable {
	private TileView view;
	
	public Tile(TileView view){
		this.view = view;
	}
	
	public Tile(StructuredMap map) {
		this.view = TileViewFactory.getTileView(map.getStructuredMap("view"));
	}
	
	public TileView getView() {
		return view;
	}
	
	public abstract boolean isPassable(Entity e);
	public abstract void touch(Entity e);
	
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("view", view.getStructuredMap());
		map.put("type", getType());
		return map;
	}
	
	protected abstract String getType();

}
