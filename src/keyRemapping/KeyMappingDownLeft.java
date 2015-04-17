package keyRemapping;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import model.KeyPreferences;
import controller.KeyBindingsController;

public class KeyMappingDownLeft extends KeyMapping {

    public KeyMappingDownLeft(KeyPreferences preferences, KeyBindingsController rebindingController) {
        super(preferences, rebindingController);
    }

    @Override
    protected void updatePreferences(KeyEvent arg0) {
        super.getKeyPreferences().setDownLeftKey(KeyStroke.getKeyStrokeForEvent(arg0));
    }

}
