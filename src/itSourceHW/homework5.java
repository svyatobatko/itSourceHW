//Book: id, ��������, ����� (�), ������������, ��� �������, ���������� ����-
//���, ����, ��� ���������.
//������� ������ ��������. �������:
//a) ������ ���� ��������� ������;
//b) ������ ����, ���������� �������� �������������;
//c) ������ ����, ���������� ����� ��������� ����.
package itSourceHW;

import itSourceHW.Book;
import itSourceHW.Bookbinding;
import java.util.Scanner;

public class homework5 {
	public static void main(String[] args) {
		
		Book[] book = new Book[10];
		book[0] = new Book(0, "����� ����� 1", "�����", "����", 2010, 307, Bookbinding.SOFT);
		book[1] = new Book(1, "����� ����� 2", "����", "�������", 2009, 258, Bookbinding.SOFT);
		book[2] = new Book(2, "����� ����� 3", "����", "�������", 2015, 563, Bookbinding.HARD);
		book[3] = new Book(3, "����� ����� 4", "����", "�����", 2006, 497, Bookbinding.HARD);
		book[4] = new Book(4, "����� ����� 5", "����", "����", 1995, 601, Bookbinding.HARD);
		book[5] = new Book(5, "����� ����� 6", "����", "������", 2017, 326, Bookbinding.SOFT);
		book[6] = new Book(6, "����� ����� 7", "����", "����", 2017, 454, Bookbinding.HARD);
		book[7] = new Book(7, "����� ����� 8", "����", "�������", 2001, 196, Bookbinding.SOFT);
		book[8] = new Book(8, "����� ����� 9", "�����", "����", 1992, 239, Bookbinding.SOFT);
		book[9] = new Book(9, "����� ����� 10", "����", "�����", 2008, 356, Bookbinding.HARD);

		Scanner sc = new Scanner(System.in);
		System.out.println("��������� ������� ������ ���� ��������� ������, "
				+ "���������� �������� �������������, ���������� ����� ��������� ����.");
		System.out.println("������� ������ �����");
		String varText = sc.nextLine();
		
		tableTitlePrint();

		for (int i = 0; i < book.length; i++) {
			book[i].compareWithAuthor(varText);
		}

		System.out.println("������� ������������ �����");
		varText = sc.nextLine();

		tableTitlePrint();
		for (int i = 0; i < book.length; i++) {
			book[i].compareWithPublisher(varText);
		}

		System.out.println("������� ���, ����������� ����� ����� ���������� ����� ��������� ����.");
		int varYear = sc.nextInt();
		
		tableTitlePrint();
		for (int i = 0; i < book.length; i++) {
			book[i].compareWithYear(varYear);
		}
		

	}
	
	public static void tableTitlePrint() {
		System.out.println("|ID �����|   ��������   |  �����  |������������|��� �������|���-�� �������|��������|");
		System.out.println("|--------|--------------|---------|------------|-----------|--------------|--------|");
	}
}

