package dev.tim9h.swtor.parser.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EffectParserTest {

	@Test
	void parseEmptyEffect() {
		var effect = new Effect("");
		assertTrue(effect.isEmpty());
	}

	@Test
	void parseEmpty() {
		var effect0 = new Effect("Event {836045448945472}: AbilityActivate {836045448945479}");
		assertFalse(effect0.isEmpty());
		assertEquals("Event", effect0.getEvent());
		assertEquals("836045448945472", effect0.getEventId());
		assertEquals("AbilityActivate", effect0.getEffect());
		assertEquals("836045448945479", effect0.getEffectId());

		var effect1 = new Effect("ApplyEffect {836045448945477}: Intercede {1984695797547008}");
		assertFalse(effect1.isEmpty());
		assertEquals("ApplyEffect", effect1.getEvent());
		assertEquals("836045448945477", effect1.getEventId());
		assertEquals("Intercede", effect1.getEffect());
		assertEquals("1984695797547008", effect1.getEffectId());

		var effect2 = new Effect("RemoveEffect {836045448945478}: Channel Hatred {807733024522240}");
		assertFalse(effect1.isEmpty());
		assertEquals("RemoveEffect", effect2.getEvent());
		assertEquals("836045448945478", effect2.getEventId());
		assertEquals("Channel Hatred", effect2.getEffect());
		assertEquals("807733024522240", effect2.getEffectId());
	}

	@Test
	void testDisciplineChanged() {
		var effect = new Effect(
				"DisciplineChanged {836045448953665}: Assassin {16141163438392504574}/Darkness {2031339142381582}");
		assertFalse(effect.isEmpty());
		assertEquals("DisciplineChanged", effect.getEvent());
		assertEquals("836045448953665", effect.getEventId());
		assertEquals("Assassin", effect.getCombatStyle());
		assertEquals("16141163438392504574", effect.getCombatStyleId());
		assertEquals("Darkness", effect.getDiscipline());
		assertEquals("2031339142381582", effect.getDisciplineId());
	}

	@Test
	void testAreaEntered() {
		var effect0 = new Effect(
				"AreaEntered {836045448953664}: Valley of the Machine Gods {833571547775765} 8 Player Master {836045448953655}");
		assertFalse(effect0.isEmpty());
		assertEquals("AreaEntered", effect0.getEvent());
		assertEquals("836045448953664", effect0.getEventId());
		assertEquals("Valley of the Machine Gods", effect0.getArea());
		assertEquals("833571547775765", effect0.getAreaId());
		assertEquals("8 Player Master", effect0.getDifficulty());
		assertEquals("836045448953655", effect0.getDifficultyId());

		var effect1 = new Effect("AreaEntered {836045448953664}: Imperial Fleet {137438989504}");
		assertFalse(effect0.isEmpty());
		assertEquals("AreaEntered", effect1.getEvent());
		assertEquals("836045448953664", effect1.getEventId());
		assertEquals("Imperial Fleet", effect1.getArea());
		assertEquals("137438989504", effect1.getAreaId());
		assertNull(effect1.getDifficulty());
		assertNull(effect1.getDifficultyId());
	}

}
