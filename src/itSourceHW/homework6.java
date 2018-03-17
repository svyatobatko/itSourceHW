package itSourceHW;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import itSourceHW.hw6.Sweets;
import itSourceHW.hw6.sweets.Candies;
import itSourceHW.hw6.sweets.candies.Caramel;
import itSourceHW.hw6.sweets.candies.Chocolate;
import itSourceHW.hw6.sweets.candies.Lollipop;

public class homework6 {
	public static void main(final String[] args) {
	
		// arrays of candies parameters
		String[] sweetNameArr = {"Чупачупс", "Петушок", "Красный мак", "Шоколадный заяц", "Карамелька"};
		int[] sweetWeightArr = {25, 50, 20, 18, 30};
		int[] sweetSugarArr = {15, 45, 5, 5, 9};
		int[] sweetCaloriesArr = {75, 200, 89, 95, 115};
		String[] sweetColorArr = {"Красный", "Оранжевый", "Коричневый", "Черный", "Коричневый"};
		String[] sweetManufacturerArr = {"Фирма 1", "Бабушка", "Фирма 1", "Фирма 2", "Фирма 2"};
		String[][] sweetCompositionArr = new String[5][];
		String[] sweetCompositionArr1 = {"Сахар", "Вкусовой сироп", "Ароматизатор"};
		String[] sweetCompositionArr2 = {"Сахар", "Вкусовой сироп"};
		String[] sweetCompositionArr3 = {"Сахар", "Шоколад"};
		String[] sweetCompositionArr4 = {"Сахар", "Шоколад", "Арахис"};
		String[] sweetCompositionArr5 = {"Сахар", "Карамель", "Ароматизатор"};
		sweetCompositionArr[0] = sweetCompositionArr1;
		sweetCompositionArr[1] = sweetCompositionArr2;
		sweetCompositionArr[2] = sweetCompositionArr3;
		sweetCompositionArr[3] = sweetCompositionArr4;
		sweetCompositionArr[4] = sweetCompositionArr5;
		
		int[] sweetTransparencyArr = {50, 30};
		String[] sweetTypeOfChocolateArr = {"молочный", "черный"};
		int ductility = 50;
		
		Lollipop[] candiesLollipop = {new Lollipop(), new Lollipop()};
		Chocolate[] candiesChocolate = {new Chocolate(), new Chocolate()};
		Caramel candiesCaramel = new Caramel();
		Sweets[] candies = {candiesLollipop[0], candiesLollipop[1], 
				candiesChocolate[0], candiesChocolate[1], candiesCaramel};
		
		for (int i = 0; i < candies.length; i++) {
			candies[i].setSweetName(sweetNameArr[i]);
			candies[i].setWeight(sweetWeightArr[i]);
			candies[i].setSugar(sweetSugarArr[i]);
			candies[i].setCalories(sweetCaloriesArr[i]);
			candies[i].setManufacturer(sweetManufacturerArr[i]);
			candies[i].setComposition(sweetCompositionArr[i]);
		}
		candiesLollipop[0].setColor(sweetColorArr[0]);
		candiesLollipop[1].setColor(sweetColorArr[1]);
		candiesChocolate[0].setColor(sweetColorArr[2]);
		candiesChocolate[1].setColor(sweetColorArr[3]);
		candiesCaramel.setColor(sweetColorArr[4]);
		
		candiesLollipop[0].setTransparency(sweetTransparencyArr[0]);
		candiesLollipop[1].setTransparency(sweetTransparencyArr[1]);
		candiesChocolate[0].setTypeOfChocolate(sweetTypeOfChocolateArr[0]);
		candiesChocolate[1].setTypeOfChocolate(sweetTypeOfChocolateArr[1]);
		candiesCaramel.setDuctility(ductility);
		
		Scanner sc = new Scanner(System.in);
		int[] candiesQuantity = new int[5];
		System.out.println("Есть следующие конфеты:");
		
		for (int i = 0; i < candies.length; i++) {
			System.out.print("|" + (i+1) + "|" + candies[i].getSweetName());
		}
		System.out.println("|");
		System.out.println("Какие и сколько конфет вы хотите положить в подарок?");
		
		int weightNewYearGift = 0;
		for (int j = 0; j < candies.length; j++) {
			System.out.println("Введите сколько положить конфет " + (j+1) + "го типа");
			candiesQuantity[j] = sc.nextInt();
			weightNewYearGift += candiesQuantity[j]*candies[j].getWeight();
			if (candiesQuantity[j] > 0) {
				candies[j].setQuantity(candiesQuantity[j]);
			}
		}
		
		System.out.println("Вес новогоднего подарка будет равен: " + weightNewYearGift + " грамм");
		System.out.println();
		
		System.out.println("Задайте диапазон содержания сахора, "
				+ "и конфеты с содержанием сахара в этом диапазоне, "
				+ "которые есть в подарке будут выведены.");
		System.out.println("Введите минимальное значение содержания сахара:");
		int minSugar = sc.nextInt();
		System.out.println("Введите максимальное значение содержания сахара:");
		int maxSugar = sc.nextInt();
		
		Stream<Sweets> candiesStream1 = Stream.of(candies);
		candiesStream1
					.filter(s -> s.getSugar() > minSugar)
					.filter(s -> s.getSugar() < maxSugar)
					.filter(s -> s.getQuantity() > 0)
					.forEach(s->System.out.println(s.getSweetName() + 
							" - содержит сахара: " + s.getSugar() + " грамм"));

		System.out.println();
//		System.out.println("Конфеты которые находятся в подарке, "
//				+ "отсортированные по калорийности:");
//		
//		Stream<Sweets> candiesStream2 = Stream.of(candies);
//		candiesStream2
//					.filter(ss -> ss.getQuantity() > 0)
//					.forEach(ss->System.out.println(ss.getSweetName()));
		
		
		sc.close();
				
	}
}
