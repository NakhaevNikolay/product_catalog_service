package org.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LoggerUtil {
	private static boolean init = false;

	static {
		initializeLogger();
	}

	public static void initializeLogger() {
		if (init) {
			return;
		}

		try (InputStream ins = getConfigInputStream()) {
			LogManager.getLogManager().readConfiguration(ins);
			init = true;
			getLogger(LoggerUtil.class).info("Логгер инициализирован");
		} catch (Exception e) {
			System.err.println("Ошибка инициализации логгера: " + e.getMessage());
			init = true;
		}
	}

	private static InputStream getConfigInputStream() throws FileNotFoundException {
		File configFile = new File("src/main/resources/logger.config");
		if (configFile.exists()) {
			return new FileInputStream(configFile);
		}

		InputStream ins = LoggerUtil.class.getClassLoader().getResourceAsStream("logger.config");

		if (ins != null) {
			return ins;
		}

		throw new FileNotFoundException("Файл конфигурации логгера не найден");
	}

	public static Logger getLogger(Class<?> clazz) {
		initializeLogger();
		return Logger.getLogger(clazz.getName());
	}

	public static Logger getLogger(String name) {
		initializeLogger();
		return Logger.getLogger(name);
	}
}
