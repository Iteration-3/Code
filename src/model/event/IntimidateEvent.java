package model.event;

import model.entity.Entity;
import model.entity.behavior.npc.Coward;

public class IntimidateEvent extends SourcedEvent{



	public IntimidateEvent(Entity source, Entity target, double duration) {
		super(source, target, duration);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onExpired() {
		this.getTarget().pop();
	}
	@Override
	public void onBegin() {
		System.out.println("was run");
		System.out.println(this.getSource() + " " + this.getTarget());
		this.getTarget().push(new Coward(true, this.getSource()));
	}

	@Override
	public IntimidateEvent clone() {
		IntimidateEvent clone = 
				new IntimidateEvent(this.getSource(),this.getTarget(),this.getDuration());
		return clone;
	}

	@Override
	protected String getType() {
		return "intimidateevent";
	}

}
