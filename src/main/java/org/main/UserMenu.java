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

	public static boolean menuLogin(List<User> listOfUsers, Scanner scanner) {
		boolean flag = true;
		boolean n = false;
		String nickName;
		String password;
		int input = scanner.nextInt();
		scanner.nextLine();

		switch (input) {
			case 1:
				System.out.print("Введите логин: ");
				nickName = scanner.nextLine();
				System.out.print("Введите пароль: ");
				password = scanner.nextLine();
				for (User user : listOfUsers) {
					if (user.getPassword().equals(password) && user.getNickName().equals(nickName)) {
						System.out.println("Авторизация успешна!");
						flag = false;
						break;
					}
				}
				if (flag) {
					System.out.println("Ошибка!");
				}
				break;
			case 2:
				System.out.print("Придумайте логин: ");
				nickName = scanner.nextLine();
				for (User user : listOfUsers) {
					if (user.getNickName().equals(nickName)) {
						System.out.println("Такой логин уже существует!");
						n =  true;
						break;
					}
				}
				if (n) {break;}
				System.out.print("Придумайте пароль: ");
				password = scanner.nextLine();
				System.out.print("Повторите пароль: ");
				String password1 = scanner.nextLine();
				if (!password.equals(password1)) {
					System.out.println("Ошибка! Пароли не одинаковы!");
					break;
				}
				listOfUsers.add(new User(nickName, password));
				flag = false;
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

	public static void loginMenu() {
		System.out.println("Вы уже имеете аккаунт?");
		System.out.println("1) Да");
		System.out.println("2) Нет, зарегистрироваться");
	}
}
