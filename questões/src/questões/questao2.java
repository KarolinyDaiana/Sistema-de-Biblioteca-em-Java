package questões;

import java.util.Scanner;

import java.util.Random;

public class questao2 {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
		Random rd = new Random();

		int[] numeros = new int[10];
		int num = 0;

		for (int cont = 0; cont < 9; cont++) {

			numeros[cont] = rd.nextInt(30);
		}

		System.out.println("Digite o número desejado: ");
		num = leia.nextInt();

		for (int cont2 = 0; cont2 < 9; cont2++) {

			if (num == numeros[cont2]) {
				System.out.println("Este número está na sequência.");
				System.out.println("Está na posição " + cont2);
			} 
		}
	}

}
