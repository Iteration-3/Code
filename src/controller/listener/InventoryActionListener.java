package controller.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryActionListener implements ActionListener {
	private int slotLocation;
	
	public InventoryActionListener(int i){
		slotLocation = i;
	}

	public void actionPerformed(ActionEvent arg0) {
		System.out.println("I am slot " + slotLocation);
	}

}
