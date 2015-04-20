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
	
	@Override
	public void push(Behaviorable state){
		if (state != null){
			state.setEntity(entity);
			this.states.push(state);
		}
	}
	
	public void revert(){
		this.states.peek().onExit();
	}
		
	@Override
	public Behaviorable pop() {
		//keeps its original behavior
		if (this.states.size() > 1){
			return this.states.pop();
		}
		else{
			return null;
		}
	}
	
	@Override
	public void perform(double deltaTime){
		if (this.states.isEmpty()){
			return;
		}
		this.states.peek().perform(deltaTime);
	}
	
	@Override
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
	
	@Override
	public void observe(double deltaTime){
		if (this.states.isEmpty()){
			return;
		}
		this.states.peek().observe(deltaTime);
	}
}
