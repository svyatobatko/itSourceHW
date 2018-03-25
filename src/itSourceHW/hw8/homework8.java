package itSourceHW.hw8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class homework8 {

	public static int counter = 0;

	public static void main(String[] args) throws IOException {
		System.out.println("Будет произведен поиск файлов с расширением .java");
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		System.out.println("Введите путь начала поиска *.java файлов:");
		String varPath = sc2.nextLine();
		System.out.println("поиск...");
		Path startPath = Paths.get(varPath);
		File startFile = new File(varPath);
		
		System.out.println("= подсчет количества файлов *.java с помощью рекурсивного метода =");
		
		int quantityJava = countJavaFileMethod(startFile, ".java");
		System.out.println("количество файлов *.java :" + quantityJava);
		
		System.out.println("Введите глубину поиска, для вывода файлов *.java :");
		int depthPath = sc1.nextInt();
		System.out.println("= с помощью Files.find =========================================");
		
		try (Stream<Path> stream = Files.find(startPath, depthPath, (path, attr) -> {
			return String.valueOf(path).endsWith(".java");
		}))	
		{
			String joined = stream.sorted().map(String::valueOf).collect(Collectors.joining("; "));
			System.out.println("Found: " + joined);
		}

		sc1.close();
		sc2.close();
	}
	
	public static int countJavaFileMethod(File file, String extension) {
//		int counter;
//		System.out.println(file.isDirectory());
		if (file.isDirectory()) {
			File[] listFilesAll = file.listFiles();
			File[] listFilesJava = file.listFiles(pathname -> pathname.getName().endsWith(extension));
//			System.out.println(listFilesJava.length + " " + counter);
			if (listFilesJava.length > 0) {
				counter += listFilesJava.length;
			} 
			for (File file2 : listFilesAll) {
				countJavaFileMethod(file2, extension);
			}
		} 
		return counter;
	}

}

