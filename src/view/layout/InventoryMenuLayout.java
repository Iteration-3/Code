package view.layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import controller.InventoryMenuController;
import view.EquipmentView;
import view.InventoryView;
import view.components.MenuButton;

@SuppressWarnings("serial")
public class InventoryMenuLayout extends Layout {
	private static int inventoryOffsetX;
	private static int inventoryOffsetY;
	private static int equipmentOffsetX;
	private static int equipmentOffsetY;

    private MenuButton backButton;
    private InventoryView inventoryView;
    private EquipmentView equipmentView;

    public InventoryMenuLayout(InventoryView inventoryView,EquipmentView equipmentView) {
    	setPreferredSize(new Dimension(1024, 768));
     
    	setInventoryView(inventoryView);
    	this.equipmentView = equipmentView;
        initButtons();
        addViews();
    }
    
    private void addViews(){
    	addButtons();
    }
    
    private void initButtons() {
        backButton = new MenuButton("GO BACK");
        backButton.setColor(Color.CYAN);
    }
    
    private void addButtons() {
        add(backButton);
    }
    
    public void paint(Graphics g){
    	super.paint(g);
    	inventoryView.render(g);
    	equipmentView.render(g);
    }
    

    public void attachController(InventoryMenuController controller) {   	
    	backButton.addActionListener(controller.getBackAction());
    }
    
    public void setInventoryView(InventoryView inventoryView){
    	this.inventoryView = inventoryView;
    }
}
