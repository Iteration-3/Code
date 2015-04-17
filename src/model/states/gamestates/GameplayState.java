package model.states.gamestates;

import gameactions.GameActionStateSwitchPause;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Collection;

import javax.swing.KeyStroke;

import model.Model;
import model.area.RealCoordinate;
import model.entity.Avatar;
import model.entity.EntityManager;
import model.entity.Smasher;
import model.item.ConsumableItem;
import model.map.GameTerrain;
import model.map.TakeableItemMap;
import model.map.tile.PassableTile;
import view.EntityView;
import view.GameplayLayout;
import view.item.BasicItemView;
import view.item.ItemView;
import view.map.BasicTileView;
import view.map.TileView;
import controller.GameplayController;
import controller.listener.SingleUseListener;
import controller.listener.Listener;

public class GameplayState extends GameState {
    private GameplayController controller;
    private GameplayLayout layout;
    private GameTerrain gameMap;
    private TakeableItemMap itemMap;

    public GameplayState(Model model) {
        super(model);

        layout = new GameplayLayout();
        controller = new GameplayController();
        gameMap = new GameTerrain();
        itemMap = new TakeableItemMap();
        this.addTilesTest();
        this.addEntityTest();
    }

    public void addEntityTest() {
        RealCoordinate loc = new RealCoordinate(50, 50);
        EntityView eView = new EntityView(new Color(200, 200, 0), Color.orange, loc);
        Avatar avatar = new Smasher("Smasher", eView, loc);
        
        Listener escapeListener = new SingleUseListener(KeyStroke.getKeyStroke("ESCAPE"),
                new GameActionStateSwitchPause(getModel()));
        escapeListener.addAsBinding(getLayout());
        //controller.addEntityListener(escapeListener);
        
        Collection<Listener> listeners = avatar.getListeners();
        for (Listener listener : listeners) {
            listener.addAsBinding(getLayout());
            controller.addEntityListener(listener);
        }

        
        EntityManager.getSingleton().setAvatar(avatar);
        eView.registerWithGameMapView(layout.getGameEntityView(), loc);
    }

    public void addTilesTest() {
        for (int x = 0; x < 100; ++x) {
            for (int y = 0; y < 100; ++y) {// Hardcoded for as long as the area
                                           // is
                TileView view = new BasicTileView(new Color(0, 200, 200), Color.WHITE);
                RealCoordinate p = new RealCoordinate(x, y);
                view.registerWithGameMapView(layout.getGameTerrainView(), p);
                gameMap.add(new PassableTile(view), p);
            }
        }
        ItemView view = new BasicItemView(new Color(100, 60, 100), Color.GREEN);
        RealCoordinate p = new RealCoordinate(5, 5);
        view.registerWithGameItemView(layout.getGameItemView(), p);
        itemMap.add(new ConsumableItem(null), p);
    }

    @Override
    public GameplayController getController() {
        return controller;
    }

    @Override
    public GameplayLayout getLayout() {
        return layout;
    }

}
