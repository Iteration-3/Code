package model.projectile.conical;

import utilities.Angle;
import model.area.TileCoordinate;
import model.projectile.Projectile;
import model.projectile.ProjectileManager;
import model.trigger.TimedTrigger;
import model.trigger.Trigger;

public class ConicalProjectile extends Projectile {

	public ConicalProjectile() {
		super();
		this.setTrigger(new TimedTrigger(this.getTrigger().getArea(), this.getTrigger().getEvent(), 5));
	}

	public ConicalProjectile(Angle direction, TileCoordinate location, double speed,
			Trigger trigger) {
		super(direction, location, speed, trigger);
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
				this.getTrigger());
		Projectile rightProjectile = new Projectile(rightAngle, this
				.getLocation().nextLocation(rightAngle), this.getSpeed(),
				this.getTrigger());
		ProjectileManager.addProjectile(leftProjectile);
		ProjectileManager.addProjectile(rightProjectile);

		this.setLocation(this.getLocation().nextLocation(this.getDirection()));
		this.getTrigger().moveLocation(this.getLocation());
	}

	@Override
	public boolean hasExpired() {
		return getTrigger().hasExpired(); // TODO(jraviles) figure out collisions
	}
	
	public ConicalProjectile clone() {
		ConicalProjectile clone = new ConicalProjectile();
		clone.setDirection(this.getDirection());
		clone.setLocation(this.getLocation());
		clone.setSpeed(this.getSpeed());
		clone.setTimeout(this.getTimeout());
		clone.setTrigger(this.getTrigger());
		return clone;
	}

}
