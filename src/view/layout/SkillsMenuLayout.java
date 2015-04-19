package view.layout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.entity.Avatar;
import model.entity.EntityManager;
import model.skillmanager.SkillManager;
import model.skillmanager.SmasherSkillManager;
import model.skillmanager.SneakSkillManager;
import model.skillmanager.SummonerSkillManager;
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
		System.out.println(skillManager.getSkillPointsToSpend());
		skillPointsRemainingLabel.setText("Skill Points Left To Spend: " + skillManager.getSkillPointsToSpend());
	}
	
	private void refreshBindWoundLabel(SkillManager skillManager, TextLabel bindWoundLabel) {
		bindWoundLabel.setText("Bind Wound: " + skillManager.getBindWoundsSkill());
	}
	
	private void refreshBarterLabel(SkillManager skillManager, TextLabel barterLabel) {
		barterLabel.setText("Barter: " + skillManager.getBarterSkill());
	}

	private void refreshObserveLabel(SkillManager skillManager, TextLabel observeLabel) {
		observeLabel.setText("Observe: " + skillManager.getObserveSkill());
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
	
	private TextLabel initObserveLabel(SkillManager skillManager) {
		TextLabel observeLabel = new TextLabel();
		refreshObserveLabel(skillManager, observeLabel);
		add(observeLabel);
		return observeLabel;
	}
	
	private void initObserveButton(final SkillManager skillManager, final TextLabel observeLabel) {
		MenuButton observeButton = new MenuButton("+");
		observeButton.setColor(Color.GREEN);
		observeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				skillManager.incrementObserve();
				refreshObserveLabel(skillManager, observeLabel);
				refreshSkillPointsRemainingLabel(skillManager);
			}
			
		});
		add(observeButton);
		
	}	

	private void refreshTwoHandedLabel(SmasherSkillManager smasherSkillManager, TextLabel bindWoundLabel) {
		bindWoundLabel.setText("Two Handed: " + smasherSkillManager.getTwoHandedSkill());
	}
	
	private TextLabel initTwoHandedLabel(SmasherSkillManager smasherSkillManager) {
		TextLabel twoHandedLabel = new TextLabel();
		refreshTwoHandedLabel(smasherSkillManager, twoHandedLabel);
		add(twoHandedLabel);
		return twoHandedLabel;
	}
	
	private void initTwoHandedButton(final SmasherSkillManager smasherSkillManager, final TextLabel twoHandedLabel) {
		MenuButton twoHandedButton = new MenuButton("+");
		twoHandedButton.setColor(Color.GREEN);
		twoHandedButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				smasherSkillManager.incrementTwoHand();
				refreshTwoHandedLabel(smasherSkillManager, twoHandedLabel);
				refreshSkillPointsRemainingLabel(smasherSkillManager);
			}
			
		});
		add(twoHandedButton);
		
	}	

	private void refreshOneHandedLabel(SmasherSkillManager smasherSkillManager, TextLabel twoHandedLabel) {
		twoHandedLabel.setText("Two Handed: " + smasherSkillManager.getOneHandedSkill());
	}
	
	private TextLabel initOneHandedLabel(SmasherSkillManager smasherSkillManager) {
		TextLabel oneHandedLabel = new TextLabel();
		refreshOneHandedLabel(smasherSkillManager, oneHandedLabel);
		add(oneHandedLabel);
		return oneHandedLabel;
	}
	
	private void initOneHandedButton(final SmasherSkillManager smasherSkillManager, final TextLabel oneHandedLabel) {
		MenuButton oneHandedButton = new MenuButton("+");
		oneHandedButton.setColor(Color.GREEN);
		oneHandedButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				smasherSkillManager.incrementOneHand();
				refreshOneHandedLabel(smasherSkillManager, oneHandedLabel);
				refreshSkillPointsRemainingLabel(smasherSkillManager);
			}
			
		});
		add(oneHandedButton);
		
	}
	
	private void refreshBrawlLabel(SmasherSkillManager smasherSkillManager, TextLabel brawlLabel) {
		brawlLabel.setText("Brawl: " + smasherSkillManager.getBrawlSkill());
	}
	
	private TextLabel initBrawlLabel(SmasherSkillManager smasherSkillManager) {
		TextLabel brawlLabel = new TextLabel();
		refreshBrawlLabel(smasherSkillManager, brawlLabel);
		add(brawlLabel);
		return brawlLabel;
	}
	
	private void initBrawlButton(final SmasherSkillManager smasherSkillManager, final TextLabel brawlLabel) {
		MenuButton brawlButton = new MenuButton("+");
		brawlButton.setColor(Color.GREEN);
		brawlButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				smasherSkillManager.incrementBrawl();
				refreshBrawlLabel(smasherSkillManager, brawlLabel);
				refreshSkillPointsRemainingLabel(smasherSkillManager);
			}
			
		});
		add(brawlButton);
		
	}

	private void refreshPickPocketLabel(SneakSkillManager sneakSkillManager, TextLabel pickPocketLabel) {
		pickPocketLabel.setText("Pick Pocket: " + sneakSkillManager.getPickPocketSkill());
	}
	
	private TextLabel initPickPocketLabel(SneakSkillManager sneakSkillManager) {
		TextLabel pickPocketLabel = new TextLabel();
		refreshPickPocketLabel(sneakSkillManager, pickPocketLabel);
		add(pickPocketLabel);
		return pickPocketLabel;
	}
	
	private void initPickPocketButton(final SneakSkillManager sneakSkillManager, final TextLabel pickPocketLabel) {
		MenuButton pickPocketButton = new MenuButton("+");
		pickPocketButton.setColor(Color.GREEN);
		pickPocketButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				sneakSkillManager.incrementPickPocketSkill();
				refreshPickPocketLabel(sneakSkillManager, pickPocketLabel);
				refreshSkillPointsRemainingLabel(sneakSkillManager);
			}
			
		});
		add(pickPocketButton);
		
	}

	private void refreshDetectTrapLabel(SneakSkillManager sneakSkillManager, TextLabel detectTrapLabel) {
		detectTrapLabel.setText("Detect & Remove Trap: " + sneakSkillManager.getTrapRemoveSkill());
	}
	
	private TextLabel initDetectTrapLabel(SneakSkillManager sneakSkillManager) {
		TextLabel detectTrapLabel = new TextLabel();
		refreshDetectTrapLabel(sneakSkillManager, detectTrapLabel);
		add(detectTrapLabel);
		return detectTrapLabel;
	}
	
	private void initDetectTrapButton(final SneakSkillManager sneakSkillManager, final TextLabel detectTrapLabel) {
		MenuButton detectTrapButton = new MenuButton("+");
		detectTrapButton.setColor(Color.GREEN);
		detectTrapButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				sneakSkillManager.incrementTrapRemoveSkill();
				refreshDetectTrapLabel(sneakSkillManager, detectTrapLabel);
				refreshSkillPointsRemainingLabel(sneakSkillManager);
			}
			
		});
		add(detectTrapButton);
		
	}

	private void refreshCreepLabel(SneakSkillManager sneakSkillManager, TextLabel creepLabel) {
		creepLabel.setText("Creep: " + sneakSkillManager.getCreepskill());
	}
	
	private TextLabel initCreepLabel(SneakSkillManager sneakSkillManager) {
		TextLabel creepLabel = new TextLabel();
		refreshCreepLabel(sneakSkillManager, creepLabel);
		add(creepLabel);
		return creepLabel;
	}
	
	private void initCreepButton(final SneakSkillManager sneakSkillManager, final TextLabel creepLabel) {
		MenuButton creepButton = new MenuButton("+");
		creepButton.setColor(Color.GREEN);
		creepButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				sneakSkillManager.incrementCreepSkill();
				refreshCreepLabel(sneakSkillManager, creepLabel);
				refreshSkillPointsRemainingLabel(sneakSkillManager);
			}
			
		});
		add(creepButton);
		
	}

	private void refreshStaffLabel(SummonerSkillManager summonerSkillManager, TextLabel staffLabel) {
		staffLabel.setText("Staff: " + summonerSkillManager.getStaffSkill());
	}
	
	private TextLabel initStaffLabel(SummonerSkillManager summonerSkillManager) {
		TextLabel staffLabel = new TextLabel();
		refreshStaffLabel(summonerSkillManager, staffLabel);
		add(staffLabel);
		return staffLabel;
	}
	
	private void initStaffButton(final SummonerSkillManager summonerSkillManager, final TextLabel staffLabel) {
		MenuButton staffButton = new MenuButton("+");
		staffButton.setColor(Color.GREEN);
		staffButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				summonerSkillManager.incrementStaff();
				refreshStaffLabel(summonerSkillManager, staffLabel);
				refreshSkillPointsRemainingLabel(summonerSkillManager);
			}
			
		});
		add(staffButton);
		
	}

	private void refreshEnchantmentLabel(SummonerSkillManager summonerSkillManager, TextLabel enchantmentLabel) {
		enchantmentLabel.setText("Enchantment: " + summonerSkillManager.getEnchantSkill());
	}
	
	private TextLabel initEnchantmentLabel(SummonerSkillManager summonerSkillManager) {
		TextLabel enchantmentLabel = new TextLabel();
		refreshEnchantmentLabel(summonerSkillManager, enchantmentLabel);
		add(enchantmentLabel);
		return enchantmentLabel;
	}
	
	private void initEnchantmentButton(final SummonerSkillManager summonerSkillManager, final TextLabel enchantmentLabel) {
		MenuButton enchantmentButton = new MenuButton("+");
		enchantmentButton.setColor(Color.GREEN);
		enchantmentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				summonerSkillManager.incrementEnchant();
				refreshEnchantmentLabel(summonerSkillManager, enchantmentLabel);
				refreshSkillPointsRemainingLabel(summonerSkillManager);
			}
			
		});
		add(enchantmentButton);
		
	}

	private void refreshBoonLabel(SummonerSkillManager summonerSkillManager, TextLabel boonLabel) {
		boonLabel.setText("Boon: " + summonerSkillManager.getBoonSkill());
	}
	
	private TextLabel initBoonLabel(SummonerSkillManager summonerSkillManager) {
		TextLabel boonLabel = new TextLabel();
		refreshBoonLabel(summonerSkillManager, boonLabel);
		add(boonLabel);
		return boonLabel;
	}
	
	private void initBoonButton(final SummonerSkillManager summonerSkillManager, final TextLabel boonLabel) {
		MenuButton boonButton = new MenuButton("+");
		boonButton.setColor(Color.GREEN);
		boonButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				summonerSkillManager.incrementBoon();
				refreshBoonLabel(summonerSkillManager, boonLabel);
				refreshSkillPointsRemainingLabel(summonerSkillManager);
			}
			
		});
		add(boonButton);
		
	}
	
	private void refreshBaneLabel(SummonerSkillManager summonerSkillManager, TextLabel baneLabel) {
		baneLabel.setText("Bane: " + summonerSkillManager.getBaneSkill());
	}
	
	private TextLabel initBaneLabel(SummonerSkillManager summonerSkillManager) {
		TextLabel baneLabel = new TextLabel();
		refreshBaneLabel(summonerSkillManager, baneLabel);
		add(baneLabel);
		return baneLabel;
	}
	
	private void initBaneButton(final SummonerSkillManager summonerSkillManager, final TextLabel baneLabel) {
		MenuButton baneButton = new MenuButton("+");
		baneButton.setColor(Color.GREEN);
		baneButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				summonerSkillManager.incrementBane();
				refreshBaneLabel(summonerSkillManager, baneLabel);
				refreshSkillPointsRemainingLabel(summonerSkillManager);
			}
			
		});
		add(baneButton);
		
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
		TextLabel observeLabel = initObserveLabel(skillManager);
		initObserveButton(skillManager, observeLabel);
		
		// We don't what type of Skill Manager we have, so this
		// Will fill in the remaining Buttons for each skill.
		skillManager.accept(this);
	}

	public void attachController(SkillsMenuController controller) {   	
		backButton.addActionListener(controller.getBackAction());
	}

	public void populateSmasherSkills(SmasherSkillManager smasherSkillManager) {
		TextLabel twoHandedLabel = initTwoHandedLabel(smasherSkillManager);
		initTwoHandedButton(smasherSkillManager, twoHandedLabel);
		TextLabel oneHandedLabel = initOneHandedLabel(smasherSkillManager);
		initOneHandedButton(smasherSkillManager, oneHandedLabel);
		TextLabel brawlLabel = initBrawlLabel(smasherSkillManager);
		initBrawlButton(smasherSkillManager, brawlLabel);
	}

	public void populateSneakSkills(SneakSkillManager sneakSkillManager) {
		TextLabel pickPocketLabel = initPickPocketLabel(sneakSkillManager);
		initPickPocketButton(sneakSkillManager, pickPocketLabel);
		TextLabel detectTrapLabel = initDetectTrapLabel(sneakSkillManager);
		initDetectTrapButton(sneakSkillManager, detectTrapLabel);
		TextLabel creepLabel = initCreepLabel(sneakSkillManager);
		initCreepButton(sneakSkillManager, creepLabel);
	}

	public void populateSummonerSkills(SummonerSkillManager summonerSkillManager) {
		TextLabel enchantLabel = initEnchantmentLabel(summonerSkillManager);
		initEnchantmentButton(summonerSkillManager, enchantLabel);
		TextLabel baneLabel = initBaneLabel(summonerSkillManager);
		initBaneButton(summonerSkillManager, baneLabel);
		TextLabel boonLabel = initBoonLabel(summonerSkillManager);
		initBoonButton(summonerSkillManager, boonLabel);
		TextLabel staffLabel = initStaffLabel(summonerSkillManager);
		initStaffButton(summonerSkillManager, staffLabel);
	}
}
