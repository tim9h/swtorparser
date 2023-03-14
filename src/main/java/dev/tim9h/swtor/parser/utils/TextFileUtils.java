package dev.tim9h.swtor.parser.utils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

//@ImplementedBy(TextFileUtilsPS.class)
//@ImplementedBy(TextFileUtilsCommons.class)
public interface TextFileUtils {

	public List<String> tail(File file, long linecount, Charset charset);

	public default void close() {
	}

}
