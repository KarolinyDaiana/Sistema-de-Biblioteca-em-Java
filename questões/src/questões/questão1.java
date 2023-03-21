package questões;

import java.util.Scanner;

public class questão1 {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int[] numero = new int[10 + 1], aux = new int[10 + 1];

		for (int cont = 1; cont <= 10; cont++) {

			System.out.println("Digite um número:");
			numero[cont] = leia.nextInt();

			aux[cont] = numero[cont];
		}
		
		for(int cont2 = 0; cont2 < numero.length / 2; cont2++) {
			int j = numero[cont2];
			numero[cont2] = numero[numero.length - cont2 - 1];
			numero[numero.length - cont2 - 1] = j;
			
		}

		for (int cont3 = 0; cont3 < 10; cont3++) {
			System.out.println(numero[cont3]);
		}

	}

}
