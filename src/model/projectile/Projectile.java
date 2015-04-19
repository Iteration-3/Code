package model.projectile;

import java.awt.Color;

import factories.TriggerFactory;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.event.StatisticModifierEvent;
import model.statistics.EntityStatistics;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import model.trigger.TriggerManager;
import utilities.Angle;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.projectiles.BasicProjectileView;
import view.projectiles.ProjectileView;

public class Projectile implements Cloneable, Saveable {
	private Angle direction;
	private TileCoordinate location;
	private double speed;
	private long timeout;
	private Trigger trigger;
	public ProjectileView projView;

	public Projectile() {
		this.direction = Angle.UP;
		this.location = new TileCoordinate();
		this.speed = 1;
		this.trigger = new SingleUseTrigger(new RadialArea(0, this.location),
				new StatisticModifierEvent(new EntityStatistics(), 5));
		projView = new BasicProjectileView(location, Color.RED, 40);
	}
	
	public Projectile(StructuredMap map) {
		this.direction = Angle.values()[map.getInteger("direction")];
		int[] locations = map.getIntArray("location");
		this.location = new TileCoordinate(locations[0], locations[1]);
		this.speed = map.getDouble("speed");
		this.timeout = map.getDouble("timeout").longValue();
		this.trigger = TriggerFactory.createTrigger(map.getStructuredMap("trigger"));
		projView = new BasicProjectileView(location, Color.RED, 40);
	}
	
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		
		int[] locationArray = new int[2];
        locationArray[0] = location.getX();
        locationArray[1] = location.getY();
 
		map.put("direction", direction.ordinal());
		map.put("location", locationArray);
		map.put("speed", speed);
		map.put("timeout",(double) timeout);
		map.put("trigger", trigger.getStructuredMap());
		map.put("type", getType());
		
		return map;
	}

	protected String getType() {
		return "projectile";
	}

	public Projectile(Angle direction, TileCoordinate location, double speed,
			Trigger trigger) {
		this.direction = direction;
		this.location = location;
		this.speed = speed;
		this.trigger = trigger;
		projView = new BasicProjectileView(location, Color.RED, 40);
	}
	
	public void move(TileCoordinate location) {
		this.location = location;
		trigger.moveLocation(location);
		projView.setLocation(location);
	}

	public void advance() {
		if (!isTimedOut()) {
			System.out.println("DIRECTION: " + direction);
			System.out.println("AREA: " + trigger.getArea().getStartLocation());
			move(location.nextLocation(direction));
			timeOutProjectile();
		}
	}
	
	public void placeOnMap() {
		this.getTrigger().moveLocation(this.getLocation());
		TriggerManager.getSingleton().addNeutralTrigger(trigger);
		ProjectileManager.getSingleton().enqueueProjectile(this);
	}
	
	public boolean hasExpired() {
		return trigger.hasExpired(); // TODO(jraviles) expire on collision
	}

	private void timeOutProjectile() {
		this.timeout = (long) (System.currentTimeMillis());
	}

	private boolean isTimedOut() {
		return (System.currentTimeMillis()-timeout) < 2000;
	}

	public Angle getDirection() {
		return direction;
	}

	public void setDirection(Angle direction) {
		this.direction = direction;
	}

	public TileCoordinate getLocation() {
		return location;
	}

	public void setLocation(TileCoordinate location) {
		//this.location = location;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public Trigger getTrigger() {
		return trigger;
	}

	public void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}
	
	
}
