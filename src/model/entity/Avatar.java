package model.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import model.KeyPreferences;
import model.ability.Ability;
import model.area.ConicalArea;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.light.LightManager;
import model.light.MovingLightSource;
import model.skillmanager.SkillManager;
import utilities.Angle;
import utilities.structuredmap.StructuredMap;
import view.EntityView;
import controller.listener.Listener;
import controller.listener.PollingListener;
import factories.AbilityFactory;
import factories.SkillManagerFactory;
import gameactions.GameAction;

public abstract class Avatar extends Entity {
	private Collection<Ability> abilities = new ArrayList<Ability>();
	private SkillManager skillManager;
	
	public Avatar(StructuredMap map) {
		this.abilities = new ArrayList<Ability>();
		StructuredMap[] abilityMap = map.getStructuredMapArray("abilities");
		for(StructuredMap ability : abilityMap) {
			this.abilities.add(AbilityFactory.createAbility(ability));
		}
		this.skillManager = SkillManagerFactory.createSkillManager(map.getStructuredMap("skills"));
	}
	
	@Override 
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		StructuredMap[] abilityMap = new StructuredMap[this.abilities.size()];
		int i = 0;
		Iterator<Ability> it = abilities.iterator();
		while(it.hasNext()) {
			abilityMap[i++] = it.next().getStructuredMap();
		}
		map.put("abilities", abilityMap);
		map.put("skills", skillManager.getStructuredMap());
		return map;
	}

	public Avatar(String name, EntityView view, TileCoordinate loc){
		super(name, view, loc);
		//Make light manager track all avatars movement
		MovingLightSource avatarLight = new MovingLightSource(new RadialArea(3, loc), 255, this);
		LightManager.getSingleton().addLightSource(avatarLight);
		setLocation(loc);
		//LightManager.getLightManager().getLightMap().trackMovement(this);
		//setLocation(loc);//So lightMap registers current position
	}
	
	@Override
	public void move(Angle angle) {
		TileCoordinate nextLocation = this.nextLocation(angle);
		NPC npc = EntityManager.getSingleton().getNPCAtLocation(nextLocation);
		if (npc != null) {
			npc.interact(this);
		} else {
			super.move(angle);
		}
	}
	
	@Override
	public void addExperience(int experience) {
		int level = getBaseStats().getLevel();
        getBaseStats().addExperience(experience);
        int updatedLevel = getBaseStats().getLevel();
        if (updatedLevel > level) {
        	skillManager.incrementSkillPointToSpend();
        }
	}
	
	@Override
	public Collection<Listener> getListeners(KeyPreferences preferences) {
		System.out.println("Test");
		Collection<Listener> listeners = new ArrayList<Listener>();
		int i = 1;
		for(final Ability a : this.getAbilities()){
			listeners.add(new PollingListener(preferences.getAbility(i),new GameAction() {
				@Override
				public void perform() {
					a.perform(Avatar.this);
				}
			}));
			++i;
		}
		return listeners;
		
	}
	
	public int getAttackSkill() {
		return getSkillManager().getAttackSkill();
	}
	
	public int getBarterSkill() {
		return getSkillManager().getBarterSkill();
	}
	
	public int getBindWoundSkill() {
		return getSkillManager().getBindWoundsSkill();
	}
	
	public int getObserveSkill() {
		return getSkillManager().getObserveSkill();
	}
	
	// I made this public instead of protected.  
	// The alternative is making things like: incrementAttackSkill() in the 
	// Avatar's public interface
	// This may not be good Encapsulation practices though
	public SkillManager getSkillManager() {
		return this.skillManager;
	}
	
	protected void setSkillManager(SkillManager skillManager) {
		this.skillManager = skillManager;
	}
	
	protected Collection<Ability> getAbilities(){
		return abilities;
	}
	
}
