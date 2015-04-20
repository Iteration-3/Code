package model.entity.behavior.npc;

import model.entity.Entity;
import model.entity.behavior.npc.defaultb.DefaultableBehaviorState;
import model.entity.behavior.npc.defaultb.Patrol;
import model.entity.behavior.npc.defaultb.circuit.UpDown;

public class Patroling implements Behaviorable {
	private DefaultableBehaviorState regular;
	private Entity entity;
	private int count;
	private int ticker = 100;
	
	public Patroling(){
	}
	
	public void setStates(){
		//set default Patrolling movemenet
		regular = new Patrol(this.entity,new UpDown());
	}

	public void perform(){
		if (count++ == ticker){
			regular.perform();
			count = 0;
		}
	}
	
	public void observe(){
	}
	
	public void interact(Entity entity){
		
	}
	
	public void onDamage(Entity entity){
		
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
