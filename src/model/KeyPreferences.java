package model;

import java.util.List;

import javax.swing.KeyStroke;

import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;

public class KeyPreferences implements SavableLoadable {

    private KeyStroke upKey;
    private KeyStroke upRightKey;
    private KeyStroke downRightKey;
    private KeyStroke downKey;
    private KeyStroke downLeftKey;
    private KeyStroke upLeftKey;
    private KeyStroke inventoryKey;
    private KeyStroke skillsKey;
    private KeyStroke pauseKey;
    private List<KeyStroke> abilities;

    public KeyPreferences() {
        this.upKey = KeyStroke.getKeyStroke('8');
        this.upRightKey = KeyStroke.getKeyStroke('9');
        this.downRightKey = KeyStroke.getKeyStroke('3');
        this.downKey = KeyStroke.getKeyStroke('2');
        this.downLeftKey = KeyStroke.getKeyStroke('1');
        this.upLeftKey = KeyStroke.getKeyStroke('7');
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
    }

    public KeyStroke getUpRightKey() {
        return upRightKey;
    }

    public void setUpRightKey(KeyStroke upRightKey) {
        this.upRightKey = upRightKey;
    }

    public KeyStroke getDownRightKey() {
        return downRightKey;
    }

    public void setDownRightKey(KeyStroke downRightKey) {
        this.downRightKey = downRightKey;
    }

    public KeyStroke getDownKey() {
        return downKey;
    }

    public void setDownKey(KeyStroke downKey) {
        this.downKey = downKey;
    }

    public KeyStroke getDownLeftKey() {
        return downLeftKey;
    }

    public void setDownLeftKey(KeyStroke downLeftKey) {
        this.downLeftKey = downLeftKey;
    }

    public KeyStroke getUpLeftKey() {
        return upLeftKey;
    }

    public void setUpLeftKey(KeyStroke upLeftKey) {
        this.upLeftKey = upLeftKey;
    }

    public KeyStroke getInventoryKey() {
        return inventoryKey;
    }

    public void setInventoryKey(KeyStroke inventoryKey) {
        this.inventoryKey = inventoryKey;
    }

    public KeyStroke getSkillsKey() {
        return skillsKey;
    }

    public void setSkillsKey(KeyStroke skillsKey) {
        this.skillsKey = skillsKey;
    }

    public KeyStroke getPauseKey() {
        return pauseKey;
    }

    public void setPauseKey(KeyStroke pauseKey) {
        this.pauseKey = pauseKey;
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

}
