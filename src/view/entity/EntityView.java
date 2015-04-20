package view.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import model.area.RealCoordinate;
import model.area.TileCoordinate;
import utilities.Direction;
import utilities.ScreenCoordinate;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.Renderable;
import view.StatBar;
import view.ViewTransform;

public class EntityView implements Renderable, Saveable {
	private StatBar healthBar = new StatBar(Color.red,Color.white);
	private boolean drawHealthBar = false;
	private float lastKnownHealth = 1f;
	
	private StatBar manaBar = new StatBar(Color.blue,Color.white);
	private boolean drawManaBar = false;
	private float lastKnownMana = 1f;

	AbstractEntitySpriteHolder sprites;
	private RealCoordinate location;
	private boolean hidden = false;
	private Direction angle;
	private GameEntityView gameEntityView = null;
	private boolean locked = false;
	private RealCoordinate copyLocation;
	private Direction copyAngle;
	
	public EntityView(AbstractEntitySpriteHolder sprites) {
		this.sprites = sprites;
	}
	
	public EntityView(StructuredMap map) {
		this.sprites = EntitySpriteFactory.getSpritesFromType(map.getStructuredMap("sprites").getString("spriteType"));
		this.location = new RealCoordinate(map.getDouble("locationX"), map.getDouble("locationY"));
	}
	
	public void lock() {
		locked = true;
	}
	
	public void release() {
		locked = false;
		if (copyAngle != null) {
			angle = copyAngle;
			copyAngle = null;
		}
		if (copyLocation != null) {
			location = copyLocation;
			copyLocation = null;
		}
	}

	public void registerWithGameMapView(GameEntityView gv, RealCoordinate location, Direction angle) {
		gv.addEntityView(this);
		this.location = location;
		this.setDirection(angle);
		this.gameEntityView = gv;
	}
	
	@Override
	public void render(Graphics graphics, ViewTransform transform) {		
		if (!hidden) {
			ScreenCoordinate renderPosition = transform.getTranslatedPosition(location);
			sprites.render(graphics, renderPosition.getX(), renderPosition.getY(), transform.getTileHeight(), this.getDirection());
			
			if(drawHealthBar){
				healthBar.render(graphics, renderPosition.getX(), renderPosition.getY()-25, lastKnownHealth);
				//Height offset hardcoded atm.
			}
			if(drawManaBar){
				manaBar.render(graphics, renderPosition.getX(), renderPosition.getY()-40, lastKnownMana);
				//Height offset hardcoded atm.
			}
		}
	}
	
	public void turnOnHealthBar() {
		drawHealthBar = true;

	}
	public void updateHP(float HP){
		lastKnownHealth = HP;
	}
	
	public void turnOffHealthBar(){
		drawHealthBar = false;
	}
	
	public void turnOnManaBar(){
		drawManaBar = true;
	}
	
	public void updateMana(float mana){
		lastKnownMana = mana;
	}
	
	public void turnOffManaBar(){
		drawManaBar = false;
	}
	
	public void toggle() {
		hidden = !hidden;
	}
	
	public boolean getHidden(){
		return hidden;
	}

	private Direction getDirection() {
		return angle;
	}

	public void setLocation(RealCoordinate location) {
		if (locked) {
			this.copyLocation = location;
		} else {
			this.location = location;
		}
	}

	public void setLocation(TileCoordinate location) {
		if (hidden == false) {
			this.setLocation(TileCoordinate.convertToRealCoordinate(location));//new RealCoordinate(location.getX(), location.getY()));
		}
	}

	public void setDirection(Direction angle) {
		if (locked) {
			this.copyAngle = angle;
		} else {
			this.angle = angle;
		}
	}

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		
		map.put("locationX", location.getX());
		map.put("locationY", location.getY());
		map.put("sprites", sprites.getStructuredMap());
		return map;
	}

	public void removeFromTheWorld() {
		if(gameEntityView==null){
			System.err.println("THIS VIEW ISNT ON ANY WORLD TO REMOVE!!!!");
		}else{
			gameEntityView.remove(this);
		}
		
	}
}
