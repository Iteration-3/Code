package model.entity;

import gameactions.GameAction;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.KeyStroke;

import model.KeyPreferences;
import model.ability.Ability;
import model.ability.BindWounds;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.entity.behavior.npc.AvatarBehavior;
import model.entity.behavior.npc.Behaviorable;
import model.light.LightManager;
import model.light.MovingLightSource;
import model.skillmanager.SkillManager;
import utilities.Direction;
import utilities.structuredmap.StructuredMap;
import view.entity.EntityView;
import controller.listener.Listener;
import controller.listener.PollingListener;

public abstract class Avatar extends Entity {
	private Collection<Ability> abilities = new ArrayList<Ability>();
	
	public Avatar(String name, EntityView view, TileCoordinate loc) {
		super(name, view, loc, new AvatarBehavior());
		//Make light manager track all avatars movement
		MovingLightSource avatarLight = new MovingLightSource(new RadialArea(5, loc), 255, this);
		LightManager.getSingleton().addLightSource(avatarLight);
		setLocation(loc);
		//LightManager.getLightManager().getLightMap().trackMovement(this);
		//setLocation(loc);//So lightMap registers current position
	}
	
	public Avatar(StructuredMap map) {
		super(map);
		//hack?
		MovingLightSource avatarLight = new MovingLightSource(new RadialArea(5, getLocation()), 255, this);
		LightManager.getSingleton().addLightSource(avatarLight);
	}
	
	protected void generateSkills(){
		this.getAbilities().add(new BindWounds(this.getSkillManager()));
	}
	
	@Override
	public void move(Direction angle) {
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
		for (int i = level; i < updatedLevel; ++i )
			this.getSkillManager().incrementSkillPointToSpend();
	}
	
	@Override
	public Collection<Listener> getListeners(KeyPreferences preferences) {
		Collection<Listener> listeners = new ArrayList<Listener>();
		int i = 0;
		for(final Ability a : this.getAbilities()){
			listeners.add(new PollingListener(preferences.getAbility(i),new GameAction() {
				@Override
				public void perform() {
					a.perform(Avatar.this);
				}
			}));
			++i;
		}
		listeners.add(new PollingListener(preferences.getAttackKey(), new GameAction() {
			
			@Override
			public void perform() {
				//TODO Ensure this isaffected by equipement and so forth.
				//Same for defending.
				System.out.println("attack");
				Avatar.this.attackInFront(-Avatar.this.getDerivedStats().getOffensiveRating()*10);
				
			}
		}));
		listeners.add(new PollingListener(preferences.getSuicideKey(), new GameAction() {
			
			@Override
			public void perform() {
				Avatar.this.attackEntity(Avatar.this, -500);
				
			}
		}));
		return listeners;
		
	}
	
	public boolean hasMoney(int money) {
		return this.getBaseStats().getMoney() >= money;
	}
	
	public void addMoney(int money) {
		this.removeMoney(-1 * money);
	}
	
	public void removeMoney(int money) {
		this.getBaseStats().addMoney(-1 * money);
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
	public abstract SkillManager getSkillManager();

	
	@Override
	public void updateExtras(double deltaTime){
		this.updateStatBars();
	}
	
	private void updateStatBars(){
		//Only appear during combat state.
		if(this.isInCombat()){
			this.getEntityView().updateHP(this.getHpPercentage());
			this.getEntityView().turnOnHealthBar();
			this.getEntityView().updateMana(this.getManaPercentage());
			this.getEntityView().turnOnManaBar();
		}else{
			this.getEntityView().turnOffHealthBar();
			this.getEntityView().turnOffManaBar();
		}
	}
	
	protected Collection<Ability> getAbilities(){
		return abilities;
	}
	
	@Override
	public void accept(EntiyVisitorable visitor){
		visitor.accept(this);
	}
	
	@Override
	protected Behaviorable getBehavior(){
		return new AvatarBehavior();
	}
	
}
