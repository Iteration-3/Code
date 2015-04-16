package controller;

import keyRemapping.KeyMapping;
import keyRemapping.KeyMappingDown;
import keyRemapping.KeyMappingDownLeft;
import keyRemapping.KeyMappingDownRight;
import keyRemapping.KeyMappingUp;
import keyRemapping.KeyMappingUpLeft;
import keyRemapping.KeyMappingUpRight;
import model.KeyPreferences;
import view.Layout;

public class RebindingController extends Controller {
    KeyPreferences keyPreferences = KeyPreferences.getInstance().clone();
    Layout layout;

    @Override
    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public void attachKeyMapping(KeyMapping mapper) {
        this.layout.addKeyListener(mapper);
    }

    public void removeKeyMapping(KeyMapping mapper) {
        this.layout.removeKeyListener(mapper);
    }

    public void attachNewUpMapping() {
        KeyMapping mapping = new KeyMappingUp(keyPreferences, this);
        attachKeyMapping(mapping);
    }

    public void attachNewDownMapping() {
        KeyMapping mapping = new KeyMappingDown(keyPreferences, this);
        attachKeyMapping(mapping);
    }

    public void attachNewUpLeftMapping() {
        KeyMapping mapping = new KeyMappingUpLeft(keyPreferences, this);
        attachKeyMapping(mapping);
    }

    public void attachNewUpRightMapping() {
        KeyMapping mapping = new KeyMappingUpRight(keyPreferences, this);
        attachKeyMapping(mapping);
    }

    public void attachNewDownRightMapping() {
        KeyMapping mapping = new KeyMappingDownRight(keyPreferences, this);
        attachKeyMapping(mapping);
    }

    public void attachNewDownLeftMapping() {
        KeyMapping mapping = new KeyMappingDownLeft(keyPreferences, this);
        attachKeyMapping(mapping);
    }
}