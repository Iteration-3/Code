package view.layout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import view.Camera;
import view.ViewTransform;
import view.entity.GameEntityView;
import view.item.GameItemView;
import view.light.GameLightView;
import view.map.GameTileView;
import view.projectiles.GameProjectileView;
import view.trigger.GameTriggerView;

@SuppressWarnings("serial")
public class GameplayLayout extends Layout implements ActionListener {
	
    private GameTileView gameMap;
    private GameEntityView gameEntityView;
    private GameItemView gameItemView;
    private GameLightView gameLightView;
	private GameProjectileView gameProjectileView;
	private GameTriggerView gameTriggerView;
	private Camera camera;
	private static final int FPS = 60;
	private static final int REDRAW_INTERVAL = 1000 / FPS;
	
    public GameplayLayout() {
        gameMap = new GameTileView(300,75);
        gameEntityView = new GameEntityView();
        gameItemView = new GameItemView();
        gameLightView = new GameLightView();
        gameTriggerView = new GameTriggerView();
		gameProjectileView = new GameProjectileView();
        setBackground(Color.BLACK);
        initRedrawTimer();
        camera = new Camera();
    }
    
    public Camera getCamera() {
    	return camera;
    }
    
    public GameTriggerView getGameTriggerView() {
    	return gameTriggerView;
    }

    public void setGameTileView(GameTileView gtv) {
    	gameMap = gtv;
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
    
    @Override
    public void revalidate() {
    	super.revalidate();
    	if(camera != null) // b / c super
    		camera.setViewportBounds(getWidth(), getHeight());
    }

    public void clearBindings() {
        getInputMap().clear();
        getActionMap().clear();
    }
    
    private void initRedrawTimer() {
		Timer t = new Timer(REDRAW_INTERVAL, this);
		t.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        ViewTransform transform = camera.getTransform();
        
        /* Do locks */
        gameEntityView.lock();
        gameLightView.lock();
        
        /* Render */
        gameMap.render(graphics, transform);
        gameEntityView.render(graphics, transform);
        gameItemView.render(graphics, transform);
        gameTriggerView.render(graphics, transform);
		gameProjectileView.render(graphics, transform);
        gameLightView.render(graphics, transform);
        
        /* Do releases */
        gameEntityView.release();
        gameLightView.release();
    }
}
