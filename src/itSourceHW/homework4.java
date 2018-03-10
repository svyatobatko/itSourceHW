package itSourceHW;

import java.util.Scanner;

public class homework4 {

	public static void main(String[] args) {
		
		// ������� 0 - ����� ��
		System.out.println("�����, ������� ������� �� ����� ����� �� 5 ���.");
		FormatPI();
		
		// ������� 1 - �������� �����, ������� ��������� ������ ����� ����� � ���������� ������������
		int[] arr1 = new int[10];
		int maxArr1;
		System.out.println("��������� �������� �����, ������� ��������� ������ ����� ����� � ���������� ������������");
		System.out.println("������ ����� �����:");
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = (int) (Math.random() * 100);
			System.out.print(arr1[i] + "\t");
		}
		System.out.println();
		maxArr1 = getMaxInt(arr1);
		System.out.println("������������ ����� � �������: " + maxArr1);
		System.out.println();
		
		// ������� 2 - �������� �����, ������� ������ ������������� �� ��������. 
		// �������� ����������� ����� ��� ����� - ������ � ������
		Scanner sc = new Scanner(System.in);
		System.out.println("��������� �������� �����, ������� ������ ������������� �� ��������.");
		System.out.println("������� ������ �������������� (� ��������)");
		int varWidth = sc.nextInt();
		System.out.println("������� ������ �������������� (� ��������)");
		int varHeight = sc.nextInt();
		rectangle(varWidth, varHeight);

		// ������� 3 - ���������� �����, ������� ������ ���������� ���� � ������ ������
		Scanner sc1 = new Scanner(System.in);
		System.out.println("��������� �������� �����, ������� ������ ���������� ���� � ������ ������.");
		System.out.println("������� �����");
		String varText = sc1.nextLine();
		int numWord;
		numWord = getNumWord(varText);
		System.out.println("���������� ���� � ������: " + numWord);
	}
	
	//�����, ������� ��������� ������ ����� ����� � ���������� ������������
	public static int getMaxInt(int[] arr) {
		int maxInt = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (maxInt<arr[i]) {
				maxInt = arr[i];
			} 
		}
		return maxInt;
	}
	
	//�����, ������� ������ ������������� �� ��������.
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
	
	//�����, ������� ������ ���������� ���� � ������ ������
	public static int getNumWord(String inputText) {
		int numWord = 1;
		for (int i = 1; i < (inputText.length() - 1); i++) {
			// �������� ��������, ��������� ������� ���������� 2 � ����� �������� ����� ����,
			// � ��� �� �� ����������� ������� � ������ � ����� ������
			// �� �������� ���� ������ ���������� (����� ��������....)
			if (((inputText.charAt(i) == ' ') & (inputText.charAt(i-1) != ' ') & (inputText.charAt(i+1) != ' '))) {
				numWord += 1;
			} 
		}
		return numWord;
		// ������ �������!
		// return inputText.split("\\s").lenght;
	}

	//�����, ������� ������� �� ����� ����� �� 5 ���. 
	//� ������ ������ ������ ���������� ���� ����� �������. 
	//� ������ ������ - 1, � ��������� - 5.
	public static void FormatPI() {
		for (int i = 1; i <= 5; i++) {
			System.out.printf("%." + i + "f", Math.PI);
			System.out.println(" Pi � ����������� ������ ����� ������� = " + i);
		}
		System.out.println();
	}


}
