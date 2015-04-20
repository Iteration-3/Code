package model.entity;

import model.ability.Ability;
import model.ability.summoner.bane.Firebolt;
import model.ability.summoner.bane.LightBeam;
import model.ability.summoner.bane.ShadowBlast;
import model.ability.summoner.boon.FlightBoon;
import model.ability.summoner.boon.HealBoon;
import model.ability.summoner.boon.MovementBoon;
import model.ability.summoner.boon.StrengthBoon;
import model.ability.summoner.enchantment.Cripple;
import model.ability.summoner.enchantment.Intimidate;
import model.ability.summoner.enchantment.Silence;
import model.area.TileCoordinate;
import model.item.Helmet;
import model.skillmanager.SummonerSkillManager;
import model.slots.ItemManager;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.EntitySpriteFactory;
import view.EntityView;
import view.item.BasicItemView;

public class Summoner extends Avatar {
	protected ItemManager itemManger = new ItemManager(this);
	private SummonerSkillManager skillManager;

	public Summoner() {
		this("Summoner", new EntityView(EntitySpriteFactory.getSummonerSpriteHolder()), new TileCoordinate(1, 1));
	}

	public Summoner(String name, EntityView view, TileCoordinate loc) {
		super(name, view, loc);
		this.skillManager = (new SummonerSkillManager());
		this.generateSkills();

	}
	
	public Summoner(StructuredMap map) {
		super(map);
	}
	
	protected void addRandomItems(){
		//TODO why are items here???
		this.addItem(new Helmet(new BasicItemView(),new Statistics()));
		this.addItem(new Helmet(new BasicItemView(),new Statistics()));
		this.addItem(new Helmet(new BasicItemView(),new Statistics()));
		this.equip(new Helmet(new BasicItemView(),new Statistics()));

	}

	@Override
	protected void generateSkills(){
		//TODO(mbregg) abilities should level up in strength with you

		
		
		//Bane skills
		this.getAbilities().add(new Firebolt(this.getSkillManager()));
		this.getAbilities().add(new LightBeam(this.getSkillManager()));
		this.getAbilities().add(new ShadowBlast(this.getSkillManager()));
		//Boon skills
		this.getAbilities().add(new HealBoon(this.getSkillManager()));
		this.getAbilities().add(new MovementBoon(this.getSkillManager()));
		this.getAbilities().add(new StrengthBoon(this.getSkillManager()));
		this.getAbilities().add(new FlightBoon(this.getSkillManager()));
		//Enchantment Skills
		this.getAbilities().add(new Cripple(this.getSkillManager()));
		this.getAbilities().add(new Intimidate(this.getSkillManager()));
		this.getAbilities().add(new Silence(this.getSkillManager()));
		
		
		//Get the base skills.
		super.generateSkills();

		//Print out the abilities we have. 
		for(Ability a : this.getAbilities()){
		}
		
		//To avoid breaking shit
		this.addRandomItems();
	}



	@Override
	protected ItemManager createItemManager() {
		return new ItemManager(this);
	}


	@Override
	public StructuredMap getStructuredMap() {
		return super.getStructuredMap();
	}

	@Override
	public void load(StructuredMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();

	}




	@Override
	public String getType() {
		return "summoner";
	}

	@Override
	public SummonerSkillManager getSkillManager() {
		return skillManager;
	}



}
