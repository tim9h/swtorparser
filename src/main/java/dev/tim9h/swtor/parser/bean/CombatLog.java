package dev.tim9h.swtor.parser.bean;

import java.time.LocalTime;
import java.util.regex.Pattern;

import dev.tim9h.swtor.parser.utils.CombatlogParserException;
import dev.tim9h.swtor.parser.utils.CombatlogParserException.Type;

public class CombatLog {

	private static final Pattern PATTERN = Pattern
			.compile("^\\[(.+)\\] \\[(.*)\\] \\[(.*)\\] \\[(.*)\\] \\[(.*)\\](?: \\((.*)\\))?(?: <(.*)>)?$");

	private LocalTime timestamp;

	private Entity source;

	private Entity target;

	private Ability ability;

	private Effect effect;

	private String misc;

	private String version;

	public CombatLog(String log) throws CombatlogParserException {
		var matcher = PATTERN.matcher(log);
		if (matcher.find() && matcher.groupCount() >= 7) {
			setTimestamp(matcher.group(1));
			setSource(matcher.group(2));
			setTarget(matcher.group(3));
			setAbility(matcher.group(4));
			setEffect(matcher.group(5));
			setMisc(matcher.group(6));
			setVersion(matcher.group(7));
		} else {
			throw new CombatlogParserException(Type.UNPARSABLE_COMBATLOG);
		}
	}

	public LocalTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = LocalTime.parse(timestamp);
	}

	public Entity getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = new Entity(source);
	}

	public Entity getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = new Entity(target);
	}

	public Ability getAbility() {
		return ability;
	}

	public void setAbility(String ability) {
		this.ability = new Ability(ability);
	}

	public Effect getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = new Effect(effect);
	}

	public String getMisc() {
		return misc;
	}

	public void setMisc(String misc) {
		this.misc = misc;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "CombatLog [timestamp=" + timestamp + ", source=" + source + ", target=" + target + ", " + ability + ", "
				+ effect + "]";
	}

}
