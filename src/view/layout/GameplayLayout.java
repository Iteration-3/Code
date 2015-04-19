package view.layout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import view.map.GameEntityView;
import view.map.GameItemView;
import view.map.GameLightView;
import view.map.GameProjectileView;
import view.map.GameTerrainView;

@SuppressWarnings("serial")
public class GameplayLayout extends Layout implements ActionListener {
    GameTerrainView gameTerrainView;
    GameEntityView gameEntityView;
    GameItemView gameItemView;
    GameLightView gameLightView;
	GameProjectileView gameProjectileView;
	private static final int FPS = 30;
	private static final int REDRAW_INTERVAL = 1000 / FPS;

    public GameplayLayout() {
        gameTerrainView = new GameTerrainView();
        gameEntityView = new GameEntityView();
        gameItemView = new GameItemView();
        gameLightView = new GameLightView();
		gameProjectileView = new GameProjectileView();
        setBackground(Color.BLACK);
        initRedrawTimer();
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

    public GameProjectileView getGameProjectileView() {
    	return gameProjectileView;
    }

    public void clearBindings() {
        getInputMap().clear();
        getActionMap().clear();
    }
    
    private void initRedrawTimer() {
		Timer t = new Timer(REDRAW_INTERVAL, this);
		t.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        gameTerrainView.render(graphics, getWidth(), getHeight());
        gameEntityView.render(graphics, getWidth(), getHeight());
        gameItemView.render(graphics, getWidth(), getHeight());
		gameProjectileView.render(graphics, getWidth(), getHeight());
        gameLightView.render(graphics, getWidth(), getHeight());
    }
}
