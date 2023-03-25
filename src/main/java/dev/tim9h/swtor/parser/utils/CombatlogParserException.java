package dev.tim9h.swtor.parser.utils;

public class CombatlogParserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public enum Type {
		UNPARSABLE_COMBATLOG
	}

	private final Type type;

	public CombatlogParserException(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}

}
