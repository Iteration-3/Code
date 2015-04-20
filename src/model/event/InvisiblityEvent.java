package model.event;

import model.entity.EntityManager;
import utilities.structuredmap.StructuredMap;

public class InvisiblityEvent extends Event{
	
	public InvisiblityEvent(double duration) {
		super(duration);
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
				EntityManager.getSingleton().setAvatarHiding(true);
				this.getTarget().getEntityView().toggle();
			}
		}
	}

	@Override
	public void onExpired() {
		if(this.getTarget()!=null){
			//When clear to refactor eView, change to like, ...visibility(true);
			if(this.getTarget().getEntityView().getHidden()){
				EntityManager.getSingleton().setAvatarHiding(false);
				this.getTarget().getEntityView().toggle();
			}
		}		
	}

	@Override
	public InvisiblityEvent clone() {
		InvisiblityEvent clone =  new InvisiblityEvent(this.getDuration());
		clone.setTarget(this.getTarget());
		return clone;
	}

	@Override
	protected String getType() {
		return "InvisibleEvent";
	}

}
