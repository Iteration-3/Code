package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controller.listener.ToggleAction;
import model.Model;

public class InventoryMenuController extends Controller {
	private Model model;
	private ToggleAction backAction;
	private InventoryMouseListener inventoryMouseListener;
	
	public InventoryMenuController(Model model) {
		this.model = model;
		initActions();
	}
	
	@SuppressWarnings("serial")
	private void initActions() {
		backAction = new ToggleAction() {
			@Override
			public void action() {
				model.popState();
			}
		};
	}
	
	public InventoryMouseListener getInventoryMouseListener(){
		return new InventoryMouseListener();
	}
	
	public ToggleAction getBackAction() {
		return backAction;
	}
	
	public void toggle() {
		backAction.toggle();
	}
	
	public class InventoryMouseListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			System.out.println(e);
		}

		public void mouseEntered(MouseEvent e) {
			System.out.println(e);
		}

		public void mouseExited(MouseEvent e) {
			System.out.println(e);
		}

		public void mousePressed(MouseEvent e) {
			System.out.println(e);
		}

		public void mouseReleased(MouseEvent e) {
			System.out.println(e);
		}
		
	}
}
