package model.projectile;

import java.awt.Color;

import model.area.Area;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.event.Event;
import model.light.LightManager;
import model.light.MovingLightSource;
import model.observers.MobileObject;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import model.trigger.TriggerManager;
import utilities.Angle;
import view.projectiles.BasicProjectileView;
import view.projectiles.ProjectileView;

public class Projectile extends MobileObject implements Cloneable {
	
	private double speed;
	private long timeout;
	private Trigger trigger;
	public ProjectileView projView;
	private MovingLightSource mlb;
	
	public Projectile(TileCoordinate location, Angle direction, Area area, Event event, double speed) {
		super(location);
		setDirectionNoNotify(direction);
		this.speed = speed;
		this.trigger = new SingleUseTrigger(area, event);
		area.setStartLocation(location);
		area.setDirection(direction);
		this.projView = new BasicProjectileView(area, new Color(255, 0, 0, 140));
		this.mlb = new MovingLightSource(area, 255, this);
	}
	
	public void move(TileCoordinate location) {
		setLocation(location);
	}

	public void advance() {
		if (!isTimedOut()) {
			move(getLocation().nextLocation(getDirection()));
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
		this.timeout = (long) (System.currentTimeMillis());
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