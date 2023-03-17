package dev.tim9h.swtor.parser;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Inject;

import dev.tim9h.swtor.parser.bean.CombatLog;

public class SWToRParserDemo {

	private static final Logger logger = LogManager.getLogger(SWToRParserDemo.class);

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
			logger.info(() -> String.format("%s entered %s", log.getSource().getName(), log.getEffect().getArea()));
		}
	}

}
