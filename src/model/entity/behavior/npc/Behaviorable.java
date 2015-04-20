package model.entity.behavior.npc;

import model.entity.Entity;

public interface Behaviorable {
	
	public void perform();
	
	public void observe();
	
	public void interact(Entity entity);
	
	public void onDamage(Entity entity);
	
	public boolean isExpired();
	
	public void onExit();
	
	public void onEnter();
	
	public void setEntity(Entity entity);
	
	public void setStates();

}
