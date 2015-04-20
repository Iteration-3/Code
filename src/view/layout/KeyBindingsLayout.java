package view.layout;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.KeyPreferences;
import view.components.MenuButton;
import view.components.TextLabel;
import controller.KeyBindingsController;

@SuppressWarnings("serial")
public class KeyBindingsLayout extends Layout {

    private MenuButton backButton;

    private MenuButton rebindUp;
    private TextLabel upLabel;

    private MenuButton rebindDown;
    private TextLabel downLabel;

    private MenuButton rebindUpLeft;
    private TextLabel upLeftLabel;

    private MenuButton rebindUpRight;
    private TextLabel upRightLabel;

    private MenuButton rebindDownLeft;
    private TextLabel downLeftLabel;

    private MenuButton rebindDownRight;
    private TextLabel downRightLabel;

    private MenuButton rebindPause;
    private TextLabel pauseLabel;
    
    private MenuButton rebindDismount;
    private TextLabel dismountLabel;

    private MenuButton rebindInventory;
    private TextLabel inventoryLabel;

    private MenuButton rebindSkills;
    private TextLabel skillLabel;
    
    private static final int NUM_ABILITIES = 10;
    private MenuButton[] rebindAbilities;
    private TextLabel[] abilityLabels;
    private Image bgImage;

    public KeyBindingsLayout() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    	setBorder(new EmptyBorder(50, 50, 50, 50));
    	bgImage = null;//new ImageIcon("src/resources/images/hex_bg.jpg").getImage();
        initLabels();
        initButtons();
        addComponents();
    }

    private void initLabels() {
        upLabel = new TextLabel();
        upLabel.setHorizontalAlignment(SwingConstants.CENTER);
        downLabel = new TextLabel();
        downLabel.setHorizontalAlignment(SwingConstants.CENTER);
        upLeftLabel = new TextLabel();
        upLeftLabel.setHorizontalAlignment(SwingConstants.CENTER);
        upRightLabel = new TextLabel();
        upRightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        downLeftLabel = new TextLabel();
        downLeftLabel.setHorizontalAlignment(SwingConstants.CENTER);
        downRightLabel = new TextLabel();
        downRightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pauseLabel = new TextLabel();
        dismountLabel = new TextLabel();
        dismountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pauseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        skillLabel = new TextLabel();
        skillLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inventoryLabel = new TextLabel();
        inventoryLabel.setHorizontalAlignment(SwingConstants.CENTER);
        abilityLabels = new TextLabel[NUM_ABILITIES];
        for(int i = 0; i < NUM_ABILITIES; ++i) {
        	abilityLabels[i] = new TextLabel();
        	abilityLabels[i].setHorizontalAlignment(SwingConstants.CENTER);
        }
    }

    private void addComponents() {
    	TextLabel title = new TextLabel("Controls");
    	title.setFont(title.getFont().deriveFont(50.0f));
    	title.setForeground(Color.WHITE);
    	title.setAlignmentX(Component.CENTER_ALIGNMENT);
    	add(title);
    	
    	JPanel centerPanel = new JPanel() {
    		{
    			setLayout(new GridLayout(10,4));
    			setBorder(new EmptyBorder(50, 20, 50, 20));
    	    	setOpaque(false);
    			add(rebindUp);
    			add(upLabel);
                add(rebindUpLeft);
                add(upLeftLabel);
                add(rebindUpRight);
                add(upRightLabel);
                add(rebindDown);
                add(downLabel);
                add(rebindDownLeft);
                add(downLeftLabel);
                add(rebindDownRight);
                add(downRightLabel);
                
                for(int i = 0; i < NUM_ABILITIES; ++i){
                	add(rebindAbilities[i]);
                	add(abilityLabels[i]);
                }
                
                add(rebindPause);
                add(pauseLabel);
                add(rebindDismount);
                add(dismountLabel);
                add(rebindSkills);
                add(skillLabel);
                add(rebindInventory);
                add(inventoryLabel);
    		}
    		
    	    @Override
    	    public void paintComponent(Graphics graphics) {
    	    	Graphics2D graphics2D = (Graphics2D) graphics;
    	    	graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    	    			RenderingHints.VALUE_ANTIALIAS_ON);
    	    	graphics2D.setColor(Color.LIGHT_GRAY);
    	    	float alpha = 0.75f;
    	    	int type = AlphaComposite.SRC_OVER; 
    	    	AlphaComposite composite = 
    	    	  AlphaComposite.getInstance(type, alpha);
    	    	graphics2D.setComposite(composite);
    	    	graphics2D.fillRoundRect(0, 0, getWidth(), getHeight(), 35, 35);
    	    	super.paintComponent(graphics);
    	    }
    	};
    	
    	add(Box.createRigidArea(new Dimension(0, 15)));
    	
    	add(centerPanel);

    	add(Box.createRigidArea(new Dimension(0, 15)));
    	
    	backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(backButton);
    }

    private void initButtons() {
        backButton = new MenuButton("BACK");
        backButton.setColor(Color.CYAN);

        rebindUp = new MenuButton("MOVE UP");
        rebindUp.setColor(Color.GRAY);

        rebindDown = new MenuButton("MOVE DOWN");
        rebindDown.setColor(Color.GRAY);

        rebindUpLeft = new MenuButton("MOVE UP-LEFT");
        rebindUpLeft.setColor(Color.GRAY);

        rebindUpRight = new MenuButton("MOVE UP-RIGHT");
        rebindUpRight.setColor(Color.GRAY);

        rebindDownLeft = new MenuButton("MOVE LEFT");
        rebindDownLeft.setColor(Color.GRAY);

        rebindDownRight = new MenuButton("MOVE DOWN-RIGHT");
        rebindDownRight.setColor(Color.GRAY);

        rebindPause = new MenuButton("PAUSE MENU");
        rebindPause.setColor(Color.GRAY);
        
        rebindDismount = new MenuButton("REBIND DISMOUNT");
        rebindDismount.setColor(Color.GRAY);

        rebindSkills = new MenuButton("SKILLS MENU");
        rebindSkills.setColor(Color.GRAY);

        rebindInventory = new MenuButton("INVENTORY MENU");
        rebindInventory.setColor(Color.GRAY);

        rebindAbilities = new MenuButton[NUM_ABILITIES];
        for(int i = 0; i < NUM_ABILITIES; ++i) {
        	rebindAbilities[i] = new MenuButton("ABILITY " + (i + 1));
        	rebindAbilities[i].setColor(Color.GRAY);
        }
    }

    public void attachController(KeyBindingsController controller) {
        backButton.addActionListener(controller.goBackAction());
        rebindUp.addActionListener(controller.getRebindUpAction());
        rebindDown.addActionListener(controller.getRebindDownAction());
        rebindUpLeft.addActionListener(controller.getRebindUpLeftAction());
        rebindUpRight.addActionListener(controller.getRebindUpRightAction());
        rebindDownLeft.addActionListener(controller.getRebindDownLeftAction());
        rebindDownRight.addActionListener(controller.getRebindDownRightAction());
        rebindInventory.addActionListener(controller.getRebindInventory());
        rebindSkills.addActionListener(controller.getRebindSkills());
        rebindPause.addActionListener(controller.getRebindPause());
        rebindDismount.addActionListener(controller.getRebindDismount());
        for(int i = 0; i < NUM_ABILITIES; ++i) {
        	rebindAbilities[i].addActionListener(controller.getRebindAbility(i));
        }
    }

    public void updateKeyText(KeyPreferences preferences) {
        upLabel.setText(formatKey(preferences.getUpKey()));
        upLeftLabel.setText(formatKey(preferences.getUpLeftKey()));
        upRightLabel.setText(formatKey(preferences.getUpRightKey()));
        downLabel.setText(formatKey(preferences.getDownKey()));
        downLeftLabel.setText(formatKey(preferences.getDownLeftKey()));
        downRightLabel.setText(formatKey(preferences.getDownRightKey()));
        skillLabel.setText(formatKey(preferences.getSkillsKey()));
        pauseLabel.setText(formatKey(preferences.getPauseKey()));
        dismountLabel.setText(formatKey(preferences.getDismountKey()));
        inventoryLabel.setText(formatKey(preferences.getInventoryKey()));

        List<KeyStroke> abilities = preferences.getAbilities();
        for(int i = 0; i < NUM_ABILITIES; ++i)
        	abilityLabels[i].setText(formatKey(abilities.get(i)));
    }

    private String formatKey(KeyStroke stroke) {
        return stroke.toString().replaceAll("(pressed|typed) ", "");
    }
    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(bgImage.getWidth(null), bgImage.getHeight(null)));
    }

    @Override
    public void paintComponent(Graphics graphics) {
    	super.paintComponent(graphics);
    	//int width = (int) (bgImage.getWidth(null) * ((float)getHeight() / bgImage.getHeight(null)));
    	//graphics.drawImage(bgImage, (getWidth() - width) / 2, 0, width, getHeight(), null);
    }
}