package controller.barter;

import java.awt.event.ActionListener;

import controller.Controller;
import controller.listener.ToggleAction;
import model.Model;
import model.entity.Avatar;
import model.entity.Entity;

public final class BarterMenuController extends Controller {
	private Model model;
	private BarterSellingController barterSellingController;
	private BarterBuyingController barterBuyingController;
	private ToggleAction exitGameAction;
	
	public BarterMenuController(Model model, Entity npc, Avatar avatar) {
		setModel(model);
		setBarterSellingController(new BarterSellingController(npc, avatar));
		setBarterBuyingController(new BarterBuyingController(npc, avatar));
		initActions();
	}
	
	@Override
	public void toggle() {
		barterSellingController.toggle();
		barterBuyingController.toggle();
	}


	public ActionListener getExitActionListener() {
		return getExitGameAction();
	}
	
	@SuppressWarnings("serial")
	private void initActions() {
		setExitGameAction(new ToggleAction() {
			@Override
			public void action() {
				getModel().popState();
			}
		});
	}

	public BarterSellingController getBarterSellingController() {
		return barterSellingController;
	}

	private void setBarterSellingController(
			BarterSellingController barterSellingController) {
		this.barterSellingController = barterSellingController;
	}

	public BarterBuyingController getBarterBuyingController() {
		return barterBuyingController;
	}

	private void setBarterBuyingController(
			BarterBuyingController barterBuyingController) {
		this.barterBuyingController = barterBuyingController;
	}

	private Model getModel() {
		return model;
	}

	private void setModel(Model model) {
		this.model = model;
	}

	private ToggleAction getExitGameAction() {
		return exitGameAction;
	}

	private void setExitGameAction(ToggleAction exitGameAction) {
		this.exitGameAction = exitGameAction;
	}

}
