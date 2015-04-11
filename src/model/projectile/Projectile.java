package model.projectile;

import model.area.Location;
import model.area.RadialArea;
import model.event.StatisticModifierEvent;
import model.statistics.EntityStatistics;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import model.trigger.TriggerManager;
import utilities.Angle;

public class Projectile {
	private Angle direction;
	private Location location;
	private double speed;
	private long timeout;
	private Trigger trigger;

	public Projectile() {
		this.direction = Angle.UP;
		this.location = new Location();
		this.speed = 1;
		this.timeout = 1;
		this.trigger = new SingleUseTrigger(new RadialArea(1, this.location),
				new StatisticModifierEvent(new EntityStatistics(), 5));
		TriggerManager.addNeutralTrigger(trigger);
	}

	public Projectile(Angle direction, Location location, double speed,
			long timeout, Trigger trigger) {
		this.direction = direction;
		this.location = location;
		this.speed = speed;
		this.timeout = timeout;
		this.trigger = trigger;
		TriggerManager.addNeutralTrigger(trigger);
	}

	public void advance() {
		if (!isTimedOut()) {
			this.location = location.nextLocation(direction);
			trigger.moveLocation(location);
			timeOutProjectile();
		}
	}

	public boolean hasExpired() {
		return trigger.hasExpired(); // TODO(jraviles) expire on collision
	}

	private void timeOutProjectile() {
		this.timeout = (long) (System.currentTimeMillis() + 1 / speed);
	}

	private boolean isTimedOut() {
		return this.timeout > System.currentTimeMillis();
	}

	public Angle getDirection() {
		return direction;
	}

	public void setDirection(Angle direction) {
		this.direction = direction;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
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
