package model.states.gamestates;

import gameactions.GameActionStatePush;

import java.awt.Color;
import java.util.Collection;

import javax.swing.KeyStroke;

import model.ItemEntityAssociation;
import model.area.RealCoordinate;
import model.entity.Avatar;
import model.entity.EntityManager;
import model.entity.Smasher;
import model.item.TakeableItem;
import model.map.GameTerrain;
import model.map.tile.PassableTile;
import view.EntityView;
import view.GameplayLayout;
import view.item.BasicItemView;
import view.item.ItemView;
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
        RealCoordinate loc = new RealCoordinate(50, 50);
        EntityView eView = new EntityView(new Color(200, 200, 0), Color.orange, loc);
        Avatar avatar = new Smasher("Smasher", eView, loc);
        
        Listener escapeListener = new SingleUseListener(KeyStroke.getKeyStroke("ESCAPE"),
                new GameActionStatePush(getContext(), new PauseMenuState()));
        escapeListener.addAsBinding(getLayout());
        //controller.addEntityListener(escapeListener);
        
        Collection<Listener> listeners = avatar.getListeners();
        for (Listener listener : listeners) {
            listener.addAsBinding(getLayout());
            controller.addEntityListener(listener);
        }

        
        EntityManager.getSingleton().setAvatar(avatar);
        eView.registerWithGameMapView(layout.getGameEntityView(), loc);
        
        this.itemEntityAssociation = new ItemEntityAssociation(avatar); 

        ItemView view = new BasicItemView(new Color(100, 60, 100), Color.GREEN);
        RealCoordinate p = new RealCoordinate(5, 5);
        view.registerWithGameItemView(layout.getGameItemView(), p);
        itemEntityAssociation.addItem(new TakeableItem(view), p);
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
    }

    @Override
    public GameplayLayout getLayout() {
        return layout;
    }

}
