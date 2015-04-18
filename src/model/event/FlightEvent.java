package model.event;

public class FlightEvent extends Event {

		public FlightEvent(double duration){
			super(duration);
		}
		
		@Override
		public void perform() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onExpired(){
			if(hasTarget()){
				this.getTarget().setFlight(false);
			}
		}
		@Override
		public void onBegin(){
			if(hasTarget()){
				this.getTarget().setFlight(true);
			}
			
		}
		
		@Override
		public Event clone() {
			FlightEvent clone = 
					new FlightEvent(this.getDuration());
			return clone;
		}
	
}
