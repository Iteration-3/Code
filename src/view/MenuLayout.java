package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import view.components.MenuButton;

@SuppressWarnings("serial")
public abstract class MenuLayout extends Layout {
    
    public MenuLayout() {
        setPreferredSize(new Dimension(1024, 768));
    }

    public void formatButton(MenuButton button, Color color) {
        button.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        button.setBackground(color);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
    }
    
    public void setGridLayout(int x, int y) {
        setLayout(new GridLayout(x,y));
    }

}
