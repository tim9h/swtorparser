package dev.tim9h.swtor.parser.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.input.ReversedLinesFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextFileUtilsCommons implements TextFileUtils {

	private static final Logger LOGGER = LogManager.getLogger(TextFileUtilsCommons.class);

	@Override
	public List<String> tail(File file, long linecount, Charset charset) {
		try (var reader = new ReversedLinesFileReader(file, charset)) {
			var list = reader.readLines((int) linecount);
			Collections.reverse(list);
			return list;
		} catch (IllegalArgumentException | IOException e) {
			// new combat file started
			try (var reader = new ReversedLinesFileReader(file, charset)) {
				return Arrays.asList(reader.readLine());
			} catch (Exception ex) {
				LOGGER.warn(() -> "Unable to read line", e);
				return Collections.emptyList();
			}
		}
	}

}
