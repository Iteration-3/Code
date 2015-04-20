package factories;

import model.statistics.BoundedEntityStatistics;

public class StatsFactory {
	
	public static BoundedEntityStatistics getNormalStats(){
		return new BoundedEntityStatistics();
	}
	
	public static BoundedEntityStatistics getTrooperStats(){
		return new BoundedEntityStatistics(40, 10,10,700,1,700,50,700,700,0);
	}
	public static BoundedEntityStatistics getHeavyTrooperStats(){
		return new BoundedEntityStatistics(80, 10,10,3000,1,3000,50,3000,3000,0);
	}

//		  public EntityStatistics(int strength, int agility, int intellect, int hardiness, int livesLeft, int experience,
//            int movement, int currentHealth, int currentMana, int money) 
}
