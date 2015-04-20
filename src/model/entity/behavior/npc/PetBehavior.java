package model.entity.behavior.npc;

import model.area.RadialArea;
import model.entity.Entity;
import model.entity.EntityManager;
import model.entity.behavior.npc.defaultb.LinkAndInteract;
import model.entity.behavior.npc.defaultb.LinkWithTarget;
import model.entity.behavior.npc.interact.AttackInteract;
import model.entity.behavior.npc.observe.FindTargetRandom;
import model.entity.behavior.npc.observe.StopAtTarget;
import model.light.LightManager;
import model.light.LightSource;
import model.light.MovingStaticLightSource;

public class PetBehavior implements Behaviorable {
	private Entity entity;
	private Entity target;
	private Entity attackEntity;
	private FindTargetRandom observer;
	private LinkWithTarget performer;
	private LightSource lightSource;
	private AttackInteract interact;
	private LinkAndInteract performInteract;
	private boolean foundATarget;
	private int counter,trigger = 5000;
	
	public PetBehavior(){
		
	}

	@Override
	public void perform(double deltaTime) {
		if (this.observer.found()){
			this.foundATarget = true;
			this.performInteract = new LinkAndInteract(this.entity,this.observer.getFoundPerson());
		}
		if(this.foundATarget){
			this.performInteract.perform();
			if (counter++ == trigger){
				this.foundATarget = false;
				counter = 0;
			}
		}
		else{
			this.performer.perform();
		}
	}

	@Override
	public void observe(double deltaTime) {
		if (!this.foundATarget){
			this.observer.observe();
		}
	}

	@Override
	public void interact(Entity entity) {
		if (this.foundATarget){
			interact.interact(entity);
		}
	}

	@Override
	public void onDamage(Entity entity) {
	}

	@Override
	public boolean isExpired() {
		return false;
	}

	@Override
	public void onExit() {
		LightManager.getSingleton().removeLightSource(lightSource);
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void setEntity(Entity entity) {
		this.entity = entity;
		this.setStates();

		this.lightSource = new MovingStaticLightSource(new RadialArea(1, entity.getLocation()),255, entity);
		LightManager.getSingleton().addLightSource(lightSource);
	}

	@Override
	public void setStates() {
		performer = new LinkWithTarget(this.entity , 
				EntityManager.getSingleton().getAvatar());
		observer = new FindTargetRandom(this.entity,new RadialArea(10,this.entity.getLocation()));
		interact = new AttackInteract(this.entity,true);
	}

}
