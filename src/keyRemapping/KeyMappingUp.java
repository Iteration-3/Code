package keyRemapping;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import model.KeyPreferences;
import controller.KeyBindingsController;

public class KeyMappingUp extends KeyMapping {

    public KeyMappingUp(KeyPreferences preferences, KeyBindingsController rebindingController) {
        super(preferences, rebindingController);
    }

    @Override
    protected void updatePreferences(KeyEvent arg0) {
        super.getKeyPreferences().setUpKey(KeyStroke.getKeyStrokeForEvent(arg0));
    }

}
