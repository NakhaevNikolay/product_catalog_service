package org.main;

import java.io.Serializable;
import java.util.Objects;

public class Merchandise implements Serializable {
	private String name;
	private double price;
	private String brand;
	private double weight;

	public Merchandise(String name, double price, String brand, double weight) {
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void display() {
		System.out.println("--------------------");
		System.out.println("Товар " + name + "\nЦена " + price + "\nБрэнд " + brand + "\nВес " + weight);
		System.out.println("--------------------");
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Merchandise that = (Merchandise) o;
		return Double.compare(price, that.price) == 0 && Double.compare(weight, that.weight) == 0 && Objects.equals(name, that.name) && Objects.equals(brand, that.brand);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price, brand, weight);
	}
}
