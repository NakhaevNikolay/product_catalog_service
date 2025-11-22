package org.main;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.*;

public class Main {
	static final Logger LOGGER = LoggerUtil.getLogger(Main.class);

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<User> listOfUsers = (ArrayList<User>) DBImitatiom.loadArrayList("src/main/resources/usersDB");
		ArrayList<Merchandise> listOfMerchandises = (ArrayList<Merchandise>) DBImitatiom.loadArrayList("src/main/resources/dataBaseImitation");
		User currentUser = new User("admin","admin");

		boolean flag = true;
		while (flag) {
			UserMenu.loginMenu();
			currentUser = UserMenu.menuLogin(listOfUsers, scanner);

			if (!currentUser.getNickName().equals("admin")) {
				flag = false;
			}
		}

		flag = true;
		while (flag) {
			UserMenu.menuText();
			flag = UserMenu.menuButtons(listOfMerchandises,scanner, currentUser);
		}

		DBImitatiom.saveArrayList(listOfMerchandises, "src/main/resources/dataBaseImitation");
		DBImitatiom.saveArrayList(listOfUsers, "src/main/resources/usersDB");
		scanner.close();
	}
}