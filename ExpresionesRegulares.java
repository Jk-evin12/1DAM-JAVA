
package Condicion;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ExpresionesRegulares {

public static void main(String[] args) {
	Scanner teclado= new Scanner(System.in);
	String numero;
	System.out.println("Introduce tu NIF: ");
	numero=teclado.next();
	
	if(numero.matches("[0-3][0-9]{8} ")== true) {
	
		System.out.println("Es un NIF Válido. ");
	}else 
		System.out.println("No es un NIF válido");
}
}

