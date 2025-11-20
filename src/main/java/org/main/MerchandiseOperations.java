package org.main;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MerchandiseOperations {

	public static boolean addMerchandise(String merchandiseName,
										 double merchandisePrice,
										 String merchandiseBrand,
										 double merchandiseWeight,
										 List<Merchandise> merchandises) {
		for (Merchandise merchandise : merchandises) {
			if (merchandise.getName().equals(merchandiseName)) {
				return false;
			}
		}
		merchandises.add(new Merchandise(merchandiseName, merchandisePrice, merchandiseBrand, merchandiseWeight));
		return true;
	}

	public static Merchandise findMerchandiseByName(String merchandiseName, List<Merchandise> merchandises) {
		for (Merchandise merchandise : merchandises) {
			if (merchandise.getName().equals(merchandiseName)) {
				return merchandise;
			}
		}
		System.out.println("Товар не найден");
		return null;
	}

	public static List<Merchandise> findMerchandise(List<Merchandise> merchandises,
													String name,
													String brand,
													Double minPrice,
													Double maxPrice) {
		return merchandises.stream()
				.filter(m -> name == null || m.getName().equals(name))
				.filter(m -> brand == null || m.getBrand().equals(brand))
				.filter(m -> minPrice == null || m.getPrice() >= minPrice)
				.filter(m -> maxPrice == null || m.getPrice() <= maxPrice)
				.collect(Collectors.toList());
	}

	public static boolean deleteMerchandise(String merchandiseName, List<Merchandise> merchandises) {
		return merchandises.remove(findMerchandiseByName(merchandiseName, merchandises));
	}

	public static void changeMerchandise(Merchandise merchandise) {
		if (merchandise == null) {
			return;
		}

		System.out.println("Что вы хотите изменить?");
		System.out.println("1) Имя \n2) Брэнд \n3) Цену \n4) Вес");
		System.out.print("Введите цифру: ");
		Scanner scanner = new Scanner(System.in);

		int input = scanner.nextInt();
		scanner.nextLine();
		switch (input) {
			case 1:
				System.out.print("Введите новое имя: ");
				String merchandiseName = scanner.nextLine();
				merchandise.setName(merchandiseName);
				break;
			case 2:
				System.out.print("Введите новый брэнд: ");
				String merchandiseBrand = scanner.nextLine();
				merchandise.setBrand(merchandiseBrand);
				break;
			case 3:
				System.out.print("Введите новую цену: ");
				double merchandisePrice = scanner.nextDouble();
				merchandise.setPrice(merchandisePrice);
				break;
			case 4:
				System.out.print("Введите новый вес: ");
				double merchandiseWeight = scanner.nextDouble();
				merchandise.setWeight(merchandiseWeight);
				break;
		}
	}
}
