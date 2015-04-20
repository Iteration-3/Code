package model.entity;


import model.area.TileCoordinate;
import model.entity.behavior.npc.Behaviorable;
import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;
import view.entity.EntityView;

public class NPC extends Entity {
	private Behaviorable behavior;
	private String type;
	
	public NPC() {
		super();
	}
	
	public NPC(String name, String type, EntityView view, TileCoordinate location, Behaviorable behavior) {
		super(name, view, location,behavior);
		this.behavior = behavior;
		this.type = type;
	}
	/*
	public NPC(StructuredMap map) {
		super(map);
	}
	*/
	public NPC(StructuredMap map, Behaviorable behavior) {
		super(map, behavior);
		this.behavior = behavior;
		this.type = map.getString("type");
	}
	
	
	@Override 
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		//DEPRECATED TO THE BEHAVIOR
//		map.put("dialogueTree", dialogTree.getStructuredMap());
		return map;
	}
	
		//DEPRECATED TO THE BEHAVIOR
//		setDialogTree(dialogTree);
	
	@Override
	protected ItemManager createItemManager() {
		return new ItemManager(this);
	}

	
	@Override
	public void load(StructuredMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateExtras(double deltaTime) {
		observeHelper();
		if(this.outOfLives()){
			this.removeFromTheWorld();
		}
	}
	
	private void removeFromTheWorld(){
		EntityManager.getSingleton().removeEntity(this);
		this.getEntityView().removeFromTheWorld();
	}
	
	private void observeHelper(){
		Avatar avatar = EntityManager.getSingleton().getAvatar();
		if (this.getLocation().getDistance(avatar.getLocation()) < avatar.getObserveSkill()*4
				&& this.isInCombat()){
			//The distance between the two objects vs the observe skill times 4 is the range.
			this.getEntityView().updateHP(getHpPercentage());
			this.getEntityView().updateMana(getManaPercentage());
			this.getEntityView().turnOnHealthBar();
			this.getEntityView().turnOnManaBar();
		} else {
			this.getEntityView().turnOffHealthBar();
			this.getEntityView().turnOffManaBar();
		}
	}
	


	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public void accept(EntiyVisitorable visitor) {
		visitor.accept(this);
	}

	@Override
	protected Behaviorable getBehavior() {
		this.behavior.setEntity(this);
		return this.behavior;
	}

}
