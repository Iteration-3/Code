package model;

import java.util.List;

import javax.swing.KeyStroke;

import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;

public class KeyPreferences implements SavableLoadable {

    private KeyStroke upKey;
    private KeyStroke upRightKey;
    private KeyStroke upLeftKey;
    private KeyStroke downRightKey;
    private KeyStroke downKey;
    private KeyStroke downLeftKey;
    private KeyStroke inventoryKey;
    private KeyStroke skillsKey;
    private KeyStroke pauseKey;
    private List<KeyStroke> abilities;
    private boolean hasChanged = false;

    public KeyPreferences() {
        /*
         * Num Pad Key Preferences this.upKey =
         * KeyStroke.getKeyStroke("NUMPAD8"); this.upRightKey =
         * KeyStroke.getKeyStroke("NUMPAD9"); this.upLeftKey=
         * KeyStroke.getKeyStroke("NUMPAD7"); this.downRightKey =
         * KeyStroke.getKeyStroke("NUMPAD3"); this.downKey =
         * KeyStroke.getKeyStroke("NUMPAD2"); this.downLeftKey =
         * KeyStroke.getKeyStroke("NUMPAD1");
         */
        this.upKey = KeyStroke.getKeyStroke("W");
        this.upRightKey = KeyStroke.getKeyStroke("E");
        this.upLeftKey = KeyStroke.getKeyStroke("Q");
        this.downRightKey = KeyStroke.getKeyStroke("C");
        this.downKey = KeyStroke.getKeyStroke("X");
        this.downLeftKey = KeyStroke.getKeyStroke("Z");
        this.pauseKey = KeyStroke.getKeyStroke("ESCAPE");
        this.inventoryKey = KeyStroke.getKeyStroke("I");
        this.skillsKey = KeyStroke.getKeyStroke("S");
    }

    public KeyPreferences(KeyStroke upKey, KeyStroke upRightKey, KeyStroke downRightKey, KeyStroke downKey,
            KeyStroke downLeftKey, KeyStroke upLeftKey, KeyStroke pauseKey, KeyStroke inventoryKey, KeyStroke skillsKey) {
        setUpKey(upKey);
        setUpRightKey(upRightKey);
        setDownRightKey(downRightKey);
        setDownKey(downKey);
        setDownLeftKey(downLeftKey);
        setUpLeftKey(upLeftKey);
        setPauseKey(pauseKey);
        setInventoryKey(inventoryKey);
        setSkillsKey(skillsKey);
    }

    public StructuredMap getStructuredMap() {
        return null;
    }

    public void load(StructuredMap map) {

    }

    public KeyStroke getUpKey() {
        return upKey;
    }

    public void setUpKey(KeyStroke upKey) {
        this.upKey = upKey;
        updateChanged();
    }

    public KeyStroke getUpRightKey() {
        return upRightKey;
    }

    public void setUpRightKey(KeyStroke upRightKey) {
        this.upRightKey = upRightKey;
        updateChanged();
    }

    public KeyStroke getDownRightKey() {
        return downRightKey;
    }

    public void setDownRightKey(KeyStroke downRightKey) {
        this.downRightKey = downRightKey;
        updateChanged();
    }

    public KeyStroke getDownKey() {
        return downKey;
    }

    public void setDownKey(KeyStroke downKey) {
        this.downKey = downKey;
        updateChanged();
    }

    public KeyStroke getDownLeftKey() {
        return downLeftKey;
    }

    public void setDownLeftKey(KeyStroke downLeftKey) {
        this.downLeftKey = downLeftKey;
        updateChanged();
    }

    public KeyStroke getUpLeftKey() {
        return upLeftKey;
    }

    public void setUpLeftKey(KeyStroke upLeftKey) {
        this.upLeftKey = upLeftKey;
        updateChanged();
    }

    public KeyStroke getInventoryKey() {
        return inventoryKey;
    }

    public void setInventoryKey(KeyStroke inventoryKey) {
        this.inventoryKey = inventoryKey;
        updateChanged();
    }

    public KeyStroke getSkillsKey() {
        return skillsKey;
    }

    public void setSkillsKey(KeyStroke skillsKey) {
        this.skillsKey = skillsKey;
        updateChanged();
    }

    public KeyStroke getPauseKey() {
        return pauseKey;
    }

    public void setPauseKey(KeyStroke pauseKey) {
        this.pauseKey = pauseKey;
        updateChanged();
    }

    public KeyStroke getAbility(int number) {
        return this.getAbilities().get(number - 1);
    }

    public void setAbility(int number, KeyStroke key) {
        this.getAbilities().set(number - 1, key);
    }

    public List<KeyStroke> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<KeyStroke> abilities) {
        this.abilities = abilities;
    }

    public void updateChanged() {
        this.hasChanged = true;
    }

    public boolean hasChanged() {
        return hasChanged;
    }

    public void reset() {
        this.hasChanged = false;
    }

}
