package org.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Merchandise> listOfMerchandises = new ArrayList<>();
		boolean flag = true;

		while (flag) {
			UserMenu.menuText();
			flag = UserMenu.menuButtons(listOfMerchandises,scanner);
		}

		scanner.close();
	}
}