package model.entity.behavior.npc.state;

import java.util.Stack;

import model.entity.Entity;
import model.entity.behavior.npc.Behaviorable;

public class StateMachine implements StateMachineable {
	private Stack<Behaviorable> states = new Stack<Behaviorable>();
	private Entity entity;
	
	public StateMachine(Entity entity){
		this.entity = entity;
	}
	
	public void push(Behaviorable state){
		if (state != null){
			state.setEntity(entity);
			this.states.push(state);
		}
	}
		
	public Behaviorable pop() {
		//keeps its original behavior
		if (this.states.size() > 1){
			return this.states.pop();
		}
		else{
			return null;
		}
	}
	
	public void perform(){
		if (this.states.isEmpty()){
			return;
		}
		this.states.peek().perform();
	}
	
	public void interact(Entity entity){
		if (this.states.isEmpty()){
			return;
		}
		this.states.peek().interact(entity);
	}
	
	public void onDamage(Entity entity){
		if (this.states.isEmpty()){
			return;
		}
		this.states.peek().onDamage(entity);
	}
	
	public void observe(){
		if (this.states.isEmpty()){
			return;
		}
		this.states.peek().observe();
	}
}
