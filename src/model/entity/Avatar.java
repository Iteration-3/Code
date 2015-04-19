package model.entity;

import gameactions.GameAction;

import java.util.ArrayList;
import java.util.Collection;

import controller.listener.Listener;
import controller.listener.PollingListener;
import model.KeyPreferences;
import model.ability.Ability;
import model.area.TileCoordinate;
import model.skillmanager.SkillManager;
import utilities.Angle;
import view.EntityView;

public abstract class Avatar extends Entity {
	private Collection<Ability> abilities = new ArrayList<Ability>();
	private SkillManager skillManager;
	
	public Avatar(String name, EntityView view, TileCoordinate loc){
		super(name, view, loc);
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
	public Collection<Listener> getListeners(KeyPreferences preferences) {
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
	
	protected Collection<Ability> getAbilities(){
		return abilities;
	}
	
}
