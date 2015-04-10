package model.projecilte;

import utilities.Angle;
import model.area.Location;
import model.trigger.TimedTrigger;
import model.trigger.Trigger;

public class ConicalProjectile extends Projectile {

	public ConicalProjectile() {
		super();
		this.setTrigger(new TimedTrigger(this.getTrigger().getArea(), this.getTrigger().getEvent(), 5));
	}

	public ConicalProjectile(Angle direction, Location location, double speed,
			long timeout, Trigger trigger) {
		super(direction, location, speed, timeout, trigger);
	}

	/* (non-Javadoc)
	 * @see projectile.Projectile#advance()
	 * This will create two linear triggers on the edges of the cone and move up by one
	 */
	@Override
	public void advance() {
		Angle leftAngle = this.getDirection().getLeft();
		Angle rightAngle = this.getDirection().getRight();
		Projectile leftProjectile = new Projectile(leftAngle, this
				.getLocation().nextLocation(leftAngle), this.getSpeed(),
				this.getTimeout(), this.getTrigger());
		Projectile rightProjectile = new Projectile(rightAngle, this
				.getLocation().nextLocation(rightAngle), this.getSpeed(),
				this.getTimeout(), this.getTrigger());
		ProjectileManager.addProjectile(leftProjectile);
		ProjectileManager.addProjectile(rightProjectile);

		this.setLocation(this.getLocation().nextLocation(this.getDirection()));
		this.getTrigger().moveLocation(this.getLocation());
	}

	@Override
	public boolean hasExpired() {
		return getTrigger().hasExpired(); // TODO(jraviles) figure out collisions
	}

}
