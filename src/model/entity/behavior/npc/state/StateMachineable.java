package model.entity.behavior.npc.state;

import model.entity.Entity;
import model.entity.behavior.npc.Behaviorable;

public interface StateMachineable {
	
	public Behaviorable pop();
	
	public void push(Behaviorable behavior);
	
	public void perform(double deltaTime);
	
	public void interact(Entity entity);
	
	public void observe(double deltatTime);


}
