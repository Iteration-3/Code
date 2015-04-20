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
    private KeyStroke dismountKey;
	private static final int NUM_ABILITIES = 11;
    private List<KeyStroke> abilities;
	private KeyStroke attackKey;

    public KeyPreferences() {
        this.upKey = KeyStroke.getKeyStroke("W");
        this.upRightKey = KeyStroke.getKeyStroke("E");
        this.upLeftKey = KeyStroke.getKeyStroke("Q");
        this.downRightKey = KeyStroke.getKeyStroke("D");
        this.downKey = KeyStroke.getKeyStroke("S");
        this.downLeftKey = KeyStroke.getKeyStroke("A");
        this.pauseKey = KeyStroke.getKeyStroke("ESCAPE");
        this.inventoryKey = KeyStroke.getKeyStroke("I");
        this.skillsKey = KeyStroke.getKeyStroke("ENTER");
        this.dismountKey = KeyStroke.getKeyStroke("H");
        this.abilities = new ArrayList<KeyStroke>();
        this.attackKey = KeyStroke.getKeyStroke("F");
        for (int i = 0; i != 10; ++i) {//This should never go above 10, don't have that many keys!
            abilities.add(KeyStroke.getKeyStroke(Integer.toString(i)));
        }
        abilities.add(KeyStroke.getKeyStroke("EQUALS"));
        abilities.add(KeyStroke.getKeyStroke("MINUS"));
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
        setDismountKey(KeyStroke.getKeyStroke(structuredMap.getString("dismount")));
        setAttackKey(KeyStroke.getKeyStroke(structuredMap.getString("attack")));
        abilities = new ArrayList<KeyStroke>();
        for (int i = 1; i <= NUM_ABILITIES; i++) {
            abilities.add(KeyStroke.getKeyStroke(structuredMap.getString("ability" + i)));
        }
    }

    private void setAttackKey(KeyStroke keyStroke) {
		this.attackKey = keyStroke;
		
	}

	public KeyPreferences(KeyStroke upKey, KeyStroke upRightKey, KeyStroke downRightKey, KeyStroke downKey,
            KeyStroke downLeftKey, KeyStroke upLeftKey, KeyStroke pauseKey, KeyStroke inventoryKey,
            KeyStroke dismountKey, KeyStroke skillsKey, List<KeyStroke> abilities) {
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
        setDismountKey(dismountKey);
    }

    @Override
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
        map.put("dismount", formatKey(getDismountKey()));
        for (int i = 1; i <= abilities.size(); i++) {
            map.put("ability" + i, formatKey(abilities.get(i)));
        }
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
    
   public KeyStroke getDismountKey() {
	   return dismountKey;
   }
   
   public void setDismountKey(KeyStroke dismountKey) {
	   this.dismountKey = dismountKey;
   }

    public KeyStroke getAbility(int number) {
        return this.getAbilities().get(number);
    }

    public void setAbility(int number, KeyStroke key) {
        this.getAbilities().set(number, key);
    }

    public List<KeyStroke> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<KeyStroke> abilities) {
        this.abilities = abilities;
    }

	public KeyStroke getAttackKey() {
		return this.attackKey;
	}

}
