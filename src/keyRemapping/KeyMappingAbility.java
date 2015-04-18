package keyRemapping;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import model.KeyPreferences;
import controller.KeyBindingsController;

public class KeyMappingAbility extends KeyMapping {

    int location;

    public KeyMappingAbility(KeyPreferences preferences, KeyBindingsController controller, int abilityLocation) {
        super(preferences, controller);
        this.location = abilityLocation;
    }

    @Override
    protected void updatePreferences(KeyEvent arg0) {
        super.getKeyPreferences().setAbility(location, KeyStroke.getKeyStrokeForEvent(arg0));
    }

}
