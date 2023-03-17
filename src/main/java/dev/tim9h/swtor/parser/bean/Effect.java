package dev.tim9h.swtor.parser.bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Effect {

	private static final Logger LOGGER = LogManager.getLogger(Effect.class);

	private static final Pattern PATTERN = Pattern.compile(
			"^([a-zA-Z- ]+) \\{(\\d+)}(?:: ([a-zA-Z ]*) \\{(\\d+)})?(?: (.*) \\{(\\d*)\\}|\\/(.*) \\{(\\d*)\\})?");

	private String event;

	private String eventId;

	private String effectName;

	private String effectId;

	private boolean empty = false;

	private String area;

	private String areaId;

	private String difficulty;

	private String difficultyId;

	private String combatStyle;

	private String combatStyleId;

	private String discipline;

	private String disciplineId;

	public Effect(String effect) {
		if (StringUtils.isBlank(effect)) {
			empty = true;
		} else {
			var matcher = PATTERN.matcher(effect);
			if (matcher.find()) {
				if (matcher.group(7) != null && matcher.group(8) != null) {
					parseDisciplineEffect(matcher);
				} else if (matcher.group(5) != null && matcher.group(6) != null) {
					parseAreaEffect(matcher);
				} else {
					parseDefaultEffect(matcher);
				}
			} else {
				LOGGER.warn(() -> "Unable to parse effect: " + effect);
			}
		}
	}

	private void parseDisciplineEffect(Matcher matcher) {
		// DisciplineChanged {836045448953665}: Assassin {16141163438392504574}/Darkness
		// {2031339142381582}
		setEvent(matcher.group(1));
		setEventId(matcher.group(2));
		setCombatStyle(matcher.group(3));
		setCombatStyleId(matcher.group(4));
		setDiscipline(matcher.group(7));
		setDisciplineId(matcher.group(8));
	}

	private void parseAreaEffect(Matcher matcher) {
		// AreaEntered {836045448953664}: Valley of the Machine Gods {833571547775765} 8
		// Player Master {836045448953655}
		setEvent(matcher.group(1));
		setEventId((matcher.group(2)));
		setArea(matcher.group(3));
		setAreaId((matcher.group(4)));
		setDifficulty(matcher.group(5));
		setDifficultyId((matcher.group(6)));
	}

	private void parseDefaultEffect(Matcher matcher) {
		// Event {836045448945472}: AbilityActivate {836045448945479}
		var g1 = matcher.group(1);
		setEvent(g1);
		setEventId((matcher.group(2)));
		if ("AreaEntered".equals(g1)) {
			setArea(matcher.group(3));
			setAreaId(matcher.group(4));
		} else {
			setEffect(matcher.group(3));
			setEffectId(matcher.group(4));
		}
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEffect() {
		return effectName;
	}

	public void setEffect(String effectName) {
		this.effectName = effectName;
	}

	public String getEffectId() {
		return effectId;
	}

	public void setEffectId(String effectId) {
		this.effectId = effectId;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getDifficultyId() {
		return difficultyId;
	}

	public void setDifficultyId(String difficultyId) {
		this.difficultyId = difficultyId;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	public String getCombatStyle() {
		return combatStyle;
	}

	public void setCombatStyle(String combatStyle) {
		this.combatStyle = combatStyle;
	}

	public String getCombatStyleId() {
		return combatStyleId;
	}

	public void setCombatStyleId(String combatStyleId) {
		this.combatStyleId = combatStyleId;
	}

	public String getDiscipline() {
		return discipline;
	}

	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}

	public String getDisciplineId() {
		return disciplineId;
	}

	public void setDisciplineId(String disciplineId) {
		this.disciplineId = disciplineId;
	}

	@Override
	public String toString() {
		if (empty) {
			return "Effect []";
		} else if (effectName == null) {
			return "Effect [event=" + event + "]";
		} else {
			return "Effect [event=" + event + ", effectName=" + effectName + "]";
		}
	}

}
