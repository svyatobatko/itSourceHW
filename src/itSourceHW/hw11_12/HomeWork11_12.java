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
		// хешмапа делается по названию товара (ключь) и количество в корзине (значение)
		Shop shop = new Shop();
		List<Ware> myWare = shop.getWare();
		shop.helloBuyer();
		Scanner sc = new Scanner(System.in);
		String shopCommand = new String();
		
		do {
			shopCommand = sc.nextLine();
//			System.out.println(shopCommand);
			
			switch (shopCommand) {
			case "add":
					addWareInConsole();
					myWare = shop.getWare();
				break;

			case "print":
					printWareInConsole(myWare);
				break;
				
			case "put":

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
	
	static void printWareInConsole(List<Ware> myWare) {
	
		System.out.print("|");
		System.out.printf("%5s", "Id |");
		System.out.printf("%20s", " Название |");
		System.out.printf("%10s", " Вес |");
		System.out.printf("%25s", " Размер |");
		System.out.printf("%10s", " Цена |");
		System.out.printf("%10s", " Кол-во |");
		System.out.println();
		for (Ware ware2 : myWare) {
			System.out.print("|");
			System.out.printf("%5s", ware2.getId() + " |");
			System.out.printf("%20s", ware2.getName()  + "|");
			System.out.printf("%10s", ware2.getWeight()  + " гр |");
			System.out.printf("%25s", ware2.getDimHeight() + 
					"x" + ware2.getDimWidth() + "x" + ware2.getDimDepth() + " мм |");
			System.out.printf("%10s", ware2.getPrice() + " $ |");
			System.out.printf("%10s", ware2.getQuantity() + "|");
			System.out.println();
		}

	}
	
	static void addWareInConsole () throws IOException {
		Shop shop = new Shop();
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
		//scWare.close();
	}
	
}
