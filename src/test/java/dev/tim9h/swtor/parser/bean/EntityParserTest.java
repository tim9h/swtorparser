package dev.tim9h.swtor.parser.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class EntityParserTest {

	private static final float FLOAT_DELTA = 0.001f;

	@Test
	void parsePlayerEntity() {
		var entity = new Entity("@Player'æâäß-ø#688563013365069|(4641.86,4695.99,710.02,-90.94)|(122477/122477)");
		assertTrue(entity.isPlayer());
		assertEquals("Player'æâäß-ø", entity.getName());
		assertEquals("688563013365069", entity.getId());
		assertEquals(4641.86, entity.getCoordX(), FLOAT_DELTA);
		assertEquals(4695.99, entity.getCoordY(), FLOAT_DELTA);
		assertEquals(710.02, entity.getCoordA(), FLOAT_DELTA);
		assertEquals(-90.94, entity.getCoordB(), FLOAT_DELTA);
		assertEquals(122477, entity.getValue0());
		assertEquals(122477, entity.getValue1());
	}

	@Test
	void parseNpcEntity() {
		var entity = new Entity(
				"Hyde {4626684800139264}:113850000006986|(-4565.34,-4549.61,694.02,105.17)|(10440/10440)");
		assertFalse(entity.isPlayer());
		assertEquals("Hyde", entity.getName());
		assertEquals("4626684800139264", entity.getId());
		assertEquals("113850000006986", entity.getId2());
		assertEquals(-4565.34, entity.getCoordX(), FLOAT_DELTA);
		assertEquals(-4549.61, entity.getCoordY(), FLOAT_DELTA);
		assertEquals(694.02, entity.getCoordA(), FLOAT_DELTA);
		assertEquals(105.17, entity.getCoordB(), FLOAT_DELTA);
		assertEquals(10440, entity.getValue0());
		assertEquals(10440, entity.getValue1());
	}

	@Test
	void parsePlayerCompanionEntity() {
		var entity = new Entity(
				"@Moskova#688563013365069/Shae Vizla {3916370223824896}:120098004112697|(4640.54,4702.38,710.22,-3.36)|(292261/292261)");
		assertTrue(entity.isPlayer());
		assertEquals("Moskova", entity.getName());
		assertEquals("688563013365069", entity.getId());
		assertEquals("Shae Vizla", entity.getCompanion());
		assertEquals("3916370223824896", entity.getCompanionId());
		assertEquals("120098004112697", entity.getCompanionId2());
		assertEquals(4640.54, entity.getCoordX(), FLOAT_DELTA);
		assertEquals(4702.38, entity.getCoordY(), FLOAT_DELTA);
		assertEquals(710.22, entity.getCoordA(), FLOAT_DELTA);
		assertEquals(-3.36, entity.getCoordB(), FLOAT_DELTA);
		assertEquals(292261, entity.getValue0());
		assertEquals(292261, entity.getValue1());
	}

	@Test
	void parseUnknownEntity() {
		var entity = new Entity("{3313047577821184}:121085000751202|(0.02,-786.91,9.02,-0.00)|(1209062/1209062)");
		assertFalse(entity.isPlayer());
		assertNull(entity.getName());
		assertEquals("3313047577821184", entity.getId());
		assertEquals("121085000751202", entity.getId2());
		assertEquals(0.02, entity.getCoordX(), FLOAT_DELTA);
		assertEquals(-786.91, entity.getCoordY(), FLOAT_DELTA);
		assertEquals(9.02, entity.getCoordA(), FLOAT_DELTA);
		assertEquals(-0.00, entity.getCoordB(), FLOAT_DELTA);
		assertEquals(1209062, entity.getValue0());
		assertEquals(1209062, entity.getValue1());
	}

	@Test
	void parseEqualEntity() {
		var entity = new Entity("=");
		assertTrue(entity.isEquals());
	}

	@Test
	void parseEmptyEntity() {
		var entity = new Entity("");
		assertTrue(entity.isEmpty());
	}

}
