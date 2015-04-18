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
	private TextLabel skillsLabel;
	private TextLabel statsLabel;

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
		statsLabel = new TextLabel();
		skillsLabel = new TextLabel();
	}

	private void addButtons() {
		add(backButton);
	}

	private void addLabels(){
		add(statsLabel);
		add(skillsLabel);
	}
	
	public void generateLabelText(){
		// Stats Label
		StringBuilder builder = new StringBuilder();
		Avatar avatar = EntityManager.getSingleton().getAvatar();

		if(avatar == null){return;}
		builder.append("<html>");
		builder.append(avatar.getDerivedStats().toString().replaceAll("\\n", "<br>"));
		builder.append("<br>");
		builder.append("ITEMS:<br>");
		for(Item i : avatar.getItems()){
			if(i==null){continue;}
			builder.append(i.toString());
			builder.append("<br>");
		}
		builder.append("</html>");

		statsLabel.setText(builder.toString());

		builder.setLength(0); // Clear the StringBuilder
		
		// Skills Label
		builder.append("<html>");

	}

	public void attachController(SkillsMenuController controller) {   	
		backButton.addActionListener(controller.getBackAction());
	}
}
