package view.layout;

import java.awt.Color;
import java.awt.Dimension;

import model.entity.Avatar;
import model.entity.EntityManager;
import model.item.Item;
import view.components.MenuButton;
import view.components.TextLabel;
import controller.SkillsMenuController;

@SuppressWarnings("serial")
public class SkillsMenuLayout extends Layout {
	private MenuButton backButton;
	private TextLabel skills;

	public SkillsMenuLayout() {
		setPreferredSize(new Dimension(1024, 768));
		initLabels();
		addLabels();
		initButtons();
		addButtons();

	}

	private void initButtons() {
		backButton = new MenuButton("GO BACK");
		backButton.setColor(Color.CYAN);
	}

	private void initLabels(){
		
		skills = new TextLabel();
	}

	private void addButtons() {
		add(backButton);
	}

	private void addLabels(){
		add(skills);
	}
	
	public void updateLabelText(){
		StringBuilder stats = new StringBuilder();
		Avatar avatar = EntityManager.getSingleton().getAvatar();
		if(avatar == null){return;}
		stats.append(avatar.getBaseStats().toString());
		stats.append(" " + System.lineSeparator()+ " ");
		stats.append(avatar.getDerivedStats().toString());
		stats.append(" " + System.lineSeparator()+ " ");
		stats.append(avatar.toString());
		stats.append(" " + System.lineSeparator()+ " ");
		stats.append(" LIFE " + avatar.getDerivedStats().getCurrentHealth() + " MANA "
		+ avatar.getDerivedStats().getCurrentMana());
		stats.append("ITEMS:");
		for(Item i : avatar.getItems()){
			if(i==null){continue;}
			stats.append(i.getInfo());
			stats.append(" " + System.lineSeparator()+ " ");
		}
				
		skills.setText(stats.toString());
	}

	public void attachController(SkillsMenuController controller) {   	
		backButton.addActionListener(controller.getBackAction());
	}
}
