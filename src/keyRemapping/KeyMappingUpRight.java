package keyRemapping;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import model.KeyPreferences;
import controller.KeyBindingsController;

public class KeyMappingUpRight extends KeyMapping {

    public KeyMappingUpRight(KeyPreferences preferences, KeyBindingsController rebindingController) {
        super(preferences, rebindingController);
    }

    @Override
    protected void updatePreferences(KeyEvent arg0) {
        super.getKeyPreferences().setUpRightKey(KeyStroke.getKeyStrokeForEvent(arg0));
    }

}
