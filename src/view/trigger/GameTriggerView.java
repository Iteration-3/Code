package view.trigger;

import java.awt.Graphics;
import java.util.List;

import model.trigger.TriggerManager;
import view.ViewTransform;

public class GameTriggerView {
	private List<ViewableTrigger> viewableTriggers;

	public GameTriggerView() {
		viewableTriggers = TriggerManager.getSingleton().getViewableTriggers();
	}

	public void render(Graphics graphics, ViewTransform transform) {
		for (ViewableTrigger viewableTrigger: viewableTriggers) {
			viewableTrigger.render(graphics, transform);
		}
		viewableTriggers = TriggerManager.getSingleton().getViewableTriggers();
	}

}
