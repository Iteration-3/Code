package model.ability.sneak;

import utilities.Angle;
import model.ability.ProjectileAbility;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.entity.Entity;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.projectile.Projectile;
import model.projectile.linear.ThrowingKnife;
import model.skillmanager.SneakSkillManager;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;

public class Ranged extends ProjectileAbility {
	
	private SneakSkillManager manager;
	
	public Ranged(SneakSkillManager sneakSkillManager) {
		super(10);
		this.manager = sneakSkillManager;
	}
	
	
	public Projectile getProjectile(Entity ent) {
		//TODO: Currently no level for this?
		Event damageEvent = new HealthModifierEvent(0, -10);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, ent.getLocation()), damageEvent);
		ThrowingKnife knife =  new ThrowingKnife(ent.getLocation(), ent.getDirection(), damageTrigger
				, 1.0);
		return knife;
	}
}
