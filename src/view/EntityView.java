package view;

import java.awt.Color;
import java.awt.Graphics;

import model.area.RealCoordinate;
import model.area.TileCoordinate;
import utilities.Angle;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.map.GameEntityView;

public class EntityView implements Saveable {
	//COPY AND PASTED SHIT FROM HEXAGON PLACE HOLDER
	AbstractEntitySpriteHolder sprites;
	private RealCoordinate location;
	private boolean hidden = false;
	private static final float BORDER_PERCENTAGE = 0.15f; // 15% border edge
	private static final float OVERDRAW = 1.05f; // To eliminate little blank spaces between tiles
	private StatBar healthBar = new StatBar(Color.red,Color.white);
	private boolean drawHealthBar = false;
	private float lastKnownHealth = 1f;
	
	private StatBar manaBar = new StatBar(Color.blue,Color.white);
	private boolean drawManaBar = false;
	private float lastKnownMana = 1f;
	
	public EntityView(AbstractEntitySpriteHolder sprites) {
		this.sprites=sprites;
	}
	
	public EntityView(StructuredMap map) {
		this.sprites = EntitySpriteFactory.getSpritesFromType(map.getStructuredMap("sprites").getString("spriteType"));
		this.location = new RealCoordinate(map.getDouble("locationX"), map.getDouble("locationY"));
	}

	public void registerWithGameMapView(GameEntityView gv, RealCoordinate location, Angle angle) {
		gv.addEntityView(this);
		this.location = location;
		this.setDirection(angle);
	}
	
	
	float tileWidth;
	float tileHeight;
	private Angle angle;
	
	public void render(Graphics graphics, int screenHeight) {	
		tileHeight = screenHeight / 18.0f;
		tileWidth = tileHeight / (float) (Math.sqrt(3) / 2);
		RealCoordinate updatedCoordinate = new RealCoordinate
				((location.getX() * tileWidth * 0.75),
						(location.getY() * tileHeight + (location.getX() % 2) * tileHeight / 2));
		//foregroundHexagon.render(graphics, updatedCoordinate, tileWidth * (1 - BORDER_PERCENTAGE) * OVERDRAW);
		//backgroundHexagon.render(graphics, updatedCoordinate, tileWidth * BORDER_PERCENTAGE * OVERDRAW);
		sprites.render(graphics, updatedCoordinate, 1,this.getDirection());
		if(drawHealthBar){
			healthBar.render(graphics,updatedCoordinate.getX(),updatedCoordinate.getY()-25,lastKnownHealth);
			//Height offset hardcoded atm.
		}
		if(drawManaBar){
			manaBar.render(graphics,updatedCoordinate.getX(),updatedCoordinate.getY()-40,lastKnownMana);
			//Height offset hardcoded atm.
		}
		
	}
	
	public void turnOnHealthBar(){
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
		if (hidden) {
			this.setLocation(new RealCoordinate(-5, -5));
		}
	}

	private Angle getDirection() {
		return angle;
	}

	public void setLocation(RealCoordinate location) {
		this.location = location;
	}

	public void setLocation(TileCoordinate location) {
		if (hidden == false) {
			this.setLocation(new RealCoordinate(location.getX(), location.getY()));
		}
	}

	public void setDirection(Angle angle) {
		this.angle = angle;
		
	}

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		
		map.put("locationX", location.getX());
		map.put("locationY", location.getY());
		map.put("sprites", sprites.getStructuredMap());
		return map;
	}
}
