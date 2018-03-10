package itSourceHW;

import java.util.Scanner;

public class homework4 {

	public static void main(String[] args) {
		
		// задание 0 - ¬ывод ѕи
		System.out.println("ћетод, который выводит на экран число пи 5 раз.");
		FormatPI();
		
		// задание 1 - написать метод, который принимает массив целых чисел и возвращает максимальное
		int[] arr1 = new int[10];
		int maxArr1;
		System.out.println("ѕрограмма вызывает метод, который принимает массив целых чисел и возвращает максимальное");
		System.out.println("массив целых чисел:");
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = (int) (Math.random() * 100);
			System.out.print(arr1[i] + "\t");
		}
		System.out.println();
		maxArr1 = getMaxInt(arr1);
		System.out.println("максимальное число в массиве: " + maxArr1);
		System.out.println();
		
		// задание 2 - написать метод, который рисует пр€моугольник из плюсиков. 
		// ¬ходными параметрами будут два числа - ширина и высота
		Scanner sc = new Scanner(System.in);
		System.out.println("ѕрограмма вызывает метод, который рисует пр€моугольник из плюсиков.");
		System.out.println("¬ведите ширину пр€моугольника (в символах)");
		int varWidth = sc.nextInt();
		System.out.println("¬ведите высоту пр€моугольника (в символах)");
		int varHeight = sc.nextInt();
		rectangle(varWidth, varHeight);

		// задание 3 - релизовать метод, который вернет количество слов в строке текста
		Scanner sc1 = new Scanner(System.in);
		System.out.println("ѕрограмма вызывает метод, который вернет количество слов в строке текста.");
		System.out.println("¬ведите текст");
		String varText = sc1.nextLine();
		int numWord;
		numWord = getNumWord(varText);
		System.out.println(" оличество слов в тексте: " + numWord);
	}
	
	//метод, который принимает массив целых чисел и возвращает максимальное
	public static int getMaxInt(int[] arr) {
		int maxInt = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (maxInt<arr[i]) {
				maxInt = arr[i];
			} 
		}
		return maxInt;
	}
	
	//метод, который рисует пр€моугольник из плюсиков.
	public static void rectangle(int width, int height) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if ((i==0) || (i==(height-1)) || ((j==0) || (j==(width-1)))) {
					System.out.print("+");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
	
	//метод, который вернет количество слов в строке текста
	public static int getNumWord(String inputText) {
		int numWord = 1;
		for (int i = 1; i < (inputText.length() - 1); i++) {
			//  онтроль пробелов, добавлено условие отсекающие 2 и более пробелов между слов,
			// а так же не учитываютс€ пробелы в начале и конце строки
			// не добавлен учет знаков припинани€ (можно улучшать....)
			if (((inputText.charAt(i) == ' ') & (inputText.charAt(i-1) != ' ') & (inputText.charAt(i+1) != ' '))) {
				numWord += 1;
			} 
		}
		return numWord;
		// второй вариант!
		// return inputText.split("\\s").lenght;
	}

	//метод, который выводит на экран число пи 5 раз. 
	//¬ каждой строке разное количество знак после зап€той. 
	//¬ первой строке - 1, в последней - 5.
	public static void FormatPI() {
		for (int i = 1; i <= 5; i++) {
			System.out.printf("%." + i + "f", Math.PI);
			System.out.println(" Pi с количеством знаков после зап€той = " + i);
		}
		System.out.println();
	}


}
