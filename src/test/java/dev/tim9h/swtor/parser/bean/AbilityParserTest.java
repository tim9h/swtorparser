package dev.tim9h.swtor.parser.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AbilityParserTest {

	@Test
	void parseAbility() {
		var ability0 = new Ability("Advanced Kyrprax Versatile Stim {4256329770205184}");
		assertEquals("Advanced Kyrprax Versatile Stim", ability0.getAbility());
		assertEquals("4256329770205184", ability0.getAbilityId());

		var ability1 = new Ability("Looking for what's inside... {4281764566532096}");
		assertEquals("Looking for what's inside...", ability1.getAbility());
		assertEquals("4281764566532096", ability1.getAbilityId());

		var ability2 = new Ability("V-1 Seismic Grenade {1792156708634624}");
		assertEquals("V-1 Seismic Grenade", ability2.getAbility());
		assertEquals("1792156708634624", ability2.getAbilityId());
	}

	@Test
	void parseAbilityDetailed() {
		var ability0 = new Ability("Trauma (PVP) {632919265640448}");
		assertEquals("Trauma", ability0.getAbility());
		assertEquals("PVP", ability0.getAbility2());
		assertEquals("632919265640448", ability0.getAbilityId());

		var ability1 = new Ability("Crushed (Demolish) {3400617666019619}");
		assertEquals("Crushed", ability1.getAbility());
		assertEquals("Demolish", ability1.getAbility2());
		assertEquals("3400617666019619", ability1.getAbilityId());
	}

	@Test
	void parseUnknownAbility() {
		var ability = new Ability(" {3975030887153664}");
		assertEquals("3975030887153664", ability.getAbilityId());
	}

	@Test
	void parseEmptyAbility() {
		var ability = new Ability("");
		assertTrue(ability.isEmpty());
	}

}
