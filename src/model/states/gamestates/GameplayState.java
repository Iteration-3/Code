package model.states.gamestates;

import gameactions.GameActionStatePush;

import java.awt.Color;
import java.util.Collection;

import model.ItemEntityAssociation;
import model.KeyPreferences;
import model.area.Area;
import model.area.RadialArea;
import model.area.RealCoordinate;
import model.area.TileCoordinate;
import model.entity.Avatar;
import model.entity.EntityManager;
import model.entity.EntityMovementAssocation;
import model.entity.Smasher;
import model.event.HealthModifierEvent;
import model.event.ManaModifierEvent;
import model.item.ObstacleItem;
import model.item.OneShotItem;
import model.item.TakeableItem;
import model.map.GameTerrain;
import model.map.tile.ImpassableTile;
import model.map.tile.PassableTile;
import model.statistics.EntityStatistics;
import model.trigger.PermanentTrigger;
import model.trigger.SingleUseTrigger;
import model.trigger.TimedTrigger;
import model.trigger.Trigger;
import model.trigger.TriggerManager;
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
    private ItemEntityAssociation itemEntityAssociation;
    private Avatar avatar;

    public GameplayState() {
        layout = new GameplayLayout();
        controller = new GameplayController();
        gameMap = new GameTerrain();
    }

    @Override
    public void onEnter() {
        super.onEnter();
        addTilesTest();
        addEntityTest();
        addItemsTest();
        addTriggersTest();
    }

    @Override
    public void onResume() {
        super.onResume();
        setListeners(getContext().getPreferences());
    }

    @Override
    public void onPause() {
        controller.removeListeners();
        layout.clearBindings();
    }

    public void addEntityTest() {
        TileCoordinate loc = new TileCoordinate(3, 3);
        EntityView eView = new EntityView(new Color(200, 200, 0), Color.orange,
                TileCoordinate.convertToRealCoordinate(loc));
        avatar = new Smasher("Smasher", eView, loc);

        KeyPreferences preferences = new KeyPreferences();
        getContext().setPreferences(preferences);

        this.itemEntityAssociation = new ItemEntityAssociation(avatar);

        setListeners(preferences);

        EntityManager.getSingleton().setAvatar(avatar);
        eView.registerWithGameMapView(layout.getGameEntityView(), TileCoordinate.convertToRealCoordinate(loc));

        this.itemEntityAssociation = new ItemEntityAssociation(avatar);
        
    }

    private void setListeners(KeyPreferences preferences) {
        controller.removeListeners();
        getLayout().clearBindings();
        avatar.getListeners();

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
                itemEntityAssociation.getItemMap()).getListeners(preferences);

        for (Listener listener : listeners) {
            listener.addAsBinding(getLayout());
            controller.addEntityListener(listener);
        }
	}
	
	private void addItemsTest() {
        ItemView takeableItemView = new BasicItemView(new Color(100, 60, 100), Color.GREEN);
        RealCoordinate takeableItemViewPosition = new RealCoordinate(5, 5);
        takeableItemView.registerWithGameItemView(layout.getGameItemView(), takeableItemViewPosition);
        itemEntityAssociation.addItem(new TakeableItem(takeableItemView),
                RealCoordinate.convertToTileCoordinate(takeableItemViewPosition));

        ItemView obstacleItemView = new BasicItemView(Color.GRAY, Color.BLACK);
        RealCoordinate obstacleItemPosition = new RealCoordinate(9, 7);
        obstacleItemView.registerWithGameItemView(layout.getGameItemView(), obstacleItemPosition);
        itemEntityAssociation.addItem(new ObstacleItem(obstacleItemView),
                RealCoordinate.convertToTileCoordinate(obstacleItemPosition));

        ItemView oneshotItemView = new BasicItemView(Color.GRAY, Color.BLACK);
        RealCoordinate oneshotItemPosition = new RealCoordinate(13, 9);
        oneshotItemView.registerWithGameItemView(layout.getGameItemView(), oneshotItemPosition);
        itemEntityAssociation.addItem(new OneShotItem(oneshotItemView, new EntityStatistics()),
                RealCoordinate.convertToTileCoordinate(oneshotItemPosition));
		
	}
	
	private void addTriggersTest() {
		TriggerManager triggerManager = TriggerManager.getSingleton();

		// This may need a ViewableTriggerDecorator to display the Decal for the AreaEffect
		TileCoordinate locOne = new TileCoordinate(2, 6);
		Area areaOne = new RadialArea(20, locOne);
		Trigger triggerOne = new SingleUseTrigger(areaOne, new HealthModifierEvent(2, -1));
		
		TileCoordinate locTwo = new TileCoordinate(2, 7);
		Area areaTwo = new RadialArea(1, locTwo);
		Trigger triggerTwo = new PermanentTrigger(areaTwo, new ManaModifierEvent(10, 200));
		
		triggerManager.addNonPartyTrigger(triggerOne);
		triggerManager.addNonPartyTrigger(triggerTwo);
	
    }

    public void addTilesTest() {
        for (int x = 0; x < 100; ++x) {
            for (int y = 0; y < 100; ++y) {// Hardcoded for as long as the area
                // is
                TileCoordinate p = new TileCoordinate(x, y);
                if (x != 10 || y != 10) {
                    TileView view = new BasicTileView(new Color(0, 200, 200), Color.WHITE);
                    view.registerWithGameMapView(layout.getGameTerrainView(), TileCoordinate.convertToRealCoordinate(p));
                    gameMap.add(new PassableTile(view), p);
                } else {
                    TileView view = new BasicTileView(new Color(200, 0, 200), Color.WHITE);
                    view.registerWithGameMapView(layout.getGameTerrainView(), TileCoordinate.convertToRealCoordinate(p));
                    gameMap.add(new ImpassableTile(view), p);
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

    @Override
    public void update() {
        // TODO poll here.
    }

}
