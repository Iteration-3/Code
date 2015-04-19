package model.entity.dialog;

import java.util.ArrayList;
import java.util.Collection;

public final class DialogTree {
	Collection<DialogEntry> dialogEntries;
	
	public DialogTree() {
		dialogEntries = new ArrayList<DialogEntry>();
	}
	
	public DialogTree(Collection<DialogEntry> dialogEntries) {
		setDialogEntries(dialogEntries);
	}
	
	public Collection<DialogEntry> getDialogEntries() {
		return this.dialogEntries;
	}

	private void setDialogEntries(Collection<DialogEntry> dialogEntries) {
		this.dialogEntries = dialogEntries;
	}
	
}
