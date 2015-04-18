package model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.KeyStroke;

import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public class KeyPreferences implements Saveable {

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

    public KeyPreferences() {
        this.upKey = KeyStroke.getKeyStroke("W");
        this.upRightKey = KeyStroke.getKeyStroke("E");
        this.upLeftKey = KeyStroke.getKeyStroke("Q");
        this.downRightKey = KeyStroke.getKeyStroke("C");
        this.downKey = KeyStroke.getKeyStroke("X");
        this.downLeftKey = KeyStroke.getKeyStroke("Z");
        this.pauseKey = KeyStroke.getKeyStroke("ESCAPE");
        this.inventoryKey = KeyStroke.getKeyStroke("I");
        this.skillsKey = KeyStroke.getKeyStroke("S");
        this.abilities = new ArrayList<KeyStroke>();
        for(int i = 0; i!=10;++i){
        	abilities.add(KeyStroke.getKeyStroke((char) ('0'+i)));
        }
    }

    public KeyPreferences(StructuredMap structuredMap) {
        setUpKey(KeyStroke.getKeyStroke(structuredMap.getString("up")));
        setUpLeftKey(KeyStroke.getKeyStroke(structuredMap.getString("upLeft")));
        setUpRightKey(KeyStroke.getKeyStroke(structuredMap.getString("upLeft")));
        setDownLeftKey(KeyStroke.getKeyStroke(structuredMap.getString("downLeft")));
        setDownRightKey(KeyStroke.getKeyStroke(structuredMap.getString("downRight")));
        setDownKey(KeyStroke.getKeyStroke(structuredMap.getString("down")));
        setInventoryKey(KeyStroke.getKeyStroke(structuredMap.getString("inventory")));
        setSkillsKey(KeyStroke.getKeyStroke(structuredMap.getString("skills")));
        setPauseKey(KeyStroke.getKeyStroke(structuredMap.getString("pause")));
        //TODO load abilitittititites.
    }

    public KeyPreferences(KeyStroke upKey, KeyStroke upRightKey, KeyStroke downRightKey, KeyStroke downKey,
            KeyStroke downLeftKey, KeyStroke upLeftKey, KeyStroke pauseKey, KeyStroke inventoryKey, KeyStroke skillsKey, List<KeyStroke> abilities) {
        setUpKey(upKey);
        setUpRightKey(upRightKey);
        setDownRightKey(downRightKey);
        setDownKey(downKey);
        setDownLeftKey(downLeftKey);
        setUpLeftKey(upLeftKey);
        setPauseKey(pauseKey);
        setInventoryKey(inventoryKey);
        setSkillsKey(skillsKey);
        setAbilities(abilities);
        
    }

    public StructuredMap getStructuredMap() {
        StructuredMap map = new StructuredMap();
        map.put("up", formatKey(getUpKey()));
        map.put("upLeft", formatKey(getUpLeftKey()));
        map.put("upRight", formatKey(getUpRightKey()));
        map.put("down", formatKey(getDownKey()));
        map.put("downLeft", formatKey(getDownLeftKey()));
        map.put("downRight", formatKey(getDownRightKey()));
        map.put("pause", formatKey(getPauseKey()));
        map.put("inventory", formatKey(getInventoryKey()));
        map.put("skills", formatKey(getSkillsKey()));

        return map;
    }

    private String formatKey(KeyStroke stroke) {
        return stroke.toString().replaceAll("(pressed|typed) ", "");
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
