package model.projectile;

import java.awt.Color;

import factories.TriggerFactory;
import model.area.ConicalArea;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.event.StatisticModifierEvent;
import model.light.LightManager;
import model.light.MovingLightSource;
import model.observers.MobileObject;
import model.statistics.EntityStatistics;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import model.trigger.TriggerManager;
import utilities.Angle;
import utilities.structuredmap.StructuredMap;
import view.projectiles.BasicProjectileView;
import view.projectiles.ProjectileView;

public class Projectile extends MobileObject implements Cloneable {
	private Angle direction;
	private double speed;
	private long timeout;
	private Trigger trigger;
	public ProjectileView projView;

	public Projectile() {
		super(new TileCoordinate());
		this.direction = Angle.UP;
		this.speed = 1;
		this.trigger = new SingleUseTrigger(new RadialArea(2, this.getLocation()),
				new StatisticModifierEvent(new EntityStatistics(), 5));
		projView = new BasicProjectileView(trigger.getArea(), new Color(255, 0, 0, 200));
		MovingLightSource mlb = new MovingLightSource(this.trigger.getArea(), 255, this);
		LightManager.getSingleton().addLightSource(mlb);
	}

	public Projectile(Angle direction, TileCoordinate location, double speed,
			Trigger trigger) {
		super(location);
		this.direction = direction;
		this.speed = speed;
		this.trigger = trigger;
		projView = new BasicProjectileView(trigger.getArea(), Color.RED);
		MovingLightSource mlb = new MovingLightSource(this.trigger.getArea(), 255, this);
		LightManager.getSingleton().addLightSource(mlb);
	}
	
	public void move(TileCoordinate location) {
		this.setLocationNoNotify(location);
		trigger.moveLocation(location);
		projView.setArea(trigger.getArea());
		notifySubscribers();
	}

	public void advance() {
		if (!isTimedOut()) {
			move(getLocation().nextLocation(direction));
			timeOutProjectile();
		}
	}
	
	public void placeOnMap() {
		this.getTrigger().moveLocation(this.getLocation());
		TriggerManager.getSingleton().addNonPartyTrigger(trigger);
		ProjectileManager.getSingleton().enqueueProjectile(this);
	}
	
	public boolean hasExpired() {
		return trigger.hasExpired(); // TODO(jraviles) expire on collision
	}

	private void timeOutProjectile() {
		this.timeout = (long) (System.currentTimeMillis());
	}

	private boolean isTimedOut() {
		return (System.currentTimeMillis()-timeout) < 1000.0/speed;
	}

	public Angle getDirection() {
		return direction;
	}

	public void setDirection(Angle direction) {
		this.direction = direction;
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