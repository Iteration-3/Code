package keyRemapping;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import model.KeyPreferences;
import controller.KeyBindingsController;

public class KeyMappingInventory extends KeyMapping {

    public KeyMappingInventory(KeyPreferences preferences, KeyBindingsController controller) {
        super(preferences, controller);
    }

    @Override
    protected void updatePreferences(KeyEvent arg0) {
        super.getKeyPreferences().setInventoryKey(KeyStroke.getKeyStrokeForEvent(arg0));

    }

}
