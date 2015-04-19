package view.layout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entity.Avatar;
import model.entity.EntityManager;
import model.skillmanager.SkillManager;
import view.components.MenuButton;
import view.components.TextLabel;
import controller.SkillsMenuController;

@SuppressWarnings("serial")
public class SkillsMenuLayout extends Layout {
	private MenuButton backButton;
	private TextLabel skillsLabel;
	private TextLabel statsLabel;
	private TextLabel skillPointsRemainingLabel;

	public SkillsMenuLayout() {
		initStatsLabels();
		generateStatsLabelText();
		addStatsLabels();
		addSkillPointInterface();
		initButtons();
		addButtons();
	}

	private void initButtons() {
		backButton = new MenuButton("GO BACK");
		backButton.setColor(Color.CYAN);
	}

	private void initStatsLabels(){
		statsLabel = new TextLabel();
		skillsLabel = new TextLabel();
	}

	private void addButtons() {
		add(backButton);
	}

	private void addStatsLabels(){
		add(statsLabel);
		add(skillsLabel);
	}
	
	public void generateStatsLabelText(){
		// Stats Label
		StringBuilder builder = new StringBuilder();
		Avatar avatar = EntityManager.getSingleton().getAvatar();

		if(avatar == null){return;}
		builder.append("<html>");
		builder.append(avatar.getDerivedStats().toString().replaceAll("\\n", "<br>"));
		builder.append("</html>");

		statsLabel.setText(builder.toString());
	}
	
	private void refreshSkillPointsRemainingLabel(SkillManager skillManager) {
		skillPointsRemainingLabel.setText("Skill Points Left To Spend: " + skillManager.getSkillPointsToSpend());
	}
	
	private void refreshBindWoundLabel(SkillManager skillManager, TextLabel bindWoundLabel) {
		bindWoundLabel.setText("Bind Wound: " + skillManager.getBindWoundsSkill());
	}
	
	private void refreshBarterLabel(SkillManager skillManager, TextLabel barterLabel) {
		barterLabel.setText("Barter: " + skillManager.getBarterSkill());
	}

	private void initSkillPointsRemainingLabel(SkillManager skillManager) {
		TextLabel skillPointsRemainingLabel = new TextLabel();
		this.skillPointsRemainingLabel = skillPointsRemainingLabel;
		refreshSkillPointsRemainingLabel(skillManager);
		add(skillPointsRemainingLabel);
	}
	
	private TextLabel initBindWoundLabel(SkillManager skillManager) {
		TextLabel bindWoundLabel = new TextLabel();
		refreshBindWoundLabel(skillManager, bindWoundLabel);
		add(bindWoundLabel);
		return bindWoundLabel;
	}
	
	private void initBindWoundButton(final SkillManager skillManager, final TextLabel bindWoundLabel) {
		MenuButton bindWoundButton = new MenuButton("+");
		bindWoundButton.setColor(Color.GREEN);
		bindWoundButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				skillManager.incrementBindWound();
				refreshBindWoundLabel(skillManager, bindWoundLabel);
				refreshSkillPointsRemainingLabel(skillManager);
			}
			
		});
		add(bindWoundButton);
		
	}
	
	private TextLabel initBarterLabel(SkillManager skillManager) {
		TextLabel barterLabel = new TextLabel();
		refreshBarterLabel(skillManager, barterLabel);
		add(barterLabel);
		return barterLabel;
	}
	
	private void initBarterButton(final SkillManager skillManager, final TextLabel barterLabel) {
		MenuButton barterButton = new MenuButton("+");
		barterButton.setColor(Color.GREEN);
		barterButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				skillManager.incrementBarter();
				refreshBarterLabel(skillManager, barterLabel);
				refreshSkillPointsRemainingLabel(skillManager);
			}
			
		});
		add(barterButton);
		
	}
	
	private void addSkillPointInterface() {
		final Avatar avatar = EntityManager.getSingleton().getAvatar();
		if(avatar == null){return;}

		final SkillManager skillManager = avatar.getSkillManager();
		initSkillPointsRemainingLabel(skillManager);
		TextLabel bindWoundLabel = initBindWoundLabel(skillManager);
		initBindWoundButton(skillManager, bindWoundLabel);
		TextLabel barterLabel = initBarterLabel(skillManager);
		initBarterButton(skillManager, barterLabel);
		//TextLabel observeLabel = initObserveLabel(skillManager);

		// For the Occupation Specific Skills
		//skillManager.accept(this);
		
		/*
		bindWoundTextLabel.setText("Bind Wound: " + avatar.getBindWoundSkill());
		MenuButton incrementBindWoundButton = new MenuButton("+");
		incrementBindWoundButton.setColor(Color.GREEN);
		incrementBindWoundButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				skillManager.incrementBindWound();
				bindWoundTextLabel.setText("Bind Wound: " + avatar.getBindWoundSkill());
				refreshSkillPointsRemainingLabel(skillManager);
			}
		});
		add(skillPointsRemainingLabel);
		add(bindWoundTextLabel);
		add(incrementBindWoundButton);
		*/
	}

	public void attachController(SkillsMenuController controller) {   	
		backButton.addActionListener(controller.getBackAction());
	}
}
