package model.ability.sneak;

import model.ability.ProjectileAbility;
import model.area.RadialArea;
import model.entity.Entity;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.projectile.Projectile;
import model.projectile.linear.ThrowingKnife;
import model.skillmanager.SneakSkillManager;

public class Ranged extends ProjectileAbility {
	
	private SneakSkillManager manager;
	
	public Ranged(SneakSkillManager sneakSkillManager) {
		super(10);
		this.manager = sneakSkillManager;
	}
	
	
	@Override
	public Projectile getProjectile(Entity ent) {
		//TODO: Currently no level for this?
		Event damageEvent = new HealthModifierEvent(ent, null, 0, -10);
		return new ThrowingKnife(ent.getLocation(), ent.getDirection(), new RadialArea(1, null), damageEvent, 1.0);
	}
}
