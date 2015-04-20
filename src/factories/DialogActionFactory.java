package factories;

import model.entity.dialog.action.BarterAction;
import model.entity.dialog.action.DialogAction;
import model.entity.dialog.action.ExitAction;
import model.entity.dialog.action.MountAction;
import utilities.structuredmap.StructuredMap;

public class DialogActionFactory {

	public static DialogAction createDialogAction(StructuredMap structuredMap) {
		switch (structuredMap.getString("type")) {
		case "barter":
			return new BarterAction();
		case "exit":
			return new ExitAction();
		case "mount":
			return new MountAction();
		default:
			throw new IllegalArgumentException("Bad dialogue");
		}
	}
}
