package keyRemapping;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import model.KeyPreferences;
import controller.RebindingController;

public class KeyMappingDownLeft extends KeyMapping {

    public KeyMappingDownLeft(KeyPreferences preferences, RebindingController rebindingController) {
        super(preferences, rebindingController);
    }

    @Override
    protected void updatePreferences(KeyEvent arg0) {
        super.getKeyPreferences().setDownLeftKey(KeyStroke.getKeyStrokeForEvent(arg0));
    }

}
