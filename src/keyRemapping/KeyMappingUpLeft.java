package keyRemapping;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import model.KeyPreferences;
import controller.KeyBindingsController;

public class KeyMappingUpLeft extends KeyMapping {

    public KeyMappingUpLeft(KeyPreferences preferences, KeyBindingsController rebindingController) {
        super(preferences, rebindingController);
    }

    @Override
    protected void updatePreferences(KeyEvent arg0) {
        super.getKeyPreferences().setUpLeftKey(KeyStroke.getKeyStrokeForEvent(arg0));
    }

}
