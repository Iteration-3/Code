package keyRemapping;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import model.KeyPreferences;
import controller.KeyBindingsController;

public class KeyMappingPause extends KeyMapping {

    public KeyMappingPause(KeyPreferences preferences, KeyBindingsController controller) {
        super(preferences, controller);
    }

    @Override
    protected void updatePreferences(KeyEvent arg0) {
        super.getKeyPreferences().setPauseKey(KeyStroke.getKeyStrokeForEvent(arg0));
    }

}
