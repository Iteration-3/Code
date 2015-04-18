package keyRemapping;

import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;

import model.KeyPreferences;
import controller.KeyBindingsController;

public class KeyMappingSkills extends KeyMapping {

    public KeyMappingSkills(KeyPreferences preferences, KeyBindingsController controller) {
        super(preferences, controller);
    }

    @Override
    protected void updatePreferences(KeyEvent arg0) {
        super.getKeyPreferences().setSkillsKey(KeyStroke.getKeyStrokeForEvent(arg0));
    }

}
