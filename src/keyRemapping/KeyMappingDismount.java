package keyRemapping;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import model.KeyPreferences;
import controller.KeyBindingsController;

public class KeyMappingDismount extends KeyMapping {
	
	public KeyMappingDismount(KeyPreferences preferences, KeyBindingsController controller) {
		super(preferences, controller);
	}

	@Override
	protected void updatePreferences(KeyEvent arg0) {
		super.getKeyPreferences().setDismountKey(KeyStroke.getKeyStrokeForEvent(arg0));
	}

}
