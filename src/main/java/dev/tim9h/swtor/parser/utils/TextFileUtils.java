package dev.tim9h.swtor.parser.utils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

import com.google.inject.ImplementedBy;

//@ImplementedBy(TextFileUtilsPS.class)
@ImplementedBy(TextFileUtilsCommons.class)
@FunctionalInterface
public interface TextFileUtils {

	public List<String> tail(File file, long linecount, Charset charset);

	public default void close() {
	}

}
