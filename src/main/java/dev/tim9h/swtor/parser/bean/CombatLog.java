package dev.tim9h.swtor.parser.bean;

import java.time.LocalTime;

public class CombatLog {

	private LocalTime timestamp;

	private Entity source;

	private Entity target;

	private Ability ability;

	private Effect effect;

	private String misc;

	private String version;

	public CombatLog(String timestamp, String source, String target, String ability, String effect, String misc,
			String version) {
		super();
		setTimestamp(timestamp);
		setSource(source);
		setTarget(target);
		setAbility(ability);
		setEffect(effect);
		setMisc(misc);
		setVersion(version);
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
