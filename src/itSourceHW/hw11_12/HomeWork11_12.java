package itSourceHW.hw11_12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import itSourceHW.hw11_12.Shop;
import itSourceHW.hw11_12.Ware;

public class HomeWork11_12 {
	public static void main(String[] args) throws IOException {
		// создать кучу товаров
		// добавить интерфейс который добавляет в корзину (файл)
		// добавить работу с файлом из которого при старте вычитываются товары
		// добавить работу с файлом из которого вычитывается инфа по корзине
		// хешмапа делается по ID товара (ключь) и количество в корзине (значение)
		Shop shop = new Shop();
		List<Ware> myWare = shop.getWare();
		shop.helloBuyer();
		Scanner sc = new Scanner(System.in);
		String shopCommand = new String();
		
		do {
			shopCommand = sc.nextLine();
			
			switch (shopCommand) {
			case "add":
					addWareInConsole(shop);
				break;

			case "print":
					printWareInConsole(myWare, 1);
				break;
				
			case "put":
				putWareInConsole(shop);
				break;
			case "basket":
				System.out.println("Вы выбрали следующие товары: ");
				printWareInConsole(myWare, 2);
				break;
			case "buy":
				System.out.println("Вы совершили покупку");
				break;
			case "help":
					shop.helpBuyer();
				break;
			case "exit":
					System.out.println("До свидание, благодарим за интерес к нашему магазину");
				break;
			default:
				break;
			}
			
		} while (shopCommand.equals("exit") == false);
		
		sc.close();
	}
	
	static void printWareInConsole(List<Ware> myWare, int option) { // option = 1 for all; = 2 for put in basket
		int totalBasketPrice = 0;
		System.out.print("|");
		System.out.printf("%5s", "Id |");
		System.out.printf("%20s", " Название |");
		System.out.printf("%10s", " Вес |");
		System.out.printf("%25s", " Размер |");
		System.out.printf("%10s", " Цена |");
		System.out.printf("%10s", " Кол-во |");
		if (option == 2) {
			System.out.printf("%15s", " В корзине |");
		}
		System.out.println();
		for (Ware ware2 : myWare) {
			if (option == 1 || (option == 2 & ware2.getReserved() > 0)) {
				System.out.print("|");
				System.out.printf("%5s", ware2.getId() + " |");
				System.out.printf("%20s", ware2.getName()  + "|");
				System.out.printf("%10s", ware2.getWeight()  + " гр |");
				System.out.printf("%25s", ware2.getDimHeight() + 
						"x" + ware2.getDimWidth() + "x" + ware2.getDimDepth() + " мм |");
				System.out.printf("%10s", ware2.getPrice() + " $ |");
				System.out.printf("%10s", ware2.getQuantity() + "|");
			}
			if (option == 2 & ware2.getReserved() > 0) {
				System.out.printf("%15s", ware2.getReserved() + "|");
				totalBasketPrice += ware2.getReserved() * ware2.getPrice();
			}
			
			if (option == 1 || ware2.getReserved() > 0) {
				System.out.println();
			}
		}
		if (option == 2 && totalBasketPrice > 0) {
			System.out.println("Общая сумма товаров в корзине составляет: " + totalBasketPrice + " $");
		} else {
			System.out.println("Корзина еще пуста, выберети товар который планируете приобрести.");
		}

	}
	
	static void addWareInConsole (Shop shop) throws IOException {
		Scanner scWare = new Scanner(System.in);
		String newWare = new String();
		System.out.println("Для добавления товара введите его: Название, Вес, Ширина, Высота, Глубина, Кол-во, Цена. Все вводить через ; в одну строку.");
		newWare = scWare.nextLine();
		String[] newFild = newWare.split(";");
		if (newFild.length == 7) {
			shop.addWare(newWare);
		} else {
			System.out.println("Товар не добавлен, Вы не ввели все необходимые поля");
		}
//		scWare.close();
	}
	
	static void putWareInConsole (Shop shop) throws IOException {
		Scanner scWare = new Scanner(System.in);
		System.out.println("Для добавления товара в корзину, введите его Id.");
		int putWare = scWare.nextInt();
		shop.putWare(putWare);
		
//		scWare.close();
	}

}
