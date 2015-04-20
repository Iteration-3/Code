package model.entity.dialog;

import model.entity.dialog.action.DialogAction;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import factories.DialogActionFactory;

public class DialogEntry implements Saveable {
	private String entryText;
	private DialogAction action;
	
	public DialogEntry(String entryText, DialogAction action) {
		setEntryText(entryText);
		setAction(action);
	}
	
	public DialogEntry(StructuredMap map) {
		this.entryText = map.getString("text");
		this.action = DialogActionFactory.createDialogAction(map.getStructuredMap("action"));
	}
	
	public String getEntryText() {
		return this.entryText;
	}
	
	public DialogAction getAction() {
		return this.action;
	}
	
	private void setEntryText(String entryText) {
		this.entryText = entryText;
	}
	
	private void setAction(DialogAction action) {
		this.action = action;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof DialogEntry) {
			DialogEntry dialogEntry = (DialogEntry) other;
			return dialogEntry.getEntryText().equals(this.getEntryText()) &&
					dialogEntry.getAction().equals(this.getAction());
		}
		return false;
	}

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("text", entryText);
		map.put("action", this.action.getStructuredMap());
		return map;
	}

}
