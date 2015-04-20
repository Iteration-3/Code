package model.event;

import model.entity.Sneak;
import utilities.structuredmap.StructuredMap;

public class InvisiblityEvent extends Event{
	private Sneak sneak;
	public InvisiblityEvent(double duration, Sneak sneak) {
		super(duration);
		this.sneak = sneak;
	}

	public InvisiblityEvent(StructuredMap structuredMap) {
		super(structuredMap);
	}

	@Override
	public void perform() {
		//Do nothing.
	}
	@Override
	public void onBegin() {
		if(this.getTarget()!=null){
			//When clear to refactor eView, change to like, ...visibility(false);
			if(!this.getTarget().getEntityView().getHidden()){
				this.getTarget().getEntityView().toggle();
				sneak.setSurpriseAttackOn();
			}
		}
	}

	@Override
	public void onExpired() {
		if(this.getTarget()!=null){
			//When clear to refactor eView, change to like, ...visibility(true);
			if(this.getTarget().getEntityView().getHidden()){
				this.getTarget().getEntityView().toggle();
				sneak.setSurpriseAttackOff();
			}
		}		
	}

	@Override
	public InvisiblityEvent clone() {
		InvisiblityEvent clone =  new InvisiblityEvent(this.getDuration(),sneak);
		clone.setTarget(this.getTarget());
		return clone;
	}

	@Override
	protected String getType() {
		return "InvisibleEvent";
	}

}
