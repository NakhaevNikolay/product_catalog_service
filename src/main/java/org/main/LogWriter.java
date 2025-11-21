package org.main;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

public class LogWriter {
	public static void appendToFile(String filename, String operation, User currentUser) {
		try (FileWriter writer = new FileWriter(filename, true)) {
			String content = "Пользователь " + currentUser.getNickName() + operation + " " + Instant.now();
			writer.write(content + "\n");
		} catch (IOException e) {
			System.out.println("Ошибка записи: " + e.getMessage());
		}
	}
}
