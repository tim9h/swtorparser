module swtor.parser {
	exports dev.tim9h.swtor.parser;
	exports dev.tim9h.swtor.parser.bean;
	exports dev.tim9h.swtor.parser.utils;

	requires jPowerShell;
	requires java.desktop;
	requires org.apache.logging.log4j;
	requires org.apache.commons.lang3;
	requires com.google.guice;
	requires org.apache.commons.io;

	opens dev.tim9h.swtor.parser;
}