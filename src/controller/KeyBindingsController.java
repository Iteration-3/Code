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
import view.layout.Layout;
import controller.listener.ToggleAction;

public class KeyBindingsController extends Controller {
    private KeyPreferences keyPreferences;
    private Layout layout;
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
    private ToggleAction rebindAbility1;
    private ToggleAction rebindAbility2;
    private ToggleAction rebindAbility3;
    private ToggleAction rebindAbility4;
    private ToggleAction rebindAbility5;
    private ToggleAction rebindAbility6;
    private ToggleAction rebindAbility7;
    private ToggleAction rebindAbility8;
    private ToggleAction rebindAbility9;
    private ToggleAction rebindAbility0;

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
        rebindAbility1 = new ToggleAction() {
            public void action() {
                attachNewAbilityMapping(1);
            }
        };
        rebindAbility2 = new ToggleAction() {
            public void action() {
                attachNewAbilityMapping(2);
            }
        };
        rebindAbility3 = new ToggleAction() {
            public void action() {
                attachNewAbilityMapping(3);
            }
        };
        rebindAbility4 = new ToggleAction() {
            public void action() {
                attachNewAbilityMapping(4);
            }
        };
        rebindAbility5 = new ToggleAction() {
            public void action() {
                attachNewAbilityMapping(5);
            }
        };
        rebindAbility6 = new ToggleAction() {
            public void action() {
                attachNewAbilityMapping(6);
            }
        };
        rebindAbility7 = new ToggleAction() {
            public void action() {
                attachNewAbilityMapping(7);
            }
        };
        rebindAbility8 = new ToggleAction() {
            public void action() {
                attachNewAbilityMapping(8);
            }
        };
        rebindAbility9 = new ToggleAction() {
            public void action() {
                attachNewAbilityMapping(9);
            }
        };
        rebindAbility0 = new ToggleAction() {
            public void action() {
                attachNewAbilityMapping(0);
            }
        };
    }

    public KeyPreferences getKeyPreferences() {
        return keyPreferences;
    }

    public Model getModel() {
        return model;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public void attachKeyMapping(KeyMapping mapper) {
        this.layout.setFocusable(true);
        this.layout.requestFocusInWindow();
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

    public ToggleAction getRebindAbility1() {
        return rebindAbility1;
    }

    public ToggleAction getRebindAbility2() {
        return rebindAbility2;
    }

    public ToggleAction getRebindAbility3() {
        return rebindAbility3;
    }

    public ToggleAction getRebindAbility4() {
        return rebindAbility4;
    }

    public ToggleAction getRebindAbility5() {
        return rebindAbility5;
    }

    public ToggleAction getRebindAbility6() {
        return rebindAbility6;
    }

    public ToggleAction getRebindAbility7() {
        return rebindAbility7;
    }

    public ToggleAction getRebindAbility8() {
        return rebindAbility8;
    }

    public ToggleAction getRebindAbility9() {
        return rebindAbility9;
    }

    public ToggleAction getRebindAbility0() {
        return rebindAbility0;
    }

}