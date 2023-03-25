package dev.tim9h.swtor.parser.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class CombatLogParserTest {

	@Test
	void parseCombatLogTest() {
		var log = new CombatLog(
				"[23:06:15.025] [@Playername#689144335813939|(941.37,1.68,193.07,-88.64)|(122551/122551)] [=] [Wings of the Architect {3349133893042176}] [ApplyEffect {836045448945477}: Wings of the Architect {3349133893042176}]");
		assertEquals(LocalTime.of(23, 6, 15, 25000000), log.getTimestamp());
		assertNotNull(log.getSource());
		assertTrue(log.getTarget().isEquals());
		assertNotNull(log.getAbility());
		assertNotNull(log.getEffect());
		assertNull(log.getMisc());
		assertNull(log.getVersion());
	}

	@Test
	void parseCombatLogDetailsTest() {
		var log = new CombatLog(
				"[23:02:25.465] [@Playername#689144335813939|(895.13,4.72,192.82,109.65)|(1/121770)] [] [] [AreaEntered {836045448953664}: Imperial Fleet {137438989504}] (he4001) <v7.0.0b>");
		assertEquals(LocalTime.of(23, 2, 25, 465000000), log.getTimestamp());
		assertEquals("he4001", log.getMisc());
		assertEquals("v7.0.0b", log.getVersion());
		assertNotNull(log.getSource());
		assertTrue(log.getTarget().isEmpty());
		assertTrue(log.getAbility().isEmpty());
		assertNotNull(log.getEffect());
	}

}
