/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica4;

public class Demos {
	
	static java.util.Scanner scanner;


	public static void main(String[] args) {
		Demos instance = new Demos();
		instance.doMenu();
	}
	
	/**
	 * Muestra el menú y gestiona las solicitudes de cada una de sus opciones
	 */
	private void doMenu() {
	
		System.out.println("\t  0. Crear un archivo de texto");
		System.out.println("1. Generar clave para algoritmo de cifrado 3DES");
		System.out.println("2. Cifrar archivo con 3DES");
		System.out.println("3. Descifrar archivo con 3DES");
		
		
		System.out.print("\n\nSeleccione una opción y pulse ENTER:");
		
		scanner = new java.util.Scanner (System.in);
		String selectedOption = scanner.nextLine();

		if (!selectedOption.matches("-?\\d+?") && !selectedOption.equals("q")) {
			System.out.println("Opción incorrecta");
		} else {
			if(selectedOption.equals("q")){
				System.exit(0);
			}
			switch (Integer.parseInt(selectedOption)) {
			case 0:
				Utils.instance().saveConsoleToFile();
				break;
			case 1:
				new TripleDES().doGenerateKey();
				break;
			case 2:
				new TripleDES().doEncrypt();
				break;
			case 3:
				new TripleDES().doDecrypt();
				break;
			
			default:
				System.out.println("Opción incorrecta");
				break;
			}
		}
		Utils.instance().clearConsole();
		doMenu();
		
	}
}