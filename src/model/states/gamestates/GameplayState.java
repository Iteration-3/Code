package model.states.gamestates;

import gameactions.GameActionStatePush;

import java.awt.Color;
import java.util.Collection;

import model.ItemEntityAssociation;
import model.KeyPreferences;
import model.area.RealCoordinate;
import model.area.TileCoordinate;
import model.entity.Avatar;
import model.entity.EntityManager;
import model.entity.EntityMovementAssocation;
import model.entity.Smasher;
import model.item.ObstacleItem;
import model.item.OneShotItem;
import model.item.TakeableItem;
import model.map.GameTerrain;
import model.map.ItemMap;
import model.map.tile.ImpassableTile;
import model.map.tile.PassableTile;
import model.statistics.EntityStatistics;
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
    }

    public void addEntityTest() {
        TileCoordinate loc = new TileCoordinate(3, 3);
        EntityView eView = new EntityView(new Color(200, 200, 0), Color.orange,
                TileCoordinate.convertToRealCoordinate(loc));
        Avatar avatar = new Smasher("Smasher", eView, loc);

        KeyPreferences preferences = new KeyPreferences();
        getContext().setPreferences(preferences);

        Listener escapeListener = new SingleUseListener(preferences.getPauseKey(), new GameActionStatePush(
                getContext(), new PauseMenuState()));
        escapeListener.addAsBinding(getLayout());

        Listener inventoryListener = new SingleUseListener(preferences.getInventoryKey(), new GameActionStatePush(
                getContext(), new InventoryMenuState(avatar)));
        inventoryListener.addAsBinding(getLayout());

        Listener skillsListener = new SingleUseListener(preferences.getSkillsKey(), new GameActionStatePush(
                getContext(), new SkillsMenuState()));
        skillsListener.addAsBinding(getLayout());

        this.itemEntityAssociation = new ItemEntityAssociation(avatar);

        Collection<Listener> listeners = new EntityMovementAssocation(avatar, gameMap,
                itemEntityAssociation.getItemMap()).getListeners(preferences);

        for (Listener listener : listeners) {
            listener.addAsBinding(getLayout());
            controller.addEntityListener(listener);
        }

        EntityManager.getSingleton().setAvatar(avatar);
        eView.registerWithGameMapView(layout.getGameEntityView(), TileCoordinate.convertToRealCoordinate(loc));

        this.itemEntityAssociation = new ItemEntityAssociation(avatar);
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
