package dev.tim9h.swtor.parser.bean;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ability {

	private static final Pattern PATTERN = Pattern
			.compile("^(?:([a-zA-Z- '\\d\\.]+)(?: \\((.+)\\))? )?\\s?\\{(\\d+)}$");

	private static final Logger LOGGER = LogManager.getLogger(Ability.class);

	private String abilityName;

	private String ability2;

	private String abilityId;

	private boolean empty = false;

	public Ability(String ability) {
		if (StringUtils.isBlank(ability)) {
			empty = true;
		} else {
			var matcher = PATTERN.matcher(ability);
			if (matcher.find() && matcher.groupCount() == 3) {
				setAbility(matcher.group(1));
				setAbility2(matcher.group(2));
				setAbilityId(matcher.group(3));
			} else {
				LOGGER.warn(() -> "Unable to parse ability: " + ability);
			}
		}
	}

	public String getAbility() {
		return abilityName;
	}

	public void setAbility(String abilityName) {
		this.abilityName = abilityName;
	}

	public String getAbilityId() {
		return abilityId;
	}

	public void setAbilityId(String abilityId) {
		this.abilityId = abilityId;
	}

	public String getAbility2() {
		return ability2;
	}

	public void setAbility2(String ability2) {
		this.ability2 = ability2;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

	@Override
	public String toString() {
		if (empty) {
			return "Ability []";
		} else if (getAbility2() != null) {
			return "Ability [ability=" + abilityName + " (" + ability2 + ")]";
		} else {
			return "Ability [ability=" + abilityName + "]";
		}
	}
}
