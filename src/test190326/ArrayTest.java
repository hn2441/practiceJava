package test190326;

import java.util.Scanner;

public class ArrayTest {
	
	Scanner sc = new Scanner(System.in);
	String[][] seat = new String[5][10];
	int[][] check = new int[5][10];
	
	public ArrayTest() {
//		twoD();
		while(true) {
			menu();
			System.out.println();
		}
	}
	
	public void twoD() {
		int[][] a = new int[5][10];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print("��");
			}
			System.out.println();
		}
	}
	
	public void menu() {
		System.out.println("===============================");
		theater();
		System.out.println("===============================");
		System.out.println("1.����\t2.�������\t3.Ȯ��\t0.����");
		System.out.print("������ �Ͻðڽ��ϱ�(�����Է�)>>");
		int input = sc.nextInt();
		switch (input) {
		case 1:	//����
			book(1);
			break;
		case 2:	//���
			book(0);
			break;
		case 3:	//Ȯ��
			theater();
			break;
		case 0:	//����
			System.out.println("����");
			System.exit(0);
			break;
		default:
			System.out.println("�߸����Է�");
			break;
		}
	}
	
	public void theater() {
		for (int i = 0; i < seat.length; i++) {
			for (int j = 0; j < seat[0].length; j++) {
				char a = (char)('A'+i);
				System.out.print(a);
				System.out.print(j);
				System.out.print("[");
				if(check[i][j]==0) {
					System.out.print("��");
				}else {
					System.out.print("��");
				}
				System.out.print("]");
				System.out.print("\t");
			}
			System.out.println();
		}
	}
	
	public String bookHelper(int input) {
		if(input == 0) {	//���� ��� ���
			return "�������";	
		}else {				//���� ���� ���
			return "����";
		}
	}
	
	public void book(int input) {
		String word = bookHelper(input);
		System.out.print(word+"���¼�>>");
		String seat = sc.next();
		int a = (int)((seat.charAt(0)+"").toUpperCase().charAt(0)-'A');
		int b = Integer.parseInt(seat.charAt(1)+"");
		if(check[a][b]==input) {
			System.out.println(word+"����");
		}else {
			check[a][b]=input;
			System.out.println(word+"����");
		}
	}
	
	public static void main(String[] args) {
		new ArrayTest();
	}

}
