package itSourceHW.hw8;

import java.io.File;
import java.util.Scanner;

public class homework8 {
	public static void main(String[] args) {
		System.out.println("Будет произведен поиск файлов с расширением .java");
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Введите глубину поиска :");
		int depthPath = sc1.nextInt();
		System.out.println("Введите путь начала поиска :");
		String varPath = sc2.nextLine();
		System.out.println("поиск...");
		
		
		
		sc1.close();
		sc2.close();
	}
	
	public void search (File file, int counter) {
		if (file.isDirectory()) {
			File[] listFiles = file.listFiles();
			
			for (File file2 : listFiles) {
				search (file2, counter);
			}
		} else {
			++counter;
		}
	}
}

