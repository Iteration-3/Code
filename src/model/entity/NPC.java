package model.entity;


import model.area.TileCoordinate;
import model.entity.behavior.npc.BarterBehavior;
import model.entity.behavior.npc.Behaviorable;
import model.entity.behavior.npc.PetBehavior;
import model.entity.behavior.npc.Pursue;
import model.entity.dialog.DialogTree;
import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public class NPC extends Entity {
	
	
	public NPC(String name, EntityView view, TileCoordinate location) {
		super(name, view, location);
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
	public void attack() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void load(StructuredMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}
	@Override
	public String getType() {
		return "npc";
	}

	@Override
	public void accept(EntiyVisitorable visitor) {
		visitor.accept(this);
	}

	@Override
	protected Behaviorable getBehavior() {
		return new BarterBehavior();
	}

}
