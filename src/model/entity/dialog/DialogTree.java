package model.entity.dialog;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public final class DialogTree implements Saveable{
	Collection<DialogEntry> dialogEntries;
	
	public DialogTree() {
		dialogEntries = new ArrayList<DialogEntry>();
	}
	
	public DialogTree(Collection<DialogEntry> dialogEntries) {
		setDialogEntries(dialogEntries);
	}
	
	public DialogTree(StructuredMap map) {
		this.dialogEntries = new ArrayList<DialogEntry>();
		//TODO work on this
	}
	
	public Collection<DialogEntry> getDialogEntries() {
		return this.dialogEntries;
	}

	private void setDialogEntries(Collection<DialogEntry> dialogEntries) {
		this.dialogEntries = dialogEntries;
	}

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap[] array = new StructuredMap[dialogEntries.size()];
		StructuredMap map = new StructuredMap();
		Iterator<DialogEntry> it = dialogEntries.iterator();
		int i = 0;
		while(it.hasNext()) {
			array[i] = it.next().getStructuredMap();
		}
		map.put("options", array);
		return map;
	}
	
}
