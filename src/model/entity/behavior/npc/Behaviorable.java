package model.entity.behavior.npc;

import model.entity.Entity;

public interface Behaviorable {
	
	public void perform();
	
	public void observe();
	
	public void interact(Entity entity);
	
	public void onDamage();
	
	public boolean isExpired();
	
	public void onExit();
	
	public void onEnter();

}