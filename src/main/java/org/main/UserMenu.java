package org.main;

import java.util.List;
import java.util.Scanner;

public class UserMenu {
	public static boolean menuButtons(List<Merchandise> listOfMerchandises, Scanner scanner) {
		boolean flag = true;
		int input = scanner.nextInt();
		scanner.nextLine();
		switch (input) {
			case 1:
				UserDisplay.userViewAddMerchandise(listOfMerchandises, scanner);
				break;
			case 2:
				UserDisplay.userViewDeleteMerchandise(listOfMerchandises, scanner);
				break;
			case 3:
				UserDisplay.userViewChangeMerchandise(listOfMerchandises, scanner);
				break;
			case 4:
				UserDisplay.userViewFindMerchandise(listOfMerchandises, scanner);
				break;
			case 100:
				UserDisplay.showAllMerchandises(listOfMerchandises);
				break;
			case 0:
				flag = false;
				break;
			default:
				System.out.println("Error");
				break;
		}
		return flag;
	}

	public static void menuText() {
		System.out.println("1) Добавить товар");
		System.out.println("2) Удалить товар");
		System.out.println("3) Изменить товар");
		System.out.println("4) Найти товар");
		System.out.println("100) Показать все товары");
		System.out.println("0) Выход");
	}
}
