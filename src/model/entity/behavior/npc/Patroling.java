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
	
	@Override
	public void setStates(){
		//set default Patrolling movemenet
		regular = new Patrol(this.entity,new UpDown());
	}

	@Override
	public void perform(double deltaTime){
		if (count++ == ticker){
			regular.perform();
			count = 0;
		}
	}
	@Override
	public void observe(double deltaTime){
	}
	
	@Override
	public void interact(Entity entity){
		
	}
	
	@Override
	public void onDamage(Entity entity){
		
	}
	
	@Override
	public boolean isExpired(){
		return false;
	}
	
	@Override
	public void onExit(){
		
	}
	
	@Override
	public void onEnter(){
		
	}

	@Override
	public void setEntity(Entity entity) {
		this.entity = entity;
		this.setStates();
	}
}
