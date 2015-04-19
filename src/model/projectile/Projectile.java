package model.projectile;

import java.awt.Color;

import model.area.RadialArea;
import model.area.TileCoordinate;
import model.event.StatisticModifierEvent;
import model.statistics.EntityStatistics;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import model.trigger.TriggerManager;
import utilities.Angle;
import view.projectiles.BasicProjectileView;
import view.projectiles.ProjectileView;

public class Projectile implements Cloneable {
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
