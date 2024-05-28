package paquete;

import java.util.*;

public class Calcula {

	public static String binarioDecimal(int binario) {
		int decimal = 0;
		int uno = 1, digito = 0;
		String resultado = "";

		while (binario > 0) {
			digito = binario % 10;

			decimal = decimal + (digito * uno);
			binario = binario / 10;
			uno = uno * 2;
		}

		resultado = String.valueOf(decimal);

		return resultado;
	}

	public static String decimalBinario(int numero) {
		int resto = 0;
		String conversion = "";

		if (numero == 0) {
			return "0";
		} else if (numero == 1) {
			return "1"; 
		} else {
			resto = numero % 2;
			conversion = decimalBinario(numero / 2) + resto ;
			return conversion;
		}
	}

	public static boolean comprobarBinario(int numero) {
		String cNumero = "";

		cNumero = String.valueOf(numero);

		for (int x=0; x < cNumero.length(); x++) {
			if (cNumero.charAt(x) != '0' && cNumero.charAt(x) != '1') {
				return true;
			}
		}

		return false;

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub


		boolean salir = true;
		while (salir) {
			try {
				Scanner leer = new Scanner(System.in);

				boolean salirmenu = true;
				int numero, nMenu;
				String resultado = "";


				while (salirmenu) {
					System.out.println("Elige una opción:");
					System.out.println("1. Pasar de binario a decimal");
					System.out.println("2. Pasar de decimal a binario");
					System.out.println("3. Terminar programa");
					nMenu = (int) leer.nextFloat();

					switch (nMenu) {
					case 1:
						System.out.println("Has elegido pasar de binario a decimal");

						System.out.println("Dime el número binario que quieres pasar a decimal:");
						numero = leer.nextInt();

						while (comprobarBinario(numero)) {
							System.out.println("El número escrito no es binario");
							System.out.println("Escribe otro número binario:");
							numero = leer.nextInt();
						}

						resultado = binarioDecimal(numero);
						System.out.println("El número decimal de " + numero + " es: " + resultado);

						break;
					case 2:
						System.out.println("Has elegido pasar de decimal a binario");

						System.out.println("Dime el número decimal que quieres pasar a binario:");
						numero = leer.nextInt();

						resultado = decimalBinario(numero);
						System.out.println("El número binario de " + numero + " es: " + resultado);

						break;
					case 3:
						System.out.println("As salido del programa!!");

						salirmenu = false;

						break;
					default:
						System.out.println("La opción seleccionada no existe, escribela otra vez");
					}
				}

				salir = false;
				leer.close();

			} catch (InputMismatchException e) {
				System.out.println("Entrada no válida");
				System.out.println("Empezamos de nuevo!!");
			}
		}
	}
}
