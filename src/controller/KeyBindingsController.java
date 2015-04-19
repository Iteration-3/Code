package controller;

import keyRemapping.KeyMapping;
import keyRemapping.KeyMappingAbility;
import keyRemapping.KeyMappingDown;
import keyRemapping.KeyMappingDownLeft;
import keyRemapping.KeyMappingDownRight;
import keyRemapping.KeyMappingInventory;
import keyRemapping.KeyMappingPause;
import keyRemapping.KeyMappingSkills;
import keyRemapping.KeyMappingUp;
import keyRemapping.KeyMappingUpLeft;
import keyRemapping.KeyMappingUpRight;
import model.KeyPreferences;
import model.Model;
import view.layout.KeyBindingsLayout;
import controller.listener.ToggleAction;

public class KeyBindingsController extends Controller {
    private KeyPreferences keyPreferences;
    private KeyBindingsLayout layout;
    private Model model;

    private ToggleAction backAction;
    private ToggleAction rebindUpAction;
    private ToggleAction rebindDownAction;
    private ToggleAction rebindUpLeftAction;
    private ToggleAction rebindUpRightAction;
    private ToggleAction rebindDownLeftAction;
    private ToggleAction rebindDownRightAction;
    private ToggleAction rebindInventory;
    private ToggleAction rebindSkills;
    private ToggleAction rebindPause;
  
    private static final int NUM_ABILITIES = 10;
    private ToggleAction[] rebindAbilities;

    @SuppressWarnings("serial")
    public KeyBindingsController(final Model model) {
        this.model = model;
        this.keyPreferences = model.getPreferences();

        backAction = new ToggleAction() {
            public void action() {
                model.popState();
            }
        };
        rebindUpAction = new ToggleAction() {
            public void action() {
                attachNewUpMapping();
            }
        };
        rebindDownAction = new ToggleAction() {
            public void action() {
                attachNewDownMapping();
            }
        };
        rebindUpLeftAction = new ToggleAction() {
            public void action() {
                attachNewUpLeftMapping();
            }
        };
        rebindUpRightAction = new ToggleAction() {
            public void action() {
                attachNewUpRightMapping();
            }
        };
        rebindDownLeftAction = new ToggleAction() {
            public void action() {
                attachNewDownLeftMapping();
            }
        };
        rebindDownRightAction = new ToggleAction() {
            public void action() {
                attachNewDownRightMapping();
            }
        };
        rebindInventory = new ToggleAction() {
            public void action() {
                attachNewInventoryMapping();
            }
        };
        rebindSkills = new ToggleAction() {
            public void action() {
                attachNewSkillsMapping();
            }
        };
        rebindPause = new ToggleAction() {
            public void action() {
                attachNewPauseMapping();
            }
        };
        
        rebindAbilities = new ToggleAction[NUM_ABILITIES];
        for(int i = 0; i < NUM_ABILITIES; ++i) {
        	final int index = i;
        	rebindAbilities[i] = new ToggleAction() {
        		@Override
        		public void action() {
        			attachNewAbilityMapping(index);
        			System.out.println(index);
        		}
        	};
        }
    }

    public KeyPreferences getKeyPreferences() {
        return keyPreferences;
    }

    public Model getModel() {
        return model;
    }

    public void updateLayout(){
        layout.updateKeyText(this.getKeyPreferences());

    }
    public void setLayout(KeyBindingsLayout layout) {
        this.layout = layout;
        //Now that we've got a layout, set it
        this.updateLayout();
    }

    public void attachKeyMapping(KeyMapping mapper) {
        this.layout.setFocusable(true);
        this.layout.requestFocusInWindow();
        this.layout.addKeyListener(mapper);
    }

    public void removeKeyMapping(KeyMapping mapper) {
        this.layout.removeKeyListener(mapper);
    }
    //Add view updating after all of these, so call updateKeyText
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

    public void attachNewInventoryMapping() {
        KeyMapping mapping = new KeyMappingInventory(keyPreferences, this);
        attachKeyMapping(mapping);

    }

    public void attachNewSkillsMapping() {
        KeyMapping mapping = new KeyMappingSkills(keyPreferences, this);
        attachKeyMapping(mapping);

    }

    public void attachNewPauseMapping() {
        KeyMapping mapping = new KeyMappingPause(keyPreferences, this);
        attachKeyMapping(mapping);

    }

    public void attachNewAbilityMapping(int location) {
        KeyMapping mapping = new KeyMappingAbility(keyPreferences, this, location);
        attachKeyMapping(mapping);

    }

    public ToggleAction goBackAction() {
        return backAction;
    }

    @Override
    public void toggle() {
        // TODO Auto-generated method stub

    }

    public ToggleAction getRebindUpAction() {
        return rebindUpAction;
    }

    public ToggleAction getRebindDownAction() {
        return rebindDownAction;
    }

    public ToggleAction getRebindUpLeftAction() {
        return rebindUpLeftAction;
    }

    public ToggleAction getRebindUpRightAction() {
        return rebindUpRightAction;
    }

    public ToggleAction getRebindDownLeftAction() {
        return rebindDownLeftAction;
    }

    public ToggleAction getRebindDownRightAction() {
        return rebindDownRightAction;
    }

    public ToggleAction getBackAction() {
        return backAction;
    }

    public ToggleAction getRebindInventory() {
        return rebindInventory;
    }

    public ToggleAction getRebindSkills() {
        return rebindSkills;
    }

    public ToggleAction getRebindPause() {
        return rebindPause;
    }

    public ToggleAction getRebindAbility(int i) {
    	return rebindAbilities[i];
    }
}