package model.entity;


import model.area.TileCoordinate;
import model.entity.behavior.npc.Behaviorable;
import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public class NPC extends Entity {
	private Behaviorable behavior;
	private String type;
	
	public NPC() {
		super();
	}
	
	public NPC(String name, String type, EntityView view, TileCoordinate location, Behaviorable behavior) {
		super(name, view, location);
		this.behavior = behavior;
		this.type = type;
	}
	
	public NPC(StructuredMap map) {
		super(map);
		//DEPRECATED TO THE BEHAVIOR
//		this.dialogTree = new DialogTree(map.getStructuredMap("dialogueTree"));
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
	}
	
	private void observeHelper(){
		Avatar avatar = EntityManager.getSingleton().getAvatar();
		if(this.getLocation().getDistance(avatar.getLocation()) < avatar.getObserveSkill()*4 ){
			//The distance between the two objects vs the observe skill times 4 is the range.
			//TODO ADD check if in combat state.
			this.getEntityView().updateHP(getHpPercentage());
			this.getEntityView().updateMana(getManaPercentage());
			this.getEntityView().turnOnHealthBar();
			this.getEntityView().turnOnManaBar();

			
			
		}else{
			this.getEntityView().turnOffHealthBar();
			this.getEntityView().turnOffManaBar();
		}
		
	}
	
	
	@Override
	public String getType() {
		//Kyle you might want 
		return this.type;
//		return "npc";
	}

	@Override
	public void accept(EntiyVisitorable visitor) {
		visitor.accept(this);
	}

	@Override
	protected Behaviorable getBehavior() {
		return this.behavior;
	}

}
