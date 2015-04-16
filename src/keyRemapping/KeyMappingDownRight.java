package keyRemapping;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import model.KeyPreferences;
import controller.RebindingController;

public class KeyMappingDownRight extends KeyMapping {

    public KeyMappingDownRight(KeyPreferences preferences, RebindingController rebindingController) {
        super(preferences, rebindingController);
    }

    @Override
    protected void updatePreferences(KeyEvent arg0) {
        super.getKeyPreferences().setDownRightKey(KeyStroke.getKeyStrokeForEvent(arg0));
    }

}
