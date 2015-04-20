package model.entity;

import static org.junit.Assert.assertEquals;
import model.area.TileCoordinate;
import model.entity.behavior.npc.BarterBehavior;
import model.entity.behavior.npc.PetBehavior;

import org.junit.Test;

import view.entity.EntitySpriteFactory;
import view.entity.EntityView;
import factories.EntityFactory;

public class EntityFactoryTest {

	@Test
	public void testSummonerSave() {
		Avatar avatar = new Summoner("kyle", new EntityView(
				EntitySpriteFactory.getBaldySpriteHolder()),
				new TileCoordinate(5, 5));
		System.out.println(avatar.getStructuredMap());
		Avatar avatar2 = EntityFactory.createAvatar(avatar.getStructuredMap());
		assertEquals(avatar.getStructuredMap().getJson(), avatar2
				.getStructuredMap().getJson());

	}
	
	@Test
	public void testSmasherSave() {
		Avatar avatar = new Smasher("kyle", new EntityView(
				EntitySpriteFactory.getBaldySpriteHolder()),
				new TileCoordinate(5, 5));
		System.out.println(avatar.getStructuredMap());
		Avatar avatar2 = EntityFactory.createAvatar(avatar.getStructuredMap());
		assertEquals(avatar.getStructuredMap().getJson(), avatar2
				.getStructuredMap().getJson());

	}
	
	@Test
	public void testSneakSave() {
		Avatar avatar = new Sneak("kyle", new EntityView(
				EntitySpriteFactory.getBaldySpriteHolder()),
				new TileCoordinate(5, 5));
		System.out.println(avatar.getStructuredMap());
		Avatar avatar2 = EntityFactory.createAvatar(avatar.getStructuredMap());
		assertEquals(avatar.getStructuredMap().getJson(), avatar2
				.getStructuredMap().getJson());

	}
	
	@Test
	public void testNPCSave() {
		NPC avatar = new NPC("kyle", "barter", new EntityView(
				EntitySpriteFactory.getBaldySpriteHolder()),
				new TileCoordinate(5, 5), new BarterBehavior());
		System.out.println(avatar.getStructuredMap());
		NPC avatar2 = EntityFactory.createNPC(avatar.getStructuredMap());
		assertEquals(avatar.getStructuredMap().getJson(), avatar2
				.getStructuredMap().getJson());

	}
	
	@Test
	public void testPetSave() {
		NPC avatar = new NPC("kyle", "pet", new EntityView(
				EntitySpriteFactory.getBaldySpriteHolder()),
				new TileCoordinate(5, 5), new PetBehavior());
		System.out.println(avatar.getStructuredMap());
		NPC avatar2 = EntityFactory.createNPC(avatar.getStructuredMap());
		assertEquals(avatar.getStructuredMap().getJson(), avatar2
				.getStructuredMap().getJson());

	}
	
	@Test
	public void testMountSave() {
		NPC avatar = new Mount("kyle", new EntityView(
				EntitySpriteFactory.getBaldySpriteHolder()),
				new TileCoordinate(5, 5));
		System.out.println(avatar.getStructuredMap());
		NPC avatar2 = EntityFactory.createNPC(avatar.getStructuredMap());
		assertEquals(avatar.getStructuredMap().getJson(), avatar2
				.getStructuredMap().getJson());

	}

}
