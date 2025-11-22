package org.main;

import java.util.*;
import java.util.stream.Collectors;

public class MerchandiseOperations {

	public static boolean addMerchandise(String merchandiseName,
										 double merchandisePrice,
										 String merchandiseBrand,
										 double merchandiseWeight,
										 List<Merchandise> merchandises,
										 HashSet<Merchandise> merchandiseHash) {
		for (Merchandise merchandise : merchandises) {
			if (merchandise.getName().equals(merchandiseName)) {
				return false;
			}
		}
		Merchandise newMerchandise = new Merchandise(merchandiseName, merchandisePrice, merchandiseBrand, merchandiseWeight);
		merchandises.add(newMerchandise);
		merchandiseHash.add(newMerchandise); //add merchandise in cash
		return true;
	}

	/*
	* support method to find merchandise exactly by name
	 */
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
													HashSet<Merchandise> merchandiseHash,
													String name,
													String brand,
													Double minPrice,
													Double maxPrice) {
		//First check if it is in cash
		List<Merchandise> result = filterMerchandise(merchandiseHash, name, brand, minPrice, maxPrice);
		if (result.isEmpty()) {
			//if not search all DB
			result = filterMerchandise(merchandises, name, brand, minPrice, maxPrice);
			//and add it to cash
			merchandiseHash.addAll(result);
		}

		return result;
	}

	/*
	*support method to filter all DB or cash to find matching merchandises
	* input parameters must be null if user don't indicate them in his request
	 */
	private static List<Merchandise> filterMerchandise(Collection<Merchandise> collection,
													   String name,
													   String brand,
													   Double minPrice,
													   Double maxPrice) {
		return collection.stream()
				.filter(m -> name == null || m.getName().equals(name))
				.filter(m -> brand == null || m.getBrand().equals(brand))
				.filter(m -> minPrice == null || m.getPrice() >= minPrice)
				.filter(m -> maxPrice == null || m.getPrice() <= maxPrice)
				.collect(Collectors.toList());
	}

	public static boolean deleteMerchandise(String merchandiseName,
											List<Merchandise> merchandises,
											HashSet<Merchandise> merchandiseHash) {
		merchandiseHash.remove(findMerchandiseByName(merchandiseName, merchandises)); // Delete from cash
		return merchandises.remove(findMerchandiseByName(merchandiseName, merchandises));
	}

	public static void changeMerchandise(Merchandise merchandise, HashSet<Merchandise> merchandiseHash) {
		if (merchandise == null) {
			return;
		}

		merchandiseHash.remove(merchandise); //firstly delete it from cash

		System.out.println("Что вы хотите изменить?");
		System.out.println("1) Имя \n2) Брэнд \n3) Цену \n4) Вес");
		System.out.print("Введите цифру: ");
		Scanner scanner = new Scanner(System.in);

		int input = scanner.nextInt();
		scanner.nextLine();
		switch (input) {
			case 1:
				System.out.print("Введите новое имя: ");
				merchandise.setName(scanner.nextLine());
				break;
			case 2:
				System.out.print("Введите новый брэнд: ");
				merchandise.setBrand(scanner.nextLine());
				break;
			case 3:
				System.out.print("Введите новую цену: ");
				merchandise.setPrice(scanner.nextDouble());
				break;
			case 4:
				System.out.print("Введите новый вес: ");
				merchandise.setWeight(scanner.nextDouble());
				break;
		}

		merchandiseHash.add(merchandise); //add new version of merchendise to cash
	}
}
