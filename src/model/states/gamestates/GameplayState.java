package model.states.gamestates;

import gameactions.GameActionRiverPush;
import gameactions.GameActionStatePush;
import gameactions.GameActionTeleport;

import java.awt.Color;
import java.util.Collection;

import model.KeyPreferences;
import model.area.Area;
import model.area.LinearArea;
import model.area.RadialArea;
import model.area.RealCoordinate;
import model.area.TileCoordinate;
import model.entity.Avatar;
import model.entity.EntityManager;
import model.entity.EntityMovementAssocation;
import model.entity.NPC;
import model.entity.Summoner;
import model.event.HealthModifierEvent;
import model.event.ManaModifierEvent;
import model.event.RiverPushEvent;
import model.event.TeleportEvent;
import model.item.Boots;
import model.item.Door;
import model.item.Gloves;
import model.item.Helmet;
import model.item.ObstacleItem;
import model.item.OneShotItem;
import model.item.TakeableItem;
import model.light.LightManager;
import model.map.GameTerrain;
import model.map.ItemMap;
import model.map.tile.AirPassableTile;
import model.map.tile.ImpassableTile;
import model.map.tile.PassableTile;
import model.statistics.EntityStatistics;
import model.statistics.Statistics;
import model.trigger.PermanentTrigger;
import model.trigger.RateLimitedTrigger;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import model.trigger.TriggerManager;
import utilities.Angle;
import view.EntityView;
import view.item.BasicItemView;
import view.item.ItemView;
import view.layout.GameplayLayout;
import view.map.BasicTileView;
import view.map.TileView;
import controller.GameplayController;
import controller.listener.Listener;
import controller.listener.SingleUseListener;

public class GameplayState extends GameState {
    private GameplayController controller;
    private GameplayLayout layout;
    private GameTerrain gameMap;
    private ItemMap itemMap;
    private Avatar avatar;

    public GameplayState() {
        layout = new GameplayLayout();
        gameMap = new GameTerrain();
        itemMap = new ItemMap();
    }

    @Override
    public void onEnter() {
        // Entity test must run before item test, which must be run before
        // setListeners.
        // The reason for this is the avatar must be made prior to items, to
        // make the itemEntityAssocation,
        // Which is needed for other stuff.
        super.onEnter();
        System.out.println(getContext());
        controller = new GameplayController(getContext());
        addTilesTest();
        addEntityTest();
        addItemsTest();
        addTriggersTest();
        controller.spawnUpdateThread();
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
        LightManager.getLightManager().clear();
        super.onExit();
    }

    public void addEntityTest() {
        TileCoordinate loc = new TileCoordinate(3, 3);
        EntityView eView = new EntityView(new Color(200, 200, 0), Color.orange,
                new RealCoordinate(3, 3));
        avatar = new Summoner("Summoner", eView, loc);

        KeyPreferences preferences = new KeyPreferences();
        getContext().setPreferences(preferences);

        setListeners(preferences);

        EntityManager.getSingleton().setAvatar(avatar);
        eView.registerWithGameMapView(layout.getGameEntityView(), new RealCoordinate(3, 3));
        
        TileCoordinate npcLocation = new TileCoordinate(7, 7);
        EntityView npcView = new EntityView(new Color(200, 200, 0), Color.orange,
        		new RealCoordinate(7, 7));
        npcView = new EntityView(new Color(0, 0, 255), Color.ORANGE,
        		new RealCoordinate(7, 7));
        NPC npc = new NPC("DaveTheBargainer", npcView, npcLocation);
        npcView.registerWithGameMapView(layout.getGameEntityView(), new RealCoordinate(7, 7));
        EntityManager.getSingleton().addPartyNpc(npc);
    }

    private void setListeners(KeyPreferences preferences) {
        controller.removeListeners();
        getLayout().clearBindings();

        //testing this for equipped Items
        avatar.equip(new Helmet(new BasicItemView(),new Statistics()));

        Listener escapeListener = new SingleUseListener(preferences.getPauseKey(), new GameActionStatePush(
                getContext(), new PauseMenuState()));
        escapeListener.addAsBinding(getLayout());
        Listener inventoryListener = new SingleUseListener(preferences.getInventoryKey(), new GameActionStatePush(
                getContext(), new InventoryMenuState(avatar)));
        inventoryListener.addAsBinding(getLayout());

        Listener skillsListener = new SingleUseListener(preferences.getSkillsKey(), new GameActionStatePush(
                getContext(), new SkillsMenuState()));
        skillsListener.addAsBinding(getLayout());

        Collection<Listener> listeners = new EntityMovementAssocation(avatar, gameMap,
                this.getItemMap()).getListeners(preferences);

        for (Listener listener : listeners) {
            listener.addAsBinding(getLayout());
            controller.addEntityListener(listener);
        }
    }

    private ItemMap getItemMap() {
		return itemMap;
	}

	private void addItemsTest() {
        ItemView takeableItemView = new BasicItemView(new Color(100, 60, 100), Color.GREEN);
        TileCoordinate takeableItemViewPosition = new TileCoordinate(5, 5);
        takeableItemView.registerWithGameItemView(layout.getGameItemView(), new RealCoordinate(5, 5));
        this.getItemMap().addItem(new Boots(takeableItemView),
                takeableItemViewPosition);

        ItemView takeableItemViewTwo = new BasicItemView(new Color(100, 60, 100), Color.DARK_GRAY);
        TileCoordinate takeableItemViewPositionTwo = new TileCoordinate(5, 6);
        takeableItemViewTwo.registerWithGameItemView(layout.getGameItemView(), new RealCoordinate(5, 6));
        TakeableItem takeableItemTwo = new Gloves(takeableItemViewTwo);
        this.getItemMap().addItem(takeableItemTwo, takeableItemViewPositionTwo);

        ItemView doorItemView = new BasicItemView(Color.RED, Color.MAGENTA);
        TileCoordinate doorItemViewPosition = new TileCoordinate(15, 14);
        doorItemView.registerWithGameItemView(layout.getGameItemView(), new RealCoordinate(15, 14));
        Door doorItem = new Door(doorItemView, takeableItemTwo);
        this.getItemMap().addItem(doorItem, doorItemViewPosition);

        ItemView obstacleItemView = new BasicItemView(Color.GRAY, Color.BLACK);
        TileCoordinate obstacleItemPosition = new TileCoordinate(9, 7);
        obstacleItemView.registerWithGameItemView(layout.getGameItemView(), new RealCoordinate(9, 7));
        this.getItemMap().addItem(new ObstacleItem(obstacleItemView), obstacleItemPosition);

        ItemView oneshotItemView = new BasicItemView(Color.WHITE, Color.GREEN);
        TileCoordinate oneshotItemPosition = new TileCoordinate(13, 9);
        oneshotItemView.registerWithGameItemView(layout.getGameItemView(), new RealCoordinate(13, 9));
        this.getItemMap().addItem(new OneShotItem(oneshotItemView, new EntityStatistics()), oneshotItemPosition);
        
        ItemView riverMarker = new BasicItemView(Color.GRAY, Color.BLACK);
        TileCoordinate riverMarkerSpot = new TileCoordinate(13, 0);
        riverMarker.registerWithGameItemView(layout.getGameItemView(), new RealCoordinate(13, 0));
        this.getItemMap().addItem(new ObstacleItem(riverMarker), riverMarkerSpot);

    }

    private void addTriggersTest() {
        TriggerManager triggerManager = TriggerManager.getSingleton();

        // This may need a ViewableTriggerDecorator to display the Decal for the
        // AreaEffect
        TileCoordinate locOne = new TileCoordinate(2, 6);
        Area areaOne = new RadialArea(20, locOne);
        Trigger triggerOne = new SingleUseTrigger(areaOne, new HealthModifierEvent(2, -1));

        TileCoordinate locTwo = new TileCoordinate(2, 7);
        Area areaTwo = new RadialArea(1, locTwo);
        Trigger triggerTwo = new PermanentTrigger(areaTwo, new ManaModifierEvent(10, 200));

        TileCoordinate locThree = new TileCoordinate(2, 8);
        Area areaThree = new RadialArea(0, locThree);
        Trigger triggerThree = new PermanentTrigger(areaThree, new TeleportEvent(new TileCoordinate(2, 0),
                new GameActionTeleport(avatar, gameMap, this.getItemMap(), Angle.DOWN)));
        
        TileCoordinate locFour = new TileCoordinate(13, 0);
        Area areaFour = new LinearArea(20, locFour, Angle.DOWN);
        Trigger triggerFour = new RateLimitedTrigger(areaFour, new RiverPushEvent(
                new GameActionRiverPush(avatar, gameMap, this.getItemMap(), Angle.DOWN)),1000);

        triggerManager.addNonPartyTrigger(triggerOne);
        triggerManager.addNonPartyTrigger(triggerTwo);
        triggerManager.addNonPartyTrigger(triggerThree);
        triggerManager.addNonPartyTrigger(triggerFour);

    }

    public void addTilesTest() {
        for (int x = 0; x < 100; ++x) {
            for (int y = 0; y < 100; ++y) {// Hardcoded for as long as the area
                // is
                TileCoordinate p = new TileCoordinate(x, y);
                if ((x != 10 || y != 10) && (x!=13 || y!=13)) {
                    TileView view = new BasicTileView(new Color(0, 200, 200), Color.WHITE);
                    view.registerWithGameMapView(layout.getGameTerrainView(), new RealCoordinate(x, y));
                    gameMap.add(new PassableTile(view), p);
                } else if(x!=13 || y!=13){
                    TileView view = new BasicTileView(new Color(200, 0, 200), Color.WHITE);
                    view.registerWithGameMapView(layout.getGameTerrainView(), new RealCoordinate(x, y));
                    gameMap.add(new ImpassableTile(view), p);
                }
                else{
                	TileView view = new BasicTileView(new Color(100, 0, 200), Color.BLACK);
                    view.registerWithGameMapView(layout.getGameTerrainView(), new RealCoordinate(x, y));
                    gameMap.add(new AirPassableTile(view), p);
                }

            }
        }
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
