package model.entity.behavior.npc;

import model.area.RadialArea;
import model.entity.Entity;
import model.entity.EntityManager;
import model.entity.behavior.npc.defaultb.LinkAndInteract;
import model.entity.behavior.npc.defaultb.ListenForMovement;
import model.entity.behavior.npc.interact.AttackInteract;
import model.entity.behavior.npc.observe.TargetEntity;

public class TrooperBehavior implements Behaviorable {
	private Entity chosen;
	private AttackInteract interact;
	private ListenForMovement perform;
	private Behaviorable onAttack;
	private TargetEntity observer;
	private int radius;
	
	public TrooperBehavior(Behaviorable behavior,int radius){
		this.onAttack = behavior;
		this.radius = radius;
	}
	public TrooperBehavior(int radius){
		this.radius = radius;
	}

	@Override
	public void perform(double deltaTime) {
		this.perform.perform();
	}

	@Override
	public void observe(double deltaTime) {
		this.observer.observe();
		if (this.observer.found()) {
			this.perform.push(this.observer.getMove());
		}
	}

	@Override
	public void interact(Entity entity) {
		interact.interact(entity);
	}

	@Override
	public void onDamage(Entity entity) {
		if (this.onAttack != null){
			//System.out.println(this.chosen.getHpPercentage());
			if (this.chosen.getHpPercentage() < 0.5){
				this.chosen.push(this.onAttack);
			}
		}
	}

	@Override
	public boolean isExpired() {
		return false;
	}

	@Override
	public void onExit() {
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void setEntity(Entity entity) {
		this.chosen = entity;
		this.setStates();
	}

	@Override
	public void setStates() {
		this.interact = new AttackInteract(this.chosen);
		this.observer = new TargetEntity(this.chosen,EntityManager.getSingleton().getAvatar()
				,new RadialArea(this.radius,this.chosen.getLocation()),false);
		this.perform = new ListenForMovement(this.chosen);
	}

}
