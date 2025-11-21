package org.main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.main.MerchandiseOperations.*;

public class UserDisplay {
	public static void userViewAddMerchandise(List<Merchandise> merchandises, Scanner scanner, User currentUser) {
		String name;
		String brand;
		double weight;
		double price;

		System.out.print("Введите имя: ");
		name = scanner.nextLine();
		System.out.print("Введите брэнд: ");
		brand = scanner.nextLine();
		System.out.print("Введите вес: ");
		try {
			weight = scanner.nextDouble();
		} catch (Exception e) {
			System.out.println("Невозможное значение!");
			scanner.nextLine();
			return;
		}
		System.out.print("Введите цену: ");
		try {
			price = scanner.nextDouble();
		} catch (Exception e) {
			System.out.println("Невозможное значение!");
			scanner.nextLine();
			return;
		}
		System.out.println("------------");
		scanner.nextLine();

		if(!addMerchandise(name,price, brand, weight, merchandises)){
			System.out.println("Товар уже существует!");
		} else {
			LogWriter.appendToFile("src/main/resources/userLog", " добавил товар " + name, currentUser);
			System.out.println("Товар успешно добавлен!");
		}
	}

	public static void userViewFindMerchandise(List<Merchandise> merchandises, Scanner scanner) {
		Double maxPrice = null;
		Double minPrice = null;
		String name = null;
		String brand = null;
		int n = 0;
		searchMenuText();
		String input = scanner.nextLine();
		int[] numArr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
		for (int num : numArr) {
			if (num == 1) {
				System.out.println("Введите имя: ");
				name = scanner.nextLine();
				n++;
			}
			if (num == 2) {
				System.out.println("Введите бренд: ");
				brand = scanner.nextLine();
				n++;
			}
			if (num == 3) {
				System.out.println("Введите минимальную цену: ");
				minPrice = scanner.nextDouble();
				System.out.println("Введите максимальную цену: ");
				maxPrice = scanner.nextDouble();
				n++;
			}
		}
		if (n == 0) {
			System.out.println("Ошибка ввода!");
			return;
		}
		List<Merchandise> merchandisesLookingFor = MerchandiseOperations.findMerchandise(merchandises, name, brand, minPrice, maxPrice);

		if(!merchandisesLookingFor.isEmpty()){
			System.out.println("Искомые товары: ");
			for(Merchandise merchandise : merchandisesLookingFor){
				merchandise.display();
			}
		} else {
			System.out.println("Товар не найден!");
		}
	}

	public static void userViewDeleteMerchandise(List<Merchandise> merchandises, Scanner scanner, User currentUser) {
		System.out.print("Введите имя товара, который хотите удалить: ");
		String name = scanner.nextLine();

		if(deleteMerchandise(name, merchandises)){
			System.out.println("Товар успешно удалён!");
			LogWriter.appendToFile("src/main/resources/userLog", " удалил товар " + name, currentUser);
		}
	}

	public static void userViewChangeMerchandise(List<Merchandise> merchandises, Scanner scanner, User currentUser) {
		System.out.print("Введите имя товара, который хотите изменить: ");
		String name = scanner.nextLine();

		changeMerchandise(findMerchandiseByName(name,merchandises));
		LogWriter.appendToFile("src/main/resources/userLog", " изменил товар " + name,  currentUser);
	}

	public static void showAllMerchandises(List<Merchandise> merchandises) {
		System.out.println("Все товары: ");
		for(Merchandise merchandise : merchandises){
			merchandise.display();
		}
	}

	public static void searchMenuText() {
		System.out.println("Задайте параметры фильтрации: ");
		System.out.println("1) Имя товара");
		System.out.println("2) Бренд товара");
		System.out.println("3) Цена товара");
	}
}
