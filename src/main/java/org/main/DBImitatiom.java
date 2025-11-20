package org.main;

import java.io.*;
import java.util.ArrayList;

public class DBImitatiom {
	public static void saveArrayList(ArrayList<?> list, String filename) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(filename))) {
			oos.writeObject(list);
			System.out.println("Данные сохранены");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static ArrayList<?> loadArrayList(String filename) {
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(filename))) {
			return (ArrayList<?>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}
}
