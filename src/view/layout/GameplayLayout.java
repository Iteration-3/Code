package view.layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;

import view.map.GameEntityView;
import view.map.GameItemView;
import view.map.GameTerrainView;

@SuppressWarnings("serial")
public class GameplayLayout extends Layout {
    GameTerrainView gameTerrainView;
    GameEntityView gameEntityView;
    GameItemView gameItemView;

    public GameplayLayout() {
        gameTerrainView = new GameTerrainView();
        gameEntityView = new GameEntityView();
        gameItemView = new GameItemView();
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

    public void clearBindings() {
        getInputMap().clear();
        getActionMap().clear();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        gameTerrainView.render(graphics, this.getWidth(), this.getHeight());
        gameEntityView.render(graphics, this.getWidth(), this.getHeight());
        gameItemView.render(graphics, this.getWidth(), this.getHeight());
    }

}
