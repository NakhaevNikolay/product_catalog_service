package org.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<User> listOfUsers = (ArrayList<User>) DBImitatiom.loadArrayList("src/main/resources/UsersDB");
		ArrayList<Merchandise> listOfMerchandises = (ArrayList<Merchandise>) DBImitatiom.loadArrayList("src/main/resources/DataBaseImitation");

		boolean flag = true;
		while (flag) {
			UserMenu.loginMenu();
			flag = UserMenu.menuLogin(listOfUsers, scanner);
		}

		flag = true;
		while (flag) {
			UserMenu.menuText();
			flag = UserMenu.menuButtons(listOfMerchandises,scanner);
		}

		DBImitatiom.saveArrayList(listOfMerchandises, "src/main/resources/DataBaseImitation");
		DBImitatiom.saveArrayList(listOfUsers, "src/main/resources/UsersDB");
		scanner.close();
	}
}