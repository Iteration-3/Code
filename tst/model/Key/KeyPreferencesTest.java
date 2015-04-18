package model.Key;

import static org.junit.Assert.assertEquals;

import javax.swing.KeyStroke;

import model.KeyPreferences;

import org.junit.Test;

import utilities.structuredmap.StructuredMap;

public class KeyPreferencesTest {

    @Test
    public void testSave() {
        KeyPreferences test = new KeyPreferences();
        test.setDownKey(KeyStroke.getKeyStroke("H"));
        test.setInventoryKey(KeyStroke.getKeyStroke("NUMPAD8"));
        test.setAbility(3, KeyStroke.getKeyStroke("U"));

        StructuredMap map = test.getStructuredMap();

        System.out.println(map.getJson());

        KeyPreferences returnPref = new KeyPreferences(map);
        assertEquals(test.getDownKey(), returnPref.getDownKey());
        assertEquals(test.getInventoryKey(), returnPref.getInventoryKey());
        assertEquals(test.getAbility(3), returnPref.getAbility(3));

    }

}
