package keyRemapping;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import model.KeyPreferences;
import controller.RebindingController;

public class KeyMappingDown extends KeyMapping {

    public KeyMappingDown(KeyPreferences preferences, RebindingController rebindingController) {
        super(preferences, rebindingController);
    }

    @Override
    protected void updatePreferences(KeyEvent arg0) {
        super.getKeyPreferences().setDownKey(KeyStroke.getKeyStrokeForEvent(arg0));
    }

}
