package model.entity;

import static org.junit.Assert.*;
import model.area.TileCoordinate;

import org.junit.Test;

import view.EntitySpriteFactory;
import view.EntityView;
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
		NPC avatar = new NPC("kyle", new EntityView(
				EntitySpriteFactory.getBaldySpriteHolder()),
				new TileCoordinate(5, 5));
		System.out.println(avatar.getStructuredMap());
		NPC avatar2 = EntityFactory.createNPC(avatar.getStructuredMap());
		assertEquals(avatar.getStructuredMap().getJson(), avatar2
				.getStructuredMap().getJson());

	}
	
	@Test
	public void testPetSave() {
		NPC avatar = new Pet("kyle", new EntityView(
				EntitySpriteFactory.getBaldySpriteHolder()),
				new TileCoordinate(5, 5));
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
