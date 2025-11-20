package org.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Merchandise> listOfMerchandises = DBImitatiom.loadArrayList("src/main/resources/DataBaseImitation");
		boolean flag = true;

		while (flag) {
			UserMenu.menuText();
			flag = UserMenu.menuButtons(listOfMerchandises,scanner);
		}

		DBImitatiom.saveArrayList(listOfMerchandises, "src/main/resources/DataBaseImitation");
		scanner.close();
	}
}