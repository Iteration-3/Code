package model.event;

import utilities.structuredmap.StructuredMap;

public class FlightEvent extends Event {

		public FlightEvent(double duration){
			super(duration);
		}
		
		public FlightEvent(StructuredMap map) {
			super(map);
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

		@Override
		protected String getType() {
			return "flightEvent";
		}
	
}
