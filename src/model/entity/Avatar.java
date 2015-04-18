package model.entity;

import factories.AbilityFactory;
import factories.SkillManagerFactory;
import gameactions.GameAction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import model.KeyPreferences;
import model.ability.Ability;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.light.LightManager;
import model.light.MovingLightSource;
import model.light.Visibility;
import model.skillmanager.SkillManager;
import utilities.structuredmap.StructuredMap;
import view.EntityView;
import controller.listener.Listener;
import controller.listener.PollingListener;

public abstract class Avatar extends Entity {
	private Collection<Ability> abilities = new ArrayList<Ability>();
	private SkillManager skillManager;
	
	public Avatar() {
		//LightManager.getLightManager().getLightMap().trackMovement(this);
		//setLocation(getLocation());//So lightMap registers current position
	}
	
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
		MovingLightSource avatarLight = new MovingLightSource(new RadialArea(10, loc), new Visibility(255), this);
		LightManager.getLightManager().addLightSource(avatarLight);
		setLocation(loc);
		//LightManager.getLightManager().getLightMap().trackMovement(this);
		//setLocation(loc);//So lightMap registers current position
	}
	
	protected Collection<Ability> getAbilities(){
		return abilities;
	}
	
	@Override
	public Collection<Listener> getListeners(KeyPreferences preferences){
		System.out.println("Test");
		Collection<Listener> listeners = new ArrayList<Listener>();
		int i = 1;
		for(Ability a : this.getAbilities()){
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
	
	
	
	//Ovverrides stats and name? Says in UML, but that's weird
	//Also overrides move, according to uml? Meh, if we need it, we'll do it, not before IMO
	
	//SkillManager
	//Abilities
	//ControlerManager
	
	//Also apparently ovverrides add/removeItem, and equip/unequipItem, but that also seems 
	//like an uneeded ovverride, so won't do until needed.
	
	//getListeners will be needed
	
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
	
	protected SkillManager getSkillManager() {
		return this.skillManager;
	}
	
	protected void setSkillManager(SkillManager skillManager) {
		this.skillManager = skillManager;
	}
	
}
