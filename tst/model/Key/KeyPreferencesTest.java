package model.Key;

import javax.swing.JFrame;

import model.KeyPreferences;

import org.junit.Before;
import org.junit.Test;

import controller.RebindingController;
import view.Layout;

public class KeyPreferencesTest {

    Layout layout;
    RebindingController controller;
    JFrame frame;

    @Before
    public void init() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500, 500);
        layout = new Layout();
        controller = new RebindingController();
        //layout.setController(controller); // TODO: i (Daniel) removed this because i revamped the Layout interface
        									// which causes this to no longer makes sense...
        frame.add(layout);
    }

    @Test
    public void test() {
        KeyPreferences test = KeyPreferences.getInstance();
        KeyPreferences test2 = test.clone();

        System.out.println(test.getDownKey());
        System.out.println(test2.getDownKey());
    }

    @Test
    public void testPanel() {
        KeyPreferences pref = KeyPreferences.getInstance();
        System.out.println(pref.getUpKey());
        controller.attachNewUpMapping();

    }

}
