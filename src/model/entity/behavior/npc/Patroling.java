package model.entity.behavior.npc;

import model.entity.Entity;
import model.entity.behavior.npc.defaultb.DefaultableBehaviorState;
import model.entity.behavior.npc.defaultb.Patrol;
import model.entity.behavior.npc.observe.ObservableBehaviorState;
import model.entity.behavior.npc.observe.TargetAvatar;

public class Patroling implements Behaviorable {
	private DefaultableBehaviorState regular;
	private Entity entity;
	private int count;
	private int ticker = 1000000;
	private ObservableBehaviorState targetAvatar;
	
	public Patroling(){
	}
	
	public void setStates(){
		regular = new Patrol(this.entity);
		targetAvatar = new TargetAvatar(this.entity,7);
	}

	public void perform(){
		if (count++ == ticker){
			regular.perform();
			count = 0;
		}
	}
	
	public void observe(){
		targetAvatar.observe();
	}
	
	public void interact(Entity entity){
		
	}
	
	public void onDamage(){
		
	}
	
	public boolean isExpired(){
		return false;
	}
	
	public void onExit(){
		
	}
	
	public void onEnter(){
		
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
		this.setStates();
	}
}
