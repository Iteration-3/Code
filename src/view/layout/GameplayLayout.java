package view.layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import view.map.GameEntityView;
import view.map.GameItemView;
import view.map.GameLightView;
import view.map.GameTerrainView;

@SuppressWarnings("serial")
public class GameplayLayout extends Layout {
    GameTerrainView gameTerrainView;
    GameEntityView gameEntityView;
    GameItemView gameItemView;
    GameLightView gameLightView;

    public GameplayLayout() {
        gameTerrainView = new GameTerrainView();
        gameEntityView = new GameEntityView();
        gameItemView = new GameItemView();
        gameLightView = new GameLightView();
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(1024, 768)); // externalize elsewhere
    }

    public GameTerrainView getGameTerrainView() {
        return gameTerrainView;
    }

    public GameEntityView getGameEntityView() {
        return gameEntityView;
    }

    public GameItemView getGameItemView() {
        return gameItemView;
    }
    
    public GameLightView getGameLightView() {
    	return gameLightView;
    }

    public void clearBindings() {
        getInputMap().clear();
        getActionMap().clear();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        gameTerrainView.render(graphics, getWidth(), getHeight());
        gameEntityView.render(graphics, getWidth(), getHeight());
//        gameItemView.render(graphics, getWidth(), getHeight());
//        gameLightView.render(graphics, getWidth(), getHeight());
    }

}
