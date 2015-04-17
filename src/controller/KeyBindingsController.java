package controller;

import java.awt.event.ActionListener;

import keyRemapping.KeyMapping;
import keyRemapping.KeyMappingDown;
import keyRemapping.KeyMappingDownLeft;
import keyRemapping.KeyMappingDownRight;
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
    private ToggleAction saveBindings;

    @SuppressWarnings("serial")
    public KeyBindingsController(Model model, KeyPreferences preferences) {
        this.model = model;
        this.keyPreferences = preferences;
        
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
        saveBindings = new ToggleAction() {
            public void action() {
                // TODO also save the bindings
                model.popState();
            }
        };

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

    public ActionListener getSaveAction() {
        return saveBindings;
    }
}