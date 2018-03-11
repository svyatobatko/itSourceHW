//Book: id, Название, Автор (ы), Издательство, Год издания, Количество стра-
//ниц, Цена, Тип переплета.
//Создать массив объектов. Вывести:
//a) список книг заданного автора;
//b) список книг, выпущенных заданным издательством;
//c) список книг, выпущенных после заданного года.
package itSourceHW;

import itSourceHW.Book;
import itSourceHW.Bookbinding;
import java.util.Scanner;

public class homework5 {
	public static void main(String[] args) {
		
		Book[] book = new Book[10];
		book[0] = new Book(0, "Умная книга 1", "Ольга", "Киев", 2010, 307, Bookbinding.SOFT);
		book[1] = new Book(1, "Умная книга 2", "Петя", "Харьков", 2009, 258, Bookbinding.SOFT);
		book[2] = new Book(2, "Умная книга 3", "Иван", "Харьков", 2015, 563, Bookbinding.HARD);
		book[3] = new Book(3, "Умная книга 4", "Вася", "Львов", 2006, 497, Bookbinding.HARD);
		book[4] = new Book(4, "Умная книга 5", "Петя", "Киев", 1995, 601, Bookbinding.HARD);
		book[5] = new Book(5, "Умная книга 6", "Иван", "Одесса", 2017, 326, Bookbinding.SOFT);
		book[6] = new Book(6, "Умная книга 7", "Вася", "Киев", 2017, 454, Bookbinding.HARD);
		book[7] = new Book(7, "Умная книга 8", "Петя", "Харьков", 2001, 196, Bookbinding.SOFT);
		book[8] = new Book(8, "Умная книга 9", "Ольга", "Киев", 1992, 239, Bookbinding.SOFT);
		book[9] = new Book(9, "Умная книга 10", "Вася", "Львов", 2008, 356, Bookbinding.HARD);

		Scanner sc = new Scanner(System.in);
		System.out.println("Программа выводит список книг заданного автора, "
				+ "выпущенных заданным издательством, выпущенных после заданного года.");
		System.out.println("Введите автора книги");
		String varText = sc.nextLine();
		
		tableTitlePrint();

		for (int i = 0; i < book.length; i++) {
			book[i].compareWithAuthor(varText);
		}

		System.out.println("Введите издательство книги");
		varText = sc.nextLine();

		tableTitlePrint();
		for (int i = 0; i < book.length; i++) {
			book[i].compareWithPublisher(varText);
		}

		System.out.println("Введите год, результатом будут книги выпущенные после заданного года.");
		int varYear = sc.nextInt();
		
		tableTitlePrint();
		for (int i = 0; i < book.length; i++) {
			book[i].compareWithYear(varYear);
		}
		

	}
	
	public static void tableTitlePrint() {
		System.out.println("|ID книги|   Название   |  Автор  |Издательство|Год издания|Кол-во страниц|Переплет|");
		System.out.println("|--------|--------------|---------|------------|-----------|--------------|--------|");
	}
}

