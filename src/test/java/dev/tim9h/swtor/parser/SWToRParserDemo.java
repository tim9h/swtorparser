package dev.tim9h.swtor.parser;

import org.apache.commons.lang3.StringUtils;

import com.google.inject.Guice;
import com.google.inject.Inject;

import dev.tim9h.swtor.parser.bean.CombatLog;

public class SWToRParserDemo {

	@Inject
	private CombatLogWatcher watcher;

	public static void main(String[] args) {
		var injector = Guice.createInjector(new ParserModule());
		var parser = new SWToRParserDemo();
		injector.injectMembers(parser);
		parser.parse();
	}

	private void parse() {
		watcher.startWatching(this::acceptLog);
	}

	private void acceptLog(CombatLog log) {
		if ("AreaEntered".equals(log.getEffect().getEvent()) && StringUtils.isNotBlank(log.getEffect().getArea())) {
			System.out.println(log.getEffect().getArea());
		}
	}

}
