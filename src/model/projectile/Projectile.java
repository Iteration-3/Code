package model.projectile;

import java.awt.Color;

import model.area.Area;
import model.area.TileCoordinate;
import model.event.Event;
import model.light.ChangingAreaLightSource;
import model.light.LightManager;
import model.light.MovingLightSource;
import model.observers.MobileAreaObject;
import model.observers.MobileObject;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import model.trigger.TriggerManager;
import utilities.Direction;
import view.projectiles.BasicProjectileView;
import view.projectiles.ProjectileView;

public class Projectile extends MobileAreaObject implements Cloneable {
	
	private double speed;
	private long timeout;
	private Trigger trigger;
	public ProjectileView projView;
	private ChangingAreaLightSource mlb;
	protected Direction direction;
	protected TileCoordinate location;
	
	public Projectile(TileCoordinate location, Direction direction, Area area, Event event, double speed) {
		super(area);
		this.location = location;
		this.direction = direction;
		this.speed = speed;
		this.trigger = new SingleUseTrigger(area, event);
		area.setStartLocation(location);
		area.setDirection(direction);
		this.projView = new BasicProjectileView(area, new Color(255, 0, 0, 140));
		this.mlb = new ChangingAreaLightSource(area, 255, this);
	}
	
	public void move(TileCoordinate location) {
		this.location = location;
		this.getArea().setStartLocation(location);
		//notifySubscribers();
	}

	public void advance() {
		if (!isTimedOut()) {
			move(location.nextLocation(direction));
			timeOutProjectile();
		}
	}
	
	public void placeOnMap() {
		//LightManager.getSingleton().addLightSource(mlb);
		TriggerManager.getSingleton().addPartyTrigger(trigger);
		ProjectileManager.getSingleton().enqueueProjectile(this);
	}
	
	public void dispose() {
		//LightManager.getSingleton().removeLightSource(mlb);
		TriggerManager.getSingleton().removeTrigger(trigger);
		projView.dispose();
	}
	
	public boolean hasExpired() {
		return trigger.hasExpired();
	}

	protected void timeOutProjectile() {
		this.timeout = (System.currentTimeMillis());
	}

	protected boolean isTimedOut() {
		return (System.currentTimeMillis()-timeout) < 1000.0/speed;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	protected Trigger getTrigger() {
		return trigger;
	}
}