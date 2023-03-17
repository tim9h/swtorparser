package dev.tim9h.swtor.parser.utils;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.profesorfalken.jpowershell.PowerShell;

public class TextFileUtilsPS implements TextFileUtils {

	private static final Logger LOGGER = LogManager.getLogger(TextFileUtilsPS.class);

	private PowerShell ps;

	@Override
	public List<String> tail(File file, long linecount, Charset charset) {
		var response = getPowerShell()
				.executeCommand(String.format("Get-Content \"%s\" -Tail %d", file.toString(), Long.valueOf(linecount)));
		var output = response.getCommandOutput();
		if (StringUtils.isBlank(output)) {
			return Collections.emptyList();
		} else {
			return Arrays.asList(output.split("\r\n"));
		}
	}

	private PowerShell getPowerShell() {
		if (ps == null) {
			ps = PowerShell.openSession();
			LOGGER.debug(() -> "PowerShell session started");
		}
		return ps;
	}

	@Override
	public void close() {
		if (ps != null) {
			ps.close();
			ps = null;
			LOGGER.debug(() -> "PowerShell session terminated");
		}
	}

}
