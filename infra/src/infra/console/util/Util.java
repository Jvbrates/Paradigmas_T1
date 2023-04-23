package infra.console.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Util {
	public static String lerString(String rotulo, int minimo, int maximo){
		Scanner s = new Scanner(System.in);
		String str = "";
		boolean invalida = true;
		do {
			System.out.print(rotulo);				
			str = s.nextLine();
			invalida = str.length() > maximo || str.length() < minimo; 
			if (invalida)
				System.out.println("O tamanho maximo permitido eh de " + maximo + " caracteres e o mínimo de "+minimo+".");
		} while (invalida);
		return str;
	}

	public static Integer lerInteiro(String rotulo, int minimo, int maximo){
		Scanner s = new Scanner(System.in);
		int opcao = 0;
		boolean invalida = true;
		do {
			System.out.println(rotulo);
			try {
				opcao = Integer.parseInt(s.nextLine());
				invalida = opcao < minimo || opcao > maximo;
				if (invalida)
					System.out.println("Valor inválido!");
			} catch (NumberFormatException e) {
				System.out.println("Valor inválido!");
				invalida = true;
				opcao = 0;
			}
		} while (invalida);
		return opcao;		
	}

	private static String lerSouN() {
		Scanner s = new Scanner(System.in);
		String str = "";
		boolean invalida = true;
		do {
			str = s.nextLine();
			invalida = !("N".equals(str.toUpperCase()) || "S".equals(str.toUpperCase())); 
			if (invalida)
				System.out.println("Digite (S)im ou (N)ao para continuar.");
		} while (invalida);
		return str.toUpperCase();
	}

	public static boolean confirma(String titulo) {
		System.out.println("Confirmação - " + titulo+ ": [s/n] ?");
		return "S".equals(Util.lerSouN());
	}
	public static void main(String[] args) {
	    
	      Date data = new Date(System.currentTimeMillis()); // Pega a data atual
	      SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy"); // Cria um formatador de datas
	      System.out.println(formatarDate.format(data)); // Mostra a data
	      data.setDate(data.getDate() + 40); // 7 dias a mais
	      System.out.println(formatarDate.format(data)); // Mostra a data

	}
}
