package model.states.gamestates;

import model.entity.EntityManager;
import model.map.ItemMap;
import model.trigger.TriggerManager;
import utilities.structuredmap.JsonWriter;
import utilities.structuredmap.StructuredMap;
import view.layout.SaveMenuLayout;
import controller.SaveMenuController;

public class SaveMenuState extends GameState {
	private SaveMenuLayout layout;
	private SaveMenuController controller;
	
    public SaveMenuState() { 
    	layout = new SaveMenuLayout();
    }

    @Override
    public void onEnter() {
    	super.onEnter();
    	this.save();
    	controller = new SaveMenuController(getContext());
    	layout.attachController(controller);
    }
    
    private void save() {
    	StructuredMap map = new StructuredMap();
    	map.put("keys", getContext().getPreferences().getStructuredMap());
    	map.put("entities", EntityManager.getSingleton().getStructuredMap());
    	map.put("triggers", TriggerManager.getSingleton().getStructuredMap());
    	map.put("items", ItemMap.getInstance().getStructuredMap());
    	JsonWriter writer = new JsonWriter();
    	writer.writeStructuredMap(map, "danielIsANoob.txt");
    	
    }

    @Override
    protected SaveMenuLayout getLayout() {
        return layout;
    }

    @Override
    protected SaveMenuController getController() {
    	return controller;
    }
}
