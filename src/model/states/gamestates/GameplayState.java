package model.states.gamestates;

import gameactions.GameActionGhostMovement;
import gameactions.GameActionRiverPush;
import gameactions.GameActionStatePush;
import gameactions.GameActionTeleport;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import model.KeyPreferences;
import model.area.Area;
import model.area.LinearArea;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.entity.Avatar;
import model.entity.Entity;
import model.entity.EntityManager;
import model.entity.EntityMovementAssocation;
import model.event.EventManager;
import model.event.ExperienceModifierEvent;
import model.event.ManaModifierEvent;
import model.event.RiverPushEvent;
import model.event.TeleportEvent;
import model.item.Item;
import model.light.LightManager;
import model.map.GameMap;
import model.map.ItemMap;
import model.map.MapLoader;
import model.projectile.Projectile;
import model.projectile.ProjectileManager;
import model.trigger.PermanentTrigger;
import model.trigger.RateLimitedTrigger;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import model.trigger.TriggerManager;
import utilities.Direction;
import utilities.structuredmap.JsonReader;
import utilities.structuredmap.StructuredMap;
import view.Decal;
import view.entity.EntityView;
import view.layout.GameplayLayout;
import view.trigger.ViewableTrigger;
import controller.GameplayController;
import controller.listener.Listener;
import controller.listener.PollingListener;
import controller.listener.SingleUseListener;

public class GameplayState extends GameState {
    private GameplayController controller;
    private GameplayLayout layout;
    private GameMap gameMap;
    private ItemMap itemMap;
    private Avatar avatar;
    private String filePath;

    public GameplayState(String filePath, Avatar avatar) {
        layout = new GameplayLayout();
        gameMap = new GameMap();
        itemMap = ItemMap.getInstance();
        this.filePath = filePath;
        this.avatar = avatar;
    }

    public void update(double deltaTime) {
		TriggerManager.getSingleton().update(deltaTime);
		EventManager.getSingleton().update(deltaTime);
		// Alternative to passing an itemMap is to use traps as triggers
		EntityManager.getSingleton().update(itemMap, deltaTime);
		ProjectileManager.getSingleton().update(deltaTime);
		/* Run through projectile queue */
		while (!ProjectileManager.getSingleton().isQueueEmpty()) {
			Projectile poll = ProjectileManager.getSingleton()
					.dequeueProjectile();
			poll.projView.registerWithGameProjectileView(layout
					.getGameProjectileView());
		}
		//Check if the avatar is dead, if so, push mainmenu state.
		if(EntityManager.getSingleton().getAvatar().outOfLives()){
			//Maybe wrap this in an object, and hand it to the avatar to call when it dies?
			//Upon it being made?
			this.getContext().popState();

		}
	}
    
    @Override
    public void onEnter() {
        // Entity test must run before item test, which must be run before
        // setListeners.
        // The reason for this is the avatar must be made prior to items, to
        // make the itemEntityAssocation,
        // Which is needed for other stuff.
        super.onEnter();
        controller = new GameplayController(this);
       StructuredMap map = JsonReader.readJson(filePath);
        
        this.gameMap = MapLoader.loadMap("maps/main_map.json", layout); //CALL THIS FIRST
        addEntityTest(map.getStructuredMap("entites"), map.getStructuredMap("keyPreferences"));
        addItemsTest(map.getStructuredMap("items"));
        addTriggersTest(map.getStructuredMap("triggers"));
        
       //StructuredMap map = new StructuredMap();
       //map.put("entites", EntityManager.getSingleton().getStructuredMap());
       //map.put("items", itemMap.getStructuredMap());
      // KeyPreferences pref = new KeyPreferences();
       //map.put("keyPreferences",  pref.getStructuredMap());
        

       // JsonWriter writer = new JsonWriter();
        //writer.writeStructuredMap(map, "filePath");
        

        controller.spawnUpdateThread();
        avatar.subscribe(layout.getCamera());
        LightManager.getSingleton().getLightMap().registerAll(layout.getGameLightView());
    }

    @Override
    public void onResume() {
        super.onResume();
        setListeners(getContext().getPreferences());
    }

    @Override
    public void onPause() {
    	super.onPause();
        controller.removeListeners();
        layout.clearBindings();
    }
    
    @Override
    public void onExit() {
        controller.terminateUpdateThread();
        EntityManager.getSingleton().clear();
        TriggerManager.getSingleton().clear();
        LightManager.getSingleton().clear();
        super.onExit();
    }

    public void addEntityTest(StructuredMap entityMap, StructuredMap preferencesMap) {
    	/*
    	
        TileCoordinate loc = new TileCoordinate(3, 3);
        EntityView eView = avatar.getEntityView();
        avatar.setLocation(loc);
        
        EntityManager.getSingleton().setAvatar(avatar);
        getController().registerAvatar(avatar);
        eView.registerWithGameMapView(layout.getGameEntityView(), TileCoordinate.convertToRealCoordinate(loc),Direction.UP);
        
        TileCoordinate npcLocation = new TileCoordinate(7, 7);
        EntityView npcView = new EntityView(EntitySpriteFactory.getLadySpriteHolder());

        NPC npc = EntityFactory.createBarter("DaveTheBarbarian", npcView, npcLocation);
        npcView.registerWithGameMapView(layout.getGameEntityView(), TileCoordinate.convertToRealCoordinate(npcLocation),Direction.UP);
        EntityManager.getSingleton().addPartyNpc(npc);
        
        TileCoordinate mountLocation = new TileCoordinate(7, 2);
        EntityView mountView = new EntityView(EntitySpriteFactory.getUnderlingSpriteHolder());
        Mount mount = new Mount("My first mount", mountView, mountLocation);
        mountView.registerWithGameMapView(layout.getGameEntityView(), TileCoordinate.convertToRealCoordinate(mountLocation), Direction.UP);
        EntityManager.getSingleton().addNonPartyNpc(mount);
        */
    	
    	EntityManager.getSingleton().loadEntities(entityMap);
    	Iterator<Entity> iterator = EntityManager.getSingleton().iterator();
    	while(iterator.hasNext()) {
    		Entity entity = iterator.next();
    		EntityView view = entity.getEntityView();
    		view.registerWithGameMapView(layout.getGameEntityView(), TileCoordinate.convertToRealCoordinate(entity.getLocation()), entity.getDirection());
    	}
    	
    	avatar = EntityManager.getSingleton().getAvatar();
    	getController().registerAvatar(avatar);
    	
    	KeyPreferences preferences = new KeyPreferences(preferencesMap);
        getContext().setPreferences(preferences);
        setListeners(preferences);
        getContext().setPreferences(preferences);
        

    }

    private void setListeners(KeyPreferences preferences) {
        controller.removeListeners();
        getLayout().clearBindings();
        
        Listener escapeListener = new SingleUseListener(preferences.getPauseKey(), new GameActionStatePush(
                getContext(), new PauseMenuState()));
        escapeListener.addAsBinding(getLayout());
        Listener inventoryListener = new SingleUseListener(preferences.getInventoryKey(), new GameActionStatePush(
                getContext(), new InventoryMenuState(avatar)));
        inventoryListener.addAsBinding(getLayout());

        Listener skillsListener = new SingleUseListener(preferences.getSkillsKey(), new GameActionStatePush(
                getContext(), new SkillsMenuState()));
        skillsListener.addAsBinding(getLayout());

        Collection<Listener> listeners = new EntityMovementAssocation(getContext().getCurrentUnit(), gameMap,
                this.getItemMap()).getListeners(getContext());
        

		listeners.add(new PollingListener(preferences.getModUpLeftKey(), new GameActionGhostMovement(layout.getCamera(),gameMap, Direction.UP_LEFT)));
		listeners.add(new PollingListener(preferences.getModDownKey(), new GameActionGhostMovement(layout.getCamera(),gameMap, Direction.DOWN)));
		listeners.add(new PollingListener(preferences.getModDownRightKey(), new GameActionGhostMovement(layout.getCamera(),gameMap,Direction.DOWN_RIGHT)));
		listeners.add(new PollingListener(preferences.getModDownLeftKey(), new GameActionGhostMovement(layout.getCamera(),gameMap,  Direction.DOWN_LEFT)));
		listeners.add(new PollingListener(preferences.getModUpRightKey(), new GameActionGhostMovement(layout.getCamera(),gameMap,  Direction.UP_RIGHT)));
		listeners.add(new PollingListener(preferences.getModUpKey(), new GameActionGhostMovement(layout.getCamera(),gameMap,  Direction.UP)));
        
		for (Listener listener : listeners) {
            listener.addAsBinding(getLayout());
            controller.addEntityListener(listener);
        }
    }

    private ItemMap getItemMap() {
		return itemMap;
	}

	private void addItemsTest(StructuredMap map) {
		/*
        TileCoordinate takeableItemViewPosition = new TileCoordinate(5, 5);
        ItemView takeableItemView = new BasicItemView(TileCoordinate.convertToRealCoordinate(takeableItemViewPosition), new Decal("/images/items/two_handed_chainsaw.png", TileCoordinate.convertToRealCoordinate(takeableItemViewPosition)));
        takeableItemView.registerWithGameItemView(layout.getGameItemView());
        this.getItemMap().addItem(new TwoHandedWeapon(takeableItemView),
                takeableItemViewPosition);

        TileCoordinate takeableItemViewPositionTwo = new TileCoordinate(5, 6);
        ItemView takeableItemViewTwo = new BasicItemView(TileCoordinate.convertToRealCoordinate(takeableItemViewPositionTwo), new Decal("/images/items/key.png", TileCoordinate.convertToRealCoordinate(takeableItemViewPositionTwo)));
        takeableItemViewTwo.registerWithGameItemView(layout.getGameItemView());
        TakeableItem takeableItemTwo = new TakeableItem(takeableItemViewTwo);
        this.getItemMap().addItem(takeableItemTwo, takeableItemViewPositionTwo);

        TileCoordinate doorItemViewPosition = new TileCoordinate(15, 14);
        ItemView doorItemView = new BasicItemView(TileCoordinate.convertToRealCoordinate(doorItemViewPosition), new Decal("/images/slotImage.png", TileCoordinate.convertToRealCoordinate(doorItemViewPosition)));
        doorItemView.registerWithGameItemView(layout.getGameItemView());
        Door doorItem = new Door(doorItemView, takeableItemTwo);
        this.getItemMap().addItem(doorItem, doorItemViewPosition);

        TileCoordinate obstacleItemPosition = new TileCoordinate(9, 7);
        ItemView obstacleItemView = new BasicItemView(TileCoordinate.convertToRealCoordinate(obstacleItemPosition), new Decal("/images/slotImage.png", TileCoordinate.convertToRealCoordinate(obstacleItemPosition)));
        obstacleItemView.registerWithGameItemView(layout.getGameItemView());
        this.getItemMap().addItem(new ObstacleItem(obstacleItemView), obstacleItemPosition);

        TileCoordinate oneshotItemPosition = new TileCoordinate(13, 9);
        ItemView oneshotItemView = new BasicItemView(TileCoordinate.convertToRealCoordinate(oneshotItemPosition), new Decal("/images/items/book.png", TileCoordinate.convertToRealCoordinate(oneshotItemPosition)));
        oneshotItemView.registerWithGameItemView(layout.getGameItemView());
        this.getItemMap().addItem(new OneShotItem(oneshotItemView, new EntityStatistics()), oneshotItemPosition);
        
        TileCoordinate riverMarkerSpot = new TileCoordinate(13, 0);
        ItemView riverMarker = new BasicItemView(TileCoordinate.convertToRealCoordinate(riverMarkerSpot), new Decal("/images/slotImage.png", TileCoordinate.convertToRealCoordinate(riverMarkerSpot)));
        riverMarker.registerWithGameItemView(layout.getGameItemView());
        this.getItemMap().addItem(new ObstacleItem(riverMarker), riverMarkerSpot);
        
        TileCoordinate trapSpot = new TileCoordinate(15, 12);
        ItemView trapView = new BasicItemView(TileCoordinate.convertToRealCoordinate(trapSpot), new Decal("/images/items/trap.png", TileCoordinate.convertToRealCoordinate(trapSpot)));
        trapView.registerWithGameItemView(layout.getGameItemView());
        this.getItemMap().addItem(new Trap(trapView), trapSpot);
        
        TileCoordinate healthpackspot = new TileCoordinate(16,16);
        ItemView hView = new BasicItemView(TileCoordinate.convertToRealCoordinate(healthpackspot),
				new Decal("/images/items/healthpack.png", TileCoordinate.convertToRealCoordinate(healthpackspot)));
        hView.registerWithGameItemView(layout.getGameItemView());
        this.getItemMap().addItem(new HPPotion(hView, new Price(10), 1000),healthpackspot);
        */
      
		itemMap.loadItems(map);
		
		List<Item> items = itemMap.getItems();
		for(Item item : items) {
			if(item != null) {
				if(item.getView() != null ) {
					item.getView().registerWithGameItemView(layout.getGameItemView());
				}
			}
		}

    }

    private void addTriggersTest(StructuredMap map) {
    	
        TriggerManager triggerManager = TriggerManager.getSingleton();

        TileCoordinate locOne = new TileCoordinate(5, 5);
        Area areaOne = new RadialArea(1, locOne);
        ViewableTrigger triggerOne = new ViewableTrigger(new PermanentTrigger(areaOne, new ManaModifierEvent(2, -1)), 
        		new Decal("/images/items/skull_and_crossbones.png", TileCoordinate.convertToRealCoordinate(locOne)));
        triggerManager.registerViewableTrigger(triggerOne);

        TileCoordinate locTwo = new TileCoordinate(2, 7);
        Area areaTwo = new RadialArea(1, locTwo);
        Trigger triggerTwo = new SingleUseTrigger(areaTwo, new ExperienceModifierEvent(0, 750));

        TileCoordinate locThree = new TileCoordinate(2, 8);
        Area areaThree = new RadialArea(0, locThree);
        Trigger triggerThree = new PermanentTrigger(areaThree, new TeleportEvent(new TileCoordinate(2, 0),
                new GameActionTeleport(avatar, gameMap, this.getItemMap(), Direction.DOWN)));
        
        TileCoordinate locFour = new TileCoordinate(13, 0);
        Area areaFour = new LinearArea(20, locFour, Direction.DOWN);
        Trigger triggerFour = new RateLimitedTrigger(areaFour, new RiverPushEvent(
                new GameActionRiverPush(avatar, gameMap, this.getItemMap(), Direction.DOWN)),1000);

        triggerManager.addNonPartyTrigger(triggerOne);
        triggerManager.addNonPartyTrigger(triggerTwo);
        triggerManager.addNonPartyTrigger(triggerThree);
        triggerManager.addNonPartyTrigger(triggerFour);
        
    	//TriggerManager.getSingleton().loadTriggers(map);

    }

    @Override
    public GameplayLayout getLayout() {
        return layout;
    }

    @Override
    public GameplayController getController() {
        return controller;
    }

}
